package ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ssm.domain.Product;

import java.util.List;

public interface ProductDao {

    @Select("select * from product ")
    public List<Product> findAll() throws Exception;

    @Insert("insert into " +
            "product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus}) ")
    void save(Product product);

    @Select("select * from product where id=#{id} ")
    Product findById(String id) throws Exception;

}
