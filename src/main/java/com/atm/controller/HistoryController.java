package com.atm.controller;

import com.atm.model.Account;
import com.atm.util.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class HistoryController {

    @FXML
    private TextArea historyArea;

    @FXML
    public void initialize() {

        Account account = Session.getCurrentAccount();

        StringBuilder history = new StringBuilder();

        for (String transaction : account.getTransactionHistory()) {

            history.append(transaction).append("\n");
        }

        historyArea.setText(history.toString());
    }

    @FXML
    public void handleBack(ActionEvent event) throws Exception {

        FXMLLoader loader =
                new FXMLLoader(getClass().getResource("/dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        Stage stage =
                (Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(scene);
        stage.show();
    }
}