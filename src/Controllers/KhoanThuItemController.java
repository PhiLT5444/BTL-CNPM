package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KhoanThuItemController implements Initializable{

    @FXML
    private Button delButton;

    @FXML
    private Button detailButton;

    @FXML
    private Button editButton;

    @FXML
    private Text loaiKhoanThuText;

    @FXML
    private Text maKhoanThuText;

    @FXML
    private Text soTienNopText;

    @FXML
    private Text tenKhoanThuText;
    
    public void setData(Integer mkt, Boolean lkt, Double stn, String tkt) {
    	maKhoanThuText.setText(mkt.toString());
    	if(lkt == true) {
    		loaiKhoanThuText.setText("Phí bắt buộc");
    	}else {
    		loaiKhoanThuText.setText("Phí tự nguyện");
    	}
    	soTienNopText.setText(stn.toString());
    	tenKhoanThuText.setText(tkt);
    }

    public void delete() {
    	Connection connection = DBConnect.getConnection();
    	String query = "DELETE FROM KhoanThu WHERE maKhoanThu = " + maKhoanThuText.getText();
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void edit() {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/resources/Fxml/SuaKhoanThu.fxml"));
    	try {
			Parent root = loader.load();
			SuaKhoanThuController sktc = loader.getController();
			sktc.setData(maKhoanThuText.getText(), tenKhoanThuText.getText(), soTienNopText.getText(), loaiKhoanThuText.getText());
			Stage stage = (Stage)editButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
			Stage primaryStage = new Stage(); // Tạo một cửa sổ mới
    	    Scene scene = new Scene(root); // Tạo một Scene từ FXML
    	    primaryStage.setScene(scene); // Thiết lập Scene cho cửa sổ chính
    	    primaryStage.show(); // Hiển thị cửa sổ
		} catch (IOException e) {
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
	    	Model.getInstance().getViewFactory().showKhoanThu();
		});
		editButton.setOnAction(e->{
			edit();
		});
		detailButton.setOnAction(e->{
			
		});
	}

}
