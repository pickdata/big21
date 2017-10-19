package com.pickdata.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_manager")
@EqualsAndHashCode(of = "uid")
@Data
@ToString
public class Manager {
	
	@Id
	private String uid;
	private String upw;

}
