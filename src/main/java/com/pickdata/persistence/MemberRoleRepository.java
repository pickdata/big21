package com.pickdata.persistence;

import org.springframework.data.repository.CrudRepository;

import com.pickdata.domain.MemberRole;

public interface MemberRoleRepository extends CrudRepository<MemberRole, Integer>{

	
}
