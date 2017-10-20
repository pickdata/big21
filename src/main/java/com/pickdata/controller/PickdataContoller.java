package com.pickdata.controller;

import java.util.Arrays;

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

import com.pickdata.beta.Beta;
import com.pickdata.columns.ColumnList;
import com.pickdata.domain.CreditDO;
import com.pickdata.page.PageMaker;
import com.pickdata.page.PageVO;
import com.pickdata.page.ValuesVO;
import com.pickdata.persistence.PickdataRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/credits")
@Log
public class PickdataContoller {

	@Autowired
	private PickdataRepository repo;

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
	public String simulationGET(@ModelAttribute("vo")CreditDO vo,@ModelAttribute("valuesVO") ValuesVO valuesVo){
		log.info("simulation get");
		
//		vo.setId(1);
//		vo.setTarget(0);
//		vo.setScore(100.000000000);
		
		return "thymeleaf/credits/simulation";
	}
	
	@PostMapping("/simulation")
	public String simulationPOST(@ModelAttribute("vo")CreditDO vo,@ModelAttribute("valuesVO") ValuesVO valuesVo, RedirectAttributes rttr){
		String age = valuesVo.getAge();
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
	@PostMapping("/result")
	public String result(Integer bno, @ModelAttribute("pageVO") PageVO vo,@ModelAttribute("valuesVO") ValuesVO valuesVo, Model model){
		
		Beta bt = new Beta();
		double totalScore=0;
		String[] columnName = ColumnList.columnName;
		String[] values = {valuesVo.getAge(),valuesVo.getSex(),valuesVo.getC1(),valuesVo.getC2(),valuesVo.getC3(),
							 valuesVo.getC4(),valuesVo.getC5(),valuesVo.getC6(),valuesVo.getC7(),valuesVo.getC9(),
							 valuesVo.getC10(),valuesVo.getC11(),valuesVo.getC12(),valuesVo.getC13(),valuesVo.getI9(),
							 valuesVo.getI16(),valuesVo.getI19(),valuesVo.getI30(),valuesVo.getI32(),valuesVo.getI33(),
							 valuesVo.getI36(),valuesVo.getT1(),valuesVo.getT2(),valuesVo.getT3(),valuesVo.getT4(),
							 valuesVo.getT5(),valuesVo.getT7(),valuesVo.getT11(),valuesVo.getT13(),valuesVo.getT14(),
							 valuesVo.getT15()};
		Boolean judgement=false;
		
		for (int i = 0; i < columnName.length; i++) {
			
			String customerValue = values[i];
			System.out.println("customerValue = " + customerValue);

			double score = bt.score(columnName[i], customerValue);
			totalScore += score;
		}
		if(totalScore > bt.getPdo()){
			judgement = true;
		}
		

		log.info("values = "+Arrays.toString(values));
		log.info("result BNO: "+ bno);
		log.info("totalScore = "+totalScore);
		log.info("judgement = "+judgement);
		model.addAttribute("totalScore", totalScore);
		model.addAttribute("judgement", judgement);
		
		return "thymeleaf/credits/result";
	}
	
}
