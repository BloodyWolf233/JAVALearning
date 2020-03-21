package Test;

import dao.UserDao;
import domain.QueryVo;
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
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1. 读取配置文件，生成直接输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3. 获取SqlSession对象
        sqlSession = factory.openSession();
        //4. 获取dao的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();

        //6. 释放资源
        sqlSession.close();
        in.close();
    }
    /**
     * 测试查询所有
     * @throws IOException
     */
    @Test
    public void testFindAll() throws IOException {
        //5. 执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() throws IOException {
        User user = new User();
        user.setUserAddress("嘤嘤嘤");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserName("fucker");

        System.out.println(user);
        //5. 执行保存方法
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(50);
        user.setUserAddress("嘤嘤嘤gggg");
        user.setUserBirthday(new Date());
        user.setUserSex("女");
        user.setUserName("fucker");

        //5. 执行保存方法
        userDao.updateUser(user);
    }
    @Test
    public void testDelete(){
        userDao.deleteUser(50);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(48);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        int total = userDao.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUserName("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }
}
