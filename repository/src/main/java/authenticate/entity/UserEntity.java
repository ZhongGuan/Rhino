package authenticate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import authenticate.repository.domain.User;


/**
 * The persistent class for the USER database table.
 * 
 */
@Entity
@Table(name="USER")
public class UserEntity implements User {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String userName;

	private String password;

    public UserEntity() {
    }

    @Override
	public String getUserName() {
		return this.userName;
	}

    @Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

    @Override
	public String getPassword() {
		return this.password;
	}

    @Override
	public void setPassword(String password) {
		this.password = password;
	}

}