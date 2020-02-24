package com.kientpham.webapp.commonlib.userserviceclient.dto;
import com.kientpham.webapp.commonlib.utils.DateStringUtils;
import com.kientpham.webapp.userservice.user.User;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
public class UserTableDTO{
	private UUID id;
	private String username;
	private String firstName;
	private String lastName;
	private String birthDate;
	private String email;
	private String userType;
	private String status;
	private String address;

	public UserTableDTO(User user, Map<Integer,String> lookupMap) {
		if(user !=null){
			if (user.getId()!=null)
				this.id=user.getId();
			this.username=user.getUsername();
			this.firstName=user.getFirstName();
			this.lastName=user.getLastName();
			if (user.getBirthDate()!=null)
				this.birthDate=DateStringUtils.convertDateToString(user.getBirthDate(), DateStringUtils.DISPLAY_DATE_PATTERN);
			this.email=user.getEmail();
			this.userType=lookupMap.get(user.getUserType());
			this.status=lookupMap.get(user.getStatus());
			this.address=user.getAddress();
		}
	}
}