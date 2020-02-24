package com.kientpham.webapp.orderservice.product;
import java.util.List;
import com.kientpham.webapp.orderservice.product.Product;
import java.util.UUID;

public interface ProductDBGateway{
	public List<Product> findAll();

	public Product findById(UUID id);

	public List<Product> findByListIds(List<UUID> listId);

	public void deleteById(UUID id);

	public Product save(Product entity);


}