package com.kientpham.webapp.commonlib.dto.paging;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingOutputDTO<T>{
	private List<T> content;

	private int totalElements;
}