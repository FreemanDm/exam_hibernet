package com.freeman.exams.expression;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpressionRepository extends CrudRepository<ExpressionTemplate, Long> {
    public List<ExpressionTemplate> findByExamId (Long examId);
}
