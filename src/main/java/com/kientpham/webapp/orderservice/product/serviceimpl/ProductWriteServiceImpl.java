package com.kientpham.webapp.orderservice.product.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.orderservice.product.ProductDomain;
import com.kientpham.webapp.orderservice.product.ProductWriteService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryDomain;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class ProductWriteServiceImpl implements ProductWriteService{

	@Autowired
	private ProductDomain productDomain;

	@Autowired
	private LookupReadService lookupReadService;

	@Autowired
	private ProductCategoryDomain productCategoryDomain;

	@Override
	public void deleteProductById(UUID id) {
		productDomain.deleteById(id);		
	}

	@Override
	public void deleteListProduct(List<UUID> ids) {
		for (UUID id:ids) {
			productDomain.deleteById(id);
		}		
	}

	@Override
	public ProductEditDTO saveProduct(ProductEditDTO productEditDTO) {
		Product product=productDomain.getProductEntity(productEditDTO);
		product.setProductCategory(productCategoryDomain.findById(productEditDTO.getProductCategory()));
		productDomain.save(product);
		return productEditDTO;
	}
}