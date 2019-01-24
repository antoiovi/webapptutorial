package com.antoiovi.projectp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="group_name")
	private String groupName;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="group")
	private List<Role> roles;

	public Group() {
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setGroup(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setGroup(null);

		return role;
	}

}