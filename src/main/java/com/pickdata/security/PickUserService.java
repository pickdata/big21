package com.pickdata.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pickdata.persistence.MemberRepository;

import lombok.extern.java.Log;

@Log
@Service
public class PickUserService {
	
	@Autowired
	MemberRepository repo;
	
	
	
//	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		repo.findById(username)
		.ifPresent(member -> log.info(""+member));
		
		return repo.findById(username).filter(m -> m != null).map(m -> new PickSecurityUser(m)).get();
	}

}
