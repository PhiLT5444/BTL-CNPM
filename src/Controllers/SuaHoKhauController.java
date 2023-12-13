package Controllers;

import Database.DBConnect;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Models.HoKhau;
import Models.Model;

public class SuaHoKhauController implements Initializable{

	
	@FXML
    private TextField cccdText;

    @FXML
    private TextField diaChiText;

    @FXML
    private Button editButton;

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
	 
	 
	 String query = null;
	 Connection connection = null;
	 ResultSet resultSet = null;
	 PreparedStatement preparedStatement;
	 HoKhau hoKhau = null;
	 Integer hoKhauId;
	 Integer nhanKhauId;
	 
	 public void Edit(int ID, int nhanKhauID) {
		 
		 try {
			connection = DBConnect.getConnection();
			query = "UPDATE HOKHAU SET sothanhvien = ?, diachi = ? WHERE mahokhau = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(soThanhVienText.getText())); // Sử dụng setString để tránh lỗi SQL injection
		    preparedStatement.setString(2, diaChiText.getText()); // Sử dụng setString để tránh lỗi SQL injection
		    preparedStatement.setInt(3, ID); // Giả sử ID là một số nguyên
			preparedStatement.executeUpdate();
			
			String nhanKhauQuery = "UPDATE NHANKHAU SET hoTen = ?, ngaysinh = ?, socmnd = ?, SDT = ? WHERE manhankhau = ?";
			preparedStatement = connection.prepareStatement(nhanKhauQuery);
			preparedStatement.setString(1, hoVaTenText.getText());
			preparedStatement.setString(2, tuoiText.getText());
			preparedStatement.setString(3, cccdText.getText());
			preparedStatement.setString(4, sdtText.getText());
			preparedStatement.setInt(5, nhanKhauID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void setTextField(Integer ID, Integer number, String add, Integer IdNhanKhau, String hoTen, String ngaySinh, String cccd, String sdt) {
		 hoKhauId = ID;
		 nhanKhauId = IdNhanKhau;
		 maHoKhauText.setText(ID.toString());
		 soThanhVienText.setText(number.toString());
		 diaChiText.setText(add);
		 maNhanKhauText.setText(IdNhanKhau.toString());
		 hoVaTenText.setText(hoTen);
		 tuoiText.setText(ngaySinh);
		 cccdText.setText(cccd);
		 sdtText.setText(sdt);
	 }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		editButton.setOnAction(e->{
			Edit(hoKhauId, nhanKhauId);
			Stage stage = (Stage)editButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	        Model.getInstance().getViewFactory().showHoKhau();
		});	
	}
	
}