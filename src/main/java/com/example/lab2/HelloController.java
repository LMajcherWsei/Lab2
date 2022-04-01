package com.example.lab2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField text1;
    Integer cnt = 0;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void OnAction(ActionEvent actionEvent) {
        System.out.printf("Klawisz kliknięty!");
        text1.setText("Klawisz kliknięty po raz: " + ++cnt);
    }
}