package com.kientpham.webapp.orderservice.order;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import java.util.UUID;

public interface OrderDBGateway{
	public List<Order> findAll();

	public Order findById(UUID id);

	public List<Order> findByListIds(List<UUID> listId);

	public void deleteById(UUID id);

	public Order save(Order entity);


}