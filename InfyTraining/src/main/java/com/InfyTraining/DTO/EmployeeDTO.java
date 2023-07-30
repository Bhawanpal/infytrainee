package com.InfyTraining.DTO;

import java.util.HashSet;
import java.util.Set;


import com.InfyTraining.entity.Role;

public class EmployeeDTO {

	private Integer emploeeId;
	private String employeeName;
	private String password;
	private boolean enabled;
	private Set<Role> roles=new HashSet<>();


	public Integer getEmploeeId() {
		return emploeeId;
	}

	public void setEmploeeId(Integer emploeeId) {
		this.emploeeId = emploeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
