package com.kientpham.webapp.commonlib.userserviceclient.dto;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;
import com.kientpham.webapp.userservice.user.User;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
public class UserEditDTO{
	private UUID id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String email;
	private Integer userType;
	private Integer status;
	private String address;
	private LocalDateTime lastUpdated;
	private LocalDateTime created;
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
			this.birthDate=user.getBirthDate();
			this.email=user.getEmail();
			this.userType=user.getUserType();
			this.status=user.getStatus();
			this.address=user.getAddress();
			this.lastUpdated=user.getLastUpdated();
			this.created=user.getCreated();
		}
	}

}