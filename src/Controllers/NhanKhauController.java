package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.HoKhau;
import Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import Database.DBConnect;
import Models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class NhanKhauController implements Initializable{
	
	 @FXML
	 private ImageView backIcon;

	 @FXML
	 private ImageView menuButton;

	 @FXML
	 private VBox nhanKhauLayout;

	 @FXML
	 private TextField searchTextField;
	 
	 @FXML
	 private Button addButton;
	 
	 Connection connection = null;
	 PreparedStatement preparedStatement = null;
	 ResultSet resultSet = null;
	 
	 
	 public void refresh() {
		 nhanKhauLayout.getChildren().clear();
		 try {		 
			 connection = DBConnect.getConnection();
			 String query = "SELECT * FROM NHANKHAU";
			 preparedStatement = connection.prepareStatement(query);
			 resultSet = preparedStatement.executeQuery(query);
			 while(resultSet.next()) {
				 FXMLLoader loader = new FXMLLoader();
				 loader.setLocation(getClass().getResource("/resources/Fxml/nhanKhauItem.fxml"));				
				 try {
					 HBox hb = loader.load();
					 nhanKhauItemController nic = loader.getController();
					 nic.setDataText(resultSet.getInt("maNhanKhau"), resultSet.getString("hoTen"), resultSet.getString("soCMND"), resultSet.getString("ngaysinh"), resultSet.getString("SDT"));
					 nhanKhauLayout.getChildren().add(hb);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	 
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		refresh();
		backIcon.setOnMouseClicked(e->{
			Stage stage = (Stage)backIcon.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showHome();
		});
		addButton.setOnAction(e->{
			Stage stage = (Stage)addButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showAddNhanKhau();
		});
	}
}
