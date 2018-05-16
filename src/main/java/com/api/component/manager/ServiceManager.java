package com.api.component.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.model.sdo.ComponentsDSO;
import com.api.component.util.Consts;


@Component
public class ServiceManager {
	
	private static Logger log = LoggerFactory.getLogger(ServiceManager.class);
	
	@Autowired
	private Environment env;
	
	

	public ComponentDetailsSDO retriveDigitalOceanAPI() throws Exception {
		// TODO Auto-generated method stub
		log.info("Start - ServiceManager.retriveDigitalOceanAPI");
		ResponseEntity<ComponentDetailsSDO> componentDetailsSDO = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			log.info("Start - Calling Digital Ocean API to retrieve component details");
			String getComponentURL = env.getProperty("digital.ocean.host") + Consts.DIGITAL_OCEAN_URI;
			componentDetailsSDO = restTemplate.exchange(getComponentURL, HttpMethod.GET, null,
					ComponentDetailsSDO.class);
			
			
			log.info("Start - Removing components with group_id as null");
			List<ComponentsDSO> componentsDSO = componentDetailsSDO.getBody().getComponents().stream()
					.filter(c -> c.getGroupId() != null).collect(Collectors.toList());
			componentDetailsSDO.getBody().setComponents(componentsDSO);
			
			return componentDetailsSDO.getBody();
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}

}



