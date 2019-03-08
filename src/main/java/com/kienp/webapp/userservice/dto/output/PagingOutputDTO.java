package com.kienp.webapp.userservice.dto.output;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingOutputDTO<T> {
	
	private List<T> content;
	
	private int totalElements;

}
