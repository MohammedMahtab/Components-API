package com.api.component.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPONENTS")
public class ComponentEntity {
	
	@Id
	@Column(name = "COMPOSITE_ID")
	private String compositeId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "NAME")
	private String name;
	public String getCompositeId() {
		return compositeId;
	}

	@Override
	public String toString() {
		return "ComponentEntity [compositeId=" + compositeId + ", status=" + status + ", name=" + name + "]";
	}

	

	public void setCompositeId(String compositeId) {
		this.compositeId = compositeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComponentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComponentEntity(String compositeId, String status, String name) {
		super();
		this.compositeId = compositeId;
		this.status = status;
		this.name = name;
	}

	
	
}
