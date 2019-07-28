package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TextArea;

import javafx.scene.layout.VBox;

public class OthersController {
	@FXML
	private VBox otherslayout;
	@FXML
	private TextArea skillsTA;
	@FXML
	private TextArea interestsTA;
	@FXML
	private Label warningLabel;
	@FXML
	private Button back;
	@FXML
	private Button cancel;
	@FXML
	private Button generateCV;

	// Event Listener on Button[#back].onAction
	@FXML
	public void othersBackBtnController(ActionEvent event) throws IOException {
		System.out.println("others back btn pressed");
		goToWork();
	}

	// Event Listener on Button[#cancel].onAction
	@FXML
	public void othersCancelBtnController(ActionEvent event) {
		System.out.println("Cancel btn pressed");
		exit();
	}

	// Event Listener on Button[#generateCV].onAction
	@FXML
	public void othersGenerateCvBtnController(ActionEvent event) {
		// TODO Autogenerated
	}

	public void exit() {
		Platform.exit();
		System.exit(0);
	}

	public void goToWork() throws IOException {
		VBox pane = FXMLLoader.load(getClass().getResource("../view/Work.fxml"));
		otherslayout.getChildren().setAll(pane);
	}

	public void fieldValidation() {
		skillsTAFieldValidation();
		interestsTAFieldValidation();
	}

	public boolean skillsTAFieldValidation() {
		if (skillsTA.getText() == "null" || skillsTA.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, skills null");
			return false;
		}

		else {
			System.out.println(skillsTA.getText());			
			return true;
		}

	}

	public boolean interestsTAFieldValidation() {
		if (interestsTA.getText() == "null" || interestsTA.getText().trim().isEmpty()) {
			warningLabel.setText("*Warning! All of the fields must be filled up");
			System.out.println("False, interests null");
			return false;
		}

		else {
			System.out.println(interestsTA.getText());			
			return true;
		}

	}
	
	//html tags as method
	public String h4(String info) {
		return "<h4>" + info + "</h4>" + "\n";
	}
	
	public String p(String info) {
		return "<p>" + info + "</p>" + "\n";
	}
	
	private String generateWorkHTML() {
		String title = "<h1><i>Others</i></h1> <br>" + "\n";
		String work1 = h4("Skills")
				+ p(skillsTA.getText());
		
		String work2 = h4("Interests")
				+ p(interestsTA.getText());
		
		String othersHTML = "<div class=\"workExperience\">" + "\n" + title + work1 + work2 + "</div>";
		return othersHTML;
	}
	
	
	
}
