package com.kientpham.webapp.orderservice.order;
import java.util.UUID;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.OrderDBGateway;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;

@Component
public class OrderDomain{
	@Autowired
	private OrderDBGateway dbGateway;
	

	public List<Order> findAll(){
		return dbGateway.findAll();
	}
	
	public List<Order> findByListIds(List<UUID> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Order findById(UUID id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(UUID id) {
		dbGateway.deleteById(id);
	}
	
	public Order save(Order entity) {
		return dbGateway.save(entity);
	}

	public Order getOrderEntity(OrderEditDTO orderEditDTO) {
		Order order=new Order();
		if (orderEditDTO.getId()==null) {
			orderEditDTO.setId(UUID.randomUUID());
					}
		order.setId(orderEditDTO.getId());
		order.setNumber(orderEditDTO.getNumber());
		order.setTotalPrice(orderEditDTO.getTotalPrice());
		order.setStatus(orderEditDTO.getStatus());
		order.setUserId(orderEditDTO.getUserId());
		return order;
	}

}