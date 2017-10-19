package com.pickdata;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.pickdata.domain.Manager;
import com.pickdata.persistence.ManagerRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class ManagerTests {

	@Autowired
	private ManagerRepository repo;
	
	@Test
	public void testInsert() {
		
		Manager mgr = new Manager();
		mgr.setUid("pickdata");
		mgr.setUpw("pickme");
		
		repo.save(mgr);
		
	}
	
	@Test
	public void testRead(){
		
		Optional<Manager> result = repo.findById("pickdata");
		result.ifPresent(mgr -> log.info("mgr" + mgr));
		
	}

}
