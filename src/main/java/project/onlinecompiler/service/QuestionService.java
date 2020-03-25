package project.onlinecompiler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.onlinecompiler.dto.Question;
import project.onlinecompiler.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public Question save(Question question) {
		try {
			return questionRepository.save(question);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Question get(Integer id) {
		try {
			return questionRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Question> get(){
		try {
			return questionRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
