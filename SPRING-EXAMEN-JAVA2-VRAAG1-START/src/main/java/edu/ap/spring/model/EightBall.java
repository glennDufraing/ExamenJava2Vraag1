package edu.ap.spring.model;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.QuestionRepository;

@Component
public class EightBall {
	private QuestionRepository repos;
	
	
	@Autowired
	public void setRepos(QuestionRepository repos) {
		this.repos = repos;
	}

	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	private String[]overschot =answers;
	public String getRandomAnswer(String question) {
		String answer = "";

		Random rand = new Random();

		if(repos.findByQuestion(question) != null) {
			if(overschot.length>1) {
				
			}
		}
		else{
			answer = repos.findByQuestion(question).getAnswer();
		}
		int  n = rand.nextInt(answers.length); 
		
		System.out.println("nog over:"+ overschot.length);
		 
		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
}
