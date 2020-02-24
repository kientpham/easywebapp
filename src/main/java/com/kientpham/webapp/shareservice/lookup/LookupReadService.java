package com.kientpham.webapp.shareservice.lookup;
import java.util.List;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupTableDTO;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;

import java.util.Map;

public interface LookupReadService{

	public LookupEditDTO getLookupEditDTOById(Integer id);

	public List<LookupTableDTO> getListLookupTableDTO();

	public Map<Integer, String> getMapAllLookup();
}