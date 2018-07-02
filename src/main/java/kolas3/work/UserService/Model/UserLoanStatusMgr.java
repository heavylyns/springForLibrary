package kolas3.work.UserService.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.work.UserService.Form.UserLoanDelayForm;
import kolas3.work.UserService.Form.UserLoanStatusForm;

public class UserLoanStatusMgr {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOMySQLManager TempOraMgr = new ECOMySQLManager();
	private ECOMySQLManager TempOraMgr2 = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private ResultSet m_rs;
	private ResultSet Tempm_rs;
	private ResultSet Tempm_rs2;
	private boolean isCheck = true;
	private StringBuffer Qry = new StringBuffer();
	private StringBuffer TempQry = new StringBuffer();
	private StringBuffer TQry = new StringBuffer();
	private StringBuffer D_qry = new StringBuffer();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoanStatusMgr.class);

	public UserLoanStatusForm SetEnvironmentMgr(UserLoanStatusForm S_LoanStatusForm) {
		try {
			String S_use_reserv = "";
			String S_use_delay = "";

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				this.Qry.append("SELECT VALUE_1 FROM ESL_MANAGE_TBL ");
				this.Qry.append("WHERE VALUE_NAME ='예약기능사용여부'");

				this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
				if (this.m_rs.next()) {
					S_use_reserv = this.m_rs.getString("VALUE_1");
					if (S_use_reserv == null) {
						S_use_reserv = "";
						S_LoanStatusForm.setUse_reserv(S_use_reserv);
					}
					S_LoanStatusForm.setUse_reserv(S_use_reserv);
				}
				this.OraMgr.disconnect();
			}
			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				this.TempQry.append("SELECT VALUE_1 FROM ESL_MANAGE_TBL ");
				this.TempQry.append("WHERE VALUE_NAME ='반납연기기능사용여부'");

				this.m_rs = this.OraMgr.selectQry(this.TempQry.toString());
				if (this.m_rs.next()) {
					S_use_delay = this.m_rs.getString("VALUE_1");
					if (S_use_delay == null) {
						S_use_delay = "";
						S_LoanStatusForm.setUse_delay(S_use_delay);
					}
					S_LoanStatusForm.setUse_delay(S_use_delay);
				}
				this.OraMgr.disconnect();
			}
			return S_LoanStatusForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanStatusForm;
	}

	public UserLoanStatusForm LoanClassMgr(UserLoanStatusForm S_LoanStatusForm) {
		try {
			String S_reckey = "";
			String S_infeclass = "";
			String S_userno = "";

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				S_userno = S_LoanStatusForm.getUser_no();

				this.TQry.append("SELECT REC_KEY, USER_CLASS FROM CO_LOAN_USER_TBL ");
				this.TQry.append("WHERE USER_NO ='" + S_userno + "'");

				this.m_rs = this.OraMgr.selectQry(this.TQry.toString());
				if (this.m_rs.next()) {
					S_reckey = String.valueOf(this.m_rs.getInt("REC_KEY"));
					S_infeclass = this.m_rs.getString("USER_CLASS");
					if (S_reckey == null) {
						S_reckey = "";
						S_LoanStatusForm.setCouser_reckey(S_reckey);
					}
					S_LoanStatusForm.setCouser_reckey(S_reckey);
					if (S_infeclass == null) {
						S_infeclass = "";
						S_LoanStatusForm.setInferior_class(S_infeclass);
					}
					S_LoanStatusForm.setInferior_class(S_infeclass);
				}
				this.OraMgr.disconnect();
				if (S_infeclass.equals("1")) {
					this.isCheck = this.OraMgr.connect();
					if (this.isCheck) {
						String qry = "";

						qry = "SELECT REC_KEY, TO_CHAR(LOAN_STOP_DATE, 'YYYY-MM-DD') AS STOP_TIME, ";
						qry = qry + "TO_CHAR(LOAN_STOP_SET_DATE, 'YYYY-MM-DD') AS SET_STOP_TIME ";
						qry = qry + "FROM  CO_LOAN_USER_TBL ";
						qry = qry + "WHERE REC_KEY='" + S_reckey + "'";

						this.m_rs = this.OraMgr.selectQry(qry);
						if (this.m_rs.next()) {
							String stop_time = this.m_rs.getString("STOP_TIME");
							String set_stop_time = this.m_rs.getString("SET_STOP_TIME");
							if (stop_time != null) {
								S_LoanStatusForm.setLoan_stopdate(stop_time);
							}
							if (set_stop_time != null) {
								S_LoanStatusForm.setLoan_set_stopdate(set_stop_time);
							}
							this.OraMgr.disconnect();
						}
						return S_LoanStatusForm;
					}
				}
			}
			return S_LoanStatusForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanStatusForm;
	}

	public ArrayList LoanInfoListMgr(UserLoanStatusForm S_LoanStatusForm, String user_manage) {
		ArrayList TempLoanStatusList = new ArrayList();

		int S_couser_reckey = 0;
		String S_infeclass = "";

		int S_coloan_reckey = 0;
		int S_book_key = 0;

		int Temp_delay_date = 0;

		String S_title = "";
		String S_loan_date = "";
		String S_return_plan_date = "";
		String S_reservation_date = "";
		String S_reservation_expire_date = "";
		String S_return_date = "";
		String S_status = "";
		String S_delay_cnt = "";
		String S_publish_form_code = "";
		String S_loan_manage_code = "";

		String S_vol = "";

		String S_vol_code = "";

		String S_delay_date = "";
		try {
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return TempLoanStatusList;
			}
			S_couser_reckey = Integer.parseInt(S_LoanStatusForm.getCouser_reckey());
			S_infeclass = S_LoanStatusForm.getInferior_class();

			this.D_qry.append(
					"SELECT A.REC_KEY, A.BOOK_KEY, A.TITLE, A.LOAN_DATE, A.RETURN_PLAN_DATE, A.RESERVATION_DATE, A.RESERVATION_EXPIRE_DATE, ");
			this.D_qry.append("A.RETURN_DATE, A.STATUS, A.DELAY_CNT , A.PUBLISH_FORM_CODE, A.LOAN_MANAGE_CODE, B.VOL ");
			this.D_qry.append("FROM OC3.LH_STORAGE_V01 A, BO_BOOK_TBL B ");
			this.D_qry.append("WHERE A.USER_KEY = " + S_couser_reckey
					+ " AND A.STATUS IN ('0','2','3','L') AND A.BOOK_KEY = B.REC_KEY ");
			this.D_qry.append(" UNION ");
			this.D_qry.append(
					"( SELECT A.REC_KEY, A.BOOK_KEY, A.TITLE, A.LOAN_DATE, A.RETURN_PLAN_DATE, A.RESERVATION_DATE, A.RESERVATION_EXPIRE_DATE, ");
			this.D_qry.append(
					"A.RETURN_DATE, A.STATUS, A.DELAY_CNT , A.PUBLISH_FORM_CODE, A.LOAN_MANAGE_CODE, B.VOL_CODE ");
			this.D_qry.append("FROM OC3.LH_STORAGE_V01 A, SE_BOOK_TBL B ");
			this.D_qry.append("WHERE A.USER_KEY = " + S_couser_reckey
					+ " AND A.STATUS IN ('0','2','3','L') AND A.BOOK_KEY = B.REC_KEY ) ");

			this.m_rs = this.OraMgr.selectQry(this.D_qry.toString());
			while (this.m_rs.next()) {
				UserLoanStatusForm TempS_LoanStatusForm = new UserLoanStatusForm();

				TempS_LoanStatusForm.setCouser_reckey(String.valueOf(S_couser_reckey));
				TempS_LoanStatusForm.setInferior_class(S_infeclass);
				if (!S_LoanStatusForm.getUse_delay().equals("")) {
					TempS_LoanStatusForm.setUse_delay(S_LoanStatusForm.getUse_delay());
				}
				if (!S_LoanStatusForm.getUse_reserv().equals("")) {
				}
				TempS_LoanStatusForm.setUse_reserv(S_LoanStatusForm.getUse_reserv());

				S_coloan_reckey = this.m_rs.getInt("REC_KEY");
				S_book_key = this.m_rs.getInt("BOOK_KEY");
				S_title = this.m_rs.getString("TITLE");
				S_loan_date = this.m_rs.getString("LOAN_DATE");
				S_return_plan_date = this.m_rs.getString("RETURN_PLAN_DATE");
				S_reservation_date = this.m_rs.getString("RESERVATION_DATE");
				S_reservation_expire_date = this.m_rs.getString("RESERVATION_EXPIRE_DATE");
				S_return_date = this.m_rs.getString("RETURN_DATE");
				S_status = this.m_rs.getString("STATUS");
				S_delay_cnt = this.m_rs.getString("DELAY_CNT");
				S_publish_form_code = this.m_rs.getString("PUBLISH_FORM_CODE");
				S_loan_manage_code = this.m_rs.getString("LOAN_MANAGE_CODE");

				S_vol = this.m_rs.getString("VOL");
				if (S_title == null) {
					S_title = "";
				}
				if (S_loan_date == null) {
					S_loan_date = "";
				}
				if (S_return_plan_date == null) {
					S_return_plan_date = "";
				}
				if (S_reservation_date == null) {
					S_reservation_date = "";
				}
				if (S_reservation_expire_date == null) {
					S_reservation_expire_date = "";
				}
				if (S_return_date == null) {
					S_return_date = "";
				}
				if (S_status == null) {
					S_status = "";
				}
				if (S_delay_cnt == null) {
					S_delay_cnt = "";
				}
				if (S_publish_form_code == null) {
					S_publish_form_code = "";
				}
				if (S_loan_manage_code == null) {
					S_loan_manage_code = "";
				}
				if (S_vol == null) {
					S_vol = "";
				}
				TempS_LoanStatusForm.setColoan_reckey(String.valueOf(S_coloan_reckey));
				TempS_LoanStatusForm.setBook_key(String.valueOf(S_book_key));
				TempS_LoanStatusForm.setTitle(S_title);
				if (!S_status.equals("3")) {
					if ((S_loan_date != null) && (!S_loan_date.equals(""))) {
						TempS_LoanStatusForm.setLoan_date(S_loan_date.substring(0, 10));
					}
					if ((S_return_plan_date != null) && (!S_return_plan_date.equals(""))) {
						TempS_LoanStatusForm.setReturn_plan_date(S_return_plan_date.substring(0, 10));
					}
				}
				if (S_status.equals("3")) {
					if ((S_reservation_date != null) && (!S_reservation_date.equals(""))) {
						TempS_LoanStatusForm.setReservation_date(S_reservation_date.substring(0, 10));
					}
					if ((S_reservation_expire_date != null) && (!S_reservation_expire_date.equals(""))) {
						TempS_LoanStatusForm.setReservation_expire_date(S_reservation_expire_date.substring(0, 10));
					}
				}
				if ((S_return_date != null) && (!S_return_date.equals(""))) {
					TempS_LoanStatusForm.setReturn_date(S_return_date.substring(0, 10));
				}
				if (S_status.equals("0")) {
					S_status = "대출중";
				}
				if (S_status.equals("1")) {
					S_status = "반납";
				}
				if (S_status.equals("2")) {
					S_status = "반납연기";
				}
				if (S_status.equals("3")) {
					S_status = "예약중";
				}
				if (S_status.equals("4")) {
					S_status = "예약취소";
				}
				if (S_status.equals("L")) {
					S_status = "책두레";
				}
				TempS_LoanStatusForm.setStatus(S_status);
				TempS_LoanStatusForm.setDelay_cnt(S_delay_cnt);
				TempS_LoanStatusForm.setPublish_form_code(S_publish_form_code);
				TempS_LoanStatusForm.setLoan_manage_code(S_loan_manage_code);
				TempS_LoanStatusForm.setVol(S_vol);
				TempS_LoanStatusForm.setVol_code(S_vol_code);

				this.isCheck = this.TempOraMgr.connect();
				if (this.isCheck) {
					String DateQry = "";

					DateQry = "SELECT TO_CHAR(TO_DATE(SYSDATE,'YYYY/MM/DD') - TO_DATE('"
							+ TempS_LoanStatusForm.getReturn_plan_date() + "','YYYY/MM/DD')) AS DLEY_DATE ";
					DateQry = DateQry + "FROM DUAL";

					this.Tempm_rs = this.TempOraMgr.selectQry(DateQry);
					if (this.Tempm_rs.next()) {
						S_delay_date = this.Tempm_rs.getString("DLEY_DATE");
						if (S_delay_date != null) {
							Temp_delay_date = Integer.parseInt(S_delay_date);
							if (Temp_delay_date <= 0) {
								TempS_LoanStatusForm.setDelay_date("0");
							} else if (Temp_delay_date > 0) {
								TempS_LoanStatusForm.setDelay_date(String.valueOf(Temp_delay_date));
							}
						}
					}
				}
				String todaydelaycheck = todaydelaycheck(TempS_LoanStatusForm.getLoan_date(), user_manage);

				TempS_LoanStatusForm.setTodaydelaycheck(todaydelaycheck);
				TempLoanStatusList.add(TempS_LoanStatusForm);

				this.TempOraMgr.disconnect();
			}
			this.OraMgr.disconnect();

			return TempLoanStatusList;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return TempLoanStatusList;
	}

	public String LoanBookKeyMgr(String S_Reckey) {
		try {
			String S_book_key = "";
			String qry = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return "";
			}
			qry = "SELECT BOOK_KEY FROM OC3.LH_STORAGE_V01 WHERE REC_KEY='" + S_Reckey + "'";

			this.m_rs = this.OraMgr.selectQry(qry);
			if (!this.m_rs.next()) {
				return "";
			}
			S_book_key = this.m_rs.getString("BOOK_KEY");
			if (S_book_key == null) {
				return "";
			}
			this.OraMgr.disconnect();

			return S_book_key;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return "";
	}

	public UserLoanDelayForm LoanReservationMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String S_book_key = "";
			String S_reserv_usun = "";
			String qry = "";

			int S_reserve_count = 0;

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				S_book_key = S_LoanDelayForm.getBook_key();

				qry = "SELECT VALUE_1 FROM ESL_MANAGE_TBL WHERE GROUP_1='L' AND GROUP_2='열람'AND GROUP_3='공통' AND VALUE_NAME='반납연기예약우선순위'";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_reserv_usun = this.m_rs.getString("VALUE_1");
					if (S_reserv_usun != null) {
						S_LoanDelayForm.setReserv_usun(S_reserv_usun);
					}
				}
				this.OraMgr.disconnect();
			}
			if (S_LoanDelayForm.getReserv_usun().equals("1")) {
				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					qry = "";
					qry = "SELECT COUNT(*)  AS COUNT FROM OC3.LH_STORAGE_V01  WHERE BOOK_KEY='" + S_book_key
							+ "' AND STATUS='3'";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						S_reserve_count = this.m_rs.getInt("COUNT");

						S_LoanDelayForm.setReserve_count(String.valueOf(S_reserve_count));
						if (S_reserve_count > 0) {
							S_LoanDelayForm.setUser_message(" 이 자료는 대출예약이 되어 있으므로 반납연기를 할 수 없습니다. ");

							this.OraMgr.disconnect();

							return S_LoanDelayForm;
						}
					}
				}
				this.OraMgr.disconnect();
			}
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanReturnDelayMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_delaygubun = "";
			String S_bookgu = "";
			String S_manage_code = "";
			String S_reckey = "";
			String S_bookguname = "";

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				qry = "SELECT VALUE_1 FROM ESL_MANAGE_TBL WHERE GROUP_1='L' AND GROUP_2='열람'AND GROUP_3='공통' AND CLASS_ALIAS ='반납연기관리' AND VALUE_NAME='반납연기부여기준'";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_delaygubun = this.m_rs.getString("VALUE_1");
					if (S_delaygubun != null) {
						S_LoanDelayForm.setDelaygubun(S_delaygubun);
					}
				}
				this.OraMgr.disconnect();
			}
			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				S_reckey = S_LoanDelayForm.getColoan_reckey();

				qry = "";
				qry = "SELECT PUBLISH_FORM_CODE ,MANAGE_CODE FROM OC3.LH_STORAGE_V01 WHERE REC_KEY = '" + S_reckey
						+ "'";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_bookgu = this.m_rs.getString("PUBLISH_FORM_CODE");
					S_manage_code = this.m_rs.getString("MANAGE_CODE");
					if (S_bookgu != null) {
						if (S_bookgu.equals("MO")) {
							S_bookguname = "일반도서";
						} else if (S_bookgu.equals("SE")) {
							S_bookguname = "연속간행물";
						}
						S_LoanDelayForm.setBookgu(S_bookgu);
						S_LoanDelayForm.setBookguname(S_bookguname);
					}
					if (S_manage_code != null) {
						S_LoanDelayForm.setManage_code(S_manage_code);
					}
					this.OraMgr.disconnect();

					return S_LoanDelayForm;
				}
			}
			this.OraMgr.disconnect();
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanUserClassMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";

			String S_uer_no = "";
			String S_bookguname = "";
			String S_deldate2 = "";

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				S_uer_no = S_LoanDelayForm.getUser_no();
				S_bookguname = S_LoanDelayForm.getBookguname();

				qry = "SELECT POSTPONEMENT_PERIOD FROM MN_LOAN_ENV_POSREG_TBL WHERE LOAN_CLASS_CODE_KEY = ";
				qry = qry + "(SELECT REC_KEY FROM CD_CODE_TBL WHERE CLASS = 31 AND CODE = ";
				qry = qry + "(SELECT USER_CLASS_CODE FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + S_uer_no + "')) ";
				qry = qry + "AND REG_CODE_KEY = (SELECT REC_KEY FROM CD_CODE_TBL WHERE CLASS = 4 AND DESCRIPTION = '"
						+ S_bookguname + "')";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_deldate2 = this.m_rs.getString(0);
					if (S_deldate2 != null) {
						S_LoanDelayForm.setDeldate2(S_deldate2.trim());
					}
				}
			}
			this.OraMgr.disconnect();

			return S_LoanDelayForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanReturnDelayModeMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_deldate2 = "";

			String S_userno = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoanDelayForm;
			}
			S_userno = S_LoanDelayForm.getUser_no();
			S_deldate2 = S_LoanDelayForm.getDeldate2();
			if ((S_deldate2.equals("0")) || (S_deldate2 == null)) {
				qry = "SELECT POSTPONEMENT_PERIOD FROM CD_CODE_TBL WHERE CODE = ";
				qry = qry + "(SELECT TRIM(' ' FROM USER_CLASS_CODE) FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + S_userno
						+ "')";
				qry = qry + " AND CLASS = '31'";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_deldate2 = this.m_rs.getString(0);
					if (S_deldate2 != null) {
						S_LoanDelayForm.setDeldate2(S_deldate2.trim());
					}
				}
			}
			if (S_deldate2.equals("0")) {
				S_LoanDelayForm.setUser_message("반납 연기가능 일수가 0 일 입니다. 관리처에 문의 하십시오");

				this.OraMgr.disconnect();
				return S_LoanDelayForm;
			}
			this.OraMgr.disconnect();
			return S_LoanDelayForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanReturnDelayDateMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";

			String S_userno = "";
			String S_coloan_reckey = "";
			String S_deldate2 = "";
			String S_delaygubun = "";
			String S_delay_cnt = "";
			String S_delay_date = "";
			String S_delay_year = "";
			String S_delay_month = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoanDelayForm;
			}
			S_deldate2 = S_LoanDelayForm.getDeldate2();
			S_delaygubun = S_LoanDelayForm.getDelaygubun();

			S_userno = S_LoanDelayForm.getUser_no();
			S_coloan_reckey = S_LoanDelayForm.getColoan_reckey();
			if ((S_deldate2 == null) || (S_deldate2.equals(""))) {
				if (S_delaygubun.equals("0")) {
					qry = "SELECT ( '0' || DELAY_CNT) + 1 AS DELAY_CNT, TO_CHAR(RETURN_PLAN_DATE + ";
					qry = qry + "(SELECT POSTPONEMENT_PERIOD FROM CD_CODE_TBL WHERE CLASS = 31 AND CODE = ";
					qry = qry + "(SELECT USER_CLASS_CODE FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + S_userno
							+ "')), 'YYYY/MM/DD') AS DTIME ";
					qry = qry + "FROM OC3.LH_STORAGE_V01 ";
					qry = qry + "WHERE REC_KEY = '" + S_coloan_reckey + "'";
				} else if (S_delaygubun.equals("1")) {
					qry = "SELECT ( '0' || DELAY_CNT) + 1 AS DELAY_CNT, TO_CHAR(SYSDATE + ";
					qry = qry + "(SELECT POSTPONEMENT_PERIOD FROM CD_CODE_TBL WHERE CLASS = 31 AND CODE = ";
					qry = qry + "(SELECT USER_CLASS_CODE FROM CO_LOAN_USER_TBL WHERE USER_NO = '" + S_userno
							+ "')), 'YYYY/MM/DD') AS DTIME ";
					qry = qry + "FROM OC3.LH_STORAGE_V01 ";
					qry = qry + "WHERE REC_KEY = '" + S_coloan_reckey + "'";
				}
			} else if (S_delaygubun.equals("0")) {
				qry = "SELECT ( '0' || DELAY_CNT) + 1 AS DELAY_CNT, TO_CHAR(RETURN_PLAN_DATE + '" + S_deldate2
						+ "', 'YYYY/MM/DD') AS DTIME ";
				qry = qry + "FROM OC3.LH_STORAGE_V01 ";
				qry = qry + "WHERE REC_KEY = '" + S_coloan_reckey + "'";
			} else if (S_delaygubun.equals("1")) {
				qry = "SELECT ( '0' || DELAY_CNT) + 1 AS DELAY_CNT, TO_CHAR(SYSDATE + '" + S_deldate2
						+ "', 'YYYY/MM/DD') AS DTIME ";
				qry = qry + "FROM OC3.LH_STORAGE_V01 ";
				qry = qry + "WHERE REC_KEY = '" + S_coloan_reckey + "'";
			}
			this.m_rs = this.OraMgr.selectQry(qry);
			if (this.m_rs.next()) {
				S_delay_cnt = this.m_rs.getString("DELAY_CNT");
				S_delay_date = this.m_rs.getString("DTIME");
				if (S_delay_cnt != null) {
					S_LoanDelayForm.setDelay_cnt(String.valueOf(S_delay_cnt));
				}
				if (S_delay_date != null) {
					S_delay_year = S_delay_date.substring(0, 4);
					S_delay_month = S_delay_date.substring(5, 7);

					S_LoanDelayForm.setDelay_date(S_delay_date);

					S_LoanDelayForm.setDelay_year(S_delay_year);
					S_LoanDelayForm.setDelay_month(S_delay_month);
				}
				if ((S_delay_date == null) || (S_delay_date.equals(""))) {
					S_LoanDelayForm.setUser_message("반납예정일이 존재하지 않습니다.연기할수 없습니다.");

					this.OraMgr.disconnect();
					return S_LoanDelayForm;
				}
			}
			this.OraMgr.disconnect();
			return S_LoanDelayForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanReturnDelayCountMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_max_delay_cnt = "";

			int Tempmax_delay_cnt = 0;
			int S_delay_cnt = 0;

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoanDelayForm;
			}
			S_delay_cnt = Integer.parseInt(S_LoanDelayForm.getDelay_cnt());

			qry = "SELECT VALUE_1 FROM ESL_MANAGE_TBL ";
			qry = qry + "WHERE GROUP_1 = 'L' AND GROUP_2 = '열람' AND GROUP_3 = '공통' ";
			qry = qry + "AND CLASS_ALIAS = '반납연기관리' AND VALUE_NAME = '반납연기가능횟수' ";

			this.m_rs = this.OraMgr.selectQry(qry);
			if (this.m_rs.next()) {
				S_max_delay_cnt = this.m_rs.getString("VALUE_1");
				if ((S_max_delay_cnt != null) && (!S_max_delay_cnt.equals(""))) {
					Tempmax_delay_cnt = Integer.parseInt(S_max_delay_cnt);
					S_LoanDelayForm.setMax_delay_cnt(String.valueOf(Tempmax_delay_cnt));
					if (Tempmax_delay_cnt < S_delay_cnt) {
						S_LoanDelayForm
								.setUser_message("최대  반납연기  회수를 넘었습니다. 반납연기는 " + Tempmax_delay_cnt + " 회 까지 가능합니다.");

						this.OraMgr.disconnect();
						return S_LoanDelayForm;
					}
				}
			}
			this.OraMgr.disconnect();
			return S_LoanDelayForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanReturnDelayHolidayMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_holiday_gubun = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoanDelayForm;
			}
			qry = "SELECT VALUE_NAME FROM ESL_MANAGE_TBL WHERE GROUP_1='L' AND GROUP_2='기타' AND GROUP_3='공통' AND CLASS_ALIAS='관리구분별도서관설정'";

			this.m_rs = this.OraMgr.selectQry(qry);
			if (this.m_rs.next()) {
				S_holiday_gubun = this.m_rs.getString("VALUE_NAME");
				if ((S_holiday_gubun != null) && (!S_holiday_gubun.equals(""))) {
					S_LoanDelayForm.setHoliday_gubun(S_holiday_gubun);
				}
			}
			this.OraMgr.disconnect();
			return S_LoanDelayForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public UserLoanDelayForm LoanHolidayInfoMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_holiday_gubun = "";
			String S_year = "";
			String S_month = "";
			String S_manage_code = "";
			String Tempdays = "";
			String S_holiday = "";
			String S_delay_date = "";

			int count = 0;

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				S_holiday_gubun = S_LoanDelayForm.getHoliday_gubun();
				S_year = S_LoanDelayForm.getDelay_year();
				S_month = S_LoanDelayForm.getDelay_month();
				S_manage_code = S_LoanDelayForm.getManage_code();
				S_delay_date = S_LoanDelayForm.getDelay_date();
				if (S_holiday_gubun.equals("N")) {
					qry = "SELECT YEAR ,MONTH,DAYS FROM MN_LIB_HOLIDAY_TBL WHERE YEAR >= '" + S_year
							+ "' AND MONTH >= '" + S_month + "' AND MANAGE_CODE = 'MA' ORDER BY YEAR, MONTH,DAYS";
				} else if (S_holiday_gubun.equals("Y")) {
					qry = "SELECT YEAR ,MONTH,DAYS FROM MN_LIB_HOLIDAY_TBL WHERE YEAR >= '" + S_year
							+ "' AND MONTH >= '" + S_month + "' AND MANAGE_CODE = '" + S_manage_code
							+ "' ORDER BY YEAR, MONTH,DAYS";
				}
				this.m_rs = this.OraMgr.selectQry(qry);
				while (this.m_rs.next()) {
					Tempdays = this.m_rs.getString("DAYS");
					if (Tempdays != null) {
						String[] days = Tempdays.split(", ");
						S_LoanDelayForm.setDays(days);

						count = days.length;

						this.isCheck = this.TempOraMgr.connect();
						if (this.isCheck) {
							for (int i = 0; i < count; i++) {
								S_year = this.m_rs.getString("YEAR");
								S_month = this.m_rs.getString("MONTH");
								if ((S_year != null) && (S_month != null)) {
									S_LoanDelayForm.setYear(S_year);
									S_LoanDelayForm.setMonth(S_month);

									String TempDay = "";
									String TempMonth = "";
									if (S_month.length() == 2) {
										TempMonth = S_month.substring(0, 2);
									}
									if (S_month.length() == 1) {
										TempMonth = S_month.substring(0, 1);
									}
									if (TempMonth.length() == 1) {
										TempMonth = "0" + TempMonth;
									}
									if (days[i].length() == 2) {
										TempDay = days[i].substring(0, 2);
									}
									if (days[i].length() == 1) {
										TempDay = days[i].substring(0, 1);
									}
									if (TempDay.length() == 1) {
										TempDay = "0" + TempDay;
									}
									S_holiday = S_year + "/" + TempMonth + "/" + TempDay;

									S_LoanDelayForm.setHoliday(S_holiday);
									logger.debug("딜레이날짜" + S_delay_date);
									logger.debug("휴관날짜" + S_holiday);
									if (S_delay_date.equals(S_holiday)) {
										qry = "";
										qry = "SELECT TO_DATE('" + S_delay_date
												+ "', 'YYYY/MM/DD')+1 AS DELAY_TIME FROM DUAL";

										this.Tempm_rs = this.TempOraMgr.selectQry(qry);
										if (this.Tempm_rs.next()) {
											S_delay_date = this.Tempm_rs.getString("DELAY_TIME");
											if (S_delay_date.length() >= 11) {
												S_delay_date = S_delay_date.substring(0, 10);
												S_delay_date = S_delay_date.replace("-", "/");
											}
											if (S_delay_date != null) {
												S_LoanDelayForm.setDelay_date(S_delay_date);
											}
										}
									}
								}
							}
							this.TempOraMgr.disconnect();
						}
					}
				}
				this.OraMgr.disconnect();
			}
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoanDelayForm;
	}

	public boolean LoanDelayUpdateMgr(UserLoanDelayForm S_LoanDelayForm) {
		try {
			String qry = "";
			String S_coloan_reckey = "";
			String S_delay_date = "";

			int UpdateCheck = 0;
			int S_delay_cnt = 0;

			//--- start add by altobiz 2016.10.12
			String cur_date = "";
			String uNo =  S_LoanDelayForm.getUser_no();
			String libcode =  "141011";
			String book_key = S_LoanDelayForm.getBook_key();
			String kl_yn = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}

			qry = "Select KL_MEMBER_YN, TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') as CUR_DATE ";
			qry += "From CO_LOAN_USER_TBL where user_no = '"+uNo+"'";
			ResultSet rs = this.OraMgr.selectQry(qry);
			if(rs.next()){
				kl_yn = rs.getString("KL_MEMBER_YN");
				cur_date = rs.getString("CUR_DATE");
			}
			this.OraMgr.disconnect();
			//--- end add by altobiz 2016.10.12

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}

			S_coloan_reckey = S_LoanDelayForm.getColoan_reckey();
			S_delay_date = S_LoanDelayForm.getDelay_date();
			S_delay_cnt = Integer.parseInt(S_LoanDelayForm.getDelay_cnt());

			qry = "UPDATE LS_WORK_T01 SET RETURN_PLAN_DATE = TO_DATE('" + S_delay_date + "', 'YYYY/MM/DD'), ";
			qry = qry + "DELAY_CNT = '" + S_delay_cnt + "', DELAY_RETURN_DATE = TO_DATE(SYSDATE, 'YYYY/MM/DD'), ";
			qry = qry + "PRE_RETURN_PLAN_DATE = RETURN_PLAN_DATE, STATUS='2', LAST_WORK='WEB반납연기" + S_delay_date + "' ";
			qry = qry + "WHERE REC_KEY='" + S_coloan_reckey + "'";

			UpdateCheck = this.OraMgr.updateQry(qry);

			this.OraMgr.commit();
			if (UpdateCheck == 0) {
				return false;
			}

			//--- start add by altobiz 2016.10.12
			if (kl_yn.equals("Y")) {
				//DB 연결
				isCheck = this.TempOraMgr.connect();
				
				//DB 접속 성공한 경우 
				if(isCheck == true)
				{
					String lFrame = "";
					lFrame = lFrame+"<Frame><Header><Command>IL_K23_LOC_B01_SERVICE</Command>";
					lFrame = lFrame+"<Reiteration>N</Reiteration>";
					lFrame = lFrame+"<ClientIp>211.253.88.135</ClientIp>";
					lFrame = lFrame+"</Header>";
					lFrame = lFrame+"<Body><Body1><Record0 Count=7>";
					lFrame = lFrame+"<대출도서관>"+libcode+"</대출도서관>";
					lFrame = lFrame+"<통합대출자번호>"+uNo+"</통합대출자번호>";
					lFrame = lFrame+"<반납예정일>"+S_delay_date+" 23:59:59</반납예정일>";
					lFrame = lFrame+"<반납연기일>"+cur_date+"</반납연기일>";
					lFrame = lFrame+"<상태>2</상태>";
					lFrame = lFrame+"<로컬KEY>"+S_coloan_reckey+"</로컬KEY>";
					lFrame = lFrame+"<마지막작업>"+cur_date+" 홈페이지 반납연기</마지막작업>";
					lFrame = lFrame+"</Record0></Body1></Body></Frame>";
					
					String sql = "insert into KL_LOCAL_TEMP_INFO_TBL(REC_KEY, REQUEST_FRAME, RECORD_DATE, UPLOAD_TRY_CNT, FIRST_WORK, STATUS) VALUES (KOLAS.ESL_SEQ.NEXTVAL, '"+lFrame+"', SYSDATE, '0', '"+cur_date+"@ 홈페이지 반납연기','0')";
					//데이터 DB INSERT
					this.isCheck = this.TempOraMgr.insertQry(sql);
System.out.println("############## 책이음 서비스에 반납연기 반영 ##############");
System.out.println(lFrame + "\n\n");
					this.TempOraMgr.commit();
					//DB 연결 해제
					this.TempOraMgr.disconnect();
				}					
			}
			//--- end add by altobiz 2016.10.12

			this.OraMgr.disconnect();
			return true;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		label215: return false;
	}

	public boolean LoanReservationCancelMgr(UserLoanDelayForm S_LoanReserCacelForm) {
		try {
			int reserve_count = 0;
			int UpdateCheck = 0;
			int sucount = 0;

			String rec_key = "";
			String qry = "";

			String S_status = "";
			String S_log2data = "";
			String S_userkey = "";

			String S_userno = "";

			String last_work = "";
			String status = "";
			String reserve_cancel_date = "";

			String TempMessage = "";

			String[] S_RecKeySet = S_LoanReserCacelForm.getReserv_ca();

			S_userno = S_LoanReserCacelForm.getUser_no();
			reserve_count = S_RecKeySet.length;
			for (int i = 0; i < reserve_count; i++) {
				if (this.isCheck) {
					this.isCheck = this.OraMgr.connect();
					if ((S_RecKeySet[i] != null) && (!S_RecKeySet[i].equals(""))) {
						qry = "SELECT STATUS, USER_KEY FROM OC3.LH_STORAGE_V01 WHERE REC_KEY = '" + S_RecKeySet[i]
								+ "'";

						this.m_rs = this.OraMgr.selectQry(qry);
						if (this.m_rs.next()) {
							S_status = this.m_rs.getString("STATUS");
							S_userkey = this.m_rs.getString("USER_KEY");
						} else {
							S_LoanReserCacelForm.setUser_message("√ 해당하는 이용자 정보가 존재하지 않습니다.");

							continue;
						}
						this.OraMgr.disconnect();
						if (S_status.equals("3")) {
							this.isCheck = this.OraMgr.connect();
							if (this.isCheck) {
								qry = "";
								qry = "UPDATE CO_LOAN_USER_TBL SET RESERVATION_COUNT = RESERVATION_COUNT-1 WHERE REC_KEY = '"
										+ S_userkey + "'";

								UpdateCheck = this.OraMgr.updateQry(qry);

								this.OraMgr.commit();
								this.OraMgr.disconnect();
								if (UpdateCheck != 0) {
									this.isCheck = this.OraMgr.connect();
									if (this.isCheck) {
										S_log2data = DateTime.getTimeStampString() + "-" + S_userno + "-WEB예약취소";

										qry = "";
										qry = "UPDATE LS_WORK_T01 SET LAST_WORK = '" + S_log2data
												+ "', STATUS = '4', RESERVE_CANCEL_DATE = TO_DATE(SYSDATE, 'YYYY/MM/DD') ";
										qry = qry + "WHERE REC_KEY = '" + S_RecKeySet[i] + "'";

										UpdateCheck = this.OraMgr.updateQry(qry);
										if (UpdateCheck != 0) {
											this.OraMgr.commit();
											this.OraMgr.disconnect();
											sucount++;
										}
									}
								}
							}
						}
					}
				}
			}
			TempMessage = "전체: " + reserve_count + "건" + "  " + "완료: " + sucount + "  건";

			S_LoanReserCacelForm.setScount_message(TempMessage);
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return true;
	}

	public String todaydelaycheck(String tmploandate, String user_manage) {
		DateTime time = new DateTime();
		String re = "Y";

		this.isCheck = this.TempOraMgr2.connect();
		if (this.isCheck) {
			String qry = "";

			qry = "SELECT VALUE_1 FROM ESL_MANAGE_TBL WHERE CLASS_ALIAS='반납연기관리' AND VALUE_NAME='당일반납연기허용유무'";

			this.Tempm_rs2 = this.TempOraMgr2.selectQry(qry);
			try {
				if (this.Tempm_rs2.next()) {
					re = this.Tempm_rs2.getString("VALUE_1");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.TempOraMgr2.disconnect();
		if (re.equals("Y")) {
			return re;
		}
		String tmptime = time.getDateString();
		tmptime = tmptime.replace("/", "-");
		tmptime = tmptime.replace(" ", "");
		logger.debug("tmptime" + tmptime);
		logger.debug("tmploandate" + tmploandate);
		if (tmptime.equals(tmploandate)) {
			re = "N";
		} else {
			re = "Y";
		}
		logger.debug("당일 반납가능여부: " + re);
		return re;
	}
}
