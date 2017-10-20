package com.pickdata.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tbl_manager_roles")
@EqualsAndHashCode(of = "fno")
@Data
public class ManagerRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fno")
	private Integer fno;
	@Column(name="roleName")
	private String roleName;
	
}
