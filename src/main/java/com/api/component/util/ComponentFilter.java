package com.api.component.util;

import java.util.stream.Collectors;
import java.util.List;
import java.util.StringTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.model.sdo.ComponentsDSO;
import com.api.component.service.ComponentService;

@Component
public class ComponentFilter {
	private static Logger log = LoggerFactory.getLogger(ComponentFilter.class);
	
	public ComponentDetailsSDO filterAllowedNames(String name, ComponentDetailsSDO componentDetailsSDO) {
		// TODO Auto-generated method stub
		log.info("Executing ComponentFilter.filterAllowedNames........ ");
	if(name!=null)	{
		log.info("Executing ComponentFilter.filterAllowedNames........no null ");
		//Allow the caller to optionally specify a comma separated list of names, such as:�GET /api/v1/components?name=API,Services�
		StringTokenizer tokenizer = new StringTokenizer(name, ",");
		
		while (tokenizer.hasMoreTokens()) {
			String nextToken=tokenizer.nextToken();
			
			if(nextToken.equalsIgnoreCase(Consts.SERVICE_NAME))
			{
				log.info("Executing ComponentFilter.filterAllowedNames........no null Services nextToken "+ nextToken);
				List<ComponentsDSO> components = componentDetailsSDO.getComponents().stream()
						.filter(c -> c.getName().equalsIgnoreCase(Consts.SERVICE_NAME)).collect(Collectors.toList());
				componentDetailsSDO.setComponents(components);
			}	
			if(nextToken.equalsIgnoreCase(Consts.API_NAME))
			{
				log.info("Executing ComponentFilter.filterAllowedNames........no null API nextToken "+ nextToken);
				List<ComponentsDSO> components = componentDetailsSDO.getComponents().stream()
						.filter(c -> c.getName().equalsIgnoreCase(Consts.API_NAME)).collect(Collectors.toList());
				componentDetailsSDO.setComponents(components);
			}
		
		
	 }
	}
	log.info("End ComponentFilter.filterAllowedNames........ ");
		return componentDetailsSDO;
	}
		
		
			
}
