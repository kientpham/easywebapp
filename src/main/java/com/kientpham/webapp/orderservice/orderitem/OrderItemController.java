package com.kientpham.webapp.orderservice.orderitem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderItemTableDTO;
import com.kientpham.webapp.orderservice.orderitem.OrderItemReadService;

@RestController
@RequestMapping(value="/orderservice/orderitems")
public class OrderItemController{
	@Autowired
	private OrderItemReadService orderItemReadService;
	@Autowired
	private OrderItemWriteService orderItemWriteService;

	@RequestMapping(value="/orderitemtabledto", method=RequestMethod.GET)
	public List<OrderItemTableDTO> getOrderItemTableDTO(){
		return orderItemReadService.getListOrderItemTableDTO();		
	}

	@RequestMapping(value="orderitemeditdto",method=RequestMethod.GET)
	public ResponseEntity<OrderItemEditDTO> getorderitemeditdto(@RequestParam String id){
		return new ResponseEntity<OrderItemEditDTO>(orderItemReadService.getOrderItemEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/orderitemeditdto", method=RequestMethod.POST)
	public String saveOrderItem(@RequestBody(required=true) OrderItemEditDTO orderItemEditDTO) {
		orderItemWriteService.saveOrderItem(orderItemEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteOrderItem(@RequestBody(required=true) String id) {
		orderItemWriteService.deleteOrderItemById(id);
		return "Successfully";
	}

}