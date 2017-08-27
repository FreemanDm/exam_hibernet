package com.freeman.exams.expression;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.freeman.exams.exam.Exam;

import javax.persistence.*;

@Entity
@Table(name = "expressions")
public class ExpressionTemplate {

    @Id
    @Column(name = "EXPRESSION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "EXPRESSION")
    private String expression;
    @Column(name = "QUANTITY")
    private String quantity;
    @ManyToOne
    @JoinColumn(name = "EXAM_ID")
    @JsonBackReference
    private Exam exam;

    public ExpressionTemplate() {
    }

    public ExpressionTemplate(String expression, String quantity) {
        this.expression = expression;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
