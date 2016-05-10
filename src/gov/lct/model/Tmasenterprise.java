package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_masenterprise")
public class Tmasenterprise {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "entertype")
	private String entertype;

	@Column(name = "typeyear")
	private String typeyear;

	@Column(name = "range")
	private String range;
	
	@Column(name = "city")
	private String city;

	@Column(name = "series")
	private String series;
		
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

	public String getEntertype() {
		return entertype;
	}

	public void setEntertype(String entertype) {
		this.entertype = entertype;
	}

	public String getTypeyear() {
		return typeyear;
	}

	public void setTypeyear(String typeyear) {
		this.typeyear = typeyear;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}


}
