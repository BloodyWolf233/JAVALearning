package mybatis.sqlsession.proxy;

import mybatis.cfg.Mapper;
import mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    //map的可以是全限定类名+方法名
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
     * 用于对于方法进行增强，我们的增强就是调用selectList方法
     * @param o
     * @param method
     * @param objects
     * @return
     * @throws Throwable
     */
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //1. 获取方法名
        String methodName = method.getName();
        //2. 获取方法所在类的名称
        String className = method.getDeclaringClass().getName();
        //3. 组合key
        String key = className +"."+methodName;
        //4. 获取mappers中的Mapper对象
        Mapper mapper = mappers.get(key);
        //5. 判断是否有mapper
        if (mapper == null){
            throw new IllegalAccessException("传入的参数有误");
        }
        //6. 调用工具类查询所有
        return new Executor().selectList(mapper,conn);
    }
}
