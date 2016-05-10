package gov.lct.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_software")
public class Tsoftware {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "sw_Name")
	private String swName;
	@Column(name = "sw_Name_Abb")
	private String swNameAbb;
	@Column(name = "sw_Ver")
	private String swVer;
	@Column(name = "sw_Regnumber")
	private String swRegnumber;
	@Column(name = "sw_Class")
	private String swClass;
	@Column(name = "sw_Person")
	private String swPerson;
	@Column(name = "sw_Add")
	private String swAdd;
	@Column(name = "sw_Pd")
	private String swPd;
	@Column(name = "sw_Author")
	private String swAuthor;
	@Column(name = "sw_Author_Country")
	private String swAuthorCountry;
	@Column(name = "sw_Designer")
	private String swDesigner;
	@Column(name = "sw_Endate")
	private String swEndate;
	@Column(name = "sw_Open")
	private String swOpen;
	@Column(name = "sw_Area")
	private String swArea;
	@Column(name = "sw_Devtype")
	private String swDevtype;
	@Column(name = "sw_Auth")
	private String swAuth;
	@Column(name = "sw_Use")
	private String swUse;
	@Column(name = "sw_Charact")
	private String swCharact;
	@Column(name = "sw_Price")
	private String swPrice;
	@Column(name = "sw_Price_My")
	private String swPriceMy;
	@Column(name = "sw_Proxy")
	private String swProxy;
	@Column(name = "sw_Proxyer")
	private String swProxyer;
	@Column(name = "sw_Status")
	private String swStatus;
	@Column(name = "sw_Date")
	private String swDate;
	@Column(name = "sw_Nodate")
	private String swNodate;
	@Column(name = "sw_Why")
	private String swWhy;
	@Column(name = "patentAn")
	private String patentAn;
	@Column(name = "sw_Note1")
	private String swNote1;
	@Column(name = "sw_Note2")
	private String swNote2;
	@Column(name = "genTime")
	private Timestamp genTime;
	@Column(name = "upinstitute")
	private String upinstitute;
	@Column(name = "institute")
	private String institute;
	@Column(name = "branch")
	private String branch;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getSwName() {
		return swName;
	}
	public void setSwName(String swName) {
		this.swName = swName;
	}
	public String getSwNameAbb() {
		return swNameAbb;
	}
	public void setSwNameAbb(String swNameAbb) {
		this.swNameAbb = swNameAbb;
	}
	public String getSwVer() {
		return swVer;
	}
	public void setSwVer(String swVer) {
		this.swVer = swVer;
	}
	public String getSwRegnumber() {
		return swRegnumber;
	}
	public void setSwRegnumber(String swRegnumber) {
		this.swRegnumber = swRegnumber;
	}
	public String getSwClass() {
		return swClass;
	}
	public void setSwClass(String swClass) {
		this.swClass = swClass;
	}
	public String getSwPerson() {
		return swPerson;
	}
	public void setSwPerson(String swPerson) {
		this.swPerson = swPerson;
	}
	public String getSwAdd() {
		return swAdd;
	}
	public void setSwAdd(String swAdd) {
		this.swAdd = swAdd;
	}
	public String getSwPd() {
		return swPd;
	}
	public void setSwPd(String swPd) {
		this.swPd = swPd;
	}
	public String getSwAuthor() {
		return swAuthor;
	}
	public void setSwAuthor(String swAuthor) {
		this.swAuthor = swAuthor;
	}
	public String getSwAuthorCountry() {
		return swAuthorCountry;
	}
	public void setSwAuthorCountry(String swAuthorCountry) {
		this.swAuthorCountry = swAuthorCountry;
	}
	public String getSwDesigner() {
		return swDesigner;
	}
	public void setSwDesigner(String swDesigner) {
		this.swDesigner = swDesigner;
	}
	public String getSwEndate() {
		return swEndate;
	}
	public void setSwEndate(String swEndate) {
		this.swEndate = swEndate;
	}
	public String getSwOpen() {
		return swOpen;
	}
	public void setSwOpen(String swOpen) {
		this.swOpen = swOpen;
	}
	public String getSwArea() {
		return swArea;
	}
	public void setSwArea(String swArea) {
		this.swArea = swArea;
	}
	public String getSwDevtype() {
		return swDevtype;
	}
	public void setSwDevtype(String swDevtype) {
		this.swDevtype = swDevtype;
	}
	public String getSwAuth() {
		return swAuth;
	}
	public void setSwAuth(String swAuth) {
		this.swAuth = swAuth;
	}
	public String getSwUse() {
		return swUse;
	}
	public void setSwUse(String swUse) {
		this.swUse = swUse;
	}
	public String getSwCharact() {
		return swCharact;
	}
	public void setSwCharact(String swCharact) {
		this.swCharact = swCharact;
	}
	public String getSwPrice() {
		return swPrice;
	}
	public void setSwPrice(String swPrice) {
		this.swPrice = swPrice;
	}
	public String getSwPriceMy() {
		return swPriceMy;
	}
	public void setSwPriceMy(String swPriceMy) {
		this.swPriceMy = swPriceMy;
	}
	public String getSwProxy() {
		return swProxy;
	}
	public void setSwProxy(String swProxy) {
		this.swProxy = swProxy;
	}
	public String getSwProxyer() {
		return swProxyer;
	}
	public void setSwProxyer(String swProxyer) {
		this.swProxyer = swProxyer;
	}
	public String getSwStatus() {
		return swStatus;
	}
	public void setSwStatus(String swStatus) {
		this.swStatus = swStatus;
	}
	public String getSwDate() {
		return swDate;
	}
	public void setSwDate(String swDate) {
		this.swDate = swDate;
	}
	public String getSwNodate() {
		return swNodate;
	}
	public void setSwNodate(String swNodate) {
		this.swNodate = swNodate;
	}
	public String getSwWhy() {
		return swWhy;
	}
	public void setSwWhy(String swWhy) {
		this.swWhy = swWhy;
	}
	public String getPatentAn() {
		return patentAn;
	}
	public void setPatentAn(String patentAn) {
		this.patentAn = patentAn;
	}
	public String getSwNote1() {
		return swNote1;
	}
	public void setSwNote1(String swNote1) {
		this.swNote1 = swNote1;
	}
	public String getSwNote2() {
		return swNote2;
	}
	public void setSwNote2(String swNote2) {
		this.swNote2 = swNote2;
	}
	public Timestamp getGenTime() {
		return genTime;
	}
	public void setGenTime(Timestamp genTime) {
		this.genTime = genTime;
	}
	public String getUpinstitute() {
		return upinstitute;
	}
	public void setUpinstitute(String upinstitute) {
		this.upinstitute = upinstitute;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Tsoftware() {
	}
}
