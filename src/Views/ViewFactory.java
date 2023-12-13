package Views;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    public void showLogin() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/Login.fxml"));
        createStage(loader);
    }
    public void showHome() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/Home.fxml"));
        createStage(loader);
    }
  
    public void showHoKhau() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/HoKhau.fxml"));
        createStage(loader);
    }
    public void showAddHoKhau() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/AddHoKhau.fxml"));
        createStage(loader);
    }
    public void showNhanKhau() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/NhanKhau.fxml"));
        createStage(loader);
    }
    public void showAddNhanKhau() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/AddNhanKhau.fxml"));
        createStage(loader);
    }
    public void showSuaHoKhau() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/SuaHoKhau.fxml"));
        createStage(loader);
    }
    public void showKhoanThu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/KhoanThu.fxml"));
        createStage(loader);
    }
    public void showSuaKhoanThu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/SuaKhoanThu.fxml"));
        createStage(loader);
    }
    public void showThemKhoanThu() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/ThemKhoanThu.fxml"));
        createStage(loader);
    }
    public void showQuanLyThuTien() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/QuanLyThuTien.fxml"));
        createStage(loader);
    }
    public void showThemThuTien() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/ThemThuTien.fxml"));
        createStage(loader);
    }
    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    public void createFullScreenStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());	
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
    public void closeStage(Stage stage) {
        stage.close();
    }
}