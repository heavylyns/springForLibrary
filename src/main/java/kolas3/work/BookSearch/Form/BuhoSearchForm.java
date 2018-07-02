package kolas3.work.BookSearch.Form;

public class BuhoSearchForm {
	private String univname = "";
	private String govname = "";

	public String getGovname() {
		return this.govname;
	}

	public void setGovname(String govname) {
		this.govname = govname;
	}

	public String getUnivname() {
		return this.univname;
	}

	public void setUnivname(String univname) {
		this.univname = univname;
	}

	public void reset() {
		this.govname = null;
		this.univname = null;
	}
}
