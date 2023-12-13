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

public class KhoanThuController implements Initializable{

    @FXML
    private Button addButton;

    @FXML
    private ImageView backIcon;

    @FXML
    private ImageView menuButton;

    @FXML
    private VBox khoanThuLayout;

    @FXML
    private TextField searchTextField;
    
    
    
    public void refresh() {	
    	khoanThuLayout.getChildren().clear();
    	try {
    		String query = "Select * from KhoanThu";
        	Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery(query);
			while(resultSet.next()) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("/resources/Fxml/KhoanThuItem.fxml"));
				try {
					HBox hb = loader.load();
					KhoanThuItemController ktc = loader.getController();
					ktc.setData(resultSet.getInt("makhoanthu"), resultSet.getBoolean("loaikhoanthu"), resultSet.getDouble("sotiennop"), resultSet.getString("tenkhoanthu"));
					khoanThuLayout.getChildren().add(hb);
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		refresh();
		backIcon.setOnMouseClicked(e->{
			Stage stage = (Stage)backIcon.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showHome();
		});
		addButton.setOnAction(e->{
			Stage stage = (Stage)addButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showThemKhoanThu();
		});
	}

}
