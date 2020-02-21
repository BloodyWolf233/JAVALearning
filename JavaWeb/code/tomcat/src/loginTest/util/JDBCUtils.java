package loginTest.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            //1. load config
            Properties properties = new Properties();
            //user ClassLoader load the config file, and get stream
            InputStream resourceAsStream =
                    JDBCUtils.class.getClassLoader().getResourceAsStream("loginTest/druid.properties");
            properties.load(resourceAsStream);

            //2. init connection pool object
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get connection pool object
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * get connection object
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
