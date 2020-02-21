package loginTest.dao;

import loginTest.domain.User;
import loginTest.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //declare JDBCTemplate object for all
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * login
     * @param loginUser only name and password
     * @return all user info
     */
    public User login(User loginUser){
        try {
            //1. sql
            String sql = "select * from user where username = ? and password = ?";
            //2. query
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
