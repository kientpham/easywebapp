package com.kientpham.webapp.orderservice.order;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemJoinListDTO;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import java.util.UUID;


public interface OrderReadService{

	public OrderEditDTO getOrderEditDTOById(UUID id);

	public List<OrderTableDTO> getListOrderTableDTO();

}