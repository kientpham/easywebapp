package com.kientpham.webapp.shareservice.lookup;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupTableDTO;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;

@RestController
@RequestMapping(value="/shareservice/lookups")
public class LookupController{
	@Autowired
	private LookupReadService lookupReadService;
	@Autowired
	private LookupWriteService lookupWriteService;

	@RequestMapping(value="/lookuptabledto", method=RequestMethod.GET)
	public List<LookupTableDTO> getLookupTableDTO(){
		return lookupReadService.getListLookupTableDTO();		
	}

	@RequestMapping(value="lookupeditdto",method=RequestMethod.GET)
	public ResponseEntity<LookupEditDTO> getlookupeditdto(@RequestParam Integer id){
		return new ResponseEntity<LookupEditDTO>(lookupReadService.getLookupEditDTOById(id),HttpStatus.OK);
	}

	@RequestMapping(value="/lookupeditdto", method=RequestMethod.POST)
	public String saveLookup(@RequestBody(required=true) LookupEditDTO lookupEditDTO) {
		lookupWriteService.saveLookup(lookupEditDTO);
		return "Saved Successfully!";
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public String deleteLookup(@RequestBody(required=true) Integer id) {
		lookupWriteService.deleteLookupById(id);
		return "Successfully";
	}

}