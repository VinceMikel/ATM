package com.atm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.atm.model.Account;
import com.atm.util.Session;
import com.atm.model.Account;
import com.atm.model.BalanceInquiry;
import com.atm.util.Session;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import com.atm.util.ThemeManager;

public class DashboardController {

    @FXML
    private Label messageLabel;

    @FXML
    public void handleBalance() {

        Account account = Session.getCurrentAccount();

        BalanceInquiry inquiry =
                new BalanceInquiry(account, null);

        inquiry.execute();

        messageLabel.setText(
                "Balance: $" + account.getBalance()
        );
    }

    @FXML
    public void handleWithdraw(ActionEvent event)
            throws Exception {

        FXMLLoader loader =
                new FXMLLoader(getClass()
                        .getResource("/withdraw.fxml"));

        Scene scene =
                new Scene(loader.load());

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleDeposit() {

        messageLabel.setText("Deposit button clicked");
    }

    @FXML
    public void handleLogout() {

        messageLabel.setText("Logout button clicked");
    }

    @FXML
    public void handleHistory(ActionEvent event) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/history.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void handleDarkMode(ActionEvent event) {

        ThemeManager.toggleDarkMode();

        Scene scene =
                ((Node) event.getSource())
                        .getScene();

        scene.getStylesheets().clear();

        if (ThemeManager.isDarkMode()) {

            scene.getStylesheets().add(
                    getClass().getResource("/dark-theme.css")
                            .toExternalForm()
            );
        }
    }
}