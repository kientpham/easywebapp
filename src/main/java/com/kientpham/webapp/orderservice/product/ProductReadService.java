package com.kientpham.webapp.orderservice.product;
import java.util.List;
import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductTableDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;
import java.util.UUID;


public interface ProductReadService{

	public ProductEditDTO getProductEditDTOById(UUID id);

	public List<ProductTableDTO> getListProductTableDTO();

}