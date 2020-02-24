package com.kientpham.webapp.orderservice.order.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.OrderDomain;
import com.kientpham.webapp.orderservice.order.OrderWriteService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemJoinListDTO;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.orderservice.orderitem.OrderItemDomain;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class OrderWriteServiceImpl implements OrderWriteService{

	@Autowired
	private OrderDomain orderDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private OrderItemDomain orderItemDomain;

	@Override
	public void deleteOrderById(UUID id) {
		orderDomain.deleteById(id);		
	}

	@Override
	public void deleteListOrder(List<UUID> ids) {
		for (UUID id:ids) {
			orderDomain.deleteById(id);
		}		
	}

	@Override
	public OrderEditDTO saveOrder(OrderEditDTO orderEditDTO) {
		Order order=orderDomain.getOrderEntity(orderEditDTO);
		order.setOrderItems(orderItemDomain.findByListIds(orderEditDTO.getOrderItems()));
		orderDomain.save(order);
		return orderEditDTO;
	}
}