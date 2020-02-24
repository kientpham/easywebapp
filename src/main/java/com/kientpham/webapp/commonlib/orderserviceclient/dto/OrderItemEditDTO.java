package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import java.util.Currency;import java.util.UUID;
import java.util.List;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemEditDTO{
	private String id;
	private Integer quatity;
	private Currency itemPrice;
	private UUID order;
	private UUID product;

	public OrderItemEditDTO() {
		//default constructor
	}
	public OrderItemEditDTO(OrderItem orderitem) {
		if(orderitem !=null){
			this.id=orderitem.getId();
			this.quatity=orderitem.getQuatity();
			this.itemPrice=orderitem.getItemPrice();
		}
	}

}