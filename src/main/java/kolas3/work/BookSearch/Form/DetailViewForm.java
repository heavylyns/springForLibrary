package kolas3.work.BookSearch.Form;

public class DetailViewForm

{
	private String beforequery    = "";
	private String offset         = "";
	private String sort           = "";
	private String msa            = "";
	private String maxoffset      = "";
	private String historycount   = "";
	private String jongbook       = "";
	private String book_code      = "";
	private String col            = "";
	private String duty           = "";

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getCol() {
		return this.col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getBook_code() {
		return this.book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public String getJongbook() {
		return this.jongbook;
	}

	public void setJongbook(String jongbook) {
		this.jongbook = jongbook;
	}

	public String getHistorycount() {
		return this.historycount;
	}

	public void setHistorycount(String historycount) {
		this.historycount = historycount;
	}

	public String getMaxoffset() {
		return this.maxoffset;
	}

	public void setMaxoffset(String maxoffset) {
		this.maxoffset = maxoffset;
	}

	public String getBeforequery() {
		return this.beforequery;
	}

	public void setBeforequery(String beforquery) {
		this.beforequery = beforquery;
	}

	public String getMsa() {
		return this.msa;
	}

	public void setMsa(String msa) {
		this.msa = msa;
	}

	public String getOffset() {
		return this.offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "DetailViewForm [beforequery=" + beforequery + ", offset=" + offset + ", sort=" + sort + ", msa=" + msa
				+ ", maxoffset=" + maxoffset + ", historycount=" + historycount + ", jongbook=" + jongbook
				+ ", book_code=" + book_code + ", col=" + col + ", duty=" + duty + "]";
	}



}
