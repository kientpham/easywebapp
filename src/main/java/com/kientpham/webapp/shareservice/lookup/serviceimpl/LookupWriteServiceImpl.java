package com.kientpham.webapp.shareservice.lookup.serviceimpl;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.shareservice.lookup.LookupDomain;
import com.kientpham.webapp.shareservice.lookup.LookupWriteService;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupTableDTO;

@Component
public class LookupWriteServiceImpl implements LookupWriteService{

	@Autowired
	private LookupDomain lookupDomain;

	@Override
	public void deleteLookupById(Integer id) {
		lookupDomain.deleteById(id);		
	}

	@Override
	public void deleteListLookup(List<Integer> ids) {
		for (Integer id:ids) {
			lookupDomain.deleteById(id);
		}		
	}

	@Override
	public LookupEditDTO saveLookup(LookupEditDTO lookupEditDTO) {
		Lookup lookup=lookupDomain.getLookupEntity(lookupEditDTO);
		;		lookupDomain.save(lookup);
		return lookupEditDTO;
	}
}