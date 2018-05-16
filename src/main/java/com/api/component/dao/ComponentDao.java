package com.api.component.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.component.entities.ComponentEntity;

@Repository
public interface ComponentDao {

	public void saveAllComponentsToDB(List<ComponentEntity> componentEntity);
}
