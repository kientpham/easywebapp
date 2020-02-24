package com.kientpham.webapp.commonlib.dto.paging;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Column {
    private String data;

    private String name;

    private boolean searchable;

    private boolean orderable;

    private SearchCriteria search;
}