package Models;

public class NopTien {
	private Integer maNhanKhau;
	private Integer maKhoanThu;
	private String ngayThu;
	
	public  NopTien() {}
	public NopTien(Integer mnk, Integer mkt, String nt) {
		this.maNhanKhau = mnk;
		this.maKhoanThu = mkt;
		this.ngayThu = nt;
	}

	public Integer getMaNhanKhau() {
		return maNhanKhau;
	}

	public void setMaNhanKhau(Integer maNhanKhau) {
		this.maNhanKhau = maNhanKhau;
	}

	public Integer getMaKhoanThu() {
		return maKhoanThu;
	}

	public void setMaKhoanThu(Integer maKhoanThu) {
		this.maKhoanThu = maKhoanThu;
	}

	public String getNgayThu() {
		return ngayThu;
	}

	public void setNgayThu(String ngayThu) {
		this.ngayThu = ngayThu;
	}	
}
