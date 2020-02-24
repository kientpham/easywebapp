package com.kientpham.webapp.orderservice.product.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.product.Product;
import com.kientpham.webapp.orderservice.product.dbgatewayimpl.ProductRepository;
import com.kientpham.webapp.orderservice.product.ProductDBGateway;
import java.util.UUID;

@Component
public class ProductDBGatewayImp implements ProductDBGateway{
	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> findAll() {
		return (List<Product>) repository.findAll();
	}

	@Override
	public Product findById(UUID id) {
		return repository.findById(id).orElse(new Product());
	}

	@Override
	public List<Product> findByListIds(List<UUID> listId) {		
		return (List<Product>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);		
	}

	@Override
	public Product save(Product entity) {
		return repository.save(entity);
	}

}