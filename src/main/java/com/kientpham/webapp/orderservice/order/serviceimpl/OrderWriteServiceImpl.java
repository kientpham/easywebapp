package com.kientpham.webapp.orderservice.order.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.OrderDomain;
import com.kientpham.webapp.orderservice.order.OrderWriteService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import com.kientpham.webapp.userservice.user.User;
import com.kientpham.webapp.userservice.user.UserDomain;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class OrderWriteServiceImpl implements OrderWriteService{

	@Autowired
	private OrderDomain orderDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private UserDomain userDomain;

	@Override
	public void deleteOrderById(Integer id) {
		orderDomain.deleteById(id);		
	}

	@Override
	public void deleteListOrder(List<Integer> ids) {
		for (Integer id:ids) {
			orderDomain.deleteById(id);
		}		
	}

	@Override
	public OrderEditDTO saveOrder(OrderEditDTO orderEditDTO) {
		Order order=orderDomain.getOrderEntity(orderEditDTO);
		;		orderDomain.save(order);
		return orderEditDTO;
	}
}