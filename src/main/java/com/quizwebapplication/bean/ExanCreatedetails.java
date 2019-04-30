package com.quizwebapplication.bean;

import java.io.Serializable;
import java.util.List;

public class ExanCreatedetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2123317352446426530L;

	private List<ExanCreatedetails> exanCreatedetails;

	private String examInfo;

	private String typeOfQuestion;

	private String questionText;

	private String option1;

	private String option2;

	private String option3;

	private String option4;

	private String correctAnswer;

	public String getExamInfo() {
		return examInfo;
	}

	public void setExamInfo(String examInfo) {
		this.examInfo = examInfo;
	}

	public String getTypeOfQuestion() {
		return typeOfQuestion;
	}

	public void setTypeOfQuestion(String typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<ExanCreatedetails> getExanCreatedetails() {
		return exanCreatedetails;
	}

	public void setExanCreatedetails(List<ExanCreatedetails> exanCreatedetails) {
		this.exanCreatedetails = exanCreatedetails;
	}

	@Override
	public String toString() {
		return "ExanCreatedetails [examInfo=" + examInfo + ", typeOfQuestion=" + typeOfQuestion + ", questionText="
				+ questionText + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4="
				+ option4 + ", correctAnswer=" + correctAnswer + "]";
	}

}
