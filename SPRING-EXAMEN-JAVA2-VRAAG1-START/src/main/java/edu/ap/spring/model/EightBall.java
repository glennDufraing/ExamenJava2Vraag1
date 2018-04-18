package edu.ap.spring.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Question;
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
	
	private List<String>overschot=new ArrayList<>();
	public String getRandomAnswer(String question) {
		
		
		
		String answer = "";

		Random rand = new Random();

		if(repos.findByQuestion(question) == null) {
			if(overschot.size()==0) {
				for(String items:answers) {
					overschot.add(items);
				}
			}
			int  n = rand.nextInt(overschot.size()); 
			
			answer = overschot.remove(n);
			
			repos.save(new Question(question,answer));

		}
		else{
			answer = repos.findByQuestion(question).getAnswer();
		}
		
		
		 
		return answer;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public List<String> getOverschot() {
		return overschot;
	}

	public void setOverschot(List<String> overschot) {
		this.overschot = overschot;
	}
	
}
