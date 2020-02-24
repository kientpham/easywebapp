package com.kientpham.webapp.orderservice.order;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import java.util.UUID;


public interface OrderWriteService{

	public void deleteOrderById(UUID id);


	public void deleteListOrder(List<UUID> ids);

	public OrderEditDTO saveOrder(OrderEditDTO orderEditDTO);

}