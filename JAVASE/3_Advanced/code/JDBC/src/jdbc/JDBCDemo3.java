package jdbc;

import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String psw = "toor";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. Register driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. define sql
            String sql = "select * from table1";
            //3. get Connection subject
            conn = DriverManager.getConnection(url, user, psw);
            //4. get subject which will execute sql
            stmt = conn.createStatement();
            //5. execute
            rs = stmt.executeQuery(sql);//affected rows
            // 6. get result
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double age = rs.getDouble(3);
                System.out.println("id: " + id + ", name: " + name + ", age:" + age);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
