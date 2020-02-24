package com.kientpham.webapp.orderservice.order;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;

public interface OrderDBGateway{
	public List<Order> findAll();

	public Order findById(Integer id);

	public List<Order> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public Order save(Order entity);


}