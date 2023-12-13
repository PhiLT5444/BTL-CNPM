package Models;

public class KhoanThu {
	private Integer maKhoanThu;
	private String tenKhoanThu;
	private Double soTienNop;
	private Boolean loaiKhoanThu;
	
	
	public KhoanThu() {
		
	}
	public KhoanThu(Integer mkt, String tkt, Double tn, Boolean lkt) {
		this.maKhoanThu = mkt;
		this.tenKhoanThu = tkt;
		this.soTienNop = tn;
		this.loaiKhoanThu = lkt;
	}
	public Integer getMaKhoanThu() {
		return maKhoanThu;
	}
	public void setMaKhoanThu(Integer maKhoanThu) {
		this.maKhoanThu = maKhoanThu;
	}
	public Double getSoTienNop() {
		return soTienNop;
	}
	public void setSoTienNop(Double soTienNop) {
		this.soTienNop = soTienNop;
	}
	public String getTenKhoanThu() {
		return tenKhoanThu;
	}
	public void setTenKhoanThu(String tenKhoanThu) {
		this.tenKhoanThu = tenKhoanThu;
	}
	public Boolean getLoaiKhoanThu() {
		return loaiKhoanThu;
	}
	public void setLoaiKhoanThu(Boolean loaiKhoanThu) {
		this.loaiKhoanThu = loaiKhoanThu;
	}
}
