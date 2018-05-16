package com.api.component.model.sdo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

//SDO's are  Service Data Object
public class ComponentsDSO {
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("created_at")
	private  Date createdTime;
	
	@JsonProperty("updated_at")
	private Date updateTime;
	
	@JsonProperty("position")
	private int position;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("showcase")
	private String showcase;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("page_id")
	private String pageId;
	
	@JsonProperty("group_id")
	private String groupId;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getShowcase() {
		return showcase;
	}
	public void setShowcase(String showcase) {
		this.showcase = showcase;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public ComponentsDSO(String status, String name, Date createdTime, Date updateTime, int position, String description,
			String showcase, String id, String pageId, String groupId) {
		super();
		this.status = status;
		this.name = name;
		this.createdTime = createdTime;
		this.updateTime = updateTime;
		this.position = position;
		this.description = description;
		this.showcase = showcase;
		this.id = id;
		this.pageId = pageId;
		this.groupId = groupId;
	}
	public ComponentsDSO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((pageId == null) ? 0 : pageId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentsDSO other = (ComponentsDSO) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (pageId == null) {
			if (other.pageId != null)
				return false;
		} else if (!pageId.equals(other.pageId))
			return false;
		return true;
	}
	
}
