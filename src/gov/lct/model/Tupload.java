package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_file")
public class Tupload {
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
	private Integer id;
	
	@Column(name="loginname")
	private String loginname;
	
	@Column(name="file1")
	private String file1;
	
	@Column(name="file2")
	private String file2;

	@Column(name="file3")
	private String file3;

	@Column(name="file4")
	private String file4;

	@Column(name="file5")
	private String file5;

	@Column(name="file6")
	private String file6;

	@Column(name="file7")
	private String file7;

	@Column(name="file8")
	private String file8;

	@Column(name="file9")
	private String file9;

	@Column(name="file10")
	private String file10;

	@Column(name="file11")
	private String file11;

	@Column(name="file12")
	private String file12;

	@Column(name="file13")
	private String file13;

	@Column(name="file14")
	private String file14;
	
	@Column(name="uploadtime")
	private String uploadtime;

	@Column(name="suggestion")
	private String suggestion;
	
	@Column(name="expert")
	private String expert;
	
	@Column(name="number")
	private String number;

	public String getExpert() {
		return expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getFile4() {
		return file4;
	}

	public void setFile4(String file4) {
		this.file4 = file4;
	}

	public String getFile5() {
		return file5;
	}

	public void setFile5(String file5) {
		this.file5 = file5;
	}

	public String getFile6() {
		return file6;
	}

	public void setFile6(String file6) {
		this.file6 = file6;
	}

	public String getFile7() {
		return file7;
	}

	public void setFile7(String file7) {
		this.file7 = file7;
	}

	public String getFile8() {
		return file8;
	}

	public void setFile8(String file8) {
		this.file8 = file8;
	}

	public String getFile9() {
		return file9;
	}

	public void setFile9(String file9) {
		this.file9 = file9;
	}

	public String getFile10() {
		return file10;
	}

	public void setFile10(String file10) {
		this.file10 = file10;
	}

	public String getFile11() {
		return file11;
	}

	public void setFile11(String file11) {
		this.file11 = file11;
	}

	public String getFile12() {
		return file12;
	}

	public void setFile12(String file12) {
		this.file12 = file12;
	}

	public String getFile13() {
		return file13;
	}

	public void setFile13(String file13) {
		this.file13 = file13;
	}

	public String getFile14() {
		return file14;
	}

	public void setFile14(String file14) {
		this.file14 = file14;
	}
	
	public String getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}