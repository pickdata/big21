package com.pickdata.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.pickdata.domain.Member;
import com.pickdata.domain.MemberRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PickSecurityUser extends User {
	
	private static final String ROLE_PREFIX = "ROLE_";
	
	private Member member;
	
	public PickSecurityUser(Member member) {
		
		super(member.getUid(), member.getUpw(), makeGrantedAuthority(member.getRoles()));
		
		this.member = member;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
		
		List<GrantedAuthority> list = new ArrayList<>();
		
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		
		return list;
	}
	

}
