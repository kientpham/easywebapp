package com.kientpham.webapp.orderservice.productcategory;
import java.util.List;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryTableDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;


public interface ProductCategoryReadService{

	public ProductCategoryEditDTO getProductCategoryEditDTOById(Integer id);

	public List<ProductCategoryTableDTO> getListProductCategoryTableDTO();

}