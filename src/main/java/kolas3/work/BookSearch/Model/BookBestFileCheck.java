package kolas3.work.BookSearch.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class BookBestFileCheck {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	String configroot = "c:/eco_config/book_best/"; // 이것은 운영중인 iframe 소스에도 없음.
	Date date = new Date();
	int year = this.date.getYear() + 1900;
	int month = this.date.getMonth() + 1;
	String checkday = ggmonth() ;
	Calendar cal;

	private String ggmonth() {
		String rst = "";
		if (month < 10 ) {
			rst = String.valueOf(this.year) + "0"+String.valueOf(this.month);
		} else {
			rst = String.valueOf(this.year) +  String.valueOf(this.month);
		}
		return rst ;
	}

	public boolean filecheck() {
		boolean check = true;
		File fileroot = new File(this.configroot);
		File[] list = fileroot.listFiles();
		logger.debug(this.checkday);
		for (int i = 0; i < list.length; i++) {
			if (list[i].getName().equals(this.checkday)) {
				check = false;
			}
		}
		logger.debug(String.valueOf(check));
		return check;
	}

	public void makehtml() {
		ArrayList outHtmls = makefilevalue();
		PrintWriter writer = null;
		try {
			File dir = new File(this.configroot + this.checkday);
			logger.debug(this.configroot + this.checkday);
			dir.mkdir();
			logger.debug("aaa" + outHtmls.get(0));
			for (int q = 0; q < outHtmls.size(); q++) {
				String filename = "";
				if (q == 0) {
					filename = "/book_best_main.html";
				} else if (q == 1) {
					filename = "/book_best_kdc.html";
				} else {
					int count = q - 2;
					filename = "/book_best_kdc_" + count + ".html";
				}
				File file = new File(this.configroot + this.checkday + filename);
				file.createNewFile();
				writer = new PrintWriter(file);
				writer.println(outHtmls.get(q));
				writer.close();
			}
		} catch (FileNotFoundException e) {
			logger.error("",e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList makefilevalue() {
		int nyun = this.year;
		int mon = this.month - 1;
		String startdate = "";
		String enddate = "";
		if (mon == 0) {
			nyun = this.year - 1;
			mon = 12;
		}
		this.cal = Calendar.getInstance();
		this.cal.set(nyun, this.month - 2, 1);
		int endday = this.cal.getActualMaximum(5);
		if (mon < 10) {
			startdate = nyun + "/0" + mon + "/1";
			enddate = nyun + "/0" + mon + "/" + endday;
		} else {
			startdate = nyun + "/" + mon + "/1";
			enddate = nyun + "/" + mon + "/" + endday;
		}
		logger.debug("startdate" + startdate);
		logger.debug("enddate" + enddate);
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		ArrayList bookbestlist = new ArrayList();
		String qry = "select count(*) from OC3.LH_STORAGE_V01 ";
		qry = qry + "where status in ('0', '1', '2') and ";
		qry = qry + "to_char(LOAN_DATE,'YYYY/MM/DD') BETWEEN '" + startdate + "' and '" + enddate + "' ";
		rs = sqlmanager.selectQry(qry);
		int count = 0;
		String mainhtml = "";
		String totalhtml = "";
		String kdchtml = "";
		try {
			while (rs.next()) {
				logger.debug(String.valueOf(rs.getInt(1)));
				count = rs.getInt(1);
			}
			sqlmanager.closeConnection();
			if (count >= 0) {
				mainhtml = main(startdate, enddate);
				bookbestlist.add(mainhtml);
				totalhtml = total(startdate, enddate);
				bookbestlist.add(totalhtml);
				for (int i = 0; i <= 9; i++) {
					kdchtml = kdc(startdate, enddate, i);
					bookbestlist.add(kdchtml);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookbestlist;
	}

	public String main(String startdate, String enddate) {
		String basichtml = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>";
		basichtml = basichtml
				+ "<title>도서대출베스트</title><style type='text/css'>\tbody {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml + "td {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field   { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field2  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field3  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field4  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field5  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field6  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "tr.list   { background-color: #f2f8fc; font-family:'굴림' ; font-size:9pt; color:#085c96;}";
		basichtml = basichtml
				+ "tr.list2  { background-color: #a3d4F1; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.table  { background-color: #424242; font-family:'굴림' ; font-size:9pt; color:#424242;}";
		basichtml = basichtml + "</style>";
		basichtml = basichtml + "</head>";
		String endhtml = "</table></td></tr></table></body></html>";
		String book_best_script = "";
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;
		String qry = "select book_key, publish_form_code, count(*) as loan_count from OC3.LH_STORAGE_V01 ";
		qry = qry + "where to_char(loan_date, 'yyyy/mm/dd') between '" + startdate + "' and '" + enddate + "' ";
		qry = qry + "and manage_code = 'MA' ";
		qry = qry + "group by book_key, publish_form_code ";
		qry = qry + "order by loan_count desc ";
		rs = sqlmanager.selectQry(qry);
		int i = 0;
		try {
			while (rs.next()) {
				String tdcolor = "";
				if (i % 2 == 1) {
					tdcolor = "list";
				} else {
					tdcolor = "list2";
				}
				String publish_form_code = rs.getString("PUBLISH_FORM_CODE");
				String book_key = rs.getString("BOOK_KEY");
				String loan_count = rs.getString("LOAN_COUNT");
				String separate_shelf_code = "";
				String class_no = "";
				String book_code = "";
				String vol_code = "";
				String copy_code = "";
				String marc = "";
				String title = "";
				String author = "";
				String publisher = "";
				int species_key = 0;

				sqlmanager.connect();

				ResultSet rs1 = null;
				if (publish_form_code.equals("MO")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key ";
					qry_tmp = qry_tmp + "from bo_book_tbl a, bo_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("SE")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key  ";
					qry_tmp = qry_tmp + "from se_book_tbl a, se_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("NB")) {
					String qry_tmp = "select rec_key, separate_shelf_code, class_no, title, author, ";
					qry_tmp = qry_tmp + "publisher ";
					qry_tmp = qry_tmp + "from co_non_db_book_tbl ";
					qry_tmp = qry_tmp + "where rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						title = rs1.getString(4);
						author = rs1.getString(5);
						publisher = rs1.getString(6);
						species_key = rs1.getInt(8);
					}
				} else {
					title = "책제목임 - " + publish_form_code;
					author = "저자임 - " + publish_form_code;
					publisher = "출판사임 - " + publish_form_code;
				}
				sqlmanager.closeConnection();

				separate_shelf_code = get_printvalue(separate_shelf_code);
				logger.debug(separate_shelf_code);
				if (book_code != null) {
					book_code = "-" + book_code;
				}
				if (vol_code != null) {
					vol_code = "-" + vol_code;
				}
				if (copy_code != null) {
					copy_code = "=" + copy_code;
				}
				if (book_code == null) {
					book_code = "";
				}
				if (vol_code == null) {
					vol_code = "";
				}
				if (copy_code == null) {
					copy_code = "";
				}
				String chunggu_no = separate_shelf_code + class_no + book_code + vol_code + copy_code;
				logger.debug("species_key=" + species_key);
				sqlmanager.connect();

				ResultSet rs2 = null;

				String tmpqry = "select title,author,publisher from idx_bo_tbl where rec_key ='" + species_key + "'";
				rs2 = sqlmanager.selectQry(tmpqry);
				while (rs2.next()) {
					title = rs2.getString(1);
					author = rs2.getString(2);
					publisher = rs2.getString(3);
				}
				sqlmanager.closeConnection();
				if (title.length() > 10) {
					title = title.substring(0, 10) + "...";
				}
				book_best_script = book_best_script + "    <table>";
				book_best_script = book_best_script + "      <tr><td height=15 valign=bottom class=intro3>";
				book_best_script = book_best_script + title;
				book_best_script = book_best_script + "      </td></tr></table>";
				if (i == 3) {
					break;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basichtml + book_best_script + endhtml;
	}

	public String total(String startdate, String enddate) {
		String basichtml = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>";
		basichtml = basichtml
				+ "<title>도서대출베스트</title><style type='text/css'>\tbody {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml + "td {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field   { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field2  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field3  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field4  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field5  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field6  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "tr.list   { background-color: #f2f8fc; font-family:'굴림' ; font-size:9pt; color:#085c96;}";
		basichtml = basichtml
				+ "tr.list2  { background-color: #a3d4F1; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.table  { background-color: #424242; font-family:'굴림' ; font-size:9pt; color:#424242;}";
		basichtml = basichtml + "</style>";
		basichtml = basichtml + "</head>";
		basichtml = basichtml + "<font color=navy>" + startdate + "부터 " + enddate + "까지</font>";
		basichtml = basichtml
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td class=\"table\"><table width=\"600\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\n";
		basichtml = basichtml + "<tr height=\"32\"> \n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field\" width=\"30\"><b>순위</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field2\" width=\"120\"><b>청구기호</b></td>\n";
		basichtml = basichtml
				+ "\t<td align=\"center\" class=\"field3\"><b>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field4\" width=\"100\"><b>저자</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field5\" width=\"100\"><b>발행자</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field6\" width=\"30\"><b>대출<br>회수</b></td>\n";
		basichtml = basichtml + "</tr>\n";
		String endhtml = "</table></td></tr></table></body></html>";
		String book_best_script = "";
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;
		String qry = "select book_key, publish_form_code, count(*) as loan_count from OC3.LH_STORAGE_V01 ";
		qry = qry + "where to_char(loan_date, 'yyyy/mm/dd') between '" + startdate + "' and '" + enddate + "' ";
		qry = qry + "and manage_code = 'MA' ";
		qry = qry + "group by book_key, publish_form_code ";
		qry = qry + "order by loan_count desc ";
		rs = sqlmanager.selectQry(qry);
		int i = 0;
		try {
			while (rs.next()) {
				String tdcolor = "";
				if (i % 2 == 1) {
					tdcolor = "list";
				} else {
					tdcolor = "list2";
				}
				String publish_form_code = rs.getString("PUBLISH_FORM_CODE");
				String book_key = rs.getString("BOOK_KEY");
				String loan_count = rs.getString("LOAN_COUNT");
				String separate_shelf_code = "";
				String class_no = "";
				String book_code = "";
				String vol_code = "";
				String copy_code = "";
				String marc = "";
				String title = "";
				String author = "";
				String publisher = "";
				int species_key = 0;

				sqlmanager.connect();

				ResultSet rs1 = null;
				if (publish_form_code.equals("MO")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key ";
					qry_tmp = qry_tmp + "from bo_book_tbl a, bo_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("SE")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key  ";
					qry_tmp = qry_tmp + "from se_book_tbl a, se_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("NB")) {
					String qry_tmp = "select rec_key, separate_shelf_code, class_no, title, author, ";
					qry_tmp = qry_tmp + "publisher ";
					qry_tmp = qry_tmp + "from co_non_db_book_tbl ";
					qry_tmp = qry_tmp + "where rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						title = rs1.getString(4);
						author = rs1.getString(5);
						publisher = rs1.getString(6);
						species_key = rs1.getInt(8);
					}
				} else {
					title = "책제목임 - " + publish_form_code;
					author = "저자임 - " + publish_form_code;
					publisher = "출판사임 - " + publish_form_code;
				}
				sqlmanager.closeConnection();

				separate_shelf_code = get_printvalue(separate_shelf_code);
				logger.debug(separate_shelf_code);
				if (book_code != null) {
					book_code = "-" + book_code;
				}
				if (vol_code != null) {
					vol_code = "-" + vol_code;
				}
				if (copy_code != null) {
					copy_code = "=" + copy_code;
				}
				if (book_code == null) {
					book_code = "";
				}
				if (vol_code == null) {
					vol_code = "";
				}
				if (copy_code == null) {
					copy_code = "";
				}
				String chunggu_no = separate_shelf_code + class_no + book_code + vol_code + copy_code;
				logger.debug("species_key=" + species_key);
				sqlmanager.connect();

				ResultSet rs2 = null;

				String tmpqry = "select title,author,publisher from idx_bo_tbl where rec_key ='" + species_key + "'";
				rs2 = sqlmanager.selectQry(tmpqry);
				while (rs2.next()) {
					title = rs2.getString(1);
					author = rs2.getString(2);
					publisher = rs2.getString(3);
				}
				sqlmanager.closeConnection();

				book_best_script = book_best_script + "    <tr class=\"" + tdcolor + "\"> \n";
				book_best_script = book_best_script + "      <td height=25 align=center>" + (i + 1) + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + chunggu_no + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td height=25 align=\"left\">" + title + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + author + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + publisher + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td height=25 align=\"center\">" + loan_count
						+ "&nbsp;</td>\n";
				book_best_script = book_best_script + "    </tr>\n";
				if (i == 9) {
					break;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basichtml + book_best_script + endhtml;
	}

	public String kdc(String start_date, String end_date, int class_flag) {
		String basichtml = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=euc-kr'>";
		basichtml = basichtml
				+ "<title>도서대출베스트</title><style type='text/css'>\tbody {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml + "td {font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field   { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field2  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field3  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field4  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field5  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.field6  { background-color: #98d4e6; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "tr.list   { background-color: #f2f8fc; font-family:'굴림' ; font-size:9pt; color:#085c96;}";
		basichtml = basichtml
				+ "tr.list2  { background-color: #a3d4F1; font-family:'굴림' ; font-size:9pt; color:#000000;}";
		basichtml = basichtml
				+ "td.table  { background-color: #424242; font-family:'굴림' ; font-size:9pt; color:#424242;}";
		basichtml = basichtml + "</style>";
		basichtml = basichtml + "</head>";
		basichtml = basichtml + "<font color=navy>" + start_date + "부터 " + end_date + "까지</font>";
		basichtml = basichtml
				+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td class=\"table\"><table width=\"600\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\n";
		basichtml = basichtml + "<tr height=\"32\"> \n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field\" width=\"30\"><b>순위</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field2\" width=\"120\"><b>청구기호</b></td>\n";
		basichtml = basichtml
				+ "\t<td align=\"center\" class=\"field3\"><b>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field4\" width=\"100\"><b>저자</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field5\" width=\"100\"><b>발행자</b></td>\n";
		basichtml = basichtml + "\t<td align=\"center\" class=\"field6\" width=\"30\"><b>대출<br>회수</b></td>\n";
		basichtml = basichtml + "</tr>\n";
		String endhtml = "</table></td></tr></table></body></html>";
		String book_best_script = "";
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;
		String qry = "select book_key, publish_form_code, count(*) as loan_count from OC3.LH_STORAGE_V01 ";
		qry = qry + "where to_char(loan_date, 'yyyy/mm/dd') between '" + start_date + "' and '" + end_date + "' ";
		qry = qry + "and manage_code = 'MA' ";
		qry = qry + "and (class_no between '" + class_flag + "' and '" + class_flag + "힝') ";
		qry = qry + "group by book_key, publish_form_code ";
		qry = qry + "order by loan_count desc ";
		rs = sqlmanager.selectQry(qry);
		int i = 0;
		try {
			while (rs.next()) {
				String tdcolor = "";
				if (i % 2 == 1) {
					tdcolor = "list";
				} else {
					tdcolor = "list2";
				}
				String publish_form_code = rs.getString("PUBLISH_FORM_CODE");
				String book_key = rs.getString("BOOK_KEY");
				String loan_count = rs.getString("LOAN_COUNT");
				String separate_shelf_code = "";
				String class_no = "";
				String book_code = "";
				String vol_code = "";
				String copy_code = "";
				String marc = "";
				String title = "";
				String author = "";
				String publisher = "";
				int species_key = 0;

				sqlmanager.connect();

				ResultSet rs1 = null;
				if (publish_form_code.equals("MO")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key ";
					qry_tmp = qry_tmp + "from bo_book_tbl a, bo_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("SE")) {
					String qry_tmp = "select a.rec_key, a.separate_shelf_code, a.class_no, a.book_code, a.vol_code, ";
					qry_tmp = qry_tmp + "a.copy_code, b.marc, a.species_key  ";
					qry_tmp = qry_tmp + "from se_book_tbl a, se_species_tbl b ";
					qry_tmp = qry_tmp + "where a.species_key = b.rec_key ";
					qry_tmp = qry_tmp + "and a.rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						book_code = rs1.getString(4);
						vol_code = rs1.getString(5);
						copy_code = rs1.getString(6);
						marc = rs1.getString(7);
						species_key = rs1.getInt(8);
					}
				} else if (publish_form_code.equals("NB")) {
					String qry_tmp = "select rec_key, separate_shelf_code, class_no, title, author, ";
					qry_tmp = qry_tmp + "publisher ";
					qry_tmp = qry_tmp + "from co_non_db_book_tbl ";
					qry_tmp = qry_tmp + "where rec_key = '" + book_key + "' ";
					rs1 = sqlmanager.selectQry(qry_tmp);
					while (rs1.next()) {
						separate_shelf_code = rs1.getString(2);
						class_no = rs1.getString(3);
						title = rs1.getString(4);
						author = rs1.getString(5);
						publisher = rs1.getString(6);
						species_key = rs1.getInt(8);
					}
				} else {
					title = "책제목임 - " + publish_form_code;
					author = "저자임 - " + publish_form_code;
					publisher = "출판사임 - " + publish_form_code;
				}
				sqlmanager.closeConnection();

				separate_shelf_code = get_printvalue(separate_shelf_code);
				logger.debug(separate_shelf_code);
				if (book_code != null) {
					book_code = "-" + book_code;
				}
				if (vol_code != null) {
					vol_code = "-" + vol_code;
				}
				if (copy_code != null) {
					copy_code = "=" + copy_code;
				}
				if (book_code == null) {
					book_code = "";
				}
				if (vol_code == null) {
					vol_code = "";
				}
				if (copy_code == null) {
					copy_code = "";
				}
				String chunggu_no = separate_shelf_code + class_no + book_code + vol_code + copy_code;
				logger.debug("species_key=" + species_key);
				sqlmanager.connect();

				ResultSet rs2 = null;

				String tmpqry = "select title,author,publisher from idx_bo_tbl where rec_key ='" + species_key + "'";
				rs2 = sqlmanager.selectQry(tmpqry);
				while (rs2.next()) {
					title = rs2.getString(1);
					author = rs2.getString(2);
					publisher = rs2.getString(3);
				}
				sqlmanager.closeConnection();

				book_best_script = book_best_script + "    <tr class=\"" + tdcolor + "\"> \n";
				book_best_script = book_best_script + "      <td height=25 align=center>" + (i + 1) + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + chunggu_no + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td height=25 align=\"left\">" + title + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + author + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td align=\"center\">" + publisher + "&nbsp;</td>\n";
				book_best_script = book_best_script + "      <td height=25 align=\"center\">" + loan_count
						+ "&nbsp;</td>\n";
				book_best_script = book_best_script + "    </tr>\n";
				if (i == 9) {
					break;
				}
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return basichtml + book_best_script + endhtml;
	}

	public String get_printvalue(String separate_shelf_code) {
		String returnvalue = "";
		if (separate_shelf_code != null) {
			ECOMySQLManager sqlmanager = new ECOMySQLManager();
			sqlmanager.connect();

			ResultSet rs = null;
			if (separate_shelf_code.length() > 0) {
				String qry = "select description from cd_code_tbl where code = '" + separate_shelf_code + "' ";
				qry = qry + "and class = '11'";
				rs = sqlmanager.selectQry(qry);
				try {
					while (rs.next()) {
						returnvalue = rs.getString(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			sqlmanager.closeConnection();
		}
		return returnvalue;
	}
}
