package com.kientpham.webapp.commonlib.shareserviceclient.dto;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LookupTableDTO{
	private Integer id;
	private String lookupType;
	private String value;
	private String sequence;
	private String description;

	public LookupTableDTO(Lookup lookup,Map<Integer,String> lookupMap) {
		if(lookup !=null){
			this.id=lookup.getId();
			this.lookupType=lookup.getLookupType();
			this.value=lookup.getValue();
			this.sequence=lookup.getSequence().toString();
			this.description=lookup.getDescription();
		}
	}
}