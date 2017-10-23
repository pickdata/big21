package com.pickdata.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.pickdata.domain.MemberRole;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "tbl_members")
@EqualsAndHashCode(of = "uid")
@Data
@ToString
public class Member {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid")
	private String uid;
	
	@Column(name = "upw")
	@Transient
	private String upw;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "member")
	private List<MemberRole> roles;

}
