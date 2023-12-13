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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
	@FXML private Button loginButton;
	@FXML private TextField userName;
	@FXML private PasswordField passWord;
	
	
	@Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {
	       loginButton.setOnAction(e->{
	    	   if(userName.getText().equals("PhiLT") && passWord.getCharacters().toString().equals("admin")) {
	    		   Stage stage = (Stage)loginButton.getScene().getWindow();
		           Model.getInstance().getViewFactory().closeStage(stage);
		    	   Model.getInstance().getViewFactory().showHome();
	    	   }else{
	    		// Tạo một cửa sổ thông báo kiểu ERROR
	    	        Alert alert = new Alert(AlertType.ERROR);
	    	        alert.setTitle("Lỗi Đăng Nhập");
	    	        alert.setHeaderText("Thông tin tài khoản không hợp lệ");
	    	        alert.setContentText("Vui lòng kiểm tra lại tên người dùng và mật khẩu.");

	    	        // Hiển thị cửa sổ thông báo
	    	        alert.showAndWait();
	    	        System.out.println(passWord.getCharacters().toString());
	    	   }
	       });
	 }
}