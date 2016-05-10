package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 * 此类对应t__require表
 * @author Administrator
 *
 */
@Entity
@Table(name = "T_require")
public class Trequire {
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "problem")
	private String problem;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "cooperation")
	private String cooperation;  //合作要求
	
	@Column(name = "havaCondition")
	private String havaCondition;  //具备条件
	
	@Column(name = "unitName")
	private String unitName;  //机构名称
		
	@Column(name = "linkman")
	private String linkman;
	
	@Column(name = "investAmount")
	private float investAmount;
	
	@Column(name = "technology")
	private String technology;

	@Column(name = "industry")
	private String industry;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "createDate")
	private String createDate;

	@Column(name = "createPerson")
	private String createPerson;
	
	@Column(name = "status")
	private String status;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCooperation() {
		return cooperation;
	}

	public void setCooperation(String cooperation) {
		this.cooperation = cooperation;
	}

	public String getHavaCondition() {
		return havaCondition;
	}

	public void setHavaCondition(String havaCondition) {
		this.havaCondition = havaCondition;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public float getInvestAmount() {
		return investAmount;
	}

	public void setInvestAmount(float investAmount) {
		this.investAmount = investAmount;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
	
