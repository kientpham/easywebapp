package com.kientpham.webapp.shareservice.lookup;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LOOKUP")
@Getter
@Setter
public class Lookup{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "LOOKUP_ID")
	private Integer id;
	@Column(name = "LOOKUP_TYPE")
	private String lookupType;
	@Column(name = "VALUE")
	private String value;
	@Column(name = "SEQUENCE")
	private Integer sequence;
	@Column(name = "DESCRIPTION")
	private String description;
	public Lookup() {
		//default constructor
	}
}