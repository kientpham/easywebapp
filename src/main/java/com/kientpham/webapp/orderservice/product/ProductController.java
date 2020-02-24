package com.kientpham.webapp.orderservice.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductTableDTO;
import com.kientpham.webapp.orderservice.product.ProductReadService;

@RestController
@RequestMapping(value="/orderservice/products")
public class ProductController{
	@Autowired
	private ProductReadService productReadService;
	@Autowired
	private ProductWriteService productWriteService;

	@RequestMapping(value="/producttabledto", method=RequestMethod.GET)
	public List<ProductTableDTO> getProductTableDTO(){
		return productReadService.getListProductTableDTO();		
	}

	@RequestMapping(value="producteditdto",method=RequestMethod.GET)
	public ResponseEntity<ProductEditDTO> getproducteditdto(@RequestParam UUID id){
		return new ResponseEntity<ProductEditDTO>(productReadService.getProductEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/producteditdto", method=RequestMethod.POST)
	public String saveProduct(@RequestBody(required=true) ProductEditDTO productEditDTO) {
		productWriteService.saveProduct(productEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteProduct(@RequestBody(required=true) UUID id) {
		productWriteService.deleteProductById(id);
		return "Successfully";
	}

}