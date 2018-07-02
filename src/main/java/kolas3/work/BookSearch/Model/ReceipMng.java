package kolas3.work.BookSearch.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class ReceipMng {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String cut_page_string(String str, int length, int page) {
		String return_str = str;
		int start_point = (page - 1) * length;
		int end_point = start_point + length - 1;
		int str_length = str.length();
		String hangul_pointer = "";
		int h_count = 0;
		String RegExp = "^[a-z]+";
		Pattern p = Pattern.compile(RegExp);
		boolean pass_ck = p.matcher(str).matches();
		boolean check = false;
		if (pass_ck) {
			check = false;
		} else {
			check = true;
		}
		if ((str.length() <= length) && (pass_ck)) {
			return return_str;
		}
		return return_str;
	}

	public String cut_str(String title, String value) {
		if (value == null) {
			value = "";
		}
		String result_str = "";
		int length = 0;
		if (title.equals("청구  기호")) {
			length = 14;
		} else {
			length = 28;
		}
		result_str = "<!FN>" + title + ": ";
		double tot_page = 0.0D;

		tot_page = Math.ceil(value.length() / length);
		int count = 0;
		if (tot_page <= 0.0D) {
			tot_page = 1.0D;
		}
		for (int i = 1; i <= tot_page; i++) {
			String tmpStr = cut_page_string(value, length, i);
			if (title == "청구  기호") {
				tmpStr = tmpStr;
			}
			if (i == 1) {
				tmpStr = tmpStr + "<!LN><!FP>\n";
			} else {
				tmpStr = "<!FN>             " + tmpStr + "<!LN><!FP><!FP>\n";
			}
			result_str = result_str + tmpStr;
			count = i;
		}
		if (count == 2) {
			result_str = result_str + "<!FP>\n";
		}
		return result_str;
	}

	public String resolve_working_status_print(String working_status) {
		String resolve_result = "";
		if (working_status.equals("BOL112N")) {
			resolve_result = "대출가능";
		} else if (working_status.equals("BOL113O")) {
			resolve_result = "대출불가-수리제본";
		} else if (working_status.equals("BOL114O")) {
			resolve_result = "대출불가-파손";
		} else if (working_status.equals("BOL115O")) {
			resolve_result = "대출불가-제적";
		} else if (working_status.equals("BOL116O")) {
			resolve_result = "대출불가-재정리";
		} else if (working_status.equals("BOL252N")) {
			resolve_result = "대출불가-분실";
		} else if ((working_status.equals("BOL211O")) || (working_status.equals("BOL213O"))
				|| (working_status.equals("BOL214O")) || (working_status.equals("BOL215O"))) {
			resolve_result = "대출중";
		} else if (working_status.equals("BOL212O")) {
			resolve_result = "대출중";
		} else if ((working_status.equals("SEL212N")) || (working_status.equals("SEL112N"))) {
			resolve_result = "대출가능";
		} else if (working_status.equals("SEL213O")) {
			resolve_result = "대출불가-수리제본";
		} else if (working_status.equals("SEL214O")) {
			resolve_result = "대출불가-파손";
		} else if (working_status.equals("SEL215O")) {
			resolve_result = "대출불가-제적";
		} else if (working_status.equals("SEL216O")) {
			resolve_result = "대출불가-분실";
		} else if (working_status.equals("SEL217O")) {
			resolve_result = "대출불가-재정리";
		} else if ((working_status.equals("SEL311O")) || (working_status.equals("SEL313O"))
				|| (working_status.equals("SEL314O")) || (working_status.equals("SEL315O"))) {
			resolve_result = "대출중";
		} else if (working_status.equals("SEL312O")) {
			resolve_result = "대출중";
		}
		return resolve_result;
	}

	public String getDateDistance(String date) {
		return date;
	}

	public String isReserved(String rec_key) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();
		ResultSet rs = null;

		String qry = "select count(*) as reserve_cnt from OC3.LH_STORAGE_V01 ";
		qry = qry + "where book_key = '" + rec_key + "' ";
		qry = qry + "and status = '3' ";

		rs = sqlmanager.selectQry(qry);
		String reserve_cnt = "0";
		try {
			while (rs.next()) {
				reserve_cnt = rs.getString("RESERVE_CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlmanager.closeConnection();
		if (Integer.parseInt(reserve_cnt) > 0) {
			return "Y";
		}
		return "N";
	}

	public ArrayList GetWorkingStat(String species_key, String mat_class) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;
		String table_name = "";
		if (mat_class.equals("1")) {
			table_name = "bo_book_tbl";
		} else if (mat_class.equals("2")) {
			table_name = "se_book_tbl";
		}
		String sub_qry = "";
		sub_qry = "select rec_key, working_status, ";
		sub_qry = sub_qry
				+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(shelf_loc_code)) as place_info, ";
		sub_qry = sub_qry + "(select to_char(return_plan_date, 'yyyy/mm/dd') from OC3.LH_STORAGE_V01 ";
		sub_qry = sub_qry + "where status in ('0', '2') ";
		sub_qry = sub_qry + "and book_key=a.rec_key ) as return_plan_date ";
		sub_qry = sub_qry + "from " + table_name + " a ";
		sub_qry = sub_qry + "where species_key='" + species_key + "' ";
		rs = sqlmanager.selectQry(sub_qry);
		int cnt = 0;
		int loanable_cnt = 0;
		int loaned_cnt = 0;
		ArrayList rec_key = new ArrayList();
		ArrayList place_info = new ArrayList();
		ArrayList working_status = new ArrayList();
		ArrayList return_plan_date = new ArrayList();
		ArrayList reserve_yn = new ArrayList();
		ArrayList loanable_offset = new ArrayList();
		ArrayList loaned_offset = new ArrayList();
		try {
			while (rs.next()) {
				rec_key.add(rs.getString("REC_KEY"));
				place_info.add(rs.getString("place_info"));
				working_status.add(rs.getString("working_status"));
				return_plan_date.add(rs.getString("return_plan_date"));
				reserve_yn.add(isReserved((String) rec_key.get(cnt)));

				String working = (String) working_status.get(cnt);
				String yn = (String) reserve_yn.get(cnt);
				if (((working.equals("BOL112N")) || (working.equals("SEL212N")) || (working.equals("SEL112N")))
						&& (yn.equals("N"))) {
					loanable_offset.add(cnt);
					loanable_cnt++;
				}
				if ((working.equals("BOL211O")) || (working.equals("BOL213O")) || (working.equals("BOL214O"))
						|| (working.equals("BOL215O")) || (working.equals("SEL311O")) || (working.equals("SEL313O"))
						|| (working.equals("SEL314O")) || (working.equals("SEL315O"))) {
					loaned_offset.add(cnt);
					loaned_cnt++;
				}
				cnt++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList return_value = new ArrayList();
		if (loanable_cnt > 0) {
			logger.debug("대출가능책");
			String loanable = loanable_offset.get(0).toString();
			return_value.add(working_status.get(Integer.parseInt(loanable)));
			return_value.add(place_info.get(Integer.parseInt(loanable)));
			return_value.add("");
			return_value.add(loanable_cnt);
		} else if (loaned_cnt > 0) {
			logger.debug("대출중인책");

			String nearest_offset = (String) loaned_offset.get(0).toString();
			String loaned_offset1 = (String) loaned_offset.get(0).toString();
			String nearest_date = getDateDistance((String) return_plan_date.get(Integer.parseInt(loaned_offset1)));
			for (int i = 1; i < loaned_cnt; i++) {
				String loaned_offset2 = (String) loaned_offset.get(i).toString();
				String tmp_date = getDateDistance((String) return_plan_date.get(Integer.parseInt(loaned_offset2)));
				if (Integer.parseInt(nearest_date) > Integer.parseInt(tmp_date)) {
					nearest_date = tmp_date;
					nearest_offset = (String) loaned_offset.get(i).toString();
				}
			}
			return_value.add(working_status.get(Integer.parseInt(nearest_offset)));
			return_value.add(place_info.get(Integer.parseInt(nearest_offset)));
			return_value.add(return_plan_date.get(Integer.parseInt(nearest_offset)));
			return_value.add(loanable_cnt);
		} else {
			logger.debug("이도저도아닌책");

			return_value.add(working_status.get(0).toString());
			return_value.add("");
			return_value.add("");
			return_value.add(loanable_cnt);
		}
		sqlmanager.closeConnection();
		return return_value;
	}

	public ArrayList makeReceipStr(String query, String loanableChk) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		String qry = query;

		String printStr = "";
		String tmpPrintStr = "";
		String scriptStr = "";

		rs = sqlmanager.selectQry(qry);
		ArrayList return_value = new ArrayList();
		printStr = "<!FC><!FF>[자료위치안내]<!LF><!LC><!FP><!FP>\n";
		int printStr_length = printStr.length();
		int i = 0;
		try {
			while (rs.next()) {
				i++;
				String mat_class = rs.getString("MAT_CLASS");
				String rec_key = rs.getString("REC_KEY");
				String title_info = rs.getString("TITLE_INFO");
				String author = rs.getString("AUTHOR_INFO");
				String publish_year = rs.getString("PUB_YEAR_INFO");
				String callnoinfo = rs.getString("CALLNOINFO");

				return_value = GetWorkingStat(rec_key, mat_class);
				String loan_status = (String) return_value.get(0);
				String place_info = (String) return_value.get(1);
				String return_plan_date = (String) return_value.get(2);
				String loan_status_desc = resolve_working_status_print(loan_status);
				if (return_plan_date == null) {
					return_plan_date = "";
				}
				logger.debug("책수" + return_value.get(3));
				if (loanableChk.equals("yes")) {
					String tmp = (String) return_value.get(3).toString();
					int changetmp = Integer.parseInt(tmp);
					if ((!return_plan_date.equals("")) || (changetmp == 0)) {
					}
				} else {
					printStr = printStr + "<!FC>----------------------------------------<!LC><!FP><!FP>\n";

					printStr = printStr + cut_str("자  료  실", new StringBuilder(String.valueOf(place_info)).append("(")
							.append(loan_status_desc).append(")").toString());
					if ((loan_status.equals("BOL211O")) || (loan_status.equals("BOL213O"))
							|| (loan_status.equals("BOL214O")) || (loan_status.equals("BOL215O"))) {
						printStr = printStr + cut_str("반납예정일", return_plan_date);
					}
					printStr = printStr + cut_str("청구  기호", callnoinfo);

					printStr = printStr + cut_str("서      명", title_info);

					printStr = printStr + cut_str("저      자", author);
					if (i % 10 == 0) {
						tmpPrintStr = tmpPrintStr + printStr;
						printStr = printStr.replace("\n", "\" +\n\"");
						printStr = printStr.substring(0, printStr.length() - 5);
						scriptStr = scriptStr + " frm.printStr.value=\"" + printStr + "\";\n";
						scriptStr = scriptStr + "\tprintRecpString();\n";
						printStr = "";
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlmanager.closeConnection();
		if (printStr_length < printStr.length()) {
			tmpPrintStr = tmpPrintStr + printStr;
		} else {
			printStr = "";
		}
		if (printStr.length() > 1) {
			printStr = printStr.replace("\n", "\" +\n\"");
			printStr = printStr.substring(0, printStr.length() - 5);

			scriptStr = scriptStr + "\tfrm.printStr.value=\"" + printStr + "\";\n";
			scriptStr = scriptStr + "\tprintRecpString();\n";
		}
		logger.debug(printStr);
		return_value.set(0, tmpPrintStr);
		return_value.set(1, scriptStr);
		return return_value;
	}

	public ArrayList printListAll(String rec_keyList, String db_typeList, String loanableChk) {
		ArrayList return_value = new ArrayList();
		String[] rec_key_list = rec_keyList.split("@");
		String[] db_type_list = db_typeList.split("@");

		int arryLength = rec_key_list.length;
		String dan_where = "";
		String yon_where = "";
		for (int i = 0; i < arryLength; i++) {
			if (db_type_list[i].equals("M")) {
				dan_where = dan_where + rec_key_list[i] + ", ";
			} else if (db_type_list[i].equals("S")) {
				yon_where = yon_where + rec_key_list[i] + ", ";
			}
		}
		if (!dan_where.equals("")) {
			dan_where = dan_where.substring(0, dan_where.length() - 2);
		}
		if (!yon_where.equals("")) {
			yon_where = yon_where.substring(0, yon_where.length() - 2);
		}
		String qry = "";
		if (dan_where.length() != 0) {
			qry = qry + "select '1' as mat_class, rec_key, title_info, author_info, pub_info, pub_year_info, ";
			qry = qry
					+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(main_place_info)) as place_info, ";
			qry = qry
					+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.se_shelf_code)) || a.class_no || decode(trim(a.book_code), null,'','-'||a.book_code) as callnoinfo ";
			qry = qry + "from IDX_BO_TBL a where rec_key in (" + dan_where + ") ";
		}
		if ((dan_where.length() != 0) && (yon_where.length() != 0)) {
			qry = qry + "union all ";
		}
		if (yon_where.length() != 0) {
			qry = qry + "select '2' as mat_class, rec_key, title_info, author_info, pub_info, pub_year_info, ";
			qry = qry
					+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(place_info)) as place_info, ";
			qry = qry
					+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.se_shelf_code)) || a.class_no || decode(trim(a.book_code), null,'','-'||a.book_code) as callnoinfo ";
			qry = qry + "from IDX_SE_TBL a where rec_key in (" + yon_where + ") ";
		}
		return_value = makeReceipStr(qry, loanableChk);

		return return_value;
	}

	public ArrayList printlistDan(String rec_keyList, String show_method, String loanableChk) {
		ArrayList return_value = new ArrayList();

		String[] rec_key_list = rec_keyList.split("@");

		int arryLength = rec_key_list.length;
		String dan_where = "";
		for (int i = 0; i < arryLength; i++) {
			dan_where = dan_where + rec_key_list[i] + ", ";
		}
		dan_where = dan_where.substring(0, dan_where.length() - 2);

		String qry = "";
		if (dan_where.length() != 0) {
			if (show_method.equals("jong")) {
				qry = qry + "select '1' as mat_class, rec_key, title_info, author_info, pub_info, pub_year_info, ";
				qry = qry
						+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(main_place_info)) as place_info, ";
				qry = qry
						+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.se_shelf_code)) || a.class_no || decode(trim(a.book_code), null,'','-'||a.book_code) as callnoinfo ";
				qry = qry + "from IDX_BO_TBL a where rec_key in (" + dan_where + ") ";
			} else if (show_method.equals("book")) {
				qry = qry + "select '1' as mat_class, species_key as rec_key, ";
				qry = qry + "(select title_info from idx_bo_tbl where rec_key=a.species_key) as title_info, ";
				qry = qry + "author as author_info, ";
				qry = qry + "publish_year as pub_year_info, ";
				qry = qry
						+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(SHELF_LOC_CODE)) as place_info, ";
				qry = qry
						+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.SEPARATE_SHELF_CODE)) || a.class_no || decode(trim(a.book_code), null, '', '-'||a.book_code) as callnoinfo ";
				qry = qry + "from BO_BOOK_TBL a where rec_key in  (" + dan_where + ") ";
			}
		}
		return_value = makeReceipStr(qry, loanableChk);
		return return_value;
	}

	public ArrayList printlistYon(String rec_keyList, String show_method, String loanableChk) {
		ArrayList return_value = new ArrayList();

		String[] rec_key_list = rec_keyList.split("@");

		int arryLength = rec_key_list.length;
		String yon_where = "";
		for (int i = 0; i < arryLength; i++) {
			yon_where = yon_where + rec_key_list[i] + ", ";
		}
		yon_where = yon_where.substring(0, yon_where.length() - 2);

		String qry = "";
		if (yon_where.length() != 0) {
			if (show_method.equals("jong")) {
				qry = qry + "select '1' as mat_class, rec_key, title_info, author_info, pub_info, pub_year_info, ";
				qry = qry
						+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(main_place_info)) as place_info, ";
				qry = qry
						+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.se_shelf_code)) || a.class_no || decode(trim(a.book_code), null,'','-'||a.book_code) as callnoinfo ";
				qry = qry + "from IDX_SE_TBL a where rec_key in (" + yon_where + ") ";
			} else if (show_method.equals("book")) {
				qry = qry + "select '1' as mat_class, species_key as rec_key, ";
				qry = qry + "(select title_info from idx_bo_tbl where rec_key=a.species_key) as title_info, ";
				qry = qry + "author as author_info, ";
				qry = qry + "publish_year as pub_year_info, ";
				qry = qry
						+ "(select max(c.description) from cd_code_tbl c where c.class='19' and trim(c.code)=trim(SHELF_LOC_CODE)) as place_info, ";
				qry = qry
						+ "(select max(description) from cd_code_tbl where class='11' and code=trim(a.SEPARATE_SHELF_CODE)) || a.class_no || decode(trim(a.book_code), null, '', '-'||a.book_code) as callnoinfo ";
				qry = qry + "from SE_BOOK_TBL a where rec_key in  (" + yon_where + ") ";
			}
		}
		return_value = makeReceipStr(qry, loanableChk);
		return return_value;
	}
}
