package com.quizwebapplication.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quizwebapplication.bean.Exam;
import com.quizwebapplication.bean.ExanCreatedetails;
import com.quizwebapplication.bean.Questions;
import com.quizwebapplication.service.ExamService;

@RestController
public class ExamController {

	String userName = "";
	Integer examId;

	Exam satrtExam;
	int i = 0;
	@Autowired
	private HttpSession httpsession;
	@Autowired
	private ExamService examService;

	@GetMapping("/createExam")
	public ModelAndView createExam() {
		userName = (String) httpsession.getAttribute("userName");
		if (userName == null) {
			return new ModelAndView("userLogin");

		}

		return new ModelAndView("createExam", "userName", userName);
	}

	@PostMapping("/saveExam")
	public ModelAndView saveExam(@RequestBody ExanCreatedetails createdetails) {
		userName = (String) httpsession.getAttribute("userName");
		examId = examService.saveExam(createdetails, examId);

		return new ModelAndView("createExam", "userName", userName);

	}

	@GetMapping("/getAllExamList")
	public List<Exam> getAllExamList() {
		return examService.getAllExamList();

	}

	@PostMapping("/getExamByExamID")
	public String getExamByExamID(@RequestBody Exam exam) {
		userName = (String) httpsession.getAttribute("userName");

		httpsession.setAttribute("satrtExam", exam);
		return "";

	}

	@GetMapping("/StartExam")
	public ModelAndView startExam() {
		
		if (userName == null) {
			return new ModelAndView("userLogin");
		}
		satrtExam = (Exam) httpsession.getAttribute("satrtExam");
		return new ModelAndView("examstart", "exam", satrtExam);
	}

	@GetMapping("/submit")
	public ModelAndView submit() {
		userName = (String) httpsession.getAttribute("userName");
		if (userName == null) {
			return new ModelAndView("userLogin");
		}
		ModelAndView andView = new ModelAndView("result");
		andView.addObject("totalQuestions", satrtExam.getMyQuesions().size());
		andView.addObject("rank", examService.submit(userName));

		return andView;
	}

	@GetMapping("/cancelsubmitExam")
	public String cancelsubmitExam() {
		examId = null;
		return "";
	}

	@PostMapping("/getQuestionsbyID/{qid}/{ans}")
	public Questions getQuestionsbyID(@PathVariable Integer qid, @PathVariable String ans) {
		Exam exam = (Exam) httpsession.getAttribute("satrtExam");
		userName = (String) httpsession.getAttribute("userName");
		Questions getquestions = null;
		if (!ans.equals("undefined")) {
			examService.saveanswers(qid, ans, exam, userName);
		}

		List<Questions> ques = exam.getMyQuesions();
		if (qid == 1) {
			getquestions = ques.get(0);
		} else {
			qid = qid + 1;
			for (Questions questions : ques) {
				if (qid.equals(questions.getQuestionId())) {
					getquestions = questions;
				}
			}

		}

		return getquestions;
	}

}
