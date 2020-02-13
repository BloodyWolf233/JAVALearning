package jdbcTest.Test;

import jdbcTest.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input user name:");
        String username = sc.nextLine();
        System.out.println("input password:");
        String password = sc.nextLine();

        boolean  flag = new JDBCDemo06().login(username, password);
        if(flag){
            System.out.println("right");
        }else {
            System.out.println("error");
        }
    }

    public boolean login(String username, String password) {

        if (username != null && password != null) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            //1. get connection
            try {
                conn = JDBCUtils.getConnection();
                //2.sql
                String sql = "select * from user where username='" + username + "' and password='" + password + "'";
                //3.
                stmt = conn.createStatement();
                //4.execute
                rs = stmt.executeQuery(sql);
                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(rs, stmt, conn);
            }
        }
        return false;
    }
}
