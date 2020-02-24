package com.kientpham.webapp.orderservice.orderitem;
import java.util.List;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;


public interface OrderItemWriteService{

	public void deleteOrderItemById(String id);


	public void deleteListOrderItem(List<String> ids);

	public OrderItemEditDTO saveOrderItem(OrderItemEditDTO orderItemEditDTO);

}