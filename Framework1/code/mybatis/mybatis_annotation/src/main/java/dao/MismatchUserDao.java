package dao;

import domain.MismatchUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 在mybatis中CRUD有4个注解
 *
 * @Select
 * @Insert
 * @Upate
 * @Delete
 */
public interface MismatchUserDao {

    @Select(value = "select * from user ")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(id = false, column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday")

    })
    List<MismatchUser> findAll();

    @Select("select * from user where id=#{id} ")
    @ResultMap("userMap")
    MismatchUser findById(Integer id);

    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<MismatchUser> findUserByName(String username);

}
