package com.kientpham.webapp.orderservice.orderitem.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;


public interface OrderItemRepository extends CrudRepository<OrderItem, String> {

}