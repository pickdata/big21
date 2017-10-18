package com.pickdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pickdata.domain.CreditDO;
import com.pickdata.page.PageMaker;
import com.pickdata.page.PageVO;
import com.pickdata.persistence.PickdataRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/credits")
@Log
public class PickdataContoller {
	
	@Autowired
	private PickdataRepository repo;
	
	@GetMapping("/list")
	public String list(@ModelAttribute("pageVO") PageVO vo, Model model){
		
		Pageable pageable = vo.makePageable(0, "bno");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());
		
		Page<CreditDO> result = repo.findAll(predicate, pageable);
		
		log.info(""+ pageable);
		log.info(""+result);
		
		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());
		
		
		model.addAttribute("pageMaker", new PageMaker(result));
				
		return "thymeleaf/credits/list";
	}
	

}
