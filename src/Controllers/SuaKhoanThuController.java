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

public class SuaKhoanThuController implements Initializable{

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
    
    @FXML 
    private Button doneButton;
    
    public Boolean check() {
    	if(checkBox1.isSelected()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    String makt, tenkt, sotn, loaikt;
 
    public void setData(String mkt, String tkt, String stn, String lkt) {
    	makt = mkt;
    	tenkt = tkt;
    	sotn = stn;
    	loaikt = lkt;
    	    	
    	maKhoanThuText.setText(mkt);
    	tenKhoanThuText.setText(tkt);
    	soTienNopText.setText(stn);
    	if(lkt == "Bắt buộc") {
    		checkBox1.setSelected(true);
    	}else {
    		checkBox2.setSelected(false);
    	}
    }
    
    public void done() {
    	String query = "UPDATE KHoanthu SET makhoanthu = ?, soTienNop = ?, tenKHoanThu = ?, loaiKHoanThu = ? where makhoanthu = " + makt;
    	Connection connection = DBConnect.getConnection();
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(maKhoanThuText.getText()));
			preparedStatement.setDouble(2, Double.parseDouble(soTienNopText.getText()));
			preparedStatement.setString(3, tenKhoanThuText.getText());
			preparedStatement.setBoolean(4, check());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkBox1.setOnAction(event -> {
            if (checkBox1.isSelected()) {
                checkBox2.setSelected(false);
            }
        });

        checkBox2.setOnAction(event -> {
            if (checkBox2.isSelected()) {
                checkBox1.setSelected(false);
            }
        });
        
        doneButton.setOnAction(e->{
        	done();
        	 Stage stage = (Stage)doneButton.getScene().getWindow();
	         Model.getInstance().getViewFactory().closeStage(stage);
	    	 Model.getInstance().getViewFactory().showKhoanThu();
        });
	}

}
