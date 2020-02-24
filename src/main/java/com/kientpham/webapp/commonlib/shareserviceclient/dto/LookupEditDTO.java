package com.kientpham.webapp.commonlib.shareserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LookupEditDTO{
	private Integer id;
	private String lookupType;
	private String value;
	private Integer sequence;
	private String description;

	public LookupEditDTO() {
		//default constructor
	}
	public LookupEditDTO(Lookup lookup) {
		if(lookup !=null){
			this.id=lookup.getId();
			this.lookupType=lookup.getLookupType();
			this.value=lookup.getValue();
			this.sequence=lookup.getSequence();
			this.description=lookup.getDescription();
		}
	}
}