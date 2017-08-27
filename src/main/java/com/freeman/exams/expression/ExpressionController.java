package com.freeman.exams.expression;

import com.freeman.exams.exam.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ExpressionController {

    @Autowired
    private ExpressionService expressionService;

    @RequestMapping("/exams/{id}/expressionstempl")
    public List<ExpressionTemplate> getAllExpressionTempl(@PathVariable Long id){
        return expressionService.getAllExpressionTempl(id);
    }

    @RequestMapping("/exams/{examId}/expressionstempl/{id}")
    public ExpressionTemplate getExpressionTempl(@PathVariable Long id){
        return expressionService.getExpressionTempl(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exams/{examId}/expressionstempl")
    public void addExpressionTempl(@RequestBody ExpressionTemplate expression, @PathVariable Long examId){
        expression.setExam(new Exam(examId,""));
        expressionService.addExpressionTempl(expression);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/exams/{examId}/expressionstempl/{id}")
    public void updateExpressionTempl(@RequestBody ExpressionTemplate expression, @PathVariable Long id, @PathVariable Long examId){
        expression.setExam(new Exam(examId,""));
        expression.setId(id);
        expressionService.updateExpressionTempl(id, expression);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/exams/{examId}/expressionstempl/{id}")
    public void deleteExpressionTempl(@PathVariable Long id){
        expressionService.deleteExpressionTempl(id);
    }

    @RequestMapping("/exams/{id}/expressions")
    public List<Map<String, Integer>> getAllExpression(@PathVariable Long id){
        return expressionService.getAllExpression(id);
    }
}
