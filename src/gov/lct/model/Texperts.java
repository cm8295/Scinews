package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_experts")
public class Texperts {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "mfn")
	private String mfn;

	@Column(name = "wfid")
	private String wfid;

	@Column(name = "expname")
	private String expname;//
	
	@Column(name = "expwork")
	private String expwork;//
	
	@Column(name = "expwork1")
	private String expwork1;//
	
	@Column(name = "expwork2")
	private String expwork2;//
	
	@Column(name = "expjob")
	private String expjob;//
	
	@Column(name = "exptitle")
	private String exptitle;//
	
	@Column(name = "expaddress")
	private String expaddress;//
	
	@Column(name = "exppost")
	private String exppost;//
	
	@Column(name = "expdistrict")
	private String expdistrict;//
	
	@Column(name = "expprovince")
	private String expprovince;//
	
	@Column(name = "expcity")
	private String expcity;//
	
	@Column(name = "expcounty")
	private String expcounty;//
	
	@Column(name = "exparea")
	private String exparea;//
	
	@Column(name = "exptel")
	private String exptel;//
	
	@Column(name = "expfax")
	private String expfax;//
	
	@Column(name = "expdomain")
	private String expdomain;//
	@Column(name = "expxkname")
	private String expxkname;//
	@Column(name = "expxkcode")
	private String expxkcode;
	
	@Column(name = "expgender")
	private String expgender;//
	@Column(name = "expyear")
	private String expyear;//
	@Column(name = "expnation")
	private String expnation;//
	@Column(name = "expmail")
	private String expmail;
	@Column(name = "expedu")
	private String expedu;
	@Column(name = "exphonor")
	private String expeexphonor;
	@Column(name = "pROF_ANYNAME")
	private String pROF_ANYNAME;
	@Column(name = "dIS_ANYNAME")
	private String dIS_ANYNAME;
	@Column(name = "aCADE_ANYNAME")
	private String aCADE_ANYNAME;
	@Column(name = "aCADE")
	private String aCADE;
	@Column(name = "fLAN")
	private String fLAN;
	
	@Column(name = "author")
	private String author;//用户名
	@Column(name = "publish")
	private String publish;//1：可发布；0：不可发布
	@Column(name = "uploadtime")
	private String uploadtime;//上传时间
	@Column(name = "publishtime")
	private String publishtime;//更新时间

	public String getExpgender() {
		return expgender;
	}

	public void setExpgender(String expgender) {
		this.expgender = expgender;
	}

	public String getExpyear() {
		return expyear;
	}

	public void setExpyear(String expyear) {
		this.expyear = expyear;
	}

	public String getExpnation() {
		return expnation;
	}

	public void setExpnation(String expnation) {
		this.expnation = expnation;
	}

	public String getExpmail() {
		return expmail;
	}

	public void setExpmail(String expmail) {
		this.expmail = expmail;
	}

	public String getExpedu() {
		return expedu;
	}

	public void setExpedu(String expedu) {
		this.expedu = expedu;
	}

	public String getExpeexphonor() {
		return expeexphonor;
	}

	public void setExpeexphonor(String expeexphonor) {
		this.expeexphonor = expeexphonor;
	}

	public String getpROF_ANYNAME() {
		return pROF_ANYNAME;
	}

	public void setpROF_ANYNAME(String pROFANYNAME) {
		pROF_ANYNAME = pROFANYNAME;
	}

	public String getdIS_ANYNAME() {
		return dIS_ANYNAME;
	}

	public void setdIS_ANYNAME(String dISANYNAME) {
		dIS_ANYNAME = dISANYNAME;
	}

	public String getaCADE_ANYNAME() {
		return aCADE_ANYNAME;
	}

	public void setaCADE_ANYNAME(String aCADEANYNAME) {
		aCADE_ANYNAME = aCADEANYNAME;
	}

	public String getaCADE() {
		return aCADE;
	}

	public void setaCADE(String aCADE) {
		this.aCADE = aCADE;
	}

	public String getfLAN() {
		return fLAN;
	}

	public void setfLAN(String fLAN) {
		this.fLAN = fLAN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getPublishtime() {
		return publishtime;
	}

	public void setPublishtime(String publishtime) {
		this.publishtime = publishtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMfn() {
		return mfn;
	}

	public void setMfn(String mfn) {
		this.mfn = mfn;
	}

	public String getWfid() {
		return wfid;
	}

	public void setWfid(String wfid) {
		this.wfid = wfid;
	}

	public String getExpname() {
		return expname;
	}

	public void setExpname(String expname) {
		this.expname = expname;
	}

	public String getExpwork() {
		return expwork;
	}

	public void setExpwork(String expwork) {
		this.expwork = expwork;
	}

	public String getExpwork1() {
		return expwork1;
	}

	public void setExpwork1(String expwork1) {
		this.expwork1 = expwork1;
	}

	public String getExpwork2() {
		return expwork2;
	}

	public void setExpwork2(String expwork2) {
		this.expwork2 = expwork2;
	}

	public String getExpjob() {
		return expjob;
	}

	public void setExpjob(String expjob) {
		this.expjob = expjob;
	}

	public String getExptitle() {
		return exptitle;
	}

	public void setExptitle(String exptitle) {
		this.exptitle = exptitle;
	}

	public String getExpaddress() {
		return expaddress;
	}

	public void setExpaddress(String expaddress) {
		this.expaddress = expaddress;
	}

	public String getExppost() {
		return exppost;
	}

	public void setExppost(String exppost) {
		this.exppost = exppost;
	}

	public String getExpdistrict() {
		return expdistrict;
	}

	public void setExpdistrict(String expdistrict) {
		this.expdistrict = expdistrict;
	}

	public String getExpprovince() {
		return expprovince;
	}

	public void setExpprovince(String expprovince) {
		this.expprovince = expprovince;
	}

	public String getExpcity() {
		return expcity;
	}

	public void setExpcity(String expcity) {
		this.expcity = expcity;
	}

	public String getExpcounty() {
		return expcounty;
	}

	public void setExpcounty(String expcounty) {
		this.expcounty = expcounty;
	}

	public String getExparea() {
		return exparea;
	}

	public void setExparea(String exparea) {
		this.exparea = exparea;
	}

	public String getExptel() {
		return exptel;
	}

	public void setExptel(String exptel) {
		this.exptel = exptel;
	}

	public String getExpfax() {
		return expfax;
	}

	public void setExpfax(String expfax) {
		this.expfax = expfax;
	}

	public String getExpdomain() {
		return expdomain;
	}

	public void setExpdomain(String expdomain) {
		this.expdomain = expdomain;
	}

	public String getExpxkname() {
		return expxkname;
	}

	public void setExpxkname(String expxkname) {
		this.expxkname = expxkname;
	}

	public String getExpxkcode() {
		return expxkcode;
	}

	public void setExpxkcode(String expxkcode) {
		this.expxkcode = expxkcode;
	}
	
	

}
