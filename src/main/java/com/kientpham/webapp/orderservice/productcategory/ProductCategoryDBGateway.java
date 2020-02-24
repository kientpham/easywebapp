package com.kientpham.webapp.orderservice.productcategory;
import java.util.List;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;

public interface ProductCategoryDBGateway{
	public List<ProductCategory> findAll();

	public ProductCategory findById(Integer id);

	public List<ProductCategory> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public ProductCategory save(ProductCategory entity);


}