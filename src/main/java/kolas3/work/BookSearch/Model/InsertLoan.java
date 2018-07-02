package kolas3.work.BookSearch.Model;

import kolas3.common.db.ECOMySQLManager;
import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertLoan {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String insert(String selbook, String userid, String msa, String user_manage) throws SQLException {
		String publishformcode = msa;
		publishformcode = "MO";

		ECOMySQLManager sqlmanager = new ECOMySQLManager();

		ResultSet rs = null;

		String loanenddayuse = "";

		String userkey = "";
		String inferiorclass = "";
		String userclass = "";
		String userposition = "";
		String memberclass = "";

		int loancount = 0;

		String loanendday = "";
		String loanmaxcount = "";

		String bookguname = "";

		String deldate = "";

		String endday = "";

		String holidayuse = "";

		String endyear = "";
		String endmonth = "";

		ArrayList holidayyear = new ArrayList();
		ArrayList holidaymonth = new ArrayList();
		ArrayList holidaydays = new ArrayList();

		ArrayList subholidayyear = new ArrayList();
		ArrayList subholidaymonth = new ArrayList();
		ArrayList subholidaydays = new ArrayList();

		String lastendday = "";

		String sublastendday = "";

		String loanusercount = "";

		String bookjong = "";
		String indexjong = "";

		String book_key = "";
		String shelf_loc_code = "";
		String class_no_type = "";
		String class_no = "";
		String manage_code = "";
		String reg_code = "";
		String species_key = "";
		String working_status = "";
		String separate_shelf_code = "";
		String reg_no = "";

		String idx_title = "";
		String idx_author = "";
		String idx_publisher = "";

		String chugnseparate_shelf_code = "";
		String separate_shelf_code2 = "";
		String chungclass_no = "";
		String book_code = "";
		String vol_code = "";
		String copy_code = "";

		String call_no = "";

		int maxrec = 0;
		String vol_sort_no = "";
		sqlmanager.connect();
		String qry = " alter session set NLS_DATE_FORMAT = 'YYYY/MM/DD' ";
		sqlmanager.selectQry(qry);
		sqlmanager.disconnect();

		sqlmanager.connect();
		String loanenddayuseqry = "select value_1 from ESL_MANAGE_TBL where value_name = '예약만기일자동부여여부'";
		rs = sqlmanager.selectQry(loanenddayuseqry);
		while (rs.next()) {
			loanenddayuse = rs.getString("value_1");
		}
		sqlmanager.closeConnection();
		logger.debug("자동만기일사용여부:" + loanenddayuse);
		sqlmanager.connect();
		String userinfoqry = "select rec_key, RESERVATION_COUNT, USER_CLASS_CODE,USER_CLASS, MEMBER_CLASS, user_position_code from CO_LOAN_USER_TBL where USER_NO = '"
				+ userid + "'";
		rs = sqlmanager.selectQry(userinfoqry);
		while (rs.next()) {
			userkey = rs.getString("rec_key");
			inferiorclass = rs.getString("user_class");
			userclass = rs.getString("user_class_code").replace(" ", "");
			userposition = rs.getString("user_position_code");
			memberclass = rs.getString("member_class");
		}
		sqlmanager.closeConnection();
		logger.debug("사용자번호:" + userkey);
		logger.debug("사용자등급:" + inferiorclass);
		logger.debug("사용자직급클래스:" + userclass);
		logger.debug("대출소속정보 클래스:" + userposition);
		logger.debug("사용자구분:" + memberclass);
		if ((inferiorclass.equals("1")) || (inferiorclass.equals("2"))) {
			return "예약을 할 수 없는 이용자입니다.";
		}
		sqlmanager.connect();
		String loancountqry = "select count(*) from OC3.LH_STORAGE_V01 where user_key = '" + userkey
				+ "' and status = '3'";
		rs = sqlmanager.selectQry(loancountqry);
		while (rs.next()) {
			loancount = rs.getInt(1);
		}
		sqlmanager.disconnect();
		logger.debug("현재 예약중인책권수:" + loancount);

		sqlmanager.connect();
		String useloancountqry = "select PREENGAGE_BOOK_CNT, reservation_expire_day from CD_CODE_TBL where class = 31 and code = '"
				+ userclass + "'";
		rs = sqlmanager.selectQry(useloancountqry);
		while (rs.next()) {
			loanmaxcount = rs.getString("preengage_book_cnt");
			loanendday = rs.getString("reservation_expire_day");
		}
		sqlmanager.disconnect();
		logger.debug("예약가능권수" + loanmaxcount);
		logger.debug("예약만기일" + loanendday);
		if (loancount >= Integer.parseInt(loanmaxcount)) {
			return "예약한도를 초과하였습니다. 예약가능권수는 " + loanmaxcount + "권이고 현재 예약하신 권수는 " + loancount + "권입니다.";
		}
		if (publishformcode.equals("MO")) {
			bookguname = "일반도서";
			bookjong = "bo_book_tbl";
			indexjong = "idx_bo_tbl";
		} else if (publishformcode.equals("SO")) {
			bookguname = "연속간행물";
			bookjong = "se_book_tbl";
			indexjong = "idx_se_tbl";
		}
		sqlmanager.connect();
		String code = "";
		String codeqry = "select reg_code ";
		codeqry = codeqry + "from " + bookjong + " where rec_key = '" + selbook + "'";
		rs = sqlmanager.selectQry(codeqry);
		while (rs.next()) {
			code = rs.getString("reg_code");
		}
		sqlmanager.disconnect();

		sqlmanager.connect();
		String periodqry = "select LOAN_PERIOD FROM mn_loan_env_posreg_tbl where LOAN_CLASS_CODE_KEY =";
		periodqry = periodqry + "(select REC_KEY from cd_code_tbl where class = 31 and code = ";
		periodqry = periodqry + "(select user_class_code from co_loan_user_tbl where user_no = '" + userid + "')) ";

		periodqry = periodqry + "AND reg_code_key = (select REC_KEY from cd_code_tbl where class = 4 and CODE = '"
				+ code + "')";
		rs = sqlmanager.selectQry(periodqry);
		deldate = "2";
		while (rs.next()) {
			deldate = rs.getString("loan_period");
		}
		sqlmanager.disconnect();
		logger.debug("대출한도" + deldate);
		if (deldate.equals("0")) {
			return "대출가능 일수가 0 입니다 관리처에 문의하세요.";
		}
		if (loanenddayuse.equals("Y")) {
			sqlmanager.connect();
			String loanenddayqry = "select to_char(SYSDATE + " + deldate + ", 'yyyy/mm/dd') from dual";
			rs = sqlmanager.selectQry(loanenddayqry);
			while (rs.next()) {
				endday = rs.getString(1);
			}
			sqlmanager.disconnect();
			logger.debug("실제예약만기일" + endday);
			endyear = endday.substring(0, 4);
			endmonth = endday.substring(5, 7);
			logger.debug("예약만기일년도" + endyear);
			logger.debug("예약만기일월" + endmonth);

			sqlmanager.connect();
			String holidayqry = "SELECT VALUE_NAME FROM ESL_MANAGE_TBL WHERE GROUP_1='L' AND GROUP_2='기타' AND GROUP_3='공통' AND CLASS_ALIAS='관리구분별도서관설정'";
			rs = sqlmanager.selectQry(holidayqry);
			while (rs.next()) {
				holidayuse = rs.getString("VALUE_NAME");
			}
			sqlmanager.disconnect();
			logger.debug("휴관일관리구분사용여부" + holidayuse);
			if (holidayuse.equals("N")) {
				sqlmanager.connect();
				String holidayinfoqry = "select year ,month,days from MN_LIB_HOLIDAY_TBL where year >= " + endyear
						+ " and month >= " + endmonth + " and MANAGE_CODE Is NULL order by year, month,days";
				rs = sqlmanager.selectQry(holidayinfoqry);
				int r = 0;
				while (rs.next()) {
					holidayyear.add(rs.getString("year"));
					holidaymonth.add(rs.getString("month"));
					holidaydays.add(rs.getString("days"));
					logger.debug(holidayyear.get(r).toString());
					logger.debug(holidaymonth.get(r).toString());
					logger.debug(holidaydays.get(r).toString());
					r++;
				}
				sqlmanager.disconnect();
				for (int i = 0; i < holidayyear.size(); i++) {
					String holiyear = (String) holidayyear.get(i);
					String holimonth = (String) holidaymonth.get(i);
					String token = (String) holidaydays.get(i);
					String[] holiday = token.split(", ");
					for (int j = 0; j < holiday.length; j++) {
						String holi = holiyear + "/" + holimonth + "/" + holiday[j];
						if (endday.equals(holi)) {
							sqlmanager.connect();
							String holiuseenddayqry = "select to_date('" + endday + "', 'yyyy/mm/dd')+1 from dual";
							rs = sqlmanager.selectQry(holiuseenddayqry);
							while (rs.next()) {
								lastendday = rs.getString(1);
							}
							sqlmanager.disconnect();
							logger.debug("휴관일적용예약만료일" + lastendday);
						}
					}
				}
			}
		}
		sqlmanager.connect();
		String loanusercountqry = "select value_1 from esl_manage_tbl where value_name='예약허용인원'";
		rs = sqlmanager.selectQry(loanusercountqry);
		int tempcount = 0;
		while (rs.next()) {
			tempcount++;
			loanusercount = rs.getString("value_1");
			if (tempcount >= 1) {
				break;
			}
		}
		sqlmanager.disconnect();
		logger.debug("예약가능인원수" + loanusercount);
		if (!selbook.equals("")) {
			sqlmanager.connect();
			String bookinfoqry = "select rec_key, shelf_loc_code, class_no_type, class_no, manage_code, reg_code, ";
			bookinfoqry = bookinfoqry + "species_key, working_status, separate_shelf_code, reg_no, vol_sort_no from "
					+ bookjong + " where rec_key = '" + selbook + "'";
			rs = sqlmanager.selectQry(bookinfoqry);
			while (rs.next()) {
				book_key = rs.getString("REC_KEY");
				shelf_loc_code = rs.getString("SHELF_LOC_CODE");
				class_no_type = rs.getString("CLASS_NO_TYPE");
				class_no = rs.getString("CLASS_NO");
				manage_code = rs.getString("MANAGE_CODE");
				reg_code = rs.getString("REG_CODE");
				species_key = rs.getString("SPECIES_KEY");
				working_status = rs.getString("WORKING_STATUS");
				separate_shelf_code = rs.getString("SEPARATE_SHELF_CODE");
				reg_no = rs.getString("REG_NO");
				vol_sort_no = rs.getString("vol_sort_no");
			}
			sqlmanager.disconnect();
			if (book_key == null) {
				book_key = "";
			}
			if (shelf_loc_code == null) {
				shelf_loc_code = "";
			}
			if (class_no_type == null) {
				class_no_type = "";
			}
			if (manage_code == null) {
				manage_code = "";
			}
			if (reg_code == null) {
				reg_code = "";
			}
			if (species_key == null) {
				species_key = "";
			}
			if (working_status == null) {
				working_status = "";
			}
			if (separate_shelf_code == null) {
				separate_shelf_code = "";
			}
			if (reg_no == null) {
				reg_no = "";
			}
			if (vol_sort_no == null) {
				vol_sort_no = "";
			}
			logger.debug("배가 위치 부호" + book_key);
			logger.debug("배가 위치 부호" + shelf_loc_code);
			logger.debug("분류 기호 구분 " + class_no_type);
			logger.debug("분류 기호" + class_no);
			logger.debug("관리구분" + manage_code);
			logger.debug("등록구분" + reg_code);
			logger.debug("종정보 키" + species_key);
			logger.debug("자료상태" + working_status);
			logger.debug("별치기호" + separate_shelf_code);
			logger.debug("등록번호" + reg_no);
			if (holidayuse.equals("Y")) {
				sqlmanager.connect();
				String subholidayqry = "select year ,month,days from MN_LIB_HOLIDAY_TBL where year >= '" + endyear
						+ "' and month >= '" + endmonth + "' and MANAGE_CODE = '" + manage_code
						+ "' order by year, month,days";
				rs = sqlmanager.selectQry(subholidayqry);
				int r = 0;
				while (rs.next()) {
					subholidayyear.add(rs.getString("year"));
					subholidaymonth.add(rs.getString("month"));
					subholidaydays.add(rs.getString("days"));
					logger.debug(subholidayyear.get(r).toString());
					logger.debug(subholidaymonth.get(r).toString());
					logger.debug(subholidaydays.get(r).toString());
					r++;
				}
				sqlmanager.disconnect();
				for (int a = 0; a < subholidayyear.size(); a++) {
					String holiyear = (String) subholidayyear.get(a);
					String holimonth = (String) subholidaymonth.get(a);
					String token = (String) subholidaydays.get(a);
					String[] holiday = token.split(", ");
					for (int j = 0; j < holiday.length; j++) {
						String holi = holiyear + "/" + holimonth + "/" + holiday[j];
						if (endday.equals(holi)) {
							sqlmanager.connect();
							String holiuseenddayqry = "select to_date('" + endday + "', 'yyyy/mm/dd')+1 from dual";
							rs = sqlmanager.selectQry(holiuseenddayqry);
							while (rs.next()) {
								sublastendday = rs.getString(1);
							}
							sqlmanager.disconnect();
							logger.debug("분관별휴관일적용예약만료일" + sublastendday);
						}
					}
				}
			}
			sqlmanager.connect();
			String booktblinfoqry = "select title_info, author, publisher from " + indexjong + " where rec_key ='"
					+ species_key + "'";
			rs = sqlmanager.selectQry(booktblinfoqry);
			while (rs.next()) {
				idx_title = rs.getString("TITLE_INFO");
				idx_author = rs.getString("AUTHOR");
				idx_publisher = rs.getString("PUBLISHER");
			}
			sqlmanager.disconnect();
			logger.debug("색인정보타이틀" + idx_title);
			logger.debug("색인정보저자" + idx_author);
			logger.debug("색인정보발행자" + idx_publisher);

			sqlmanager.connect();
			String chunguqry = "select separate_shelf_code, class_no, book_code, vol_code, copy_code from " + bookjong;
			chunguqry = chunguqry + " where rec_key = '" + book_key + "'";
			rs = sqlmanager.selectQry(chunguqry);
			while (rs.next()) {
				chugnseparate_shelf_code = convert_code(rs.getString(1), "별치기호");
				separate_shelf_code2 = rs.getString(1);
				chungclass_no = rs.getString(2);
				book_code = rs.getString(3);
				vol_code = rs.getString(4);
				copy_code = rs.getString(5);
			}
			sqlmanager.disconnect();
			logger.debug("별치기호" + chugnseparate_shelf_code);
			logger.debug("별치기호코드값만" + separate_shelf_code2);
			logger.debug("분류기호" + chungclass_no);
			logger.debug("도서기호" + book_code);
			logger.debug("권책기호" + vol_code);
			logger.debug("복권기호" + copy_code);
			if ((chugnseparate_shelf_code != "") && (chugnseparate_shelf_code != null)) {
				chugnseparate_shelf_code = chugnseparate_shelf_code;
			} else {
				chugnseparate_shelf_code = "";
			}
			if ((book_code != "") && (book_code != null)) {
				book_code = "-" + book_code;
			} else {
				book_code = "";
			}
			if ((vol_code != "") && (vol_code != null)) {
				vol_code = "-" + vol_code;
			} else {
				vol_code = "";
			}
			if ((copy_code != "") && (copy_code != null)) {
				copy_code = "=" + copy_code;
			} else {
				copy_code = "";
			}
			call_no = chugnseparate_shelf_code + class_no + book_code + vol_code + copy_code;

			sqlmanager.connect();
			String loanchekqry = "select count(*) from OC3.LH_STORAGE_V01 where book_key='" + book_key
					+ "' AND STATUS in ( '0' , '2' , '3') and user_key = '" + userkey + "'";
			rs = sqlmanager.selectQry(loanchekqry);
			int loancheckcount = 0;
			while (rs.next()) {
				loancheckcount = rs.getInt(1);
			}
			sqlmanager.disconnect();
			logger.debug("대출중인책수" + loancheckcount);
			if (loancheckcount > 0) {
				return "대출중이신 도서는 예약하실수없습니다.";
			}
			sqlmanager.connect();
			String maxloancontqry = "SELECT COUNT(*) FROM OC3.LH_STORAGE_V01 WHERE book_key=" + book_key
					+ " AND STATUS='3'";
			rs = sqlmanager.selectQry(maxloancontqry);
			int maxloancheckcount = 0;
			while (rs.next()) {
				maxloancheckcount = rs.getInt(1);
			}
			sqlmanager.disconnect();
			logger.debug("예약중인인원수" + maxloancheckcount);
			if (maxloancheckcount >= Integer.parseInt(loanusercount)) {
				return "예약인원초과로 예약하실수없습니다.";
			}
			sqlmanager.connect();
			String maxrecqry = "SELECT ESL_SEQ.NEXTVAL FROM DUAL";
			rs = sqlmanager.selectQry(maxrecqry);
			while (rs.next()) {
				maxrec = rs.getInt(1);
			}
			sqlmanager.disconnect();
			logger.debug("최대값" + maxrec);
			Date today = new Date();
			String logdata = today + "-" + userid + "-WEB예약";
			idx_publisher = idx_publisher.replace("'", "''");
			idx_title = idx_title.replace("'", "''");
			logger.debug("로그기록날짜" + logdata);
			logger.debug("리플레이스출판사" + idx_publisher);
			logger.debug("리플레이스제목" + idx_title);
			sqlmanager.connect();
			String oneline = "SELECT USE_YN FROM CO_UTIL_LOCK_TBL WHERE UTIL_CODE='ONELNERESERV'";
			rs = sqlmanager.selectQry(oneline);
			String oneline_yn = "";
			while (rs.next()) {
				oneline_yn = rs.getString("USE_YN");
			}
			sqlmanager.disconnect();

			sqlmanager.connect();

			String loaninsertqry = "";
			if (oneline_yn.equals("Y")) {
				loaninsertqry = "insert into LS_WORK_T01 (rec_key, book_key, publish_form_code, ";
				loaninsertqry = loaninsertqry + "manage_code, species_key, user_key, user_position_code, ";
				loaninsertqry = loaninsertqry + "user_class_code, member_class, status, reservation_date, ";
				loaninsertqry = loaninsertqry + "title, author, publisher, first_work, vol_info";
				loaninsertqry = loaninsertqry + ") values('" + maxrec + "','" + selbook + "','" + publishformcode
						+ "',";
				loaninsertqry = loaninsertqry + "'" + manage_code + "','" + species_key + "', '" + userkey + "', '"
						+ userposition + "', ";
				loaninsertqry = loaninsertqry + "'" + userclass + "', '" + memberclass + "', '3', sysdate,";
				loaninsertqry = loaninsertqry + "'" + idx_title + "', '" + idx_author + "', '" + idx_publisher + "','"
						+ logdata + "','" + vol_sort_no + "'";
				loaninsertqry = loaninsertqry + ")";
			} else {
				loaninsertqry = "insert into LS_WORK_T01 (rec_key, book_key, shelf_loc_code, publish_form_code, class_no_type, ";
				loaninsertqry = loaninsertqry
						+ "class_no, manage_code, reg_code, species_key, user_key, user_position_code, ";
				loaninsertqry = loaninsertqry + "user_class_code, member_class, status, reservation_date, ";
				loaninsertqry = loaninsertqry
						+ "separate_shelf_code, title, author, publisher, call_no,first_work, reg_no, vol_info";
				loaninsertqry = loaninsertqry + ") values('" + maxrec + "','" + selbook + "', '" + shelf_loc_code
						+ "', '" + publishformcode + "', '" + class_no_type + "', ";
				loaninsertqry = loaninsertqry + "'" + class_no + "', '" + manage_code + "', '" + reg_code + "', '"
						+ species_key + "', '" + userkey + "', '" + userposition + "', ";
				loaninsertqry = loaninsertqry + "'" + userclass + "', '" + memberclass + "', '3', sysdate,";
				loaninsertqry = loaninsertqry + "'" + separate_shelf_code2 + "', '" + idx_title + "', '" + idx_author
						+ "', '" + idx_publisher + "','" + call_no + "','" + logdata + "','" + reg_no + "','"
						+ vol_sort_no + "'";
				loaninsertqry = loaninsertqry + ")";
			}
			logger.debug("인설트쿼리" + loaninsertqry);
			sqlmanager.insertQry(loaninsertqry);
			sqlmanager.commit();
			sqlmanager.disconnect();
			sqlmanager.connect();
			String loanupdateqry = "update co_loan_user_tbl set reservation_count = reservation_count + 1 where USER_NO = '"
					+ userid + "'";
			logger.debug("업데이트쿼리" + loanupdateqry);
			sqlmanager.updateQry(loanupdateqry);
			sqlmanager.commit();
			sqlmanager.disconnect();
			return "정상적으로 예약되었습니다 예약확인은 대출현황에서 할수있습니다.";
		}
		return "예약완료";
	}

	public String convert_code(String code_data, String class_name) throws SQLException {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();

		ResultSet rs = null;
		String description = "";
		sqlmanager.connect();
		String qry = "select a.description from cd_code_tbl a, cd_class_code_tbl b ";
		qry = qry + "where a.code like '" + code_data + "%' and ";
		qry = qry + "a.code is not null and ";
		qry = qry + "b.class_name = '" + class_name + "' and ";
		qry = qry + "a.class = b.class_code ";
		rs = sqlmanager.selectQry(qry);
		while (rs.next()) {
			description = rs.getString(1);
		}
		sqlmanager.disconnect();
		logger.debug("디스크립션" + description);
		if ((description.equals("")) || (code_data.equals(""))) {
			description = code_data;
		}
		return description;
	}
}
