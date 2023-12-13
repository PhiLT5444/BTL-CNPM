package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ThemKhoanThuController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private TextField maKhoanThuText;

    @FXML
    private TextField soTienNopText;

    @FXML
    private TextField tenKhoanThuText;
    
    public Boolean check() {
    	if(checkBox1.isSelected()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public void add() {
    	Connection connection = DBConnect.getConnection();
    	String query = "Insert Into KhoanThu (maKhoanthu, tenKhoanThu, soTienNop, loaiKhoanThu) Values (?,?,?,?)";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(maKhoanThuText.getText()));
			preparedStatement.setString(2, tenKhoanThuText.getText());
			preparedStatement.setDouble(3, Double.parseDouble(soTienNopText.getText()));
			preparedStatement.setBoolean(4, check());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		addButton.setOnAction(e -> {
			add();
			Stage stage = (Stage)addButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showKhoanThu();
		});
	}

}
