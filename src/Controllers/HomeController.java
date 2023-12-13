package Controllers;

import Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HomeController implements Initializable{

	@FXML 
	private Hyperlink logOut;
	
	@FXML
	private VBox hoKhauIcon;

	@FXML
	private VBox khoanThuIcon;

	@FXML
	private VBox nhanKhauIcon;

	@FXML
	private VBox qltpIcon;

	@FXML
	private VBox thongKeIcon;
	
	
	@Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
	       logOut.setOnAction(e->{
	    	   Stage stage = (Stage)logOut.getScene().getWindow();
	           Model.getInstance().getViewFactory().closeStage(stage);
	    	   Model.getInstance().getViewFactory().showLogin();
	       });
	       hoKhauIcon.setOnMouseClicked(e->{
	    	   Stage stage = (Stage)logOut.getScene().getWindow();
	           Model.getInstance().getViewFactory().closeStage(stage);
	    	   Model.getInstance().getViewFactory().showHoKhau();
	       });
	       nhanKhauIcon.setOnMouseClicked(e->{
	    	   Stage stage = (Stage)logOut.getScene().getWindow();
	           Model.getInstance().getViewFactory().closeStage(stage);
	    	   Model.getInstance().getViewFactory().showNhanKhau();
	       });
	       khoanThuIcon.setOnMouseClicked(e->{
	    	   Stage stage = (Stage)logOut.getScene().getWindow();
	           Model.getInstance().getViewFactory().closeStage(stage);
	    	   Model.getInstance().getViewFactory().showKhoanThu();
	       });
	       qltpIcon.setOnMouseClicked(e->{
	    	   Stage stage = (Stage)logOut.getScene().getWindow();
	           Model.getInstance().getViewFactory().closeStage(stage);
	    	   Model.getInstance().getViewFactory().showQuanLyThuTien();
	       });
	 }
}