package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserEditDTO{
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Integer userType;
	private Integer status;
	private String address;
	private List<Integer> groups;

	public UserEditDTO() {
		//default constructor
	}
	public UserEditDTO(User user) {
		if(user !=null){
			this.id=user.getId();
			this.username=user.getUsername();
			this.password=user.getPassword();
			this.firstName=user.getFirstName();
			this.lastName=user.getLastName();
			this.email=user.getEmail();
			this.userType=user.getUserType();
			this.status=user.getStatus();
			this.address=user.getAddress();
		}
	}
}