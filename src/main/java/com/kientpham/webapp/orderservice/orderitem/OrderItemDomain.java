package com.kientpham.webapp.orderservice.orderitem;
import java.util.UUID;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.orderservice.orderitem.OrderItemDBGateway;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;

@Component
public class OrderItemDomain{
	@Autowired
	private OrderItemDBGateway dbGateway;
	

	public List<OrderItem> findAll(){
		return dbGateway.findAll();
	}
	
	public List<OrderItem> findByListIds(List<String> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public OrderItem findById(String id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(String id) {
		dbGateway.deleteById(id);
	}
	
	public OrderItem save(OrderItem entity) {
		return dbGateway.save(entity);
	}

	public OrderItem getOrderItemEntity(OrderItemEditDTO orderItemEditDTO) {
		OrderItem orderitem=new OrderItem();
		if (orderItemEditDTO.getId().isEmpty()) {
			orderItemEditDTO.setId(UUID.randomUUID().toString());
					}
		orderitem.setId(orderItemEditDTO.getId());
		orderitem.setQuatity(orderItemEditDTO.getQuatity());
		orderitem.setItemPrice(orderItemEditDTO.getItemPrice());
		return orderitem;
	}

}