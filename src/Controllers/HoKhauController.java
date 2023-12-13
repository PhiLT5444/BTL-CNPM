

package Controllers;

import Models.HoKhau;
import Models.Model;
import Models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.DBConnect;

public class HoKhauController implements Initializable{
	
	@FXML
    private ImageView backIcon;

    @FXML
    private VBox hoKhauLayout;

    @FXML
    private Button addButton;

    @FXML
    private TextField searchTextField;
    
    @FXML
    private Button updateButton;
    
    Connection connection = null;
    String query = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public void refresh() {
    	hoKhauLayout.getChildren().clear();
    	try {
			query = "SELECT HOKHAU.*, NhanKhau.* FROM HOKHAU, NHANKHAU, CHUHO WHERE CHUHO.maNhanKhau = NHANKHAU.maNhanKhau AND CHUHO.maHoKhau = HOKHAU.maHoKhau";
			connection = DBConnect.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery(query);
			while(resultSet.next()) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/resources/Fxml/HoKhauTableItem.fxml"));
				try {
					HBox hBox = loader.load();
					HoKhauTableItemController hic = loader.getController();
					hic.setData(resultSet.getInt("maHoKhau"), resultSet.getString("hoTen"), resultSet.getInt("soThanhVien"), 
								resultSet.getString("diaChi"), resultSet.getInt("maNhanKhau"), 
								resultSet.getString("ngaysinh"), resultSet.getString("soCMND"), resultSet.getString("SDT"));
					hoKhauLayout.getChildren().add(hBox);
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
    
    public void showAddView() {
		Stage stage = (Stage)addButton.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
 	    Model.getInstance().getViewFactory().showAddHoKhau();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		refresh();
		updateButton.setOnAction(e->{
			refresh();
		});
		addButton.setOnAction(e->{
			showAddView();
		});
		backIcon.setOnMouseClicked(e->{
			Stage stage = (Stage)backIcon.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	 	    Model.getInstance().getViewFactory().showHome();
		});
		searchTextField.setOnAction(e->{
			String inputText = searchTextField.getText();
			if(!inputText.isEmpty()) {
				try {
					query = "SELECT HOKHAU.*, NhanKhau.* FROM HOKHAU, NHANKHAU, CHUHO WHERE CHUHO.maNhanKhau = NHANKHAU.maNhanKhau AND CHUHO.maHoKhau = HOKHAU.maHoKhau";
					connection = DBConnect.getConnection();
					preparedStatement = connection.prepareStatement(query);
					resultSet = preparedStatement.executeQuery(query);
					while(resultSet.next()) {
						if(inputText.equals(resultSet.getString("maHoKhau")) || inputText.equals(resultSet.getString("hoTen"))) {
							System.out.println(resultSet.getString("maHoKhau") + " " + resultSet.getString("hoTen") + " " + resultSet.getString("soThanhVien"));
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	
}