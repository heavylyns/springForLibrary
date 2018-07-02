package kolas3.work.BookSearch.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.work.BookSearch.Form.PlaceSearchListForm;

public class PlaceSearch {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList placesearch() {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		PreparedStatement pstmt = null;
		ArrayList placesearchlist = null;

		String qry = "";

		qry = "select code, description from cd_code_tbl where class='19' order by code";

		rs = sqlmanager.selectQry(qry);

		placesearchlist = new ArrayList();
		try {
			while (rs.next()) {
				PlaceSearchListForm placesearchlistform = new PlaceSearchListForm();
				placesearchlistform.setCode(rs.getString("code"));
				placesearchlistform.setDescription(rs.getString("description"));

				placesearchlist.add(placesearchlistform);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlmanager.closeConnection();

		return placesearchlist;
	}
}
