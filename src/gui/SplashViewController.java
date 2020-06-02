package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SplashViewController implements Initializable {

	private static Scene mainScene;
	
	@FXML
	private StackPane rootPane;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		new SplashScreen().start();
	}

	class SplashScreen extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						ScrollPane root = null;
						try {
							root = FXMLLoader.load(getClass().getResource("/gui/MainView.fxml"));
							root.setFitToHeight(true);
							root.setFitToWidth(true);
						} catch (IOException e) {
							e.printStackTrace();
						}
						mainScene = new Scene(root);
						Stage stage = new Stage();
						stage.setScene(mainScene);
						stage.setTitle("Cook Dash");
						stage.show();

						rootPane.getScene().getWindow().hide();
					}
				});
			} catch (InterruptedException e) {
				Alerts.showAlert("InterruptedException", "Error loading view", e.getMessage(), AlertType.ERROR);
			}
		}

	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
}