package com.kientpham.webapp.orderservice.productcategory.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;
import com.kientpham.webapp.orderservice.productcategory.dbgatewayimpl.ProductCategoryRepository;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryDBGateway;

@Component
public class ProductCategoryDBGatewayImp implements ProductCategoryDBGateway{
	@Autowired
	private ProductCategoryRepository repository;

	@Override
	public List<ProductCategory> findAll() {
		return (List<ProductCategory>) repository.findAll();
	}

	@Override
	public ProductCategory findById(Integer id) {
		return repository.findById(id).orElse(new ProductCategory());
	}

	@Override
	public List<ProductCategory> findByListIds(List<Integer> listId) {		
		return (List<ProductCategory>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public ProductCategory save(ProductCategory entity) {
		return repository.save(entity);
	}

}