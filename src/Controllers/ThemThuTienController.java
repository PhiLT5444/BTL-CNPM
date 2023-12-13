package Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import Database.DBConnect;
import Models.KhoanThu;
import Models.Model;
import Models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ThemThuTienController implements Initializable {
	
	@FXML
    private Button add;

    @FXML
    private ImageView backIcon;

    @FXML
    private Button clean;

    @FXML
    private TableColumn<?, ?> hoTenCol;

    @FXML
    private TableView<KhoanThu> khoanThuTable;

    @FXML
    private TableColumn<KhoanThu, Boolean> loaiKhoanThuCol;

    @FXML
    private TableColumn<KhoanThu, Integer> maKhoanThuCol;

    @FXML
    private TableColumn<NhanKhau, Integer> maNhanKhauCol;

    @FXML
    private TableColumn<NhanKhau, String> ngaySinhCol;

    @FXML
    private DatePicker ngayThuText;

    @FXML
    private TableView<NhanKhau> nhanKhauTable;

    @FXML
    private TableColumn<NhanKhau, String> sdtCol;

    @FXML
    private TableColumn<NhanKhau, String> soCMNDCol;

    @FXML
    private TableColumn<KhoanThu, Double> soTienCol;

    @FXML
    private TableColumn<KhoanThu, String> tenKhoanThuCol;
    
    ObservableList<NhanKhau> NhanKhauList = FXCollections.observableArrayList();
    ObservableList<KhoanThu> KhoanThuList = FXCollections.observableArrayList();
    
    public void loadData() {
    	refersh();
    	maNhanKhauCol.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
    	hoTenCol.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
    	soCMNDCol.setCellValueFactory(new PropertyValueFactory<>("soCMND"));
    	ngaySinhCol.setCellValueFactory(new PropertyValueFactory<>("ngaySinh"));
    	sdtCol.setCellValueFactory(new PropertyValueFactory<>("SDT"));
    	nhanKhauTable.setItems(NhanKhauList);
    	
    	maKhoanThuCol.setCellValueFactory(new PropertyValueFactory<>("maKhoanThu"));
    	tenKhoanThuCol.setCellValueFactory(new PropertyValueFactory<>("tenKhoanThu"));
    	soTienCol.setCellValueFactory(new PropertyValueFactory<>("soTienNop"));
    	loaiKhoanThuCol.setCellValueFactory(new PropertyValueFactory<>("loaiKhoanThu"));
    	khoanThuTable.setItems(KhoanThuList);
    }
    
    public void refersh() {
    	NhanKhauList.clear();
    	KhoanThuList.clear();
    	
    	Connection connection = DBConnect.getConnection();
    	String query = "Select * From NhanKhau";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				NhanKhau nhanKhau = new NhanKhau(resultSet.getInt("maNhanKhau"), resultSet.getString("hoTen"), 
												 resultSet.getString("soCMND"), resultSet.getString("ngaySinh"), 
												 resultSet.getString("SDT"));
				NhanKhauList.add(nhanKhau);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	query = "select * from Khoanthu";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				KhoanThu khoanThu = new KhoanThu(resultSet.getInt("maKhoanThu"), resultSet.getString("tenKhoanThu"), 
										resultSet.getDouble("soTienNop"), resultSet.getBoolean("loaiKhoanThu"));
				KhoanThuList.add(khoanThu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void add() {
    	String query = "Insert Into Noptien (maKhoanThu, maNhanKhau, ngayThu) Values(?,?,?)";
    	Connection connection = DBConnect.getConnection();
    	
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			NhanKhau nhanKhau = nhanKhauTable.getSelectionModel().getSelectedItem();
			KhoanThu khoanThu = khoanThuTable.getSelectionModel().getSelectedItem();
			preparedStatement.setInt(2, nhanKhau.getMaNhanKhau());
			preparedStatement.setInt(1, khoanThu.getMaKhoanThu());
			 // Sử dụng getValue() để lấy giá trị ngày từ DatePicker
	        LocalDate ngayThu = ngayThuText.getValue();

	        // Chuyển đổi LocalDate sang chuỗi "yyyy-MM-dd" để lưu vào cơ sở dữ liệu
	        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String ngayThuNewFormat = ngayThu.format(newFormatter);

	        preparedStatement.setString(3, ngayThuNewFormat);
	        preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadData();
		add.setOnAction(e-> {
			add();
			Stage stage = (Stage)add.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showQuanLyThuTien();
		});
		backIcon.setOnMouseClicked(e->{
			Stage stage = (Stage)backIcon.getScene().getWindow();
	        Model.getInstance().getViewFactory().closeStage(stage);
	    	Model.getInstance().getViewFactory().showQuanLyThuTien();
		});
	}

}
