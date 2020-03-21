package test;

import dao.MismatchUserDao;
import domain.MismatchUser;
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

public class MismatchTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private MismatchUserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userDao =session.getMapper(MismatchUserDao.class);
    }
    @After
    public void destory() throws IOException {
        session.commit();
        in.close();
        session.close();
    }

    @Test
    public void testFindAll(){
        List<MismatchUser> users = userDao.findAll();
        for (MismatchUser user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindOne(){
        MismatchUser user = userDao.findById(51);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<MismatchUser> users = userDao.findUserByName("%王%");
        for (MismatchUser user : users) {
            System.out.println(user);
        }
    }

}
