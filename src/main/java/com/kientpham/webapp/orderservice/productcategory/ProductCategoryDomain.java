package com.kientpham.webapp.orderservice.productcategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryDBGateway;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;

@Component
public class ProductCategoryDomain{
	@Autowired
	private ProductCategoryDBGateway dbGateway;
	

	public List<ProductCategory> findAll(){
		return dbGateway.findAll();
	}
	
	public List<ProductCategory> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public ProductCategory findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public ProductCategory save(ProductCategory entity) {
		return dbGateway.save(entity);
	}

	public ProductCategory getProductCategoryEntity(ProductCategoryEditDTO productCategoryEditDTO) {
		ProductCategory productcategory=new ProductCategory();
		productcategory.setId(productCategoryEditDTO.getId());
		productcategory.setName(productCategoryEditDTO.getName());
		productcategory.setDescription(productCategoryEditDTO.getDescription());
		return productcategory;
	}

}