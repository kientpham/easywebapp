package com.kientpham.webapp.orderservice.order.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.dbgatewayimpl.OrderRepository;
import com.kientpham.webapp.orderservice.order.OrderDBGateway;
import java.util.UUID;

@Component
public class OrderDBGatewayImp implements OrderDBGateway{
	@Autowired
	private OrderRepository repository;

	@Override
	public List<Order> findAll() {
		return (List<Order>) repository.findAll();
	}

	@Override
	public Order findById(UUID id) {
		return repository.findById(id).orElse(new Order());
	}

	@Override
	public List<Order> findByListIds(List<UUID> listId) {		
		return (List<Order>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);		
	}

	@Override
	public Order save(Order entity) {
		return repository.save(entity);
	}

}