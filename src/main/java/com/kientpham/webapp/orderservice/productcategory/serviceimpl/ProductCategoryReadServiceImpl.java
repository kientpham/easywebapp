package com.kientpham.webapp.orderservice.productcategory.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryDomain;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryReadService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class ProductCategoryReadServiceImpl implements ProductCategoryReadService{

	@Autowired
	private ProductCategoryDomain productCategoryDomain;

	@Override
	public ProductCategoryEditDTO getProductCategoryEditDTOById(Integer id) {
		return new ProductCategoryEditDTO(productCategoryDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<ProductCategoryTableDTO> getListProductCategoryTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<ProductCategory> allProductCategory = productCategoryDomain.findAll();
		List<ProductCategoryTableDTO> productcategoryTable = new ArrayList<ProductCategoryTableDTO>();
		for (ProductCategory productcategory :allProductCategory) {
 			productcategoryTable.add(new ProductCategoryTableDTO(productcategory, lookupMap));
		}
		return productcategoryTable;
	}

}