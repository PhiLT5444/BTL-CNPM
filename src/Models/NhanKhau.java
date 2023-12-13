package Models;

public class NhanKhau{
	private Integer maNhanKhau;
	private String hoTen;
	private String ngaySinh;
	private String soCMND;
	private String diaChi;
	private String SDT;
	
	
	public NhanKhau(Integer manhankhau, String tennhankhau, String ngaysinh, String cmnd, String sdt) {
		this.maNhanKhau = manhankhau;
		this.hoTen = tennhankhau;
		this.ngaySinh = ngaysinh;
		this.soCMND = cmnd;
		this.SDT = sdt;
	}
	
	public NhanKhau( String tennhankhau, String ngaysinh, String cmnd, String sdt) {
		this.hoTen = tennhankhau;
		this.ngaySinh = ngaysinh;
		this.soCMND = cmnd;
		this.SDT = sdt;
	}
	
	public NhanKhau() {
	}

	public Integer getMaNhanKhau() {
		return maNhanKhau;
	}
	public void setMaNhanKhau(Integer maNhanKhau) {
		this.maNhanKhau = maNhanKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String tenNhanKhau) {
		this.hoTen = tenNhanKhau;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}
}