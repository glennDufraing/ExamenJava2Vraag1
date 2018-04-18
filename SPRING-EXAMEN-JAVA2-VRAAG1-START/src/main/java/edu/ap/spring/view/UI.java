package edu.ap.spring.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	
	EventHandler eventHandler;
	
	@Autowired
	public void setEventHandler(EventHandler eventHandler) {
		this.eventHandler = eventHandler;
	}


	private JFrame jFrame;
	private JPanel controlPanel;
	private JLabel labelQuestion,labelResponse;
	private JTextField textQuestion;
	private JButton btnAdd;
	
	
    public void setupUI() {
    jFrame = new JFrame("Spring JFrame");
    jFrame.setLayout(new FlowLayout());
    	
    	
    controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(2, 2));

	labelQuestion = new JLabel("Question");
	textQuestion = new JTextField(30);
	
	
	labelResponse = new JLabel("");
	

	btnAdd = new JButton();
	btnAdd.setText("Ask Question");
	btnAdd.setTransferHandler(new TransferHandler("text"));
	btnAdd.addActionListener(eventHandler::whenAddButtonClicked);
	
	
	

	
	controlPanel.add(labelQuestion);
	controlPanel.add(textQuestion);
	controlPanel.add(labelResponse);
	controlPanel.add(btnAdd);
	

	jFrame.add(controlPanel);
	        
	jFrame.setSize(400, 400);
	jFrame.setLocationRelativeTo(null);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	jFrame.pack();
	jFrame.setVisible(true);
}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}


	public JFrame getjFrame() {
		return jFrame;
	}


	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}


	public JPanel getControlPanel() {
		return controlPanel;
	}


	public void setControlPanel(JPanel controlPanel) {
		this.controlPanel = controlPanel;
	}


	public JLabel getLabelQuestion() {
		return labelQuestion;
	}


	public void setLabelQuestion(JLabel labelQuestion) {
		this.labelQuestion = labelQuestion;
	}


	public JLabel getLabelResponse() {
		return labelResponse;
	}


	public void setLabelResponse(JLabel labelResponse) {
		this.labelResponse = labelResponse;
	}


	public JTextField getTextQuestion() {
		return textQuestion;
	}


	public void setTextQuestion(JTextField textQuestion) {
		this.textQuestion = textQuestion;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}


	public EventHandler getEventHandler() {
		return eventHandler;
	}
	
}
