package com.kientpham.webapp.commonlib.dto.paging;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PaginationCriteria {
	/**
     * Draw counter. This is used by DataTables to ensure that the Ajax returns from
     * server-side processing requests are drawn in sequence by DataTables.
     * This is used as part of the draw return parameter.
     */
    private int draw;

    /**
     * Paging first record indicator. This is the start point in the current data
     * set (0 index based - i.e. 0 is the first record).
     */
    private int start;

    /**
     * Number of records that the table can display in the current draw. 
     * Note that this can be -1 to indicate that all records should be returned 
     */
    private int length;

    private SearchCriteria search;

    private List<OrderingCriteria> order;

    private List<Column> columns;
}