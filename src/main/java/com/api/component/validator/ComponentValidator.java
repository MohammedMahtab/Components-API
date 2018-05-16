package com.api.component.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.api.component.exception.ResponseException;
import com.api.component.exception.RequestParamException;
import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.model.sdo.ComponentsDSO;
import com.api.component.util.Consts;


@Component
public class ComponentValidator {

	private static Logger log = LoggerFactory.getLogger(ComponentValidator.class);
	
	
	
//Allow the caller to optionally specify a comma separated list of names, such as:�GET /api/v1/components?name=API,Services�
	 public void validateRequest(String name) {
		log.info("Start - ComponentValidator.validateRequest" + name);

	if(name != null){
		StringTokenizer tokenizer = new StringTokenizer(name, ",");
		
		while (tokenizer.hasMoreTokens()) {	
			String nextToken=tokenizer.nextToken();
			if(!(nextToken.equalsIgnoreCase(Consts.API_NAME) || nextToken.equalsIgnoreCase(Consts.SERVICE_NAME))) 
			{
				throw new RequestParamException(Consts.PARAM_NAME);
			}
		}
	}
	}
	 
	
	public void validateRespose(ComponentDetailsSDO response) {
		log.info("Start - ComponentValidator.validateRespose");
		if (response.getComponents() != null && response.getComponents().size() > 0) {
			for (ComponentsDSO comp : response.getComponents()) {
				if (!(comp.getStatus().equalsIgnoreCase(Consts.PARAM_OP)
						|| comp.getStatus().equalsIgnoreCase(Consts.PARAM_DP)
						|| comp.getStatus().equalsIgnoreCase(Consts.PARAM_PO)
						|| comp.getStatus().equalsIgnoreCase(Consts.PARAM_MO))) {
					throw new ResponseException(Consts.PARAM_NAME);
				}
			}
		}
	}
}
