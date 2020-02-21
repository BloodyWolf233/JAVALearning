package loginTest.test;

import loginTest.dao.UserDao;
import loginTest.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("super");
        user.setPassword("1234");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);
        System.out.println(login);
    }
}
