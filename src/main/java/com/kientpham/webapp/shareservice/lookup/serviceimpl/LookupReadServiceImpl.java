package com.kientpham.webapp.shareservice.lookup.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.shareservice.lookup.LookupDomain;
import com.kientpham.webapp.shareservice.lookup.LookupReadService;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupTableDTO;
import java.util.Map;
import java.util.HashMap;

@Component
public class LookupReadServiceImpl implements LookupReadService{

	@Autowired
	private LookupDomain lookupDomain;

	@Override
	public LookupEditDTO getLookupEditDTOById(Integer id) {
		return new LookupEditDTO(lookupDomain.findById(id));
	}

	@Autowired
	private LookupReadService lookupReadService;

	@Override
	public List<LookupTableDTO> getListLookupTableDTO() {
		Map<Integer, String> lookupMap = lookupReadService.getMapAllLookup();
		List<Lookup> allLookup = lookupDomain.findAll();
		List<LookupTableDTO> lookupTable = new ArrayList<LookupTableDTO>();
		for (Lookup lookup :allLookup) {
 			lookupTable.add(new LookupTableDTO(lookup, lookupMap));
		}
		return lookupTable;
	}

	@Override
	public Map<Integer, String> getMapAllLookup() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (Lookup item : lookupDomain.findAll()) {
			map.put(item.getId(), item.getValue());
		}
		return map;
	}
}