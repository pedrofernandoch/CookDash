package gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.SQLiteConnection;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class MainViewController {

	@FXML
	private Button findRecipes;

	@FXML
	public void onFindRecipesAction() {
		Alerts.showAlert("Alert title", "Alert header", "Alert content", AlertType.INFORMATION);
	}

	@FXML
	private Button showRecipes;

	@FXML
	public void onShowRecipesAction() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = SQLiteConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM recipes");

			while (rs.next()) {
				System.out.println(rs.getString("name") + ", " + rs.getString("directions"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
