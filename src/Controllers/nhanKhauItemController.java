package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class nhanKhauItemController implements Initializable {

    @FXML
    private Text cccdText;

    @FXML
    private Button delButton;

    @FXML
    private Button editButton;

    @FXML
    private Text hoTenText;

    @FXML
    private Text maNhanKhauText;

    @FXML
    private Text ngaySinhText;

    @FXML
    private Text sdtText;
    
    public void setDataText(Integer mank, String hovaten, String cccd, String ngaySing, String sdt) {
    	maNhanKhauText.setText(mank.toString());
    	hoTenText.setText(hovaten);
    	cccdText.setText(cccd);
    	ngaySinhText.setText(ngaySing);
    	sdtText.setText(sdt);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
