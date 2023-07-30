package com.InfyTraining.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer emploeeId;
	private String employeeName;
	private String password;
	private boolean enabled;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name ="employee_roles", joinColumns = @JoinColumn (name="employee_id"), inverseJoinColumns = @JoinColumn (name="role_id"))
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

	@Override
	public int hashCode() {
		return Objects.hash(emploeeId, employeeName, enabled, password, roles);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(emploeeId, other.emploeeId) && Objects.equals(employeeName, other.employeeName)
				&& enabled == other.enabled && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles);
	}

	
}
