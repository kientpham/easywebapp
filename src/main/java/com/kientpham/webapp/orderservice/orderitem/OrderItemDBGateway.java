package com.kientpham.webapp.orderservice.orderitem;
import java.util.List;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;

public interface OrderItemDBGateway{
	public List<OrderItem> findAll();

	public OrderItem findById(String id);

	public List<OrderItem> findByListIds(List<String> listId);

	public void deleteById(String id);

	public OrderItem save(OrderItem entity);


}