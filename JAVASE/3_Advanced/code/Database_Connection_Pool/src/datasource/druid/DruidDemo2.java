package datasource.druid;

import datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1. get connection
            conn = JDBCUtils.getConnection();
            //2. sql
            String sql = "insert into table1 values(null,?,?,?,null)";
            //3.
            pstmt = conn.prepareStatement(sql);
            //4.
            pstmt.setString(1, "Jesus");
            pstmt.setInt(2, 15);
            pstmt.setDouble(3, 82124.31);
            //5.execute
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
