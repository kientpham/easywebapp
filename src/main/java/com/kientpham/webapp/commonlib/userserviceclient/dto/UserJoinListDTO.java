package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.user.User;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserJoinListDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;

	private String firstName;

	private String lastName;

	private String email;

	private String isChecked;
}