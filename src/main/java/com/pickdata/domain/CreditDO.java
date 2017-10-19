package com.pickdata.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="credit")
@Data
public class CreditDO {

	@Id
	private Integer bno;
	private Integer id;
	private Integer target;
	private Double score;
	
}
