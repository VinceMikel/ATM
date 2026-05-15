package com.atm.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import com.atm.database.BankDatabase;
import com.atm.model.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.atm.util.Session;

public class LoginController {

    @FXML
    private TextField accountField;

    @FXML
    private PasswordField pinField;

    @FXML
    private Label messageLabel;

    private BankDatabase bankDatabase = new BankDatabase();

    @FXML
    public void handleLogin(ActionEvent event) {

        try {

            int accountNumber =
                    Integer.parseInt(accountField.getText());

            int pin =
                    Integer.parseInt(pinField.getText());

            Account account =
                    bankDatabase.authenticateUser(accountNumber, pin);

            if (account != null) {

                Session.setCurrentAccount(account);

                FXMLLoader loader =
                        new FXMLLoader(getClass().getResource("/dashboard.fxml"));

                Scene dashboardScene =
                        new Scene(loader.load());

                Stage stage =
                        (Stage) ((Node) event.getSource())
                                .getScene()
                                .getWindow();

                stage.setScene(dashboardScene);
                stage.show();

            } else {

                messageLabel.setStyle("-fx-text-fill: red;");
                messageLabel.setText("Invalid credentials.");
            }

        } catch (Exception e) {

            messageLabel.setText("Enter valid numbers.");
        }
    }
}