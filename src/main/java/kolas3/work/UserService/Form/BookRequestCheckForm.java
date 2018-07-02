package kolas3.work.UserService.Form;

public class BookRequestCheckForm {
	int page = 1;
	int rec_key = 0;
	private String keyword = "";
	private String cvil_no = "";
	private String chk_name = "";
	private String chk_title = "";
	private String applicant_name = "";
	private String password = "";
	private String check_mode = "";
	private String cmd = "";

	public String getCmd() {
		return this.cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApplicant_name() {
		return this.applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getChk_name() {
		return this.chk_name;
	}

	public void setChk_name(String chk_name) {
		this.chk_name = chk_name;
	}

	public String getChk_title() {
		return this.chk_title;
	}

	public void setChk_title(String chk_title) {
		this.chk_title = chk_title;
	}

	public String getCvil_no() {
		return this.cvil_no;
	}

	public void setCvil_no(String cvil_no) {
		this.cvil_no = cvil_no;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRec_key() {
		return this.rec_key;
	}

	public void setRec_key(int rec_key) {
		this.rec_key = rec_key;
	}

	public String getCheck_mode() {
		return this.check_mode;
	}

	public void setCheck_mode(String check_mode) {
		this.check_mode = check_mode;
	}
}
