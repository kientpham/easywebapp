package com.kientpham.webapp.orderservice.orderitem.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.orderservice.orderitem.OrderItemDomain;
import com.kientpham.webapp.orderservice.orderitem.OrderItemReadService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class OrderItemReadServiceImpl implements OrderItemReadService{

	@Autowired
	private OrderItemDomain orderItemDomain;

	@Override
	public OrderItemEditDTO getOrderItemEditDTOById(String id) {
		return new OrderItemEditDTO(orderItemDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<OrderItemTableDTO> getListOrderItemTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<OrderItem> allOrderItem = orderItemDomain.findAll();
		List<OrderItemTableDTO> orderitemTable = new ArrayList<OrderItemTableDTO>();
		for (OrderItem orderitem :allOrderItem) {
 			orderitemTable.add(new OrderItemTableDTO(orderitem, lookupMap));
		}
		return orderitemTable;
	}

}