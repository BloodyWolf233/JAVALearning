package test;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao =session.getMapper(UserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("asdasadsadasda");
        user.setAddress("hhhhhhhhhh");

        userDao.saveUser(user);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(54);
        user.setUsername("11111111");
        user.setAddress("hhhhhhhhhh");

        userDao.updateUser(user);

    }

    @Test
    public void testDelete(){
        userDao.deleteUser(55);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(51);
        System.out.println(user);

        User user2 = userDao.findById(51);
        System.out.println(user2);

        System.out.println(user==user2);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int totalUser = userDao.findTotalUser();
        System.out.println(totalUser);
    }


    @Test
    public void testFindAll(){
        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println("-------每个用户的信息-------");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//        }
    }
}
