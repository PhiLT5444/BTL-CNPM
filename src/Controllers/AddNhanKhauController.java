package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNhanKhauController implements Initializable{

	
	@FXML
    private TextField CCCDText;

    @FXML
    private TextField SDTText;

    @FXML
    private TextField diaChiText;

    @FXML
    private TextField hoVaTenText;

    @FXML
    private TextField maNhanKhauText;

    @FXML
    private TextField ngaySinhText;
    
    @FXML 
    private Button addButton;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    NhanKhau nhanKhau = null;
    
    
	public void add() {
		try {
    		query = "INSERT INTO `NhanKhau` (maNhanKhau, hoTen, ngaySinh, soCMND, SDT) VALUES (?, ?, ?, ?, ?)";
    		connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(maNhanKhauText.getText()));
			preparedStatement.setString(2, hoVaTenText.getText());
			preparedStatement.setString(3, ngaySinhText.getText());
			preparedStatement.setString(4, CCCDText.getText());
			preparedStatement.setString(5, SDTText.getText());
			preparedStatement.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		addButton.setOnAction(e->add());
	}
	
}