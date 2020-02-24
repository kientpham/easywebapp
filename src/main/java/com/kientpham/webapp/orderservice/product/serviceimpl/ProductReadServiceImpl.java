package com.kientpham.webapp.orderservice.product.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.UUID;

import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.orderservice.product.ProductDomain;
import com.kientpham.webapp.orderservice.product.ProductReadService;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@Component
public class ProductReadServiceImpl implements ProductReadService{

	@Autowired
	private ProductDomain productDomain;

	@Override
	public ProductEditDTO getProductEditDTOById(UUID id) {
		return new ProductEditDTO(productDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<ProductTableDTO> getListProductTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<Product> allProduct = productDomain.findAll();
		List<ProductTableDTO> productTable = new ArrayList<ProductTableDTO>();
		for (Product product :allProduct) {
 			productTable.add(new ProductTableDTO(product, lookupMap));
		}
		return productTable;
	}

}