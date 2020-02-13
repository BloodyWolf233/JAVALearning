package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import javax.swing.plaf.basic.ComboPopup;
import java.sql.Connection;
import java.sql.SQLException;

//jar: c3p0-0.9.5.2.jar  mchange-commons-java-0.2.12.jar
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //test1();
        test2();
    }

    public static void test1() throws SQLException {
        //1. create database connection pool object
        DataSource ds = new ComboPooledDataSource();


        for (int i = 1; i <= 11; i++) {
            //2. connect
            Connection conn = ds.getConnection();
            System.out.println(i+": "+conn);

            if (i == 5)
                conn.close();
        }
    }
    public static void test2() throws SQLException {
        //1. create database connection pool object
        DataSource ds = new ComboPooledDataSource("otherc3p0");


        for (int i = 1; i <= 11; i++) {
            //2. connect
            Connection conn = ds.getConnection();
            System.out.println(i + ": " + conn);

            if (i == 5)
                conn.close();
        }
    }
}
