package com.kientpham.webapp.orderservice.order;
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
	
	public List<Order> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Order findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public Order save(Order entity) {
		return dbGateway.save(entity);
	}

	public Order getOrderEntity(OrderEditDTO orderEditDTO) {
		Order order=new Order();
		order.setId(orderEditDTO.getId());
		order.setTitle(orderEditDTO.getTitle());
		order.setStatus(orderEditDTO.getStatus());
		order.setUserId(orderEditDTO.getUserId());
		return order;
	}

}