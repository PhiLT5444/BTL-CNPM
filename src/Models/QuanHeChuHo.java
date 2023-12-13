package Models;

public class QuanHeChuHo{
	private Integer IdNhanKhau;
	private Integer IdChuHo;
	private String quanHe;
	
	public QuanHeChuHo() {}
	public QuanHeChuHo(Integer idnhan, Integer idchu, String qh) {
		this.IdNhanKhau = idnhan;
		this.IdChuHo = idchu;
		this.quanHe = qh;
	}
	public QuanHeChuHo(String qh) {
		this.quanHe = qh;
	}
	
	
	
	public Integer getIdNhanKhau() {
		return IdNhanKhau;
	}
	public void setIdNhanKhau(Integer idNhanKhau) {
		IdNhanKhau = idNhanKhau;
	}
	public Integer getIdChuHo() {
		return IdChuHo;
	}
	public void setIdChuHo(Integer idChuHo) {
		IdChuHo = idChuHo;
	}
	public String getQuanHe() {
		return quanHe;
	}
	public void setQuanHe(String quanHe) {
		this.quanHe = quanHe;
	}
}