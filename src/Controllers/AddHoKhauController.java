
package Controllers;

import Database.DBConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Models.ChuHo;
import Models.HoKhau;
import Models.Model;
import Models.NhanKhau;


public class AddHoKhauController implements Initializable {


    @FXML
    private Button add;

    @FXML
    private TextField cccdText;

    @FXML
    private Button clean;

    @FXML
    private TextField diaChiText;

    @FXML
    private TextField hoVaTenText;

    @FXML
    private TextField maHoKhauText;

    @FXML
    private TextField maNhanKhauText;

    @FXML
    private TextField sdtText;

    @FXML
    private TextField soThanhVienText;

    @FXML
    private TextField tuoiText;
    
    @FXML 
    private ImageView backIcon;
    

    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    HoKhau hoKhau = null;
    ChuHo chuHo = null;
    NhanKhau nhanKhau = null;
    int hoKhauId;
    
    
    public void add() {
    	try {
    	    Connection connection = DBConnect.getConnection();
    	    if (connection != null) {
    	        // Đoạn mã cho việc chèn dữ liệu vào bảng HOKHAU
    	        String insertHoKhauQuery = "INSERT INTO HOKHAU (maHoKhau, soThanhVien, diaChi) VALUES (?, ?, ?)";
    	        try (PreparedStatement hoKhauStatement = connection.prepareStatement(insertHoKhauQuery)) {
    	            hoKhauStatement.setInt(1, Integer.parseInt(maHoKhauText.getText()));
    	            hoKhauStatement.setInt(2, Integer.parseInt(soThanhVienText.getText()));
    	            hoKhauStatement.setString(3, diaChiText.getText());
    	            hoKhauStatement.executeUpdate();
    	        }

    	        // Đoạn mã cho việc chèn dữ liệu vào bảng NHANKHAU
    	        String insertNhanKhauQuery = "INSERT INTO NHANKHAU (maNhanKhau, hoTen, soCMND, ngaySinh, SDT) VALUES (?, ?, ?, ?, ?)";
    	        try (PreparedStatement nhanKhauStatement = connection.prepareStatement(insertNhanKhauQuery)) {
    	            nhanKhauStatement.setInt(1, Integer.parseInt(maNhanKhauText.getText()));
    	            nhanKhauStatement.setString(2, hoVaTenText.getText());
    	            nhanKhauStatement.setString(3, cccdText.getText());
    	            nhanKhauStatement.setString(4, tuoiText.getText());
    	            nhanKhauStatement.setString(5, sdtText.getText());
    	            nhanKhauStatement.executeUpdate();
    	        }
    	        
    	        String insertChuHoQuery = "INSERT INTO CHUHO (maHoKhau, maNhanKhau) VALUES (?, ?)";
    	        try (PreparedStatement chuHoStatement = connection.prepareStatement(insertChuHoQuery)) {
    	            chuHoStatement.setInt(1, Integer.parseInt(maHoKhauText.getText()));
    	            chuHoStatement.setInt(2, Integer.parseInt(maNhanKhauText.getText()));
    	            chuHoStatement.executeUpdate();
    	        }
    	    }
    	} catch (SQLException | NumberFormatException e) {
    	    e.printStackTrace();
    	}
    	
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	backIcon.setOnMouseClicked(e->{
    		Stage stage = (Stage)backIcon.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
     	    Model.getInstance().getViewFactory().showHoKhau();
    	});
    	add.setOnAction(e->{
    		add();
    	});
    	clean.setOnAction(e->{
    		Stage stage = (Stage)backIcon.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
     	    Model.getInstance().getViewFactory().showHoKhau();
    	});
    }

    

}
