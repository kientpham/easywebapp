package com.kientpham.webapp.orderservice.order.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.OrderDomain;
import com.kientpham.webapp.orderservice.order.OrderReadService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class OrderReadServiceImpl implements OrderReadService{

	@Autowired
	private OrderDomain orderDomain;

	@Override
	public OrderEditDTO getOrderEditDTOById(UUID id) {
		return new OrderEditDTO(orderDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<OrderTableDTO> getListOrderTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<Order> allOrder = orderDomain.findAll();
		List<OrderTableDTO> orderTable = new ArrayList<OrderTableDTO>();
		for (Order order :allOrder) {
 			orderTable.add(new OrderTableDTO(order, lookupMap));
		}
		return orderTable;
	}

}