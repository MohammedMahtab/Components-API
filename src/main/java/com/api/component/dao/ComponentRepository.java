package com.api.component.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.component.entities.ComponentEntity;


@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Integer> {

}
