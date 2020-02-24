package com.kientpham.webapp.orderservice.productcategory;
import java.util.List;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;


public interface ProductCategoryWriteService{

	public void deleteProductCategoryById(Integer id);


	public void deleteListProductCategory(List<Integer> ids);

	public ProductCategoryEditDTO saveProductCategory(ProductCategoryEditDTO productCategoryEditDTO);

}