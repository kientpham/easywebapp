package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.order.Order;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTableDTO{
	private Integer id;
	private String title;
	private String status;
	private String userId;

	public OrderTableDTO(Order order,Map<Integer,String> lookupMap) {
		if(order !=null){
			this.id=order.getId();
			this.title=order.getTitle();
			this.status=lookupMap.get(order.getStatus());
			this.userId=order.getUserId().toString();
		}
	}
}