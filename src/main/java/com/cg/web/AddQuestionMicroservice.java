package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.util.QuestionConstants;
import com.cg.dto.AddQuestionSuccessMessage;
import com.cg.dto.QuestionDto;
import com.cg.exceptions.QuestionAddException;
import com.cg.service.QuestionService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AddQuestionMicroservice {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping(QuestionConstants.ADD_QUESTION_URL)
    public AddQuestionSuccessMessage AddQuestion(@RequestBody QuestionDto questiondto) throws QuestionAddException{
		String msg= questionService.AddQuestion(questiondto);
		return new AddQuestionSuccessMessage(msg);
	}
	

}
