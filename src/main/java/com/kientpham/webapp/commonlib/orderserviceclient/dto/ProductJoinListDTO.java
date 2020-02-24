package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.product.Product;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ProductJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private String name;

	private String price;

	private String isChecked;
}