package com.kientpham.webapp.orderservice.product;
import java.util.UUID;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.orderservice.product.ProductDBGateway;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;

@Component
public class ProductDomain{
	@Autowired
	private ProductDBGateway dbGateway;
	

	public List<Product> findAll(){
		return dbGateway.findAll();
	}
	
	public List<Product> findByListIds(List<UUID> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Product findById(UUID id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(UUID id) {
		dbGateway.deleteById(id);
	}
	
	public Product save(Product entity) {
		return dbGateway.save(entity);
	}

	public Product getProductEntity(ProductEditDTO productEditDTO) {
		Product product=new Product();
		product.setId(productEditDTO.getId());
		product.setName(productEditDTO.getName());
		product.setPrice(productEditDTO.getPrice());
		product.setDescription(productEditDTO.getDescription());
		return product;
	}

}