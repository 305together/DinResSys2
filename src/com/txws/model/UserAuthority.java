package com.txws.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userauthority")
public class UserAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="authoId")
	private Authority authority;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="userId")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority newAuthority) {
		if (this.authority == null || !this.authority.equals(newAuthority)) {
			if (this.authority != null) {
				Authority oldAuthority = this.authority;
				this.authority = null;
				oldAuthority.removeUserAuthority(this);
			}
			if (newAuthority != null) {
				this.authority = newAuthority;
				this.authority.addUserAuthority(this);
			}
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		if (this.user == null || !this.user.equals(newUser)) {
			if (this.user != null) {
				User oldUser = this.user;
				this.user = null;
				oldUser.removeUserAuthority(this);
			}
			if (newUser != null) {
				this.user = newUser;
				this.user.addUserAuthority(this);
			}
		}
	}

}
