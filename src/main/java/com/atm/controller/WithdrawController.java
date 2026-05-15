package com.atm.controller;

import com.atm.model.Account;
import com.atm.model.Withdrawal;
import com.atm.util.Session;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class WithdrawController {

    @FXML
    private TextField amountField;

    @FXML
    private Label messageLabel;

    @FXML
    public void handleWithdraw() {

        try {

            double amount =
                    Double.parseDouble(amountField.getText());

            Account account =
                    Session.getCurrentAccount();

            Withdrawal withdrawal =
                    new Withdrawal(account, null, amount);

            double oldBalance = account.getBalance();

            withdrawal.execute();

            if (account.getBalance() < oldBalance) {

                messageLabel.setText(
                        "Withdrawal successful."
                );

            } else {

                messageLabel.setText(
                        "Insufficient funds."
                );
            }

        } catch (Exception e) {

            messageLabel.setText(
                    "Enter a valid amount."
            );
        }
    }

    @FXML
    public void handleBack(ActionEvent event)
            throws Exception {

        FXMLLoader loader =
                new FXMLLoader(getClass()
                        .getResource("/dashboard.fxml"));

        Scene scene =
                new Scene(loader.load());

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
        stage.show();
    }
}