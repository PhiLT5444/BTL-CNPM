package Models;

public class HoKhau{
	private Integer maHoKhau;
	private Integer soThanhVien;
	private String diaChi;
	
	public HoKhau(Integer id, Integer stv, String add) {
		this.maHoKhau = id;
		this.soThanhVien = stv;
		this.diaChi = add;
	}
	
	public HoKhau() {
		
	};
	
	
	public Integer getMaHoKhau() {
		return maHoKhau;
	}
	public void setMaHoKhau(Integer maHoKhau) {
		this.maHoKhau = maHoKhau;
	}
	public Integer getSoThanhVien() {
		return soThanhVien;
	}
	public void setSoThanhVien(Integer soThanhVien) {
		this.soThanhVien = soThanhVien;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
	
	
}