package com.api.component.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.api.component.dao.ComponentDao;
import com.api.component.dao.ComponentRepository;
import com.api.component.entities.ComponentEntity;


@Repository
public class ComponentDaoImpl implements ComponentDao{

	@Autowired
	private ComponentRepository repository;
	
	@Override
	public void saveAllComponentsToDB(List<ComponentEntity> componentEntity) {
		repository.saveAll(componentEntity);
		}

}
