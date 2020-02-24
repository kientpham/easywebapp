package com.kientpham.webapp.orderservice.orderitem;
import java.util.List;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemTableDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;


public interface OrderItemReadService{

	public OrderItemEditDTO getOrderItemEditDTOById(String id);

	public List<OrderItemTableDTO> getListOrderItemTableDTO();

}