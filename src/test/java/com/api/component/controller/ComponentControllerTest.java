package com.api.component.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.component.controller.ComponentController;
import com.api.component.dao.ComponentDao;
import com.api.component.mapper.ComponentMapper;
import com.api.component.model.dto.ComponentResponseDTO;
import com.api.component.model.sdo.ComponentDetailsSDO;
import com.api.component.service.ComponentService;
import com.api.component.validator.ComponentValidator;

import static org.testng.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;



@SpringBootTest
public class ComponentControllerTest {
	
	 @InjectMocks
	 ComponentController componentController;
	 
	 @Mock
	 ComponentValidator validator;
	 
	 @Mock
	 ComponentService service;
	 
	 @Mock
	 ComponentDao componentDao;
	 
	 @Mock
	 ComponentMapper mapper;
    
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetComponent() throws Exception  	{
    	
    	ComponentResponseDTO componentResponse;
    	//Test case for query param name = API
    	when(service.getComponents("API")).thenReturn(new ComponentResponseDTO(1) );
    	componentResponse = componentController.getComponent("API");
    	assertEquals(componentResponse.getComponents(),1);
    	
    	//Test case for query param name = Services
    	when(service.getComponents("Services")).thenReturn(new ComponentResponseDTO(0) );
    	 componentResponse = componentController.getComponent("Services");
    	assertEquals(componentResponse.getComponents(),0);
    	
    	//Test case without query param
    	when(service.getComponents(null)).thenReturn(new ComponentResponseDTO(26));
    	 componentResponse = componentController.getComponent(null);
    	assertEquals(componentResponse.getComponents(),26);
    	
    }
}
