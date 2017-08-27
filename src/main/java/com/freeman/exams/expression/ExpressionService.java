package com.freeman.exams.expression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExpressionService {

    @Autowired
    private ExpressionRepository expressionRepository;

    private ExpGenerator expressionGenerator = new ExpGenerator();

    public List<ExpressionTemplate> getAllExpressionTempl(Long examId){
        List<ExpressionTemplate> expression = new ArrayList<>();
        expressionRepository.findByExamId(examId).forEach(expression::add);
        return expression;
    }

    public ExpressionTemplate getExpressionTempl(Long id){
        return expressionRepository.findOne(id);
    }

    public void addExpressionTempl(ExpressionTemplate expression){
        expressionRepository.save(expression);
    }

    public void updateExpressionTempl(Long id, ExpressionTemplate expression){
        expressionRepository.save(expression);
    }

    public void deleteExpressionTempl(Long id){
        expressionRepository.delete(id);
    }


    public List<Map<String, Integer>> getAllExpression (Long examId){
        List<Map<String, Integer>> expressions = new ArrayList<>();
        List<ExpressionTemplate> expressionsTempl = new ArrayList<>();
        expressionRepository.findByExamId(examId).forEach(expressionsTempl::add);
        for(ExpressionTemplate expressionTemplate : expressionsTempl){
            expressions.add(expressionGenerator.generate(expressionTemplate.getExpression(), Integer.parseInt(expressionTemplate.getQuantity())));
        }
        return expressions;
    }
}
