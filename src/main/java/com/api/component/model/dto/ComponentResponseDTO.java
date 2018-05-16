package com.api.component.model.dto;

//DTO's are  Data Transfer Object
public class ComponentResponseDTO {
	
	private int components;
	
	public int getComponents() {
		return components;
	}

	public void setComponents(int components) {
		this.components = components;
	}

	public ComponentResponseDTO(int components) {
		super();
		this.components = components;
	}


	@Override
	public String toString() {
		return "ComponentResponseDTO [components=" + components + "]";
	}

	public ComponentResponseDTO() {
	
	}

	
	
}
