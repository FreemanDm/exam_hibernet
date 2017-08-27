package com.freeman.exams.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    private ExamService examService;

    @RequestMapping("/exams")
    public List<Exam> getAllExams(){
        return examService.getAllExams();
    }

    @RequestMapping("/exams/{id}")
    public Exam getExam(@PathVariable Long id){
        return examService.getExam(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/exams")
    public void addExam(@RequestBody Exam exam){
        examService.addExam(exam);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/exams/{id}")
    public void updateExam(@RequestBody Exam exam, @PathVariable Long id){
        exam.setId(id);
        examService.updateExam(id, exam);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/exams/{id}")
    public void deleteExam(@PathVariable Long id){
        examService.deleteExam(id);
    }
}
