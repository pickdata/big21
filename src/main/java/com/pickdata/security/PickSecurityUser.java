package com.pickdata.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.pickdata.domain.Manager;
import com.pickdata.domain.ManagerRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickSecurityUser extends User {
	
	private static final String ROLE_PREFIX = "ROLE_";
	
	private Manager manager;
	
	public PickSecurityUser(Manager manager) {
		
		super(manager.getUid(), manager.getUpw(), makeGrantedAuthority(manager.getRoles()));
		
		this.manager = manager;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<ManagerRole> roles){
		
		List<GrantedAuthority> list = new ArrayList<>();
		
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		
		return list;
	}
	

}
