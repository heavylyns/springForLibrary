package kolas3.work.BookSearch.Model;

import kolas3.common.db.ECOMySQLManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeliveryInsertLoan {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String insert(String selbook, String user_key, String addr, String phone, String zipcode)
			throws SQLException {
		String publish_form_code = "MO";
		ECOMySQLManager sqlmanager = new ECOMySQLManager();

		ResultSet rs = null;

		String qry = "";
		qry = "SELECT COUNT( * ) AS CNT FROM CO_DELIVERY_TBL WHERE BOOK_KEY = " + selbook
				+ " AND STATUS IN( '0', '1' )";
		sqlmanager.connect();
		rs = sqlmanager.selectQry(qry);
		int count = 0;
		while (rs.next()) {
			count = rs.getInt(1);
		}
		sqlmanager.disconnect();
		if (count > 0) {
			return "이미 택배대출된 책입니다";
		}
		sqlmanager.connect();
		qry = " INSERT INTO CO_DELIVERY_TBL ";
		qry = qry
				+ " (REC_KEY, PUBLISH_FORM_CODE, BOOK_KEY, USER_KEY, REQUEST_DATE, STATUS, ADDRESS, ZIP_CODE, PHONE, FIRST_WORK ) VALUES ( ";
		qry = qry + " ESL_SEQ.NEXTVAL, '" + publish_form_code + "', " + selbook + ", " + user_key + ", sysdate, '0', '"
				+ addr + "', '" + zipcode + "', '" + phone + "', '웹 택배 대출신청' )";
		sqlmanager.insertQry(qry);
		sqlmanager.disconnect();

		return "대출완료";
	}
}
