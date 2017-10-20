package com.pickdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pickdata.domain.CreditDO;
import com.pickdata.domain.Manager;
import com.pickdata.page.PageMaker;
import com.pickdata.page.PageVO;
import com.pickdata.persistence.ManagerRepository;
import com.pickdata.persistence.PickdataRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/credits")
@Log
public class PickdataContoller {

	@Autowired
	private PickdataRepository repo;
	private ManagerRepository repo2;

	/*
	 * list.html
	 * siyeon
	 */
	@GetMapping("/list")
	public String list(@ModelAttribute("pageVO") PageVO vo, Model model) {

		Pageable pageable = vo.makePageable(0, "bno");
		Predicate predicate = repo.makePredicate(vo.getType(), vo.getKeyword());

		Page<CreditDO> result = repo.findAll(predicate, pageable);

		log.info("" + pageable);
		log.info("" + result);

		log.info("TOTAL PAGE NUMBER: " + result.getTotalPages());

		model.addAttribute("pageMaker", new PageMaker(result));

		return "thymeleaf/credits/list";
	}
	
	/*
	 * searchResult.html
	 * yearin
	 */
	@GetMapping("/searchResult")
	public String searchResult(Integer bno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("BNO: "+ bno);
		
		repo.findById(bno).ifPresent(creditDO -> model.addAttribute("vo", creditDO));
		
		return "thymeleaf/credits/searchResult";
	}
	
	
	/*
	 * simulation
	 * skyoo
	 */
	@GetMapping("/simulation")
	public String simulationGET(@ModelAttribute("vo")CreditDO vo ){
		log.info("simulation get");
		
		vo.setId(1);
		vo.setTarget(0);
		vo.setScore(100.000000000);
		
		return "thymeleaf/credits/simulation";
	}
	
	@PostMapping("/simulation")
	public String simulationPOST(@ModelAttribute("vo")CreditDO vo, RedirectAttributes rttr){
		
		log.info("simulation post");
		log.info("" + vo);

		repo.save(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/credits/result";
	}

	/*
	 * result
	 * bakug
	 */
	@GetMapping("/result")
	public String result(Integer bno, @ModelAttribute("pageVO") PageVO vo, Model model){
		
		log.info("result BNO: "+ bno);
//		repo.findById(bno).ifPresent(creditDO -> model.addAttribute("vo", creditDO));
		
		return "thymeleaf/credits/result";
	}
	
	/*
	 * login
	 * yoon
	 */
	@GetMapping("/login")
	public String login(@ModelAttribute("manager") Manager vo){
		
		log.info("login page ...");

//		repo2.save(vo);
		return "thymeleaf/credits/login";
	}
	
}
