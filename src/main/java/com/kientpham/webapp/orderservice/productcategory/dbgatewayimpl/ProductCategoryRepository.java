package com.kientpham.webapp.orderservice.productcategory.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.orderservice.productcategory.ProductCategory;


public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {

}