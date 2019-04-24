package com.kienp.webapp.application.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kienp.webapp.application.model.datatable.TablePage;

public final class DataTablePresenter {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static TablePage buildTablePage(List<?> data, int draw, int totalSize) {
		TablePage page = new TablePage();
		page.setDraw(draw);
		page.setRecordsTotal(totalSize);
		page.setRecordsFiltered(totalSize);
		List<Map<String, String>> records = getData(data);
		page.setData(records);
		return page;
	}

	private static List<Map<String, String>> getData(List<?> data) {
		List<Map<String, String>> records = new ArrayList<>(data.size());
		data.forEach(i -> {
			Map<String, Object> oldMap = objectMapper.convertValue(i, new TypeReference<Map<String, Object>>() {
			});
			Map<String, Object> newMap = new HashMap<String, Object>();
			Iterator<Entry<String, Object>> it = oldMap.entrySet().iterator();
			int column = 0;
			while (it.hasNext()) {
				Entry<String, Object> pair = it.next();
				newMap.put(Integer.toString(column), (pair.getValue() != null) ? pair.getValue().toString() : Strings.EMPTY);
				column++;
			}
			records.add(newMap.entrySet().stream().collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
		});
		return records;
	}
}
