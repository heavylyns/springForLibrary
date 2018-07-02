package kolas3.work.BookSearch.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class SearchStandLibinfo {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String libinfolist(String manage_code) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		String qry = "";
		String temp_result = "";
		String result = "";
		qry = "select GUIDE, GUI_UPDATE_DATE  from mn_lib_guidance_tbl where manage_code ='" + manage_code
				+ "' and GUI_UPDATE_DATE is not null order by GUI_UPDATE_DATE desc";
		rs = sqlmanager.selectQry(qry);
		try {
			int count = 0;
			while (rs.next()) {
				result = rs.getString("GUIDE");
				if (result != null) {
					temp_result = result;
				} else {
					temp_result = "검색 결과가 없습니다.";
				}
				count++;
				if (count >= 1) {
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlmanager.closeConnection();
		return temp_result;
	}
}
