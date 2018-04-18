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
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {
	
	private JFrame jFrame;
	private JPanel controlPanel;
	private JLabel labelQuestion,labelResponse;
	private JTextField textQuestion;
	private JButton 
	
	
    public void setupUI() {
    	jFrame = new JFrame("Spring JFrame");
    	jFrame.setLayout(new FlowLayout());
    	
    	
    	controlPanel = new JPanel();
    controlPanel.setLayout(new GridLayout(2, 2));

	label1 = new JLabel("User Name : ");
	userName = new JTextField(15);
	userName.setDragEnabled(true);
	
	label2 = new JLabel("Password : ");
	userPass = new JPasswordField(15);

	btnAddUser = new JButton();
	btnAddUser.setText("Add user");
	btnAddUser.setTransferHandler(new TransferHandler("text"));
	btnAddUser.addActionListener(eventHandler::whenButtonClicked);
	
	

	
	controlPanel.add(label1);
	controlPanel.add(userName);
	controlPanel.add(label2);
	controlPanel.add(userPass);
	controlPanel.add(btnAddUser);
	controlPanel.add(jlist);

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
}
