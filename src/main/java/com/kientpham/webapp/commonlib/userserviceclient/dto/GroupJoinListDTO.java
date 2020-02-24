package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.group.Group;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;

	private String isChecked;
}