package com.kientpham.webapp.commonlib.dto.paging;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PagingInputDTO{
	private int start;
	
	private int length;
	
	private String searchTerm;
	
	private String sortedColumnName;
	
	private String order;

}