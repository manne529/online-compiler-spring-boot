package project.onlinecompiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.onlinecompiler.dto.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
