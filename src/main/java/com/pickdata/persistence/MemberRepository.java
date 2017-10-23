package com.pickdata.persistence;

import org.springframework.data.repository.CrudRepository;

import com.pickdata.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String>{
		
	
}
