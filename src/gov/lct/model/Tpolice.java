package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_policy")
public class Tpolice {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "province")
	private String province;//
	
	@Column(name = "institute")
	private String institute;//
	
	@Column(name = "publishdate")
	private String publishdate;//
	
	@Column(name = "url")
	private String url;//
	
	@Column(name = "createPerson")
	private String createPerson;//
	
	@Column(name = "createDate")
	private String createDate;//
	
	@Column(name = "content")
	private String content;//

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


}
