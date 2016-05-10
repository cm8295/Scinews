package gov.lct.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_ip")
public class Tip {

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false, insertable=true, updatable=false, precision=20, scale=0) 
	private Integer id;
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "client", nullable = false)
	private String client;

	@Column(name = "agent")
	private String agent;//
	
	@Column(name = "person")
	private String person;//
	
	@Column(name = "deliverdate")
	private Date deliverdate;//
	
	@Column(name = "attachment")
	private String attachment;//
	
	@Column(name = "status")
	private String status;//
	
	@Column(name = "request")
	private String request;//
	
	@Column(name = "telephone")
	private String telephone;//
	
	@Column(name = "email")
	private String email;//

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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getDeliverdate() {
		return deliverdate;
	}

	public void setDeliverdate(Date deliverdate) {
		this.deliverdate = deliverdate;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
