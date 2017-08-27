package com.freeman.exams.exam;

import com.freeman.exams.expression.ExpressionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams(){
        List<Exam> exams = new ArrayList<>();
        examRepository.findAll().forEach(exams::add);
        return exams;
    }

    public Exam getExam(Long id){
        return examRepository.findOne(id);
    }

    public void addExam (Exam exam){
        examRepository.save(exam);
    }

    public void updateExam(Long id, Exam exam){
        examRepository.save(exam);
    }

    public void deleteExam (Long id){
        examRepository.delete(id);
    }
}
