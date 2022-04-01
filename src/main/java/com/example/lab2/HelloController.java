package com.example.lab2;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;

public class HelloController {

    public TextField textPromien;
    public TextField textWysokosc;
    public TextField textGrubosc;
    public Button buttonWynik;
    public TextField textWynik;
    public MenuButton menuButton;
    public TextField textWynikCaly;

    DecimalFormat df = new DecimalFormat("###.##");
    Double gestoscBlachy = 0.00;
    Double kosztBlachy = 0.00;

    public void wybierzBlacha(ActionEvent actionEvent) {
        gestoscBlachy = 7850.00;
        kosztBlachy = 14.71;
        menuButton.setText("Blacha stalowa");
    }

    public void wybierzNierdzewna(ActionEvent actionEvent) {
        gestoscBlachy =  7900.00;
        kosztBlachy = 18.00;
        menuButton.setText("Blacha stalowa nierdzewna");
    }

    public void Wynik(ActionEvent actionEvent) {
        //textWynik.setText(Math.PI * toDouble(textPromien) * toDouble(textWysokosc) );
        double poleBoku;
        double objBokuWalca;
        double poleCalkowite;
        double polePodstawy;
        double objPodstawyWalca;

        // Test czy tekst jest liczba
        if (isNumeric(textGrubosc.getText()) && isNumeric(textWysokosc.getText()) && isNumeric(textPromien.getText())){
            poleBoku = 2 * Math.PI * Double.parseDouble(textWysokosc.getText()) * Double.parseDouble(textPromien.getText());
            objBokuWalca = poleBoku * Double.parseDouble(textGrubosc.getText());

            polePodstawy = Math.PI * Double.parseDouble(textPromien.getText()) * Double.parseDouble(textPromien.getText());
            poleCalkowite = poleBoku + (2 * polePodstawy);
            objPodstawyWalca = polePodstawy * Double.parseDouble(textGrubosc.getText());

            Double koszt = kosztBlachy * poleBoku;
            Double waga = objBokuWalca * gestoscBlachy;

            Double kosztCaly= kosztBlachy * poleCalkowite;
            Double wagaCala = (objPodstawyWalca * gestoscBlachy) + waga;

            // Obliczenie tylko blachy na boku walca
            textWynik.setText("Koszt materiału boku walca: " + df.format(koszt) + " PLN. Ciężar materiału boku walca: " + df.format(waga) + "Kg.");
            // Obliczenie blachy na całym walcu
            textWynikCaly.setText("Koszt materiału całego walca: " + df.format(kosztCaly) + " PLN. Ciężar materiału całego walca: " + df.format(wagaCala) + "Kg.");
        }
    }

    public boolean isNumeric(String string) {
        double doubleValue;
        if(string == null || string.equals("")) {
            textWynik.setText("Nie podano wszystkich danych. Sprawdź wprowadzone dane.");
            return false;
        }
        try {
            doubleValue = Double.parseDouble(string);
            return true;
        }
        catch(NumberFormatException e){
            textWynik.setText("Nie podano liczby. Sprawdź wprowadzone dane.");
        }
        return false;
    }
}