package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String psw = "toor";

        Connection conn = null;
        Statement stmt = null;
        try {
            //1. Register driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. define sql
            String sql = "insert into table1 values(null,'David',140)";
            //String sql ="create table student (id int, name varchar(20))";
            //3. get Connection subject
            conn = DriverManager.getConnection(url, user, psw);
            //4. get subject which will execute sql
            stmt = conn.createStatement();
            //5. execute
            int count = stmt.executeUpdate(sql);//affected rows
            //6.
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
