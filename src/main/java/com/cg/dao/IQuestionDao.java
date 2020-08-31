package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Questions;

@Repository
public interface IQuestionDao extends JpaRepository<Questions,String> {

}
