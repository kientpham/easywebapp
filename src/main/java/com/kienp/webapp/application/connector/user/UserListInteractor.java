package com.kienp.webapp.application.connector.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.kienp.webapp.application.connector.DataTablePresenter;
import com.kienp.webapp.application.model.datatable.PaginationCriteria;
import com.kienp.webapp.application.model.datatable.TablePage;
import com.kienp.webapp.application.model.user.UserDataTable;
import com.kienp.webapp.application.model.user.UserSearch;
import com.kienp.webapp.userservice.dto.entity.User;
import com.kienp.webapp.userservice.service.CategoryService;
import com.kienp.webapp.userservice.service.UserService;

@Component
public class UserListInteractor {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	public List<UserDataTable> getUserList(UserSearch userSearch) {
		if (userSearch.getUserStatusSearch() == 0 && userSearch.getName() == Strings.EMPTY) {
			List<UserDataTable> returnList = new ArrayList<UserDataTable>();
			Map<Integer, String> categoryMap=categoryService.getMapAllCategory();
			for (User user : userService.getAllUsers()) {
				returnList.add(new UserDataTable(user, categoryMap));
			}
			return returnList;
		} else {
			return null; // TODO
		}
	}

	public TablePage getUsersListPaging(PaginationCriteria paginationCriteria) {
		Pageable pageRequest = PageRequest.of(paginationCriteria.getStart() / paginationCriteria.getLength(),
				paginationCriteria.getLength());
		Page<User> userList = userService.getAllUser(pageRequest);

		List<UserDataTable> listUserTable = this.convertListUserToDataTable(userList.getContent(), categoryService.getMapAllCategory());

		return DataTablePresenter.buildTablePage(listUserTable, paginationCriteria.getDraw(),
				(int) userList.getTotalElements());
	}

	private List<UserDataTable> convertListUserToDataTable(List<User> userList, Map<Integer, String> categoryMap) {
		List<UserDataTable> list = new ArrayList<UserDataTable>();
		for (User user : userList) {
			list.add(new UserDataTable(user, categoryMap));
		}
		return list;
	}

	public String deleteUsers(List<Integer> ids) {
		userService.deleteListUser(ids);
		return "User has been deleted";
	}
}
