package gov.lct.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TAreainfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_split")
public class Tsplit  {
	
	// Fields
	@Id
	@GeneratedValue
	@Column(name="", unique=true, nullable=true, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "word", nullable = false)
	private String word;
					
	@Column(name = "resourcetype", nullable = false)
	private String resourcetype;

	@Column(name = "splitdate", nullable = false)
	private Date splitdate;
  
	
	/** default constructor */
	public Tsplit() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Date getSplitdate() {
		return splitdate;
	}

	public void setSplitdate(Date splitdate) {
		this.splitdate = splitdate;
	}

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	
}