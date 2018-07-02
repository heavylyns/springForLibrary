package kolas3.work.BookSearch.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class SearchStandInfo {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String infolist(String manage_code) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		String qry = "";
		String temp_result = "";
		String result = "";
		qry = "select announcement, ann_update_date  from mn_lib_guidance_tbl where manage_code ='" + manage_code
				+ "' and ann_update_date is not null  order by ann_update_date desc";
		rs = sqlmanager.selectQry(qry);
		try {
			int count = 0;
			while (rs.next()) {
				result = rs.getString("announcement");
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
