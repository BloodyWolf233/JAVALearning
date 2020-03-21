package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.junit.Test;

import java.util.List;

/**
 * 在mybatis中CRUD有4个注解
 * @Select
 * @Insert
 * @Upate
 * @Delete
 */
@CacheNamespace(blocking = true)
public interface UserDao {

    @Select(value = "select * from user ")
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "accounts",column = "id",many = @Many(
                    select = "dao.AccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY
            ))
    })
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday}) ")
    void saveUser(User user);

    @Update("update user set username=#{username},sex=#{sex},address=#{address},birthday=#{birthday} where id=#{id} ")
    void updateUser(User user);

    @Delete("delete from user where id=#{id} ")
    void deleteUser(Integer id);

    @Select("select * from user where id=#{id} ")
    User findById(Integer id);

    @Select("select * from user where username like #{username} ")
    List<User> findUserByName(String username);

    @Select("select count(*) from user ")
    int findTotalUser();

}
