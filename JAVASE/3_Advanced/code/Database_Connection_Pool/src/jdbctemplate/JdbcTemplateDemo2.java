package jdbctemplate;

import datasource.utils.JDBCUtils;
import domain.table1;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    //1.
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 1. change
     */
    @Test
    public void test1() {
        //2.sql
        String sql = "update table1 set money = 10000 where id = 1";
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2() {
        String sql = "insert into table1(id,name,money) values(?,?,?)";
        int count = template.update(sql, 7, "Swift", 567.43);
        System.out.println(count);
    }

    @Test
    public void test3() {
        String sql = "delete from table1 where id = ?";
        int count = template.update(sql, 7);
        System.out.println(count);
    }

    @Test
    public void test4() {
        //String sql = "select * from table1 where id = ?";
        String sql = "select * from table1 where id = ? or id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1, 5);
        System.out.println(map);
    }

    @Test
    public void test5() {
        String sql = "select * from table1";
        List<Map<String, Object>> list = template.queryForList(sql);
        //hot key: 'iter'
        for (Map<String, Object> map :list) {
            System.out.println(map);
        }
    }

    @Test
    public void test6(){
        String sql = "select * from table1";
        List<table1> list = template.query(sql, new RowMapper<table1>() {
            @Override
            public table1 mapRow(ResultSet resultSet, int i) throws SQLException {
                table1 t1 = new table1();
                t1.setId(resultSet.getInt("id"));
                t1.setAge(resultSet.getInt("age"));
                t1.setName(resultSet.getString("name"));
                t1.setMoney(resultSet.getDouble("money"));
                t1.setJoindate(resultSet.getDate("joindate"));
                return t1;
            }
        });
        for (table1 table1 : list) {
            System.out.println(table1);
        }
    }

    @Test
    public void test6_2(){
        String sql = "select * from table1";
        List<table1> list = template.query(sql, new BeanPropertyRowMapper<table1>(table1.class));
        for (table1 table1 : list) {
            System.out.println(table1);
        }
    }

    @Test
    public void test7(){
        String sql = "select count(id) from table1";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
