package jdbcTest.Test;

import jdbcTest.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input user name:");
        String username = sc.nextLine();
        System.out.println("input password:");
        String password = sc.nextLine();

        boolean  flag = new JDBCDemo07().login2(username, password);
        if(flag){
            System.out.println("right");
        }else {
            System.out.println("error");
        }
    }

    public boolean login2(String username, String password) {

        if (username != null && password != null) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            //1. get connection
            try {
                conn = JDBCUtils.getConnection();
                //2.sql
                String sql = "select * from user where username= ? and password= ?";
                //3.
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                //4.execute
                rs = pstmt.executeQuery();
                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(rs, pstmt, conn);
            }
        }
        return false;
    }
}
