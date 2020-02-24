package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.product.Product;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class ProductTableDTO{
	private UUID id;
	private String name;
	private String price;
	private String description;

	public ProductTableDTO(Product product, Map<Integer,String> lookupMap) {
		if(product !=null){
			if (product.getId()!=null)
				this.id=product.getId();
			this.name=product.getName();
			if (product.getPrice()!=null)
				this.price=product.getPrice().toString();
			this.description=product.getDescription();
		}
	}
}