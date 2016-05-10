package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_kjcg")
public class Tkjcg {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "subplatformrecid")
	private String subplatformrecid;//
	
	@Column(name = "ITEM_1")
	private String ITEM_1;
	@Column(name = "ITEM_110")
	private String ITEM_110;
	@Column(name = "ITEM_12")
	private String ITEM_12;
	@Column(name = "ITEM_12_1")
	private String ITEM_12_1;
	@Column(name = "ITEM_120")
	private String ITEM_120;
	@Column(name = "ITEM_121")
	private String ITEM_121;
	@Column(name = "ITEM_123")
	private String ITEM_123;
	@Column(name = "ITEM_124_1")
	private String ITEM_124_1;
	@Column(name = "ITEM_125")
	private String ITEM_125;
	@Column(name = "ITEM_125_1")
	private String ITEM_125_1;
	@Column(name = "ITEM_126")
	private String ITEM_126;
	@Column(name = "ITEM_13")
	private String ITEM_13;
	@Column(name = "ITEM_13_1")
	private String ITEM_13_1;
	@Column(name = "ITEM_13_2")
	private String ITEM_13_2;
	@Column(name = "ITEM_13_3")
	private String ITEM_13_3;
	@Column(name = "ITEM_14")
	private String ITEM_14;
	@Column(name = "ITEM_16")
	private String ITEM_16;
	@Column(name = "ITEM_2")
	private String ITEM_2;
	@Column(name = "ITEM_200")
	private String ITEM_200;
	@Column(name = "ITEM_210")
	private String ITEM_210;
	@Column(name = "ITEM_3")
	private String ITEM_3;
	@Column(name = "ITEM_33")
	private String ITEM_33;
	@Column(name = "ITEM_4")
	private String ITEM_4;
	@Column(name = "ITEM_420")
	private String ITEM_420;
	@Column(name = "ITEM_8")
	private String ITEM_8;
	@Column(name = "ITEM_127")
	private String ITEM_127;
	@Column(name = "ITEM_201")
	private String ITEM_201;
	@Column(name = "ITEM_37")
	private String ITEM_37;
	@Column(name = "ITEM_38")
	private String ITEM_38;
	@Column(name = "ITEM_39")
	private String ITEM_39;
	@Column(name = "ITEM_40")
	private String ITEM_40;
	@Column(name = "ITEM_41")
	private String ITEM_41;
	@Column(name = "ITEM_41_1")
	private String ITEM_41_1;
	@Column(name = "ITEM_41_2")
	private String ITEM_41_2;
	@Column(name = "ITEM_41_3")
	private String ITEM_41_3;
	@Column(name = "ITEM_60")
	private String ITEM_60;
	@Column(name = "ITEM_61")
	private String ITEM_61;
	@Column(name = "ITEM_62")
	private String ITEM_62;
	@Column(name = "ITEM_63")
	private String ITEM_63;
	@Column(name = "ITEM_64")
	private String ITEM_64;
	@Column(name = "ITEM_9")
	private String ITEM_9;
	@Column(name = "ITEM_32")
	private String ITEM_32;
	@Column(name = "ITEM_32_1")
	private String ITEM_32_1;
	@Column(name = "ITEM_34")
	private String ITEM_34;
	@Column(name = "ITEM_45")
	private String ITEM_45;
	@Column(name = "ITEM_46")
	private String ITEM_46;
	@Column(name = "ITEM_47")
	private String ITEM_47;
	@Column(name = "ITEM_300")
	private String ITEM_300;
	@Column(name = "ITEM_301")
	private String ITEM_301;
	@Column(name = "ITEM_302")
	private String ITEM_302;
	@Column(name = "ITEM_303")
	private String ITEM_303;
	@Column(name = "ITEM_304")
	private String ITEM_304;
	@Column(name = "ITEM_305")
	private String ITEM_305;
	@Column(name = "ITEM_306")
	private String ITEM_306;
	@Column(name = "ITEM_160")
	private String ITEM_160;
	@Column(name = "ITEM_161")
	private String ITEM_161;
	@Column(name = "ITEM_163")
	private String ITEM_163;
	@Column(name = "ITEM_151")
	private String ITEM_151;
	@Column(name = "ITEM_152")
	private String ITEM_152;
	@Column(name = "ITEM_153")
	private String ITEM_153;
	@Column(name = "ITEM_150")
	private String ITEM_150;
	@Column(name = "ITEM_140")
	private String ITEM_140;
	@Column(name = "ITEM_142")
	private String ITEM_142;
	@Column(name = "ITEM_143")
	private String ITEM_143;
	@Column(name = "ITEM_141")
	private String ITEM_141;
	@Column(name = "ITEM_162")
	private String ITEM_162;
	@Column(name = "ITEM_130")
	private String ITEM_130;
	@Column(name = "ITEM_133")
	private String ITEM_133;
	@Column(name = "ITEM_21")
	private String ITEM_21;
	@Column(name = "ITEM_22")
	private String ITEM_22;
	@Column(name = "ITEM_131")
	private String ITEM_131;
	@Column(name = "ITEM_51")
	private String ITEM_51;
	@Column(name = "ITEM_52")
	private String ITEM_52;
	@Column(name = "ITEM_53")
	private String ITEM_53;
	@Column(name = "ITEM_56")
	private String ITEM_56;
	@Column(name = "ITEM_SJDR")
	private String ITEM_SJDR;
	@Column(name = "ITEM_SJDC")
	private String ITEM_SJDC;
	@Column(name = "ITEM_DQDM")
	private String ITEM_DQDM;
	@Column(name = "ITEM_CGLB")
	private String ITEM_CGLB;
	@Column(name = "ITEM_144")
	private String ITEM_144;
	@Column(name = "ITEM_145")
	private String ITEM_145;
	@Column(name = "ITEM_149")
	private String ITEM_149;
	@Column(name = "ITEM_154")
	private String ITEM_154;
	@Column(name = "ITEM_128")
	private String ITEM_128;
	@Column(name = "ITEM_15")
	private String ITEM_15;
	@Column(name = "ITEM_15_1")
	private String ITEM_15_1;
	@Column(name = "ITEM_142_1")
	private String ITEM_142_1;
	@Column(name = "ITEM_142_2")
	private String ITEM_142_2;
	@Column(name = "ITEM_142_3")
	private String ITEM_142_3;
	@Column(name = "ITEM_XH")
	private String ITEM_XH;
	@Column(name = "ITEM_148")
	private String ITEM_148;
	@Column(name = "ITEM_243")
	private String ITEM_243;
	@Column(name = "ITEM_244")
	private String ITEM_244;
	@Column(name = "ITEM_51_1")
	private String ITEM_51_1;
	@Column(name = "ITEM_51_2")
	private String ITEM_51_2;
	@Column(name = "ITEM_51_3")
	private String ITEM_51_3;
	@Column(name = "ITEM_151_1")
	private String ITEM_151_1;
	@Column(name = "ITEM_152_1")
	private String ITEM_152_1;
	@Column(name = "ITEM_152_2")
	private String ITEM_152_2;
	@Column(name = "ITEM_127_1")
	private String ITEM_127_1;
	@Column(name = "Ext_IsRecommended")
	private String Ext_IsRecommended;
	@Column(name = "Ext_Attribute")
	private String Ext_Attribute;
	@Column(name = "Ext_Region")
	private String Ext_Region;
	@Column(name = "Ext_Standard")
	private String Ext_Standard;
	@Column(name = "Ext_Projects")
	private String Ext_Projects;
	@Column(name = "Ext_VisitCount")
	private String Ext_VisitCount;
	@Column(name = "item_131_1")
	private String item_131_1;
	@Column(name = "item_133_1")
	private String item_133_1;
	@Column(name = "author")
	private String author;//用户名
	@Column(name = "publish")
	private String publish;//1：可发布；0：不可发布
	@Column(name = "uploadtime")
	private String uploadtime;//上传时间
	@Column(name = "publishtime")
	private String publishtime;//更新时间
	@Column(name = "imagetime")
	private String imagetime;
	
	@Column(name = "mfn")
	private String mfn;

	@Column(name = "wfid")
	private String wfid;

	@Column(name = "kjcgname")
	private String kjcgname;//
	
	@Column(name = "kjcgcontactinst")
	private String kjcgcontactinst;//
	
	@Column(name = "kjcgfinishinst")
	private String kjcgfinishinst;//
	
	@Column(name = "kjcgfinishinsts")
	private String kjcgfinishinsts;//
	
	@Column(name = "kjcgfinishperson")
	private String kjcgfinishperson;//
	
	@Column(name = "kjcgsource")
	private String kjcgsource;//
	
	@Column(name = "kjcgpublish")
	private String kjcgpublish;//
	
	@Column(name = "kjcgtime")
	private String kjcgtime;//
	
	@Column(name = "kjcglimit")
	private String kjcglimit;//
	
	@Column(name = "kjcgintro")
	private String kjcgintro;

	@Column(name = "kjcgkeyword")
	private String kjcgkeyword;

	@Column(name = "kjcgsecret")
	private String kjcgsecret;

	@Column(name = "kjcgreg")
	private String kjcgreg;

	@Column(name = "kjcgrecom")
	private String kjcgrecom;

	@Column(name = "kjcgtype")
	private String kjcgtype;
	
	@Column(name = "cID")
	private String cID;
	@Column(name = "fITCLASS")
	private String fITCLASS;
	@Column(name = "zCID")
	private String zCID;
	@Column(name = "dATE_BEGIN")
	private String dATE_BEGIN;
	@Column(name = "dATE_END")
	private String dATE_END;
	@Column(name = "tZCID")
	private String tZCID;
	@Column(name = "sZCID")
	private String sZCID;
	@Column(name = "dATE")
	private String dATE;
	
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
	public String getKjcgname() {
		return kjcgname;
	}
	public void setKjcgname(String kjcgname) {
		this.kjcgname = kjcgname;
	}
	public String getKjcgcontactinst() {
		return kjcgcontactinst;
	}
	public void setKjcgcontactinst(String kjcgcontactinst) {
		this.kjcgcontactinst = kjcgcontactinst;
	}
	public String getKjcgfinishinst() {
		return kjcgfinishinst;
	}
	public void setKjcgfinishinst(String kjcgfinishinst) {
		this.kjcgfinishinst = kjcgfinishinst;
	}
	public String getKjcgfinishinsts() {
		return kjcgfinishinsts;
	}
	public void setKjcgfinishinsts(String kjcgfinishinsts) {
		this.kjcgfinishinsts = kjcgfinishinsts;
	}
	public String getKjcgfinishperson() {
		return kjcgfinishperson;
	}
	public void setKjcgfinishperson(String kjcgfinishperson) {
		this.kjcgfinishperson = kjcgfinishperson;
	}
	public String getKjcgsource() {
		return kjcgsource;
	}
	public void setKjcgsource(String kjcgsource) {
		this.kjcgsource = kjcgsource;
	}
	public String getKjcgpublish() {
		return kjcgpublish;
	}
	public void setKjcgpublish(String kjcgpublish) {
		this.kjcgpublish = kjcgpublish;
	}
	public String getKjcgtime() {
		return kjcgtime;
	}
	public void setKjcgtime(String kjcgtime) {
		this.kjcgtime = kjcgtime;
	}
	public String getKjcglimit() {
		return kjcglimit;
	}
	public void setKjcglimit(String kjcglimit) {
		this.kjcglimit = kjcglimit;
	}
	public String getKjcgintro() {
		return kjcgintro;
	}
	public void setKjcgintro(String kjcgintro) {
		this.kjcgintro = kjcgintro;
	}
	public String getKjcgkeyword() {
		return kjcgkeyword;
	}
	public void setKjcgkeyword(String kjcgkeyword) {
		this.kjcgkeyword = kjcgkeyword;
	}
	public String getKjcgsecret() {
		return kjcgsecret;
	}
	public void setKjcgsecret(String kjcgsecret) {
		this.kjcgsecret = kjcgsecret;
	}
	public String getKjcgreg() {
		return kjcgreg;
	}
	public void setKjcgreg(String kjcgreg) {
		this.kjcgreg = kjcgreg;
	}
	public String getKjcgrecom() {
		return kjcgrecom;
	}
	public void setKjcgrecom(String kjcgrecom) {
		this.kjcgrecom = kjcgrecom;
	}
	public String getKjcgtype() {
		return kjcgtype;
	}
	public void setKjcgtype(String kjcgtype) {
		this.kjcgtype = kjcgtype;
	}
	public String getcID() {
		return cID;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
	public String getfITCLASS() {
		return fITCLASS;
	}
	public void setfITCLASS(String fITCLASS) {
		this.fITCLASS = fITCLASS;
	}
	public String getzCID() {
		return zCID;
	}
	public void setzCID(String zCID) {
		this.zCID = zCID;
	}
	public String getdATE_BEGIN() {
		return dATE_BEGIN;
	}
	public void setdATE_BEGIN(String dATEBEGIN) {
		dATE_BEGIN = dATEBEGIN;
	}
	public String getdATE_END() {
		return dATE_END;
	}
	public void setdATE_END(String dATEEND) {
		dATE_END = dATEEND;
	}
	public String gettZCID() {
		return tZCID;
	}
	public void settZCID(String tZCID) {
		this.tZCID = tZCID;
	}
	public String getsZCID() {
		return sZCID;
	}
	public void setsZCID(String sZCID) {
		this.sZCID = sZCID;
	}
	public String getdATE() {
		return dATE;
	}
	public void setdATE(String dATE) {
		this.dATE = dATE;
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
	public String getImagetime() {
		return imagetime;
	}
	public void setImagetime(String imagetime) {
		this.imagetime = imagetime;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubplatformrecid() {
		return subplatformrecid;
	}
	public void setSubplatformrecid(String subplatformrecid) {
		this.subplatformrecid = subplatformrecid;
	}
	public String getITEM_1() {
		return ITEM_1;
	}
	public void setITEM_1(String iTEM_1) {
		ITEM_1 = iTEM_1;
	}
	public String getITEM_110() {
		return ITEM_110;
	}
	public void setITEM_110(String iTEM_110) {
		ITEM_110 = iTEM_110;
	}
	public String getITEM_12() {
		return ITEM_12;
	}
	public void setITEM_12(String iTEM_12) {
		ITEM_12 = iTEM_12;
	}
	public String getITEM_12_1() {
		return ITEM_12_1;
	}
	public void setITEM_12_1(String iTEM_12_1) {
		ITEM_12_1 = iTEM_12_1;
	}
	public String getITEM_120() {
		return ITEM_120;
	}
	public void setITEM_120(String iTEM_120) {
		ITEM_120 = iTEM_120;
	}
	public String getITEM_121() {
		return ITEM_121;
	}
	public void setITEM_121(String iTEM_121) {
		ITEM_121 = iTEM_121;
	}
	public String getITEM_123() {
		return ITEM_123;
	}
	public void setITEM_123(String iTEM_123) {
		ITEM_123 = iTEM_123;
	}
	public String getITEM_124_1() {
		return ITEM_124_1;
	}
	public void setITEM_124_1(String iTEM_124_1) {
		ITEM_124_1 = iTEM_124_1;
	}
	public String getITEM_125() {
		return ITEM_125;
	}
	public void setITEM_125(String iTEM_125) {
		ITEM_125 = iTEM_125;
	}
	public String getITEM_125_1() {
		return ITEM_125_1;
	}
	public void setITEM_125_1(String iTEM_125_1) {
		ITEM_125_1 = iTEM_125_1;
	}
	public String getITEM_126() {
		return ITEM_126;
	}
	public void setITEM_126(String iTEM_126) {
		ITEM_126 = iTEM_126;
	}
	public String getITEM_13() {
		return ITEM_13;
	}
	public void setITEM_13(String iTEM_13) {
		ITEM_13 = iTEM_13;
	}
	public String getITEM_13_1() {
		return ITEM_13_1;
	}
	public void setITEM_13_1(String iTEM_13_1) {
		ITEM_13_1 = iTEM_13_1;
	}
	public String getITEM_13_2() {
		return ITEM_13_2;
	}
	public void setITEM_13_2(String iTEM_13_2) {
		ITEM_13_2 = iTEM_13_2;
	}
	public String getITEM_13_3() {
		return ITEM_13_3;
	}
	public void setITEM_13_3(String iTEM_13_3) {
		ITEM_13_3 = iTEM_13_3;
	}
	public String getITEM_14() {
		return ITEM_14;
	}
	public void setITEM_14(String iTEM_14) {
		ITEM_14 = iTEM_14;
	}
	public String getITEM_16() {
		return ITEM_16;
	}
	public void setITEM_16(String iTEM_16) {
		ITEM_16 = iTEM_16;
	}
	public String getITEM_2() {
		return ITEM_2;
	}
	public void setITEM_2(String iTEM_2) {
		ITEM_2 = iTEM_2;
	}
	public String getITEM_200() {
		return ITEM_200;
	}
	public void setITEM_200(String iTEM_200) {
		ITEM_200 = iTEM_200;
	}
	public String getITEM_210() {
		return ITEM_210;
	}
	public void setITEM_210(String iTEM_210) {
		ITEM_210 = iTEM_210;
	}
	public String getITEM_3() {
		return ITEM_3;
	}
	public void setITEM_3(String iTEM_3) {
		ITEM_3 = iTEM_3;
	}
	public String getITEM_33() {
		return ITEM_33;
	}
	public void setITEM_33(String iTEM_33) {
		ITEM_33 = iTEM_33;
	}
	public String getITEM_4() {
		return ITEM_4;
	}
	public void setITEM_4(String iTEM_4) {
		ITEM_4 = iTEM_4;
	}
	public String getITEM_420() {
		return ITEM_420;
	}
	public void setITEM_420(String iTEM_420) {
		ITEM_420 = iTEM_420;
	}
	public String getITEM_8() {
		return ITEM_8;
	}
	public void setITEM_8(String iTEM_8) {
		ITEM_8 = iTEM_8;
	}
	public String getITEM_127() {
		return ITEM_127;
	}
	public void setITEM_127(String iTEM_127) {
		ITEM_127 = iTEM_127;
	}
	public String getITEM_201() {
		return ITEM_201;
	}
	public void setITEM_201(String iTEM_201) {
		ITEM_201 = iTEM_201;
	}
	public String getITEM_37() {
		return ITEM_37;
	}
	public void setITEM_37(String iTEM_37) {
		ITEM_37 = iTEM_37;
	}
	public String getITEM_38() {
		return ITEM_38;
	}
	public void setITEM_38(String iTEM_38) {
		ITEM_38 = iTEM_38;
	}
	public String getITEM_39() {
		return ITEM_39;
	}
	public void setITEM_39(String iTEM_39) {
		ITEM_39 = iTEM_39;
	}
	public String getITEM_40() {
		return ITEM_40;
	}
	public void setITEM_40(String iTEM_40) {
		ITEM_40 = iTEM_40;
	}
	public String getITEM_41() {
		return ITEM_41;
	}
	public void setITEM_41(String iTEM_41) {
		ITEM_41 = iTEM_41;
	}
	public String getITEM_41_1() {
		return ITEM_41_1;
	}
	public void setITEM_41_1(String iTEM_41_1) {
		ITEM_41_1 = iTEM_41_1;
	}
	public String getITEM_41_2() {
		return ITEM_41_2;
	}
	public void setITEM_41_2(String iTEM_41_2) {
		ITEM_41_2 = iTEM_41_2;
	}
	public String getITEM_41_3() {
		return ITEM_41_3;
	}
	public void setITEM_41_3(String iTEM_41_3) {
		ITEM_41_3 = iTEM_41_3;
	}
	public String getITEM_60() {
		return ITEM_60;
	}
	public void setITEM_60(String iTEM_60) {
		ITEM_60 = iTEM_60;
	}
	public String getITEM_61() {
		return ITEM_61;
	}
	public void setITEM_61(String iTEM_61) {
		ITEM_61 = iTEM_61;
	}
	public String getITEM_62() {
		return ITEM_62;
	}
	public void setITEM_62(String iTEM_62) {
		ITEM_62 = iTEM_62;
	}
	public String getITEM_63() {
		return ITEM_63;
	}
	public void setITEM_63(String iTEM_63) {
		ITEM_63 = iTEM_63;
	}
	public String getITEM_64() {
		return ITEM_64;
	}
	public void setITEM_64(String iTEM_64) {
		ITEM_64 = iTEM_64;
	}
	public String getITEM_9() {
		return ITEM_9;
	}
	public void setITEM_9(String iTEM_9) {
		ITEM_9 = iTEM_9;
	}
	public String getITEM_32() {
		return ITEM_32;
	}
	public void setITEM_32(String iTEM_32) {
		ITEM_32 = iTEM_32;
	}
	public String getITEM_32_1() {
		return ITEM_32_1;
	}
	public void setITEM_32_1(String iTEM_32_1) {
		ITEM_32_1 = iTEM_32_1;
	}
	public String getITEM_34() {
		return ITEM_34;
	}
	public void setITEM_34(String iTEM_34) {
		ITEM_34 = iTEM_34;
	}
	public String getITEM_45() {
		return ITEM_45;
	}
	public void setITEM_45(String iTEM_45) {
		ITEM_45 = iTEM_45;
	}
	public String getITEM_46() {
		return ITEM_46;
	}
	public void setITEM_46(String iTEM_46) {
		ITEM_46 = iTEM_46;
	}
	public String getITEM_47() {
		return ITEM_47;
	}
	public void setITEM_47(String iTEM_47) {
		ITEM_47 = iTEM_47;
	}
	public String getITEM_300() {
		return ITEM_300;
	}
	public void setITEM_300(String iTEM_300) {
		ITEM_300 = iTEM_300;
	}
	public String getITEM_301() {
		return ITEM_301;
	}
	public void setITEM_301(String iTEM_301) {
		ITEM_301 = iTEM_301;
	}
	public String getITEM_302() {
		return ITEM_302;
	}
	public void setITEM_302(String iTEM_302) {
		ITEM_302 = iTEM_302;
	}
	public String getITEM_303() {
		return ITEM_303;
	}
	public void setITEM_303(String iTEM_303) {
		ITEM_303 = iTEM_303;
	}
	public String getITEM_304() {
		return ITEM_304;
	}
	public void setITEM_304(String iTEM_304) {
		ITEM_304 = iTEM_304;
	}
	public String getITEM_305() {
		return ITEM_305;
	}
	public void setITEM_305(String iTEM_305) {
		ITEM_305 = iTEM_305;
	}
	public String getITEM_306() {
		return ITEM_306;
	}
	public void setITEM_306(String iTEM_306) {
		ITEM_306 = iTEM_306;
	}
	public String getITEM_160() {
		return ITEM_160;
	}
	public void setITEM_160(String iTEM_160) {
		ITEM_160 = iTEM_160;
	}
	public String getITEM_161() {
		return ITEM_161;
	}
	public void setITEM_161(String iTEM_161) {
		ITEM_161 = iTEM_161;
	}
	public String getITEM_163() {
		return ITEM_163;
	}
	public void setITEM_163(String iTEM_163) {
		ITEM_163 = iTEM_163;
	}
	public String getITEM_151() {
		return ITEM_151;
	}
	public void setITEM_151(String iTEM_151) {
		ITEM_151 = iTEM_151;
	}
	public String getITEM_152() {
		return ITEM_152;
	}
	public void setITEM_152(String iTEM_152) {
		ITEM_152 = iTEM_152;
	}
	public String getITEM_153() {
		return ITEM_153;
	}
	public void setITEM_153(String iTEM_153) {
		ITEM_153 = iTEM_153;
	}
	public String getITEM_150() {
		return ITEM_150;
	}
	public void setITEM_150(String iTEM_150) {
		ITEM_150 = iTEM_150;
	}
	public String getITEM_140() {
		return ITEM_140;
	}
	public void setITEM_140(String iTEM_140) {
		ITEM_140 = iTEM_140;
	}
	public String getITEM_142() {
		return ITEM_142;
	}
	public void setITEM_142(String iTEM_142) {
		ITEM_142 = iTEM_142;
	}
	public String getITEM_143() {
		return ITEM_143;
	}
	public void setITEM_143(String iTEM_143) {
		ITEM_143 = iTEM_143;
	}
	public String getITEM_141() {
		return ITEM_141;
	}
	public void setITEM_141(String iTEM_141) {
		ITEM_141 = iTEM_141;
	}
	public String getITEM_162() {
		return ITEM_162;
	}
	public void setITEM_162(String iTEM_162) {
		ITEM_162 = iTEM_162;
	}
	public String getITEM_130() {
		return ITEM_130;
	}
	public void setITEM_130(String iTEM_130) {
		ITEM_130 = iTEM_130;
	}
	public String getITEM_133() {
		return ITEM_133;
	}
	public void setITEM_133(String iTEM_133) {
		ITEM_133 = iTEM_133;
	}
	public String getITEM_21() {
		return ITEM_21;
	}
	public void setITEM_21(String iTEM_21) {
		ITEM_21 = iTEM_21;
	}
	public String getITEM_22() {
		return ITEM_22;
	}
	public void setITEM_22(String iTEM_22) {
		ITEM_22 = iTEM_22;
	}
	public String getITEM_131() {
		return ITEM_131;
	}
	public void setITEM_131(String iTEM_131) {
		ITEM_131 = iTEM_131;
	}
	public String getITEM_51() {
		return ITEM_51;
	}
	public void setITEM_51(String iTEM_51) {
		ITEM_51 = iTEM_51;
	}
	public String getITEM_52() {
		return ITEM_52;
	}
	public void setITEM_52(String iTEM_52) {
		ITEM_52 = iTEM_52;
	}
	public String getITEM_53() {
		return ITEM_53;
	}
	public void setITEM_53(String iTEM_53) {
		ITEM_53 = iTEM_53;
	}
	public String getITEM_56() {
		return ITEM_56;
	}
	public void setITEM_56(String iTEM_56) {
		ITEM_56 = iTEM_56;
	}
	public String getITEM_SJDR() {
		return ITEM_SJDR;
	}
	public void setITEM_SJDR(String iTEMSJDR) {
		ITEM_SJDR = iTEMSJDR;
	}
	public String getITEM_SJDC() {
		return ITEM_SJDC;
	}
	public void setITEM_SJDC(String iTEMSJDC) {
		ITEM_SJDC = iTEMSJDC;
	}
	public String getITEM_DQDM() {
		return ITEM_DQDM;
	}
	public void setITEM_DQDM(String iTEMDQDM) {
		ITEM_DQDM = iTEMDQDM;
	}
	public String getITEM_CGLB() {
		return ITEM_CGLB;
	}
	public void setITEM_CGLB(String iTEMCGLB) {
		ITEM_CGLB = iTEMCGLB;
	}
	public String getITEM_144() {
		return ITEM_144;
	}
	public void setITEM_144(String iTEM_144) {
		ITEM_144 = iTEM_144;
	}
	public String getITEM_145() {
		return ITEM_145;
	}
	public void setITEM_145(String iTEM_145) {
		ITEM_145 = iTEM_145;
	}
	public String getITEM_149() {
		return ITEM_149;
	}
	public void setITEM_149(String iTEM_149) {
		ITEM_149 = iTEM_149;
	}
	public String getITEM_154() {
		return ITEM_154;
	}
	public void setITEM_154(String iTEM_154) {
		ITEM_154 = iTEM_154;
	}
	public String getITEM_128() {
		return ITEM_128;
	}
	public void setITEM_128(String iTEM_128) {
		ITEM_128 = iTEM_128;
	}
	public String getITEM_15() {
		return ITEM_15;
	}
	public void setITEM_15(String iTEM_15) {
		ITEM_15 = iTEM_15;
	}
	public String getITEM_15_1() {
		return ITEM_15_1;
	}
	public void setITEM_15_1(String iTEM_15_1) {
		ITEM_15_1 = iTEM_15_1;
	}
	public String getITEM_142_1() {
		return ITEM_142_1;
	}
	public void setITEM_142_1(String iTEM_142_1) {
		ITEM_142_1 = iTEM_142_1;
	}
	public String getITEM_142_2() {
		return ITEM_142_2;
	}
	public void setITEM_142_2(String iTEM_142_2) {
		ITEM_142_2 = iTEM_142_2;
	}
	public String getITEM_142_3() {
		return ITEM_142_3;
	}
	public void setITEM_142_3(String iTEM_142_3) {
		ITEM_142_3 = iTEM_142_3;
	}
	public String getITEM_XH() {
		return ITEM_XH;
	}
	public void setITEM_XH(String iTEMXH) {
		ITEM_XH = iTEMXH;
	}
	public String getITEM_148() {
		return ITEM_148;
	}
	public void setITEM_148(String iTEM_148) {
		ITEM_148 = iTEM_148;
	}
	public String getITEM_243() {
		return ITEM_243;
	}
	public void setITEM_243(String iTEM_243) {
		ITEM_243 = iTEM_243;
	}
	public String getITEM_244() {
		return ITEM_244;
	}
	public void setITEM_244(String iTEM_244) {
		ITEM_244 = iTEM_244;
	}
	public String getITEM_51_1() {
		return ITEM_51_1;
	}
	public void setITEM_51_1(String iTEM_51_1) {
		ITEM_51_1 = iTEM_51_1;
	}
	public String getITEM_51_2() {
		return ITEM_51_2;
	}
	public void setITEM_51_2(String iTEM_51_2) {
		ITEM_51_2 = iTEM_51_2;
	}
	public String getITEM_51_3() {
		return ITEM_51_3;
	}
	public void setITEM_51_3(String iTEM_51_3) {
		ITEM_51_3 = iTEM_51_3;
	}
	public String getITEM_151_1() {
		return ITEM_151_1;
	}
	public void setITEM_151_1(String iTEM_151_1) {
		ITEM_151_1 = iTEM_151_1;
	}
	public String getITEM_152_1() {
		return ITEM_152_1;
	}
	public void setITEM_152_1(String iTEM_152_1) {
		ITEM_152_1 = iTEM_152_1;
	}
	public String getITEM_152_2() {
		return ITEM_152_2;
	}
	public void setITEM_152_2(String iTEM_152_2) {
		ITEM_152_2 = iTEM_152_2;
	}
	public String getITEM_127_1() {
		return ITEM_127_1;
	}
	public void setITEM_127_1(String iTEM_127_1) {
		ITEM_127_1 = iTEM_127_1;
	}
	public String getExt_IsRecommended() {
		return Ext_IsRecommended;
	}
	public void setExt_IsRecommended(String extIsRecommended) {
		Ext_IsRecommended = extIsRecommended;
	}
	public String getExt_Attribute() {
		return Ext_Attribute;
	}
	public void setExt_Attribute(String extAttribute) {
		Ext_Attribute = extAttribute;
	}
	public String getExt_Region() {
		return Ext_Region;
	}
	public void setExt_Region(String extRegion) {
		Ext_Region = extRegion;
	}
	public String getExt_Standard() {
		return Ext_Standard;
	}
	public void setExt_Standard(String extStandard) {
		Ext_Standard = extStandard;
	}
	public String getExt_Projects() {
		return Ext_Projects;
	}
	public void setExt_Projects(String extProjects) {
		Ext_Projects = extProjects;
	}
	public String getExt_VisitCount() {
		return Ext_VisitCount;
	}
	public void setExt_VisitCount(String extVisitCount) {
		Ext_VisitCount = extVisitCount;
	}
	public String getItem_131_1() {
		return item_131_1;
	}
	public void setItem_131_1(String item_131_1) {
		this.item_131_1 = item_131_1;
	}
	public String getItem_133_1() {
		return item_133_1;
	}
	public void setItem_133_1(String item_133_1) {
		this.item_133_1 = item_133_1;
	}
	
	
}
