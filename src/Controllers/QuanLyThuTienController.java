package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class QuanLyThuTienController implements Initializable{

    @FXML
    private Button addButton;

    @FXML
    private ImageView backIcon;

    @FXML
    private VBox layout;

    @FXML
    private ImageView menuButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button updateButton;
    
    public void refersh() {
    	layout.getChildren().clear();
    	Connection connection = DBConnect.getConnection();
    	String query = "Select NhanKhau.hoTen, noptien.ngaythu, KhoanThu.tenKhoanThu, nopTien.makhoanthu, noptien.manhankhau\r\n"
    			+ "From nhankhau, noptien, khoanthu\r\n"
    			+ "Where nhankhau.maNhanKhau = noptien.maNhanKhau and\r\n"
    			+ "	  khoanthu.maKhoanthu = noptien.maKhoanthu";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/resources/Fxml/QuanLyThuTienItem.fxml"));
				try {
					HBox Hbox = loader.load();
					QuanLyThuTienItemController qlttic = loader.getController();
					qlttic.setData(resultSet.getString("tenKhoanThu"), resultSet.getString("hoTen"), resultSet.getString("ngaythu"), 
							       resultSet.getInt("maKhoanThu"), resultSet.getInt("maNhanKhau"));
					layout.getChildren().add(Hbox);
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
    
    public void add() {
    	Stage stage = (Stage)addButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    	Model.getInstance().getViewFactory().showThemThuTien();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		refersh();
		addButton.setOnAction(e->{
			add();
		});
		backIcon.setOnMouseClicked(e->{
			Stage stage = (Stage)backIcon.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showHome();
		});
	}

}
