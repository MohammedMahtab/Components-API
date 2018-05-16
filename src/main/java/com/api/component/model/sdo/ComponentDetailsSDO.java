package com.api.component.model.sdo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// SDO's are Service Data Object
public class ComponentDetailsSDO {

	
	private int componentCount;
	private List<ComponentsDSO> componentsDSO;
	
	public int getComponentCount() {
		return componentCount;
	}
	public void setComponentCount(int componentCount) {
		this.componentCount = componentCount;
	}
	public List<ComponentsDSO> getComponents() {
		return componentsDSO;
	}
	public void setComponents(List<ComponentsDSO> componentsDSO) {
		this.componentsDSO = componentsDSO;
	}
	public ComponentDetailsSDO() {
		
	}	
	
	@Override
	public String toString() {
		return "ComponentDetailsSDO [componentCount=" + componentCount + ", components=" + componentsDSO + "]";
	}
	
}
