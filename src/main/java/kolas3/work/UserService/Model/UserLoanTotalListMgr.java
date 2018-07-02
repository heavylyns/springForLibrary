package kolas3.work.UserService.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.work.UserService.Form.UserLoanTotalForm;

public class UserLoanTotalListMgr {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOMySQLManager TempOraMgr = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private ResultSet m_rs;
	private ResultSet Tempm_rs;
	private boolean isCheck = true;
	private StringBuffer Qry = new StringBuffer();
	private ArrayList TempAraay = new ArrayList();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoanTotalListMgr.class);

	public ArrayList getTempAraay() {
		return this.TempAraay;
	}

	public void setTempAraay(ArrayList tempAraay) {
		this.TempAraay = tempAraay;
	}

	public ArrayList LoanListMgr(UserLoanTotalForm S_LoanTotalForm) {
		ArrayList ResultLoantList = new ArrayList();
		try {
			String qry = "";

			String term_search_flag = "";
			String user_key = "";

			String s_year = S_LoanTotalForm.getS_year();
			String s_month = S_LoanTotalForm.getS_month();
			String s_day = S_LoanTotalForm.getS_day();
			String e_year = S_LoanTotalForm.getE_year();
			String e_month = S_LoanTotalForm.getE_month();
			String e_day = S_LoanTotalForm.getE_day();
			String select_field = S_LoanTotalForm.getSelect_field();

			String last_day_f = "";
			String last_day_s = "";
			String DD = "";

			String yy_f = "";
			String mm_f = "";
			String dd_f = "";
			String yy_s = "";
			String mm_s = "";
			String dd_s = "";

			String user_no = S_LoanTotalForm.getUser_no();
			String ch_date_l = "";
			String ch_date_r = "";

			int S_total_loancount = Integer.parseInt(S_LoanTotalForm.getTotal_loancount());
			int S_total_pagecount = Integer.parseInt(S_LoanTotalForm.getTotal_pagecount());
			int S_current_pagecount = Integer.parseInt(S_LoanTotalForm.getCurrent_pagecount());
			int S_prev_page = Integer.parseInt(S_LoanTotalForm.getPrev_page());
			int S_next_page = Integer.parseInt(S_LoanTotalForm.getNext_page());
			int S_listview_rowcount = Integer.parseInt(S_LoanTotalForm.getListview_rowcount());
			int S_listview_pagecount = Integer.parseInt(S_LoanTotalForm.getListview_pagecount());
			int S_pageGroupStart = Integer.parseInt(S_LoanTotalForm.getPageGroupStart());
			int S_pageGroupEnd = Integer.parseInt(S_LoanTotalForm.getPageGroupEnd());
			int S_width_page = Integer.parseInt(S_LoanTotalForm.getWidth_page());

			term_search_flag = S_LoanTotalForm.getTerm_search_flag();
			if (term_search_flag.equals("search")) {
				logger.debug("검색인 경우");
				if ((!s_year.equals("")) && (!s_month.equals("")) && (!e_year.equals("")) && (!e_month.equals(""))) {
					ch_date_l = s_year + "/" + s_month + "/01";
					ch_date_r = e_year + "/" + e_month + "/01";

					this.isCheck = this.OraMgr.connect();
					if (this.isCheck) {
						qry = "SELECT TO_CHAR(LAST_DAY(TO_DATE('" + ch_date_l + "','YYYY/MM/DD')),'YYYY/MM/DD'), ";
						qry = qry + "TO_CHAR(LAST_DAY(TO_DATE('" + ch_date_r + "','YYYY/MM/DD')),'YYYY/MM/DD'), ";
						qry = qry + "TO_CHAR(SYSDATE,'DD') FROM DUAL";

						this.m_rs = this.OraMgr.selectQry(qry);
						if (this.m_rs.next()) {
							last_day_f = this.m_rs.getString(1);
							last_day_s = this.m_rs.getString(2);
							DD = this.m_rs.getString(3);

							yy_f = last_day_f.substring(0, 4);
							mm_f = last_day_f.substring(5, 7);
							dd_f = last_day_f.substring(8, 10);
							yy_s = last_day_s.substring(0, 4);
							mm_s = last_day_s.substring(5, 7);
							dd_s = last_day_s.substring(8, 10);
							if ((s_day == null) || (e_day == null) || (s_day.equals("")) || (e_day.equals(""))) {
								s_day = DD;
								e_day = DD;
							}
						}
						this.OraMgr.disconnect();

						this.isCheck = this.OraMgr.connect();
						if (this.isCheck) {
							qry = "";
							qry = "SELECT REC_KEY FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + user_no + "'";

							this.m_rs = this.OraMgr.selectQry(qry);
							if (this.m_rs.next()) {
								user_key = this.m_rs.getString("REC_KEY");
							}
							this.OraMgr.disconnect();
						}
					}
				}
			} else if (term_search_flag.equals("default")) {
				logger.debug("검색이 아닌경우");

				this.isCheck = this.OraMgr.connect();

				ch_date_l = this.DateMgr.getDateTrString() + "/01";
				ch_date_r = this.DateMgr.getDateTrString() + "/01";
				if (this.isCheck) {
					qry = "SELECT TO_CHAR(LAST_DAY(TO_DATE('" + ch_date_l + "','YYYY/MM/DD')),'YYYY/MM/DD'), ";
					qry = qry + "TO_CHAR(LAST_DAY(TO_DATE('" + ch_date_r + "','YYYY/MM/DD')),'YYYY/MM/DD'), ";
					qry = qry + "TO_CHAR(SYSDATE,'DD') FROM DUAL";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						last_day_f = this.m_rs.getString(1);
						last_day_s = this.m_rs.getString(2);
						DD = this.m_rs.getString(3);

						yy_f = last_day_f.substring(0, 4);
						mm_f = last_day_f.substring(5, 7);
						dd_f = last_day_f.substring(8, 10);
						yy_s = last_day_s.substring(0, 4);
						mm_s = last_day_s.substring(5, 7);
						dd_s = last_day_s.substring(8, 10);
						if ((s_day == null) || (e_day == null) || (s_day.equals("")) || (e_day.equals(""))) {
							s_day = DD;
							e_day = DD;
						}
					}
					this.OraMgr.disconnect();

					this.isCheck = this.OraMgr.connect();
					if (this.isCheck) {
						qry = "";
						qry = "SELECT REC_KEY FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + user_no + "'";

						this.m_rs = this.OraMgr.selectQry(qry);
						if (this.m_rs.next()) {
							user_key = this.m_rs.getString("REC_KEY");
						}
						this.OraMgr.disconnect();
					}
				}
			}
			if (term_search_flag.equals("default")) {
				logger.debug("검색이 아닌경우");

				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					qry = "";
					qry = "SELECT COUNT(*) AS COUNT FROM OC3.LH_STORAGE_V01 WHERE USER_KEY ='" + user_key
							+ "' AND STATUS = '1'";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						S_total_loancount = this.m_rs.getInt("COUNT");
					}
					this.OraMgr.disconnect();
				}
			} else if (term_search_flag.equals("search")) {
				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					logger.debug("검색조건==>" + s_year + "/" + s_month + "/" + s_day + select_field);

					qry = "";
					qry = "SELECT COUNT(*) AS COUNT FROM OC3.LH_STORAGE_V01 WHERE USER_KEY = '" + user_key
							+ "' AND STATUS = '1' ";
					qry = qry + "AND TO_DATE('" + s_year + "/" + s_month + "/" + s_day + "','YYYY/MM/DD') <= "
							+ select_field + " AND TO_DATE('" + e_year + "/" + e_month + "/" + e_day
							+ "','YYYY/MM/DD') >= " + select_field;

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						S_total_loancount = this.m_rs.getInt("COUNT");
					}
					this.OraMgr.disconnect();
				}
			}
			if (S_total_loancount == 0) {
				return ResultLoantList;
			}
			S_total_pagecount = S_total_loancount / S_listview_pagecount;

			logger.debug("//전체 대출 내역 도서건수===>" + S_total_loancount);
			if ((S_total_loancount % 10 != 0) && (S_total_pagecount != 0)) {
				S_total_pagecount++;
			}
			logger.debug("//전체 대출 내역 페이지  건수===>" + S_total_pagecount);
			if (S_total_pagecount == 0) {
				S_total_pagecount = 1;
			}
			if (S_total_loancount == 0) {
				S_LoanTotalForm.setTotal_pagecount(String.valueOf(S_total_pagecount));

				return ResultLoantList;
			}
			int Temp_Rnum_First = S_total_loancount - S_current_pagecount * S_listview_rowcount + 1;
			int Temp_Rnum_Second = S_total_loancount - (S_current_pagecount - 1) * S_listview_rowcount;

			S_width_page = (int) Math.floor((S_current_pagecount - 1) / S_listview_pagecount + 1);

			S_pageGroupStart = (S_width_page - 1) * S_listview_pagecount + 1;
			S_pageGroupEnd = S_width_page * S_listview_pagecount;
			if (S_total_pagecount < S_pageGroupEnd) {
				S_pageGroupEnd = S_total_pagecount;
			}
			S_LoanTotalForm.setTerm_search_flag(term_search_flag);
			S_LoanTotalForm.setUser_key(user_key);
			S_LoanTotalForm.setS_year(s_year);
			S_LoanTotalForm.setS_month(s_month);
			S_LoanTotalForm.setS_day(s_day);
			S_LoanTotalForm.setE_year(e_year);
			S_LoanTotalForm.setE_month(e_month);
			S_LoanTotalForm.setE_day(e_day);
			S_LoanTotalForm.setSelect_field(select_field);
			S_LoanTotalForm.setLast_day_f(last_day_f);
			S_LoanTotalForm.setLast_day_s(last_day_s);
			S_LoanTotalForm.setDd(DD);
			S_LoanTotalForm.setYy_f(yy_f);
			S_LoanTotalForm.setYy_s(yy_s);
			S_LoanTotalForm.setMm_f(mm_f);
			S_LoanTotalForm.setMm_s(mm_s);
			S_LoanTotalForm.setDd_f(dd_f);
			S_LoanTotalForm.setDd_s(dd_s);

			S_LoanTotalForm.setTotal_loancount(String.valueOf(S_total_loancount));
			S_LoanTotalForm.setPageGroupEnd(String.valueOf(S_pageGroupEnd));
			S_LoanTotalForm.setPageGroupStart(String.valueOf(S_pageGroupStart));
			S_LoanTotalForm.setPrev_page(String.valueOf(S_prev_page));
			S_LoanTotalForm.setNext_page(String.valueOf(S_next_page));
			S_LoanTotalForm.setListview_pagecount(String.valueOf(S_listview_pagecount));
			S_LoanTotalForm.setListview_rowcount(String.valueOf(S_listview_rowcount));
			S_LoanTotalForm.setCurrent_pagecount(String.valueOf(S_current_pagecount));
			S_LoanTotalForm.setTotal_pagecount(String.valueOf(S_total_pagecount));
			S_LoanTotalForm.setWidth_page(String.valueOf(S_width_page));
			S_LoanTotalForm.setUser_no(String.valueOf(user_no));

			this.TempAraay.add(S_LoanTotalForm);
			if (term_search_flag.equals("search")) {
				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					logger.debug("검색 조건 탐색");
					qry = "";
					qry = "SELECT ROWNUM AS RNUM, REC_KEY, BOOK_KEY, TITLE, LOAN_DATE, RETURN_DATE FROM ";
					qry = qry + "(SELECT ROWNUM AS RNUM, REC_KEY, BOOK_KEY, TITLE, LOAN_DATE, RETURN_DATE ";
					qry = qry
							+ "FROM (SELECT REC_KEY, BOOK_KEY, TITLE, RETURN_DATE, TO_CHAR(LOAN_DATE,'YYYY/MM/DD') AS LOAN_DATE FROM OC3.LH_STORAGE_V01 ";
					qry = qry + "WHERE USER_KEY = '" + user_key + "' AND STATUS in  ('1','R') ";
					qry = qry + "AND TO_DATE('" + s_year + "/" + s_month + "/" + s_day + "','YYYY/MM/DD') <= "
							+ select_field + " AND TO_DATE('" + e_year + "/" + e_month + "/" + e_day
							+ "','YYYY/MM/DD') >= " + select_field + " ";
					qry = qry + "ORDER BY LOAN_DATE DESC";
					qry = qry + ")) WHERE (RNUM >= (" + S_current_pagecount + "-1)*" + S_listview_pagecount
							+ " + 1) AND (RNUM <= " + S_current_pagecount + "*" + S_listview_pagecount + ") ";
					qry = qry + "ORDER BY LOAN_DATE DESC";

					this.m_rs = this.OraMgr.selectQry(qry);
					while (this.m_rs.next()) {
						UserLoanTotalForm NewLoanTotalForm = new UserLoanTotalForm();
						String TempReturn = "";
						String TempLoan = "";

						NewLoanTotalForm.setTitle(this.m_rs.getString("TITLE"));
						NewLoanTotalForm.setRownum(this.m_rs.getString("RNUM"));
						NewLoanTotalForm.setUser_key(this.m_rs.getString("REC_KEY"));
						NewLoanTotalForm.setBook_key(this.m_rs.getString("BOOK_KEY"));

						TempLoan = this.m_rs.getString("LOAN_DATE");
						TempReturn = this.m_rs.getString("RETURN_DATE");
						if (TempReturn == null) {
							TempReturn = "";
						}
						if (TempLoan == null) {
							TempLoan = "";
						}
						if (!TempReturn.equals("")) {
							NewLoanTotalForm.setReturn_date(TempReturn.substring(0, 10));
						}
						if (!TempLoan.equals("")) {
							NewLoanTotalForm.setLoan_date(TempLoan.replaceAll("/", "-"));
						}
						ResultLoantList.add(NewLoanTotalForm);
					}
					this.OraMgr.disconnect();

					return ResultLoantList;
				}
			} else if (term_search_flag.equals("default")) {
				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					logger.debug("일반 탐색");
					qry = "";
					qry = "SELECT ROWNUM AS RNUM, REC_KEY, BOOK_KEY, TITLE, LOAN_DATE, RETURN_DATE FROM ";
					qry = qry + "(SELECT ROWNUM AS RNUM, REC_KEY, BOOK_KEY, TITLE, LOAN_DATE, RETURN_DATE ";
					qry = qry
							+ "FROM (SELECT REC_KEY, BOOK_KEY, TITLE, TO_CHAR(RETURN_DATE, 'YYYY/MM/DD') AS RETURN_DATE, TO_CHAR(LOAN_DATE,'YYYY/MM/DD') AS LOAN_DATE FROM OC3.LH_STORAGE_V01 ";
					qry = qry + "WHERE USER_KEY = '" + user_key + "' AND STATUS in ('1','R') ";
					qry = qry + "ORDER BY LOAN_DATE DESC";
					qry = qry + ")) WHERE (RNUM >= (" + S_current_pagecount + "-1)*" + S_listview_pagecount
							+ " + 1) AND (RNUM <= " + S_current_pagecount + "*" + S_listview_pagecount + ") ";
					qry = qry + "ORDER BY LOAN_DATE DESC";

					this.m_rs = this.OraMgr.selectQry(qry);
					while (this.m_rs.next()) {
						UserLoanTotalForm NewLoanTotalForm = new UserLoanTotalForm();
						String TempReturn = "";
						String TempLoan = "";

						NewLoanTotalForm.setTitle(this.m_rs.getString("TITLE"));
						NewLoanTotalForm.setRownum(this.m_rs.getString("RNUM"));
						NewLoanTotalForm.setUser_key(this.m_rs.getString("REC_KEY"));
						NewLoanTotalForm.setBook_key(this.m_rs.getString("BOOK_KEY"));

						TempLoan = this.m_rs.getString("LOAN_DATE");
						TempReturn = this.m_rs.getString("RETURN_DATE");
						if (TempReturn == null) {
							TempReturn = "";
						}
						if (TempLoan == null) {
							TempLoan = "";
						}
						if (!TempReturn.equals("")) {
							NewLoanTotalForm.setReturn_date(TempReturn.replaceAll("/", "-"));
						}
						if (!TempLoan.equals("")) {
							NewLoanTotalForm.setLoan_date(TempLoan.replaceAll("/", "-"));
						}
						ResultLoantList.add(NewLoanTotalForm);
					}
					this.OraMgr.disconnect();

					return ResultLoantList;
				}
			}
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return ResultLoantList;
	}
}
