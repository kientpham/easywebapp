package com.kientpham.webapp.orderservice.order;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderEditDTO;
import com.kientpham.webapp.commonlib.orderserviceclient.dto.OrderTableDTO;
import com.kientpham.webapp.orderservice.order.OrderReadService;
import com.kientpham.webapp.commonlib.userserviceclient.dto.UserJoinListDTO;

@RestController
@RequestMapping(value="/orderservice/orders")
public class OrderController{
	@Autowired
	private OrderReadService orderReadService;
	@Autowired
	private OrderWriteService orderWriteService;

	@RequestMapping(value="/ordertabledto", method=RequestMethod.GET)
	public List<OrderTableDTO> getOrderTableDTO(){
		return orderReadService.getListOrderTableDTO();		
	}

	@RequestMapping(value="ordereditdto",method=RequestMethod.GET)
	public ResponseEntity<OrderEditDTO> getordereditdto(@RequestParam Integer id){
		return new ResponseEntity<OrderEditDTO>(orderReadService.getOrderEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/ordereditdto", method=RequestMethod.POST)
	public String saveOrder(@RequestBody(required=true) OrderEditDTO orderEditDTO) {
		orderWriteService.saveOrder(orderEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteOrder(@RequestBody(required=true) Integer id) {
		orderWriteService.deleteOrderById(id);
		return "Successfully";
	}

}