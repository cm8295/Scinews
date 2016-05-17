package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_evaluation")
public class Tevaluation {
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0)
	private Integer id;
	
	@Column(name="user")
	private String user;
	
	@Column(name="expert")
	private String expert;
	
	@Column(name="item1")
	private Integer item1;

	@Column(name="item2")
	private Integer item2;
	
	@Column(name="item3")
	private Integer item3;
	
	@Column(name="item4")
	private Integer item4;
	
	@Column(name="item5")
	private Integer item5;
	
	@Column(name="item6")
	private Integer item6;
	
	@Column(name="item7")
	private Integer item7;
	
	@Column(name="item8")
	private Integer item8;
	
	@Column(name="item9")
	private Integer item9;
	
	@Column(name="item10")
	private Integer item10;
	
	@Column(name="item11")
	private Integer item11;
	
	@Column(name="item12")
	private Integer item12;
	
	@Column(name="item13")
	private Integer item13;
	
	@Column(name="item14")
	private Integer item14;
	
	@Column(name="item15")
	private Integer item15;
	
	@Column(name="item16")
	private Integer item16;
	
	@Column(name="item17")
	private Integer item17;
	
	@Column(name="item18")
	private Integer item18;
	
	@Column(name="item19")
	private Integer item19;
	
	@Column(name="item20")
	private Integer item20;
	
	@Column(name="item21")
	private Integer item21;
	
	@Column(name="item22")
	private Integer item22;
	
	@Column(name="time")
	private String time;
	
	@Column(name="suggestion")
	private String suggestion;
	
	@Column(name="no")
	private Integer no;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getExpert() {
		return expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

	public Integer getItem1() {
		return item1;
	}

	public void setItem1(Integer item1) {
		this.item1 = item1;
	}

	public Integer getItem2() {
		return item2;
	}

	public void setItem2(Integer item2) {
		this.item2 = item2;
	}

	public Integer getItem3() {
		return item3;
	}

	public void setItem3(Integer item3) {
		this.item3 = item3;
	}

	public Integer getItem4() {
		return item4;
	}

	public void setItem4(Integer item4) {
		this.item4 = item4;
	}

	public Integer getItem5() {
		return item5;
	}

	public void setItem5(Integer item5) {
		this.item5 = item5;
	}

	public Integer getItem6() {
		return item6;
	}

	public void setItem6(Integer item6) {
		this.item6 = item6;
	}

	public Integer getItem7() {
		return item7;
	}

	public void setItem7(Integer item7) {
		this.item7 = item7;
	}

	public Integer getItem8() {
		return item8;
	}

	public void setItem8(Integer item8) {
		this.item8 = item8;
	}

	public Integer getItem9() {
		return item9;
	}

	public void setItem9(Integer item9) {
		this.item9 = item9;
	}

	public Integer getItem10() {
		return item10;
	}

	public void setItem10(Integer item10) {
		this.item10 = item10;
	}

	public Integer getItem11() {
		return item11;
	}

	public void setItem11(Integer item11) {
		this.item11 = item11;
	}

	public Integer getItem12() {
		return item12;
	}

	public void setItem12(Integer item12) {
		this.item12 = item12;
	}

	public Integer getItem13() {
		return item13;
	}

	public void setItem13(Integer item13) {
		this.item13 = item13;
	}

	public Integer getItem14() {
		return item14;
	}

	public void setItem14(Integer item14) {
		this.item14 = item14;
	}

	public Integer getItem15() {
		return item15;
	}

	public void setItem15(Integer item15) {
		this.item15 = item15;
	}

	public Integer getItem16() {
		return item16;
	}

	public void setItem16(Integer item16) {
		this.item16 = item16;
	}

	public Integer getItem17() {
		return item17;
	}

	public void setItem17(Integer item17) {
		this.item17 = item17;
	}

	public Integer getItem18() {
		return item18;
	}

	public void setItem18(Integer item18) {
		this.item18 = item18;
	}

	public Integer getItem19() {
		return item19;
	}

	public void setItem19(Integer item19) {
		this.item19 = item19;
	}

	public Integer getItem20() {
		return item20;
	}

	public void setItem20(Integer item20) {
		this.item20 = item20;
	}

	public Integer getItem21() {
		return item21;
	}

	public void setItem21(Integer item21) {
		this.item21 = item21;
	}

	public Integer getItem22() {
		return item22;
	}

	public void setItem22(Integer item22) {
		this.item22 = item22;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}
	
	
}