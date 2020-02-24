package com.kientpham.webapp.orderservice.order.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.orderservice.order.Order;
import java.util.UUID;


public interface OrderRepository extends CrudRepository<Order, UUID> {

}