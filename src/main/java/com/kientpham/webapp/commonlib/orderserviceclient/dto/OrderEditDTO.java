package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEditDTO{
	private Integer id;
	private String title;
	private Integer status;
	private Integer userId;
	private List<Integer> user;

	public OrderEditDTO() {
		//default constructor
	}
	public OrderEditDTO(Order order) {
		if(order !=null){
			this.id=order.getId();
			this.title=order.getTitle();
			this.status=order.getStatus();
			this.userId=order.getUserId();
		}
	}
}