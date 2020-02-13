package jdbctemplate;

import datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1. create JDBCTemplate object
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //2.
        String sql = "update table1 set money = 50000 where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }
}
