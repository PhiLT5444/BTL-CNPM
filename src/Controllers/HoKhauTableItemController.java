package Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.HoKhau;
import Models.Model;
import Models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HoKhauTableItemController implements Initializable{

    @FXML
    private Button delButton;

    @FXML
    private Text diaChi;

    @FXML
    private Button editButton;

    @FXML
    private Text hoTen;

    @FXML
    private Text maHoKhau;

    @FXML
    private Text soThanhVien;
    
    Integer IdNhanKhau;
    String ngaySinh;
    String cccd;
    String sdt;
    
    
    String query = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    
    public void setData(Integer maHo, String hoten, Integer sotv, String diachi, Integer idnk, String ns, String cc, String pn) {
    	  maHoKhau.setText(maHo.toString());
    	  hoTen.setText(hoten);
    	  soThanhVien.setText(sotv.toString());
    	  diaChi.setText(diachi);
    	  IdNhanKhau = idnk;
    	  ngaySinh = ns;
    	  cccd = cc;
    	  sdt = pn;
    }
    
    public void edit() {
    	try {
    		Stage stage = (Stage)delButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
    	    // Tạo một FXML Loader và thiết lập địa chỉ tệp FXML
    	    FXMLLoader loader = new FXMLLoader();
    	    loader.setLocation(getClass().getResource("/resources/Fxml/SuaHoKhau.fxml"));

    	    // Load FXML file để có thể lấy controller và giao diện người dùng
    	    Parent root = loader.load();

    	    // Lấy controller từ FXML file
    	    SuaHoKhauController shc = loader.getController();

    	    // Thiết lập các giá trị trong controller
    	    shc.setTextField(
    	        Integer.parseInt(maHoKhau.getText()),
    	        Integer.parseInt(soThanhVien.getText()),
    	        diaChi.getText(),
    	        IdNhanKhau,
    	        hoTen.getText(),
    	        ngaySinh,
    	        cccd,
    	        sdt
    	    );

    	    // Hiển thị giao diện
    	    Stage primaryStage = new Stage(); // Tạo một cửa sổ mới
    	    Scene scene = new Scene(root); // Tạo một Scene từ FXML

    	    primaryStage.setScene(scene); // Thiết lập Scene cho cửa sổ chính
    	    primaryStage.show(); // Hiển thị cửa sổ
    	} catch (IOException e) {
    	    e.printStackTrace();
    	}

    	
    }
    
    public void delete() {
    	String maHoKhauValue = maHoKhau.getText(); // Lấy giá trị từ TextField maHoKhau

    	if (!maHoKhauValue.isEmpty()) { // Kiểm tra xem giá trị có tồn tại hay không
    	    try {
    	        int maHoKhauInt = Integer.parseInt(maHoKhauValue); // Chuyển đổi giá trị thành số nguyên
    	        Connection connection = DBConnect.getConnection(); // Lấy kết nối đến cơ sở dữ liệu

    	        // Xóa dữ liệu từ bảng CHUHO dựa trên maHoKhau
    	        String deleteChuHoQuery = "DELETE FROM CHUHO WHERE maHoKhau = ?";
    	        try (PreparedStatement deleteChuHoStatement = connection.prepareStatement(deleteChuHoQuery)) {
    	            deleteChuHoStatement.setInt(1, maHoKhauInt);
    	            deleteChuHoStatement.executeUpdate();
    	        }

    	        // Xóa dữ liệu từ bảng NHANKHAU dựa trên maNhanKhau trong CHUHO
    	        String deleteNhanKhauQuery = "DELETE FROM NHANKHAU WHERE maNhanKhau = ?";
    	        try (PreparedStatement deleteNhanKhauStatement = connection.prepareStatement(deleteNhanKhauQuery)) {
    	            deleteNhanKhauStatement.setInt(1, IdNhanKhau);
    	            deleteNhanKhauStatement.executeUpdate();
    	        }

    	        // Xóa dữ liệu từ bảng HOKHAU dựa trên maHoKhau
    	        String deleteHoKhauQuery = "DELETE FROM HOKHAU WHERE maHoKhau = ?";
    	        try (PreparedStatement deleteHoKhauStatement = connection.prepareStatement(deleteHoKhauQuery)) {
    	            deleteHoKhauStatement.setInt(1, maHoKhauInt);
    	            deleteHoKhauStatement.executeUpdate();
    	        }
    	    } catch (SQLException | NumberFormatException e) {
    	        e.printStackTrace(); // Xử lý ngoại lệ
    	    }
    	} else {
    	    // Thông báo cho người dùng về dữ liệu không hợp lệ (nếu cần)
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		delButton.setOnAction(e->{
			delete();	
			Stage stage = (Stage)delButton.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showHoKhau();
		});
		editButton.setOnAction(e->{
			edit();
		});
	}

}
