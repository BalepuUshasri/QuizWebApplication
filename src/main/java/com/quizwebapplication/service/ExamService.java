package com.quizwebapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizwebapplication.bean.Exam;
import com.quizwebapplication.bean.ExanCreatedetails;
import com.quizwebapplication.bean.Questions;
import com.quizwebapplication.bean.UserAnswer;
import com.quizwebapplication.repositry.ExamRepositry;

@Service
public class ExamService {

	@Autowired
	private ExamRepositry examRepositry;

	public Integer saveExam(ExanCreatedetails createdetails, Integer exmaID) {
		Questions questions = new Questions();
		List<Questions> allQuestions = new ArrayList<Questions>();
		Exam exam = new Exam();
		if (exmaID != null) {
			exam.setExamId(exmaID);
		}

		exam.setExamInfo(createdetails.getExamInfo());
		questions.setQuestionText(createdetails.getQuestionText());
		questions.setTypeOfQuestion(createdetails.getTypeOfQuestion());
		questions.setOption1(createdetails.getOption1());
		questions.setOption2(createdetails.getOption2());
		questions.setOption3(createdetails.getOption3());
		questions.setOption4(createdetails.getOption4());
		questions.setCorrectAnswer(createdetails.getCorrectAnswer());
		allQuestions.add(questions);
		exam.setMyQuesions(allQuestions);
		return examRepositry.saveExam(exam, exmaID);
	}

	public List<Exam> getAllExamList() {
		return examRepositry.getAllExamList();
	}

	public Exam getExamByExamID(Exam exam) {

		return examRepositry.getExamByExamID(exam.getExamId());
	}

	public void saveanswers(Integer qid, String ans, Exam exam, String username) {

		List<Questions> allQuestions = exam.getMyQuesions();

		for (Questions questions : allQuestions) {
			if (qid.equals(questions.getQuestionId())) {
				UserAnswer uns = new UserAnswer();
				uns.setQid(qid);
				uns.setCrtans(questions.getCorrectAnswer());
				uns.setUserans(ans);
				uns.setUsername(username);
				examRepositry.saveUserAnswer(uns);
			}
		}

	}

	public Integer submit(String userName) {
		Integer count=0;
		List<UserAnswer> userans = examRepositry.submit(userName);
		for (UserAnswer userAnswer : userans) {
			if(userAnswer.getCrtans().equals(userAnswer.getUserans())){
				count++;
			}
		}
		for (UserAnswer userAnswer : userans) {
			examRepositry.deletesubmithistory(userAnswer);
		}
		
		return count;
	}

}
