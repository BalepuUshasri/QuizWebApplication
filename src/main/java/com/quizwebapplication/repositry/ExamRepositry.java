package com.quizwebapplication.repositry;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.quizwebapplication.bean.Exam;
import com.quizwebapplication.bean.Questions;
import com.quizwebapplication.bean.UserAnswer;

@Repository
public class ExamRepositry {

	@Autowired
	HibernateTemplate dbConnection;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Exam> getAllExamList() {
		Query query = dbConnection.getSessionFactory().getCurrentSession().createQuery("from Exam");
		return query.list();
	}

	@Transactional
	public Integer saveExam(Exam exam, Integer examId) {
		Exam exam2 = null;
		if (examId != null) {
			exam2 = dbConnection.get(Exam.class, examId);
			List<Questions> allQuestions = exam2.getMyQuesions();
			allQuestions.addAll(exam.getMyQuesions());
			exam2.setMyQuesions(allQuestions);
			exam2 = dbConnection.merge(exam2);

		} else {
			exam2 = dbConnection.merge(exam);
		}
		return exam2.getExamId();
	}

	public Exam getExamByExamID(Integer examId) {
		return dbConnection.get(Exam.class, examId);
	}

	@Transactional
	public void saveUserAnswer(UserAnswer uns) {
		dbConnection.save(uns);
	}

	@Transactional
	public List<UserAnswer> submit(String userName) {
		Query query = dbConnection.getSessionFactory().getCurrentSession()
				.createQuery("from UserAnswer where username=?");
		query.setParameter(0, userName);
		@SuppressWarnings("unchecked")
		List<UserAnswer> arrayList = query.list();
		return arrayList;
	}

	@Transactional
	public void deletesubmithistory(UserAnswer userAnswer) {

		dbConnection.delete(userAnswer);
	}

}
