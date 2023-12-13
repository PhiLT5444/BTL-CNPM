package Models;

public class ChuHo{
	private Integer maHoKhau;
	private Integer maChuHo;
	
	public ChuHo() {}
	public ChuHo(Integer id, Integer idc) {
		this.maHoKhau = id;
		this.maChuHo = idc;
	}
	public Integer getMaHoKhau() {
		return maHoKhau;
	}
	public void setMaHoKhau(Integer iDHoKhau) {
		maHoKhau = iDHoKhau;
	}
	public Integer getMaChuHo() {
		return maChuHo;
	}
	public void setMaChuHo(Integer iDChuHo) {
		maChuHo = iDChuHo;
	}
	
}