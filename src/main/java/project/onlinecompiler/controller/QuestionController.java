package project.onlinecompiler.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project.onlinecompiler.dto.Question;
import project.onlinecompiler.dto.User;
import project.onlinecompiler.exceptions.ClassKeyWordMissingException;
import project.onlinecompiler.io.FileOperations;
import project.onlinecompiler.service.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Value("${filedirectories.location.testcasefile}")
	private String testCaseDirectoryLocation;

	@GetMapping("/trainer/question")
	public String questionPage(@RequestParam(required = false, name = "addStatus") String addStatus,
			@RequestParam(required = false, name = "badFile") String badFile, Model model) {
		if (!Boolean.valueOf(addStatus)) {
			model.addAttribute("errorMessage", "Some internalError Occured. Try again...!");
		}

		if (Boolean.valueOf(badFile)) {
			model.addAttribute("errorMessage", "Test Case file is added, due to improper java file");
		}

		model.addAttribute("question", new Question());
		return "addquestion";
	}

	@GetMapping("/question/{id}")
	public String getQestion(@PathVariable("id") Integer id, Model model) {
		if (id == null) {
			return "redirect:/qestions?search=" + false;
		} else {
			Question question = questionService.get(id);
			if (question != null) {
				model.addAttribute("question", question);
				return "question";
			} else {
				return "redirect:/questions?search=" + false;
			}
		}
	}

	@PostMapping("/trainer/question")
	public String addQuestion(@ModelAttribute("question") Question question, HttpSession session, Model model) {
		System.out.println(question);

		try {
			if (session.getAttribute("user") == null) {
				return "redirect:/login";
			}

			User user = (User) session.getAttribute("user");
			question.setUser(user);

			if (question.getTestCasesFile().isEmpty()) {
				question.setIsTestCasesAvailable(false);
			} else {
				question.setIsTestCasesAvailable(true);
			}
			if (questionService.save(question) != null) {

				if (question.getIsTestCasesAvailable()) {
					FileOperations fileOperations = new FileOperations(question.getTestCasesFile().getInputStream(),
							testCaseDirectoryLocation, String.valueOf(question.getId()), ".java");
					fileOperations.save();
					fileOperations.renameWithClassName();
				}
				return "redirect:/question/" + question.getId();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassKeyWordMissingException e) {
			e.printStackTrace();
			return "redirect:/trainer/question?badFile=" + true;
		}
		return "redirect:/trainer/question?addStatus=" + false;
	}

	@GetMapping("/questions")
	public String questions(@RequestParam(required = false, name = "search") String search, Model model) {
		if (!Boolean.valueOf(search)) {
			model.addAttribute("errorMessage", "Question is not existed");
		}
		model.addAttribute("questionList", questionService.get());
		return "questions";
	}

}
