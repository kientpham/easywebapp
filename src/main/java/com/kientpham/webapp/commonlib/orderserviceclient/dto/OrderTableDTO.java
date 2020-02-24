package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.order.Order;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class OrderTableDTO{
	private UUID id;
	private String number;
	private String totalPrice;
	private String status;
	private String userId;

	public OrderTableDTO(Order order, Map<Integer,String> lookupMap) {
		if(order !=null){
			if (order.getId()!=null)
				this.id=order.getId();
			this.number=order.getNumber();
			if (order.getTotalPrice()!=null)
				this.totalPrice=order.getTotalPrice().toString();
			this.status=lookupMap.get(order.getStatus());
			if (order.getUserId()!=null)
				this.userId=order.getUserId().toString();
		}
	}
}