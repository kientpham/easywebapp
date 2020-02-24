package com.kientpham.webapp.orderservice.productcategory;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.ProductCategoryTableDTO;
import com.kientpham.webapp.orderservice.productcategory.ProductCategoryReadService;

@RestController
@RequestMapping(value="/orderservice/productcategorys")
public class ProductCategoryController{
	@Autowired
	private ProductCategoryReadService productCategoryReadService;
	@Autowired
	private ProductCategoryWriteService productCategoryWriteService;

	@RequestMapping(value="/productcategorytabledto", method=RequestMethod.GET)
	public List<ProductCategoryTableDTO> getProductCategoryTableDTO(){
		return productCategoryReadService.getListProductCategoryTableDTO();		
	}

	@RequestMapping(value="productcategoryeditdto",method=RequestMethod.GET)
	public ResponseEntity<ProductCategoryEditDTO> getproductcategoryeditdto(@RequestParam Integer id){
		return new ResponseEntity<ProductCategoryEditDTO>(productCategoryReadService.getProductCategoryEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/productcategoryeditdto", method=RequestMethod.POST)
	public String saveProductCategory(@RequestBody(required=true) ProductCategoryEditDTO productCategoryEditDTO) {
		productCategoryWriteService.saveProductCategory(productCategoryEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteProductCategory(@RequestBody(required=true) Integer id) {
		productCategoryWriteService.deleteProductCategoryById(id);
		return "Successfully";
	}

}