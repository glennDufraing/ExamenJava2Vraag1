package edu.ap.spring.view;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;
import edu.ap.spring.model.EightBall;

@Service
public class EventHandler {

	private QuestionRepository repos;
	private EightBall eightball;
	private UI ui;
	
	
	@Autowired
	public void setRepos(QuestionRepository repos) {
		this.repos = repos;
	}


	@Autowired
	public void setUi(UI ui) {
		this.ui = ui;
	}


	@Autowired
	public void setEightball(EightBall eightball) {
		this.eightball = eightball;
	}


	public void whenAddButtonClicked(ActionEvent ae) {
		String question = ui.getTextQuestion().getText();
		String answer = eightball.getRandomAnswer(question);
		
		ui.getLabelResponse().setText(answer);
		
	}
}
