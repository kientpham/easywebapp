package com.kientpham.webapp.shareservice.lookup;
import java.util.List;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;


public interface LookupWriteService{

	public void deleteLookupById(Integer id);


	public void deleteListLookup(List<Integer> ids);

	public LookupEditDTO saveLookup(LookupEditDTO lookupEditDTO);

}