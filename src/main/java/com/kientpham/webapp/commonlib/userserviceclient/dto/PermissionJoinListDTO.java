package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.permission.Permission;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;

	private String isChecked;
}