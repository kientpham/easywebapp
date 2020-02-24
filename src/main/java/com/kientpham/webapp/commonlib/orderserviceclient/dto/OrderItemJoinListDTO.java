package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.orderitem.OrderItem;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private String title;

	private String isChecked;
}