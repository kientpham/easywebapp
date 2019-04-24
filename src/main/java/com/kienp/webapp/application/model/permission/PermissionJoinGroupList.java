package com.kienp.webapp.application.model.permission;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionJoinGroupList implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer permisisonId;

	private String permisisonName;

	private String isChecked;

}
