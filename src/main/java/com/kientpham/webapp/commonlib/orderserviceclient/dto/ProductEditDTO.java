package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import java.util.Currency;import java.util.UUID;
import java.util.List;
import com.kientpham.webapp.orderservice.product.Product;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ProductEditDTO{
	private UUID id;
	private String name;
	private Currency price;
	private String description;
	private Integer productCategory;

	public ProductEditDTO() {
		//default constructor
	}
	public ProductEditDTO(Product product) {
		if(product !=null){
			this.id=product.getId();
			this.name=product.getName();
			this.price=product.getPrice();
			this.description=product.getDescription();
		}
	}

}