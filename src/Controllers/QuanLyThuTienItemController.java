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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuanLyThuTienItemController implements Initializable{

    @FXML
    private Button delButton;

    @FXML
    private Button editButton;

    @FXML
    private Text ngayThuText;

    @FXML
    private Text tenKhoanThuText;

    @FXML
    private Text tenNguoiNopText;
    
    Integer makhoanthu;
    Integer manhankhau;
    
    public void setData(String tkt, String tnn, String tnt, int makt, int mank) {
    	tenKhoanThuText.setText(tkt);
    	tenNguoiNopText.setText(tnn);
    	ngayThuText.setText(tnt);
    	makhoanthu = makt;
    	manhankhau = mank;
    }
    
    public void delete() {
    	String query = "DELETE FROM noptien\r\n"
    			+ "WHERE maKhoanThu = " + makhoanthu
    			+ "  AND maNhanKhau = " + manhankhau;
    	Connection connection = DBConnect.getConnection();
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		delButton.setOnAction(e->{
			delete();
			Stage stage = (Stage)delButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showQuanLyThuTien();
		});
		
	}

}
