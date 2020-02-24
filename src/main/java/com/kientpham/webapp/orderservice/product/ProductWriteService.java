package com.kientpham.webapp.orderservice.product;
import java.util.List;
import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;
import java.util.UUID;


public interface ProductWriteService{

	public void deleteProductById(UUID id);


	public void deleteListProduct(List<UUID> ids);

	public ProductEditDTO saveProduct(ProductEditDTO productEditDTO);

}