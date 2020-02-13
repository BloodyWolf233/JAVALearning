package jdbcTest.Test;

import jdbcTest.domain.table1;
import jdbcTest.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo05 {
    public static void main(String[] args) {
        List<table1> list = new JDBCDemo05().findAll2();
        System.out.println(list);
    }
    public List<table1> findAll2(){
        ArrayList<table1> list = null;

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.
            conn = JDBCUtils.getConnection();
            //2. define sql
            String sql = "select * from table1";

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


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
