package kolas3.work.BookSearch.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.work.BookSearch.Form.MokchaViewForm;
import kolas3.work.BookSearch.Form.MokchaViewListForm;

public class MokchaViewSearch {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public ArrayList mokchaview(MokchaViewForm mokchaviewform) {
		ECOMySQLManager sqlmanager = new ECOMySQLManager();
		sqlmanager.connect();

		ResultSet rs = null;

		PreparedStatement pstmt = null;
		ArrayList mokchaviewlist = null;

		String qry = "";
		if (mokchaviewform.getMatcode().equals("A")) {
			qry = "select contents as content from se_article_toc_tbl where article_key = "
					+ mokchaviewform.getReckey();
		} else {
			qry = "select contents from bo_contents_tbl where rec_key = (select contents_key from bo_toc_common_tbl where species_key = "
					+ mokchaviewform.getReckey() + ")";
		}
		rs = sqlmanager.selectQry(qry);

		mokchaviewlist = new ArrayList();
		try {
			while (rs.next()) {
				String tmpstr = rs.getString("contents");
				String[] str = tmpstr.split("\n");
				for (int i = 0; i < str.length; i++) {
					MokchaViewListForm mokchaviewformlist = new MokchaViewListForm();
					str[i] = str[i].replace("<id>", "제어번호 : ");
					str[i] = str[i].replace("<call>", "청구기호 : ");
					str[i] = str[i].replace("<count>", "");
					str[i] = str[i].replace("<sertitle>", "");
					str[i] = str[i].replace("<pub>", "발행사 : ");
					str[i] = str[i].replace("<date>", "발행일 : ");
					str[i] = str[i].replace("<title>", "표제 : ");
					str[i] = str[i].replace("<body>", "");
					str[i] = str[i].replace("</body>", "");
					int tmp = 0;
					if (str[i].indexOf("<br>") >= 1) {
						str[i] = str[i].replace("<br>", "");
						tmp++;
					}
					mokchaviewformlist.setContent(str[i]);
					logger.debug(i + mokchaviewformlist.getContent());
					mokchaviewlist.add(mokchaviewformlist);
					if (tmp >= 1) {
						MokchaViewListForm tmpmokchaviewlist = new MokchaViewListForm();
						tmpmokchaviewlist.setContent("");
						mokchaviewlist.add(tmpmokchaviewlist);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sqlmanager.closeConnection();

		return mokchaviewlist;
	}
}
