package kolas3.work.UserService.Model;

import kolas3.common.db.ECOMySQLManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.UserService.Form.DeliveryResultForm;
import kolas3.work.UserService.Form.UserLoanStatusForm;

public class DeliveryStatus {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (DeliveryStatus.class);

	public ArrayList deliverystatus(UserLoanStatusForm LoanStatusForm) {
		ArrayList result = new ArrayList();
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();
		ResultSet rs = null;
		String qry = "";
		qry = "SELECT rec_key from co_loan_user_tbl where USER_NO = '" + LoanStatusForm.getUser_no() + "'";
		rs = sqlmanager.selectQry(qry);
		String user_key = "";
		try {
			while (rs.next()) {
				user_key = rs.getString("rec_key");
			}
		} catch (SQLException e) {
			sqlmanager.closeConnection();
			e.printStackTrace();
		}
		sqlmanager.closeConnection();
		sqlmanager.connect();
		ResultSet rs1 = null;
		String qry1 = "";
		qry1 = "select i.title_info as title, ";
		qry1 = qry1 + "b.vol as vol, ";
		qry1 = qry1 + "d.request_date as request_date, ";
		qry1 = qry1 + "d.receipt_date as receipt_date, ";
		qry1 = qry1 + "d.delivery_date as delivery_date, ";
		qry1 = qry1 + "decode(d.status,'0','신청', '1', '접수', '2', '배달') as status, ";
		qry1 = qry1 + "d.address as address, ";
		qry1 = qry1 + "d.rec_key as rec_key ";
		qry1 = qry1 + "from ";
		qry1 = qry1;
		qry1 = qry1 + "bo_book_tbl b, ";
		qry1 = qry1 + "co_delivery_view d, ";
		qry1 = qry1 + "co_loan_user_tbl u,";
		qry1 = qry1 + "idx_bo_tbl i ";
		qry1 = qry1 + "where ";
		qry1 = qry1 + "d.book_key=b.rec_key and ";
		qry1 = qry1 + "d.user_key=u.rec_key and ";
		qry1 = qry1 + "b.species_key=i.rec_key and ";
		qry1 = qry1 + "u.rec_key = " + user_key + " and ";
		qry1 = qry1 + "d.status in ('0','1') ";
		qry1 = qry1 + "order by ";
		qry1 = qry1 + "d.request_date desc";
		rs1 = sqlmanager.selectQry(qry1);
		try {
			while (rs1.next()) {
				DeliveryResultForm resultform = new DeliveryResultForm();
				resultform.setTitle(rs1.getString("title"));
				resultform.setVol(rs1.getString("vol"));
				resultform.setRequest_date(rs1.getString("request_date"));
				resultform.setReceipt_date(rs1.getString("receipt_date"));
				resultform.setDelivery_date(rs1.getString("delivery_date"));
				resultform.setStatus(rs1.getString("status"));
				resultform.setAddress(rs1.getString("address"));
				resultform.setRec_key(rs1.getString("rec_key"));
				result.add(resultform);
			}
		} catch (SQLException e) {
			sqlmanager.closeConnection();
			e.printStackTrace();
		}
		sqlmanager.closeConnection();
		return result;
	}
}
