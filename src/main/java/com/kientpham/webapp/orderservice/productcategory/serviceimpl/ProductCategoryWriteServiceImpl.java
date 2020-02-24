package com.kientpham.webapp.orderservice.productcategory.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryDomain;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryWriteService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class ProductCategoryWriteServiceImpl implements ProductCategoryWriteService{

	@Autowired
	private ProductCategoryDomain productCategoryDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public void deleteProductCategoryById(Integer id) {
		productCategoryDomain.deleteById(id);		
	}

	@Override
	public void deleteListProductCategory(List<Integer> ids) {
		for (Integer id:ids) {
			productCategoryDomain.deleteById(id);
		}		
	}

	@Override
	public ProductCategoryEditDTO saveProductCategory(ProductCategoryEditDTO productCategoryEditDTO) {
		ProductCategory productCategory=productCategoryDomain.getProductCategoryEntity(productCategoryEditDTO);
		productCategoryDomain.save(productCategory);
		return productCategoryEditDTO;
	}
}