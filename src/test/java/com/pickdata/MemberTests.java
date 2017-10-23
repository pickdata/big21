package com.pickdata;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.pickdata.domain.Member;
import com.pickdata.persistence.MemberRepository;
import com.pickdata.domain.MemberRole;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTests {

	@Autowired
	private MemberRepository repo;
	
	@Test
	public void testInsert() {
		
		Member mgr = new Member();
		mgr.setUid("pickdata");
		mgr.setUpw("pickme");
		
		MemberRole role = new MemberRole();
		role.setRoleName("MANAGER");
		
		repo.save(mgr);
		
	}
	
	@Test
	public void testRead(){
		
		Optional<Member> result = repo.findById("pickdata");
		result.ifPresent(mgr -> log.info("mgr" + mgr));
		
	}

}
