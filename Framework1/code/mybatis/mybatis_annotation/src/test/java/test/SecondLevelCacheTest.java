package test;

import dao.AccountDao;
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

public class SecondLevelCacheTest {
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
    public void testFindOne(){
        User user = userDao.findById(51);
        System.out.println(user);
        session.close();//释放一级缓存

        session=factory.openSession();
        userDao = session.getMapper(UserDao.class);
        user = userDao.findById(51);
        System.out.println(user);

    }
}
