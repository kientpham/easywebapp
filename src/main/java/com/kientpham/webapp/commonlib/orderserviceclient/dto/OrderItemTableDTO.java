package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemTableDTO{
	private String id;
	private String quatity;
	private String itemPrice;

	public OrderItemTableDTO(OrderItem orderItem, Map<Integer,String> lookupMap) {
		if(orderItem !=null){
			this.id=orderItem.getId();
			if (orderItem.getQuatity()!=null)
				this.quatity=orderItem.getQuatity().toString();
			if (orderItem.getItemPrice()!=null)
				this.itemPrice=orderItem.getItemPrice().toString();
		}
	}
}