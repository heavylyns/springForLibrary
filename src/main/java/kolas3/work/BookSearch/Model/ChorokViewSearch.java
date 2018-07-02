package kolas3.work.BookSearch.Model;

import kolas3.common.db.ECOMySQLManager;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Form.ChorokViewForm;
import kolas3.work.BookSearch.Form.ChorokViewListForm;

public class ChorokViewSearch
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
  public ArrayList chorokview(ChorokViewForm chorokviewform)
  {
    ECOMySQLManager sqlmanager = new ECOMySQLManager();
    sqlmanager.connect();

    ResultSet rs = null;

    PreparedStatement pstmt = null;
    ArrayList chorokviewlist = null;

    String qry = "";
    if (chorokviewform.getMatcode().equals("A")) {
      qry = "select abstracts as content from se_abstracts_tbl where article_control_no = " + chorokviewform.getReckey();
    } else {
      qry = "select abstracts from bo_abstracts_tbl where rec_key = (select abstracts_key from bo_toc_common_tbl where species_key = " + chorokviewform.getReckey() + ")";
    }
    rs = sqlmanager.selectQry(qry);


    chorokviewlist = new ArrayList();
    try
    {
      while (rs.next())
      {
        ChorokViewListForm chorokviewlistform = new ChorokViewListForm();
        chorokviewlistform.setContent(rs.getString("abstracts"));
        logger.debug(chorokviewlistform.getContent());
        chorokviewlist.add(chorokviewlistform);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    sqlmanager.closeConnection();
    return chorokviewlist;
  }
}
