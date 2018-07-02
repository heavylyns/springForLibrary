package kolas3.work.BookSearch.Model;

import kolas3.common.db.ECOMySQLManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Form.BuhoSearchForm;
import kolas3.work.BookSearch.Form.BuhoSearchListForm;

public class BuhoSearch {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList buhosearch(BuhoSearchForm buhosearchform) throws SQLException {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		ArrayList buhosearchlist = null;

		String qry = "";

		String keyword = "";
		if ((buhosearchform.getGovname() != "") && (buhosearchform.getGovname() != null)) {
			sqlmanager.connect();
			keyword = "%" + buhosearchform.getGovname() + "%";
			qry = " select ";
			qry = qry + " CLASS_CODE, DESCRIPTION ";
			qry = qry + " from CO_GOVERNMENT_CODE_TBL ";
			qry = qry + " where INDEX_DESCRIPTION like '" + keyword;
			qry = qry + "' and CLASS_CODE is not null ";
			qry = qry + " order by CLASS_CODE ";
		} else if ((buhosearchform.getUnivname() != "") && (buhosearchform.getUnivname() != null)) {
			sqlmanager.connect();
			keyword = "%" + buhosearchform.getUnivname() + "%";
			qry = " select ";
			qry = qry + " CLASS_CODE, DESCRIPTION ";
			qry = qry + " from CO_KOR_UNIVERSITY_CODE_TBL ";
			qry = qry + " where INDEX_DESCRIPTION like '" + keyword;
			qry = qry + "' and CLASS_CODE is not null ";
			qry = qry + " order by CLASS_CODE ";
		}
		buhosearchform.reset();

		rs = sqlmanager.selectQry(qry);

		buhosearchlist = new ArrayList();
		while (rs.next()) {
			BuhoSearchListForm buhosearchlistform = new BuhoSearchListForm();
			buhosearchlistform.setClass_code(rs.getString("CLASS_CODE"));
			buhosearchlistform.setDescription(rs.getString("DESCRIPTION"));
			buhosearchlist.add(buhosearchlistform);
		}
		sqlmanager.closeConnection();

		return buhosearchlist;
	}
}
