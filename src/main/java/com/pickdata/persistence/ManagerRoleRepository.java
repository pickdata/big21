package com.pickdata.persistence;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pickdata.domain.ManagerRole;

public interface ManagerRoleRepository extends CrudRepository<ManagerRole, Integer>{

	
}
