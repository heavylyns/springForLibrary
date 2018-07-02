package kolas3.work.BookSearch.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class RegForm {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String check(String[] selbook, String user_no) throws SQLException {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();

		ResultSet rs = null;

		String qry = "";
		String rec_key = "";
		String loan_count = "";
		String user_class_code = "";
		String user_class = "";
		String member_class = "";
		sqlmanager.connect();
		qry = qry
				+ "select rec_key, loan_count, user_class_code,user_class, member_class from CO_LOAN_USER_TBL where USER_NO = '"
				+ user_no + "'";
		rs = sqlmanager.selectQry(qry);
		while (rs.next()) {
			rec_key = rs.getString("rec_key");
			loan_count = rs.getString("loan_count");
			user_class_code = rs.getString("user_class_code");
			user_class = rs.getString("user_class");
			member_class = rs.getString("member_class");
		}
		sqlmanager.disconnect();
		if ((user_class.equals("1")) || (user_class.equals("2"))) {
			return "대출할 수 없는 이용자입니다";
		}
		int count = 0;
		sqlmanager.connect();
		qry = "select count(*) from OC3.LH_STORAGE_V01 where user_key = '" + rec_key + "' and status in (0,2)";
		rs = sqlmanager.selectQry(qry);
		while (rs.next()) {
			count = rs.getInt(1);
		}
		sqlmanager.disconnect();

		int ablecount = 0;
		sqlmanager.connect();
		qry = "select loan_book_cnt from CD_CODE_TBL where class = 31 and code = '" + user_class_code + "'";
		rs = sqlmanager.selectQry(qry);
		while (rs.next()) {
			ablecount = rs.getInt(1);
		}
		sqlmanager.disconnect();

		logger.debug(String.valueOf(count + selbook.length));
		logger.debug(String.valueOf(ablecount));
		if (count + selbook.length > ablecount) {
			return "대출한도를 초과하였습니다. 대출가능권수는 " + ablecount + "이고, 현재 " + count + "권을 대출하였습니다.";
		}
		return "success";
	}

	public ArrayList info(String user_no) {
		ArrayList re = new ArrayList();
		ECOMySQLManager sqlmanager = new ECOMySQLManager();

		ResultSet rs = null;

		String qry = "";
		sqlmanager.connect();
		qry = qry
				+ "select rec_key, user_position_code, user_class_code, member_class, h_addr1, h_zipcode, h_phone, name from co_loan_user_tbl where user_no = '"
				+ user_no + "'";
		rs = sqlmanager.selectQry(qry);
		try {
			while (rs.next()) {
				re.add(rs.getString("rec_key"));
				re.add(rs.getString("user_position_code"));
				re.add(rs.getString("user_class_code"));
				re.add(rs.getString("member_class"));
				re.add(rs.getString("h_addr1"));
				re.add(rs.getString("h_zipcode"));
				re.add(rs.getString("h_phone"));
				re.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			sqlmanager.disconnect();

			e.printStackTrace();
		}
		sqlmanager.disconnect();

		return re;
	}
}
