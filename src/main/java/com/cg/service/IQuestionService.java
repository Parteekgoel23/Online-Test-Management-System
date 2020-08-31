package com.cg.service;

import com.cg.dto.QuestionDto;
import com.cg.exceptions.QuestionAddException;

public interface IQuestionService  {
	
	public String AddQuestion(QuestionDto questiondto) throws QuestionAddException;

}
