package com.cg.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.IExamDao;
import com.cg.dao.IQuestionDao;
import com.cg.dto.QuestionDto;
import com.cg.entity.Exam;
import com.cg.entity.Questions;
import com.cg.exceptions.QuestionAddException;
import com.cg.util.QuestionConstants;

@Service
public class QuestionService implements IQuestionService {
     
	@Autowired
	private IQuestionDao dao;
    
	@Autowired
	private IExamDao examdao;
	@Override
	@Transactional
	public String AddQuestion(QuestionDto questiondto) throws QuestionAddException  {
		
		Questions ques=new Questions();
		ques.setQuestionId(questiondto.getQuestionid());
		ques.setOptA(questiondto.getOptA());
		ques.setOptB(questiondto.getOptB());
		ques.setOptC(questiondto.getOptC());
		ques.setOptD(questiondto.getOptD());
		ques.setAnswer(questiondto.getAnswer());
		ques.setQuestionTitle(questiondto.getQuestionTitle());
		Optional<Exam> optexam= examdao.findById(questiondto.getExamid());
		if(!optexam.isPresent())
			throw new QuestionAddException(QuestionConstants.INVALID_EXAM);
		Exam exam =optexam.get();
		ques.setExam(exam);
		dao.save(ques);
		return QuestionConstants.ADD_QUESTIONS;
	}

}
