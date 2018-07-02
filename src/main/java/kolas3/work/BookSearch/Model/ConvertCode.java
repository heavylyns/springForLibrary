package kolas3.work.BookSearch.Model;

import kolas3.common.db.ECOMySQLManager;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertCode
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
  public String convert(String code, String codename)
  {
    ECOMySQLManager sqlmanager = new ECOMySQLManager();
    sqlmanager.connect();

    ResultSet rs = null;

    PreparedStatement pstmt = null;
    ArrayList placesearchlist = null;

    String qry = "";
    String returnresult = "";


    qry = "select a.description from cd_code_tbl a, cd_class_code_tbl b ";
    qry = qry + "where a.code like '" + code.replace(" ", "") + "%' and ";
    qry = qry + "a.code is not null and ";
    qry = qry + "b.class_name = '" + codename + "' and ";
    qry = qry + "a.class = b.class_code ";
    logger.debug(qry);
    rs = sqlmanager.selectQry(qry);
    try
    {
      while (rs.next()) {
        returnresult = rs.getString(1);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    sqlmanager.closeConnection();
    return returnresult;
  }
}
