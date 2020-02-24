package com.kientpham.webapp.shareservice.lookup;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.shareservice.lookup.LookupDBGateway;
import com.kientpham.webapp.commonlib.shareserviceclient.dto.LookupEditDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class LookupDomain{
	@Autowired
	private LookupDBGateway dbGateway;
	

	public List<Lookup> findAll(){
		return dbGateway.findAll();
	}
	
	public List<Lookup> findByListIds(List<Integer> ids){
		return dbGateway.findByListIds(ids);
	}
	
	public Lookup findById(Integer id) {
		if (id==null) return null;
		return dbGateway.findById(id);
	}

	public void deleteById(Integer id) {
		dbGateway.deleteById(id);
	}
	
	public Lookup save(Lookup entity) {
		return dbGateway.save(entity);
	}

	public Lookup getLookupEntity(LookupEditDTO lookupEditDTO) {
		Lookup lookup=new Lookup();
		if (lookupEditDTO.getId()==null) {
			lookupEditDTO.setId(lookupEditDTO.hashCode());
					}
		lookup.setId(lookupEditDTO.getId());
		lookup.setLookupType(lookupEditDTO.getLookupType());
		lookup.setValue(lookupEditDTO.getValue());
		lookup.setSequence(lookupEditDTO.getSequence());
		lookup.setDescription(lookupEditDTO.getDescription());
		return lookup;
	}
	public List<Lookup> findAllSorted() {		
		return dbGateway.findAllSorted();		
	}

	
	public List<Lookup> getLookupByType(String lookupType) {
		return dbGateway.findByLookupType(lookupType);
	}	

	
	public List<Lookup> getLookupByTypes(List<String> LookupTypes) {
		List<Lookup> lookupTypeList=new ArrayList<Lookup>();				
		for(String LookupType: LookupTypes) {
			lookupTypeList.addAll(this.getLookupByType(LookupType));	
		}
		return lookupTypeList;
	}

	
	public Map<Integer, String> getMapByLookups(List<String> lookupTypes) {
		Map<Integer, String> map=new HashMap<Integer, String>();
		for(String lookupType: lookupTypes) {
			for(Lookup item:this.getLookupByType(lookupType)) {
				map.put(item.getId(), item.getValue());
			}	
		}
		return map;
	}
}