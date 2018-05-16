package com.api.component.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.api.component.entities.ComponentEntity;
import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.model.sdo.ComponentsDSO;


@Component
public class ComponentMapper {

	private static Logger log = LoggerFactory.getLogger(ComponentMapper.class);
	
	public List<ComponentEntity> mapResponseToEntityModel(ComponentDetailsSDO response)
	{
		log.info("Start - ComponentMapper.mapResponseToEntityModel ");
		List<ComponentEntity> componentEntityList = new ArrayList<ComponentEntity>();

		if (response.getComponents() != null && response.getComponents().size() > 0) {
			for (ComponentsDSO comp : response.getComponents()) {
				ComponentEntity compEntity = new ComponentEntity();
				compEntity.setCompositeId(String.valueOf(comp.hashCode()));
				compEntity.setName(comp.getName());
				compEntity.setStatus(comp.getStatus());
				componentEntityList.add(compEntity);
			}
		}
		log.info("End - ComponentMapper.mapResponseToEntityModel ");
	 return componentEntityList;
	}
}
