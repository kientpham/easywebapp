package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryEditDTO{
	private Integer id;
	private String name;
	private String description;

	public ProductCategoryEditDTO() {
		//default constructor
	}
	public ProductCategoryEditDTO(ProductCategory productcategory) {
		if(productcategory !=null){
			this.id=productcategory.getId();
			this.name=productcategory.getName();
			this.description=productcategory.getDescription();
		}
	}

}