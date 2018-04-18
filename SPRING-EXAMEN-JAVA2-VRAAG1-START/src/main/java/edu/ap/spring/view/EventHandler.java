package edu.ap.spring.view;

import java.awt.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ap.spring.model.EightBall;

@Service
public class EventHandler {

	private EightBall eightball;
	
	@Autowired
	public void setEightball(EightBall eightball) {
		this.eightball = eightball;
	}


	public void whenAddButtonClicked(ActionEvent ae) {
		eightball.getRandomAnswer("test");
	}
}
