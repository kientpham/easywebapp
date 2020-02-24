package com.kientpham.webapp.orderservice.order;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;


public interface OrderWriteService{

	public void deleteOrderById(Integer id);


	public void deleteListOrder(List<Integer> ids);

	public OrderEditDTO saveOrder(OrderEditDTO orderEditDTO);

}