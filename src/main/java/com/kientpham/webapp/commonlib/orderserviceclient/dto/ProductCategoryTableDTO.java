package com.kientpham.webapp.commonlib.orderserviceclient.dto;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCategoryTableDTO{
	private Integer id;
	private String name;
	private String description;

	public ProductCategoryTableDTO(ProductCategory productCategory, Map<Integer,String> lookupMap) {
		if(productCategory !=null){
			if (productCategory.getId()!=null)
				this.id=productCategory.getId();
			this.name=productCategory.getName();
			this.description=productCategory.getDescription();
		}
	}
}