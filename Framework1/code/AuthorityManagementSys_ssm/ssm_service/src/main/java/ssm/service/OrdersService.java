package ssm.service;

import ssm.domain.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersService {


    List<Orders> findAll(int page, int pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;

}
