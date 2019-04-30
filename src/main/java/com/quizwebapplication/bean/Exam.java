package com.quizwebapplication.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

	
	private static final long serialVersionUID = 549880218579049022L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer examId;

	@Column
	private String examInfo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examId", referencedColumnName = "examId")
	private List<Questions> myQuesions;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getExamInfo() {
		return examInfo;
	}

	public void setExamInfo(String examInfo) {
		this.examInfo = examInfo;
	}

	public List<Questions> getMyQuesions() {
		return myQuesions;
	}

	public void setMyQuesions(List<Questions> myQuesions) {
		this.myQuesions = myQuesions;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examInfo=" + examInfo + ", myQuesions=" + myQuesions + "]";
	}

}
