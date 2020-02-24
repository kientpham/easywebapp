package com.kientpham.webapp.orderservice.orderitem.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.orderservice.orderitem.dbgatewayimpl.OrderItemRepository;
import com.kientpham.webapp.orderservice.orderitem.OrderItemDBGateway;

@Component
public class OrderItemDBGatewayImp implements OrderItemDBGateway{
	@Autowired
	private OrderItemRepository repository;

	@Override
	public List<OrderItem> findAll() {
		return (List<OrderItem>) repository.findAll();
	}

	@Override
	public OrderItem findById(String id) {
		return repository.findById(id).orElse(new OrderItem());
	}

	@Override
	public List<OrderItem> findByListIds(List<String> listId) {		
		return (List<OrderItem>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);		
	}

	@Override
	public OrderItem save(OrderItem entity) {
		return repository.save(entity);
	}

}