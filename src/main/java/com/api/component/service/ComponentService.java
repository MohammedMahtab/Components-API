package com.api.component.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.component.dao.ComponentDao;
import com.api.component.entities.ComponentEntity;
import com.api.component.manager.ServiceManager;
import com.api.component.mapper.ComponentMapper;
import com.api.component.model.dto.ComponentResponseDTO;
import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.model.sdo.ComponentsDSO;
import com.api.component.util.ComponentFilter;
import com.api.component.validator.ComponentValidator;

@Service
public class ComponentService {

	private static Logger log = LoggerFactory.getLogger(ComponentService.class);
	
	
	@Autowired
	private ComponentValidator validator;
	
	@Autowired
	private ComponentService service;
	
	@Autowired
	private ComponentMapper mapper;
	
	@Autowired
	private ComponentDao componentDao;
	
	@Autowired
	ServiceManager  serviceManager;
	
	@Autowired
	ComponentFilter componentFilter;
	
	public ComponentResponseDTO getComponents(String name) throws Exception {
	   
		log.info("Start - ComponentService.getComponents param---------->"+name);
		ComponentDetailsSDO componentDetailsSDO;
		ComponentResponseDTO componentResponseDTO = new ComponentResponseDTO();
		
		try {
			
			log.info("Start - ComponentService.getComponents invoking Digital Ocean API");
			
			componentDetailsSDO = serviceManager.retriveDigitalOceanAPI();
			
			log.info("Response received from  Digital Ocean API");

			validator.validateRespose(componentDetailsSDO);

			log.info("Filtering Response  ");
		//Allow the caller to optionally specify a comma separated list of names, such as:�GET /api/v1/components?name=API,Services�
			componentDetailsSDO = componentFilter.filterAllowedNames(name, componentDetailsSDO);

			
			log.info("Entity Model Mapping ");
			List<ComponentEntity> compEnityList = mapper.mapResponseToEntityModel(componentDetailsSDO);

			
			log.info("Transactions inserting to H2-DataBase as In memory");
			componentDao.saveAllComponentsToDB(compEnityList);

			
			componentResponseDTO.setComponents(compEnityList.size());

			return componentResponseDTO;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	

	}
