package com.marc2web.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleid;
	
	

	

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	private String role;

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	

	

	

	
	
	

	
	
	

	



	

}
