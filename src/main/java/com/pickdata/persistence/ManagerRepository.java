package com.pickdata.persistence;

import org.springframework.data.repository.CrudRepository;

import com.pickdata.domain.Manager;

public interface ManagerRepository extends CrudRepository<Manager, String>{

}
