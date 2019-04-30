package com.quizwebapplication.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserAnswer")
public class UserAnswer {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userAnswerId;
	
	@Column
	private String userans;
	
	@Column
	private String username;
	@Column
	private Integer qid;
	@Column
	private String crtans;

	public String getUserans() {
		return userans;
	}

	public void setUserans(String userans) {
		this.userans = userans;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCrtans() {
		return crtans;
	}

	public void setCrtans(String crtans) {
		this.crtans = crtans;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "UserAnswer [userans=" + userans + ", username=" + username + ", qid=" + qid + ", crtans=" + crtans
				+ "]";
	}

}
