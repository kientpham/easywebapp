package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import java.util.Currency;import java.util.UUID;
import java.util.List;
import com.kientpham.webapp.orderservice.order.Order;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class OrderEditDTO{
	private UUID id;
	private String number;
	private Currency totalPrice;
	private Integer status;
	private UUID userId;
	private List<String> orderItems;

	public OrderEditDTO() {
		//default constructor
	}
	public OrderEditDTO(Order order) {
		if(order !=null){
			this.id=order.getId();
			this.number=order.getNumber();
			this.totalPrice=order.getTotalPrice();
			this.status=order.getStatus();
			this.userId=order.getUserId();
		}
	}

}