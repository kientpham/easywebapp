package com.kientpham.webapp.orderservice.product.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.orderservice.product.Product;
import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, UUID> {

}