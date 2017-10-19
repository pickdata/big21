package com.pickdata.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.pickdata.domain.CreditDO;
import com.pickdata.domain.QCreditDO;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public interface PickdataRepository extends JpaRepository<CreditDO, Integer>, QuerydslPredicateExecutor<CreditDO> {

	public default Predicate makePredicate(String type, String keyword){
		BooleanBuilder builder = new BooleanBuilder();
		
		QCreditDO credit = QCreditDO.creditDO;
		
		builder.and(credit.id.gt(0));
		
		if(type==null){
			return builder;
		}
		
		switch(type){
		
		case "i":
			builder.and(credit.id.like("%" + keyword +"%"));
			break;

		case "r":
			builder.and(credit.target.like("%" + keyword +"%"));
			break;
			
		case "s":
			builder.and(credit.score.like("%" + keyword +"%"));
			break;
		}
		
		return builder;
	}
}
