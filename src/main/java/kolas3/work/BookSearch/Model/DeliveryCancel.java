package kolas3.work.BookSearch.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;

public class DeliveryCancel
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
  public void cancel(String selbook)
  {
    ECOMySQLManager sqlmanager = new ECOMySQLManager();
    String qry = "DELETE FROM CO_DELIVERY_TBL WHERE REC_KEY = " + selbook;
    sqlmanager.connect();
    sqlmanager.deleteQry(qry);
    sqlmanager.disconnect();
  }
}
