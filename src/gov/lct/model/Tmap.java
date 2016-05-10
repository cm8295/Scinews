package gov.lct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_MapByPatent")
public class Tmap {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	@Column(name = "patent_An")
	private String patentAn;

	@Column(name = "map_Name")
	private String mapName;

	@Column(name = "map_Regnumber")
	private String mapRegnumber;
	
	@Column(name = "map_AD")
	private String mapAd;
	
	@Column(name = "map_PD")
	private String mapPd;
	
	@Column(name = "map_PN")
	private String mapPn;
	
	@Column(name = "map_Institute")
	private String mapInstitute;
	
	@Column(name = "map_Institute_Co")
	private String mapInstituteCo;
	
	@Column(name = "map_Designer")
	private String mapDesigner;
	
	@Column(name = "map_Structure")
	private String mapStructure;
	
	@Column(name = "map_Tech")
	private String mapTech;
	
	@Column(name = "map_Function")
	private String mapFunction;
	
	@Column(name = "map_Country")
	private String mapCountry;
	
	@Column(name = "map_Address")
	private String mapAddress;
	
	@Column(name = "map_CountryCo")
	private String mapCountryCo;
	
	@Column(name = "map_AddressCo")
	private String mapAddressCo;
	
	@Column(name = "map_Proxy")
	private String mapProxy;
	
	@Column(name = "map_Proxyer")
	private String mapProxyer;
	
	@Column(name = "map_Endate")
	private String mapEndate;
	
	@Column(name = "map_Business")
	private String mapBusiness;
	
	@Column(name = "institute")
	private String institute;
	
	@Column(name = "genTime")
	private String genTime;
	
	@Column(name = "branch")
	private String branch;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatentAn() {
		return patentAn;
	}

	public void setPatentAn(String patentAn) {
		this.patentAn = patentAn;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapRegnumber() {
		return mapRegnumber;
	}

	public void setMapRegnumber(String mapRegnumber) {
		this.mapRegnumber = mapRegnumber;
	}

	public String getMapAd() {
		return mapAd;
	}

	public void setMapAd(String mapAd) {
		this.mapAd = mapAd;
	}

	public String getMapPd() {
		return mapPd;
	}

	public void setMapPd(String mapPd) {
		this.mapPd = mapPd;
	}

	public String getMapPn() {
		return mapPn;
	}

	public void setMapPn(String mapPn) {
		this.mapPn = mapPn;
	}

	public String getMapInstitute() {
		return mapInstitute;
	}

	public void setMapInstitute(String mapInstitute) {
		this.mapInstitute = mapInstitute;
	}

	public String getMapInstituteCo() {
		return mapInstituteCo;
	}

	public void setMapInstituteCo(String mapInstituteCo) {
		this.mapInstituteCo = mapInstituteCo;
	}

	public String getMapDesigner() {
		return mapDesigner;
	}

	public void setMapDesigner(String mapDesigner) {
		this.mapDesigner = mapDesigner;
	}

	public String getMapStructure() {
		return mapStructure;
	}

	public void setMapStructure(String mapStructure) {
		this.mapStructure = mapStructure;
	}

	public String getMapTech() {
		return mapTech;
	}

	public void setMapTech(String mapTech) {
		this.mapTech = mapTech;
	}

	public String getMapFunction() {
		return mapFunction;
	}

	public void setMapFunction(String mapFunction) {
		this.mapFunction = mapFunction;
	}

	public String getMapCountry() {
		return mapCountry;
	}

	public void setMapCountry(String mapCountry) {
		this.mapCountry = mapCountry;
	}

	public String getMapAddress() {
		return mapAddress;
	}

	public void setMapAddress(String mapAddress) {
		this.mapAddress = mapAddress;
	}

	public String getMapCountryCo() {
		return mapCountryCo;
	}

	public void setMapCountryCo(String mapCountryCo) {
		this.mapCountryCo = mapCountryCo;
	}

	public String getMapAddressCo() {
		return mapAddressCo;
	}

	public void setMapAddressCo(String mapAddressCo) {
		this.mapAddressCo = mapAddressCo;
	}

	public String getMapProxy() {
		return mapProxy;
	}

	public void setMapProxy(String mapProxy) {
		this.mapProxy = mapProxy;
	}

	public String getMapProxyer() {
		return mapProxyer;
	}

	public void setMapProxyer(String mapProxyer) {
		this.mapProxyer = mapProxyer;
	}

	public String getMapEndate() {
		return mapEndate;
	}

	public void setMapEndate(String mapEndate) {
		this.mapEndate = mapEndate;
	}

	public String getMapBusiness() {
		return mapBusiness;
	}

	public void setMapBusiness(String mapBusiness) {
		this.mapBusiness = mapBusiness;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getGenTime() {
		return genTime;
	}

	public void setGenTime(String genTime) {
		this.genTime = genTime;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Tmap() {
	}
}
