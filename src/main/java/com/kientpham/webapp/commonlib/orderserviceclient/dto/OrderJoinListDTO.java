package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.order.Order;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String title;

	private String isChecked;
}