package com.kientpham.webapp.orderservice.order;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;


public interface OrderReadService{

	public OrderEditDTO getOrderEditDTOById(Integer id);

	public List<OrderTableDTO> getListOrderTableDTO();

}