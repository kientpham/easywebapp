package com.kientpham.webapp.orderservice.orderitem.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.orderservice.orderitem.OrderItemDomain;
import com.kientpham.webapp.orderservice.orderitem.OrderItemWriteService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.orderservice.order.OrderDomain;
import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.orderservice.product.ProductDomain;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class OrderItemWriteServiceImpl implements OrderItemWriteService{

	@Autowired
	private OrderItemDomain orderItemDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private OrderDomain orderDomain;

	@Autowired
	private ProductDomain productDomain;

	@Override
	public void deleteOrderItemById(String id) {
		orderItemDomain.deleteById(id);		
	}

	@Override
	public void deleteListOrderItem(List<String> ids) {
		for (String id:ids) {
			orderItemDomain.deleteById(id);
		}		
	}

	@Override
	public OrderItemEditDTO saveOrderItem(OrderItemEditDTO orderItemEditDTO) {
		OrderItem orderItem=orderItemDomain.getOrderItemEntity(orderItemEditDTO);
		orderItem.setOrder(orderDomain.findById(orderItemEditDTO.getOrder()));
		orderItem.setProduct(productDomain.findById(orderItemEditDTO.getProduct()));
		orderItemDomain.save(orderItem);
		return orderItemEditDTO;
	}
}