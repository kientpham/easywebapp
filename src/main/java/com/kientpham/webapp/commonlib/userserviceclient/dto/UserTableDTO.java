package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.userservice.user.User;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserTableDTO{
	private Integer id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	private String status;
	private String address;

	public UserTableDTO(User user,Map<Integer,String> lookupMap) {
		if(user !=null){
			this.id=user.getId();
			this.username=user.getUsername();
			this.firstName=user.getFirstName();
			this.lastName=user.getLastName();
			this.email=user.getEmail();
			this.userType=lookupMap.get(user.getUserType());
			this.status=lookupMap.get(user.getStatus());
			this.address=user.getAddress();
		}
	}
}