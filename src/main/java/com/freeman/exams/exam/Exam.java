package com.freeman.exams.exam;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.freeman.exams.expression.ExpressionTemplate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "EXAM")
public class Exam {

    @Id
    @Column(name = "EXAM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DISCIPLINE")
    private String discipline;
    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ExpressionTemplate> listOfExpressionTemplate = new ArrayList<ExpressionTemplate>();

    public Exam() {
    }

    public Exam(Long id, String discipline) {
        this.id = id;
        this.discipline = discipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public List<ExpressionTemplate> getListOfExpressionTemplate() {
        return listOfExpressionTemplate;
    }

    public void addExpression(ExpressionTemplate expression){
        listOfExpressionTemplate.add(expression);
        expression.setExam(this);
    }

    public void removeExpression(ExpressionTemplate expression){
        listOfExpressionTemplate.remove(expression);
        expression.setExam(null);
    }
}
