package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_PatentBasicInfo")
public class Tpatentbasicinfo {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	@Column(name = "patent_Id")
	private Integer patentId;
	@Column(name = "patent_Ti")
	private String patentTi;
	@Column(name = "patent_An")
	private String patentAn;
	@Column(name = "patent_Ad")
	private String patentAd;
	@Column(name = "patent_Pn")
	private String patentPn;
	@Column(name = "patent_Pd")
	private String patentPd;
	@Column(name = "patent_Fpa")
	private String patentFpa;
	@Column(name = "patent_PaAd")
	private String patentPaAd;
	@Column(name = "patent_In")
	private String patentIn;
	@Column(name = "patent_Type")
	private String patentType;
	@Column(name = "patent_Icm")
	private String patentIcm;
	@Column(name = "patent_Ica")
	private String patentIca;
	@Column(name = "patent_Ab")
	private String patentAb;
	@Column(name = "patent_Cl")
	private String patentCl;
	@Column(name = "patent_Branch")
	private String patentBranch;
	@Column(name = "patent_Db")
	private String patentDb;
	@Column(name = "patent_Agc")
	private String patentAgc;
	@Column(name = "patent_Agt")
	private String patentAgt;
	@Column(name = "patent_Province")
	private String patentProvince;
	@Column(name = "patent_Ls")
	private String patentLs;
	@Column(name = "patent_Lspd")
	private String patentLspd;
	@Column(name = "patent_Lsinfo")
	private String patentLsinfo;
	@Column(name = "status")
	private String status;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPatentId() {
		return patentId;
	}
	public void setPatentId(Integer patentId) {
		this.patentId = patentId;
	}
	public String getPatentTi() {
		return patentTi;
	}
	public void setPatentTi(String patentTi) {
		this.patentTi = patentTi;
	}
	public String getPatentAn() {
		return patentAn;
	}
	public void setPatentAn(String patentAn) {
		this.patentAn = patentAn;
	}
	public String getPatentAd() {
		return patentAd;
	}
	public void setPatentAd(String patentAd) {
		this.patentAd = patentAd;
	}
	public String getPatentPn() {
		return patentPn;
	}
	public void setPatentPn(String patentPn) {
		this.patentPn = patentPn;
	}
	public String getPatentPd() {
		return patentPd;
	}
	public void setPatentPd(String patentPd) {
		this.patentPd = patentPd;
	}
	public String getPatentFpa() {
		return patentFpa;
	}
	public void setPatentFpa(String patentFpa) {
		this.patentFpa = patentFpa;
	}
	public String getPatentPaAd() {
		return patentPaAd;
	}
	public void setPatentPaAd(String patentPaAd) {
		this.patentPaAd = patentPaAd;
	}
	public String getPatentIn() {
		return patentIn;
	}
	public void setPatentIn(String patentIn) {
		this.patentIn = patentIn;
	}
	public String getPatentType() {
		return patentType;
	}
	public void setPatentType(String patentType) {
		this.patentType = patentType;
	}
	public String getPatentIcm() {
		return patentIcm;
	}
	public void setPatentIcm(String patentIcm) {
		this.patentIcm = patentIcm;
	}
	public String getPatentIca() {
		return patentIca;
	}
	public void setPatentIca(String patentIca) {
		this.patentIca = patentIca;
	}
	public String getPatentAb() {
		return patentAb;
	}
	public void setPatentAb(String patentAb) {
		this.patentAb = patentAb;
	}
	public String getPatentCl() {
		return patentCl;
	}
	public void setPatentCl(String patentCl) {
		this.patentCl = patentCl;
	}
	public String getPatentBranch() {
		return patentBranch;
	}
	public void setPatentBranch(String patentBranch) {
		this.patentBranch = patentBranch;
	}
	public String getPatentDb() {
		return patentDb;
	}
	public void setPatentDb(String patentDb) {
		this.patentDb = patentDb;
	}
	public String getPatentAgc() {
		return patentAgc;
	}
	public void setPatentAgc(String patentAgc) {
		this.patentAgc = patentAgc;
	}
	public String getPatentAgt() {
		return patentAgt;
	}
	public void setPatentAgt(String patentAgt) {
		this.patentAgt = patentAgt;
	}
	public String getPatentProvince() {
		return patentProvince;
	}
	public void setPatentProvince(String patentProvince) {
		this.patentProvince = patentProvince;
	}
	public String getPatentLs() {
		return patentLs;
	}
	public void setPatentLs(String patentLs) {
		this.patentLs = patentLs;
	}
	public String getPatentLspd() {
		return patentLspd;
	}
	public void setPatentLspd(String patentLspd) {
		this.patentLspd = patentLspd;
	}
	public String getPatentLsinfo() {
		return patentLsinfo;
	}
	public void setPatentLsinfo(String patentLsinfo) {
		this.patentLsinfo = patentLsinfo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
