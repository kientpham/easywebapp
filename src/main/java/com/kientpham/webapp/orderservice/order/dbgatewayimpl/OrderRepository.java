package com.kientpham.webapp.orderservice.order.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.orderservice.order.Order;


public interface OrderRepository extends CrudRepository<Order, Integer> {

}