package jdbcTest.Test;

import jdbcTest.domain.table1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo04 {
    public static void main(String[] args) {
        List<table1> list = new JDBCDemo04().findAll();
        System.out.println(list);
    }
    public List<table1> findAll(){
        String url = "jdbc:mysql://localhost:3306/db1";
        String user = "root";
        String psw = "toor";

        ArrayList<table1> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. Register driver
            Class.forName("com.mysql.jdbc.Driver");
            //2. define sql
            String sql = "select * from table1";
            //3. get Connection
            conn = DriverManager.getConnection(url, user, psw);
            //4. get subject which will execute sql
            stmt = conn.createStatement();
            //5. execute
            rs = stmt.executeQuery(sql);
            // 6. get result
            table1 t = null;
            list = new ArrayList<>();
            while (rs.next()) {
                t = new table1();
                t.setId(rs.getInt(1));
                t.setName(rs.getString("name"));
                t.setAge(rs.getInt(3));
                t.setMoney(rs.getDouble("money"));
                t.setJoindate(rs.getDate("joindate"));

                list.add(t);
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
        return list;
    }
}
