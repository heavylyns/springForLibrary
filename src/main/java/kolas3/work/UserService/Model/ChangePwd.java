package kolas3.work.UserService.Model;

import kolas3.common.db.ECOMySQLManager;
import kolas3.work.UserService.Action.BookRequestListAction;

import java.io.PrintStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangePwd {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (ChangePwd.class);

	public String change(String id, String pwd, String changpwd) {
		String re = "0";
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;
		String qry = "select count(*) from co_loan_user_tbl where user_id = '" + id + "' and password = '" + pwd + "'";
		rs = sqlmanager.selectQry(qry);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (count <= 0) {
			re = "0";
			return re;
		}
		logger.debug(String.valueOf(count));
		sqlmanager.disconnect();
		sqlmanager.connect();
		ResultSet rs1 = null;
		qry = "update co_loan_user_tbl set password = '" + changpwd + "' where user_id = '" + id + "' and password = '"
				+ pwd + "'";
		sqlmanager.updateQry(qry);
		sqlmanager.commit();
		sqlmanager.disconnect();
		re = "1";
		return re;
	}
}
