package com.api.component.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.component.model.dto.ComponentResponseDTO;
import com.api.component.service.ComponentService;
import com.api.component.validator.ComponentValidator;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class ComponentController {

	private static Logger log = LoggerFactory.getLogger(ComponentController.class);
	
	@Autowired
	private ComponentValidator validator;
	
	@Autowired
	private ComponentService service;
	
	
		//@HystrixCommand(fallbackMethod="fallBackGetComponent")
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/components", produces = "application/json")
	public ComponentResponseDTO getComponent(@RequestParam(value = "name", required = false) String name) throws Exception {
				
		log.info("Start - ComponentController.getComponent param---------->"+name);
		
		ComponentResponseDTO componentResponseDTO;

		
		if (name != null) {
		//Allow the caller to optionally specify a comma separated list of names, such as:�GET /api/v1/components?name=API,Services�
			validator.validateRequest(name);
			log.info("Request validation Done");
		}

		
		log.info("Start - Service Layer Execution ");
		componentResponseDTO = service.getComponents(name);

		if (componentResponseDTO != null)
			log.info("Response sent" + componentResponseDTO.toString());

		log.info("End - ComponentController.getComponent ");

		return componentResponseDTO;

	}
	
	//Fall back call.
	public ComponentResponseDTO fallBackGetComponent()
	{
		log.info("Start - Fall back call Execution ");
		return new ComponentResponseDTO(0);
	}
}

