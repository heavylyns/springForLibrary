package kolas3.work.UserService.Model;

import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.common.utils.EncodingSHA256;
import kolas3.common.utils.StringChecker;
import kolas3.work.UserService.Form.UserLoginForm;

public class UserLoginMgr {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private EncodingSHA256 Encoding = new EncodingSHA256();
	private StringChecker StrMgr = new StringChecker();
	private ResultSet m_rs;
	private boolean isCheck = true;
	private StringBuffer Qry = new StringBuffer();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoginMgr.class);

	public UserLoginForm UserLoginCheck(UserLoginForm S_LoginForm) {
		try {
			String TempUSerID = "";
			String TempUserPwd = "";
			String user_id = "";
			String user_pwd = "";
			String qry = "";
			String TempUser_no = "";
			String TempUser_manage = "";
			String TempName = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoginForm;
			}
			user_id = S_LoginForm.getUser_id();
			user_pwd = S_LoginForm.getUser_pwd();

			this.Qry.append("SELECT ");
			this.Qry.append("USER_ID, PASSWORD ");
			this.Qry.append("FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE USER_ID='" + user_id + "'");

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				TempUSerID = this.m_rs.getString("USER_ID");
				TempUserPwd = this.m_rs.getString("PASSWORD");
				logger.debug(TempUSerID);
				logger.debug(TempUserPwd);
				logger.debug(user_id);
				logger.debug(user_pwd);
				if ((TempUSerID.equals(user_id)) && (TempUserPwd.equals(user_pwd))) {
					S_LoginForm.setIdcheck("SUCCESS");
				}
				this.OraMgr.disconnect();
				logger.debug("success?" + S_LoginForm.getIdcheck());

				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					qry = "SELECT USER_NO, MANAGE_CODE ,NAME FROM CO_LOAN_USER_TBL ";
					qry = qry + "WHERE USER_ID='" + user_id + "'";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						TempUser_no = this.m_rs.getString("USER_NO");
						TempUser_manage = this.m_rs.getString("MANAGE_CODE");
						TempName = this.m_rs.getString("Name");
						S_LoginForm.setUser_manage(TempUser_manage);
						S_LoginForm.setUser_no(TempUser_no);
						S_LoginForm.setName(TempName);

						this.OraMgr.disconnect();

						return S_LoginForm;
					}
				}
			}
			this.OraMgr.disconnect();

			return S_LoginForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoginForm;
	}

	public UserLoginForm UserNoCheck(UserLoginForm S_LoginForm) {
		try {
			String TempUSerID = "";
			String TempUserPwd = "";
			String user_id = "";
			String user_pwd = "";
			String qry = "";
			String TempUser_no = "";
			String TempUser_manage = "";
			String TempName = "";
			String TempCivil_no = "";
			String s_gpin_hash = "";
			String s_ipin_hash = "";
			
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoginForm;
			}
			TempUser_no = S_LoginForm.getUser_no();
			TempCivil_no = S_LoginForm.getCivil_no();
			// 암호화
			TempCivil_no = Encoding.encodingSHA256(TempCivil_no).toUpperCase();
			logger.debug("SHA256 암호화된 비밀번호 ==============================" + TempCivil_no);
			
			this.Qry.append("SELECT ");
			this.Qry.append("USER_NO ");
			this.Qry.append("FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE USER_NO='" + TempUser_no + "'");
			this.Qry.append("AND CARD_PASSWORD='" + TempCivil_no + "'");
			//this.Qry.append("AND SUBSTR(REPLACE(CIVIL_NO,'-',''),LENGTH(REPLACE(CIVIL_NO,'-',''))-6)=REPLACE('" + TempCivil_no + "','-','')");

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				String Result_Userno = "";

				Result_Userno = this.m_rs.getString("USER_NO");
				S_LoginForm.setIdcheck("SUCCESS");

				this.OraMgr.disconnect();

				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					qry = "SELECT ";
					qry = qry + "USER_ID, PASSWORD, MANAGE_CODE, NAME, GPIN_HASH, IPIN_HASH ";
					qry = qry + "FROM CO_LOAN_USER_TBL ";
					qry = qry + "WHERE USER_NO='" + Result_Userno + "'";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						TempUSerID = this.m_rs.getString("USER_ID");
						TempUserPwd = this.m_rs.getString("PASSWORD");
						TempUser_manage = this.m_rs.getString("MANAGE_CODE");
						TempName = this.m_rs.getString("NAME");
						s_gpin_hash = this.m_rs.getString("GPIN_HASH");
						s_ipin_hash = this.m_rs.getString("IPIN_HASH");
						S_LoginForm.setUser_manage(TempUser_manage);
						S_LoginForm.setUser_id(TempUSerID);
						S_LoginForm.setUser_pwd(TempUserPwd);
						S_LoginForm.setName(TempName);
						S_LoginForm.setGpin_hash(s_gpin_hash);
						S_LoginForm.setIpin_hash(s_ipin_hash);

						this.OraMgr.disconnect();

						return S_LoginForm;
					}
				}
			}
			this.OraMgr.disconnect();

			return S_LoginForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoginForm;
	}

	public UserLoginForm UserCardCheck(UserLoginForm S_LoginForm) {
		try {
			String TempUSerID = "";
			String TempUserPwd = "";
			String user_id = "";
			String user_pwd = "";
			String qry = "";
			String TempUser_no = "";
			String TempUser_manage = "";
			String TempName = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_LoginForm;
			}
			user_id = S_LoginForm.getUser_card();
			user_pwd = S_LoginForm.getPass_card();

			this.Qry.append("SELECT ");
			this.Qry.append("USER_NO, CARD_PASSWORD ");
			this.Qry.append("FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE USER_NO='" + user_id + "'");

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				TempUSerID = this.m_rs.getString("USER_NO");
				TempUserPwd = this.m_rs.getString("CARD_PASSWORD");
				if ((TempUSerID.equals(user_id)) && (TempUserPwd.equals(user_pwd))) {
					S_LoginForm.setIdcheck("SUCCESS");
				}
				this.OraMgr.disconnect();

				this.isCheck = this.OraMgr.connect();
				if (this.isCheck) {
					qry = "SELECT USER_NO, MANAGE_CODE ,NAME FROM CO_LOAN_USER_TBL ";
					qry = qry + "WHERE USER_NO='" + user_id + "'";

					this.m_rs = this.OraMgr.selectQry(qry);
					if (this.m_rs.next()) {
						TempUser_no = this.m_rs.getString("USER_NO");
						TempUser_manage = this.m_rs.getString("MANAGE_CODE");
						TempName = this.m_rs.getString("Name");
						S_LoginForm.setUser_manage(TempUser_manage);
						S_LoginForm.setUser_no(TempUser_no);
						S_LoginForm.setName(TempName);

						this.OraMgr.disconnect();

						return S_LoginForm;
					}
				}
			}
			this.OraMgr.disconnect();

			return S_LoginForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_LoginForm;
	}

	public String UserIdSearch(String S_userName, String S_civilNo1, String S_civilNo2) {
		try {
			String TempUSerID = "";
			String User_CivilNo = S_civilNo1 + "-" + S_civilNo2;

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				this.Qry.append("SELECT ");
				this.Qry.append("USER_ID ");
				this.Qry.append("FROM CO_LOAN_USER_TBL ");
				this.Qry.append("WHERE NAME='" + S_userName + "' ");
				this.Qry.append("AND CIVIL_NO='" + User_CivilNo + "'");

				this.LogMgr.fatal(this.Qry.toString());

				this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
				if (this.m_rs.next()) {
					TempUSerID = this.m_rs.getString("USER_ID");
					if (TempUSerID == null) {
						return "-1";
					}
					return TempUSerID;
				}
			}
			return "-1";
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return "-1";
	}

	public String UserPwdSearch(String S_userId, String S_userName, String S_civilNo1, String S_civilNo2) {
		try {
			String TempUSerPwd = "";
			String User_CivilNo = S_civilNo1 + "-" + S_civilNo2;

			String TempStr = "";
			String Passhidden = "";
			String PassSubstr = "";

			int Passlength = 0;
			int TailLength = 0;

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				this.Qry.append("SELECT ");
				this.Qry.append("PASSWORD ");
				this.Qry.append("FROM CO_LOAN_USER_TBL ");
				this.Qry.append("WHERE USER_ID='" + S_userId + "' ");
				this.Qry.append("AND NAME='" + S_userName + "' ");
				this.Qry.append("AND CIVIL_NO='" + User_CivilNo + "'");

				this.LogMgr.fatal(this.Qry.toString());

				this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
				if (this.m_rs.next()) {
					TempUSerPwd = this.m_rs.getString("PASSWORD");
					if (TempUSerPwd == null) {
						return "-1";
					}
					Passlength = TempUSerPwd.length();
					if (Passlength >= 4) {
						PassSubstr = TempUSerPwd.substring(0, 3);
						Passhidden = TempUSerPwd.substring(4);
						TailLength = Passhidden.length();
						for (int idx = 0; idx <= TailLength; idx++) {
							TempStr = TempStr + "*";
						}
						TempUSerPwd = "";
					}
					return PassSubstr + TempStr;
				}
			}
			return "-1";
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return "-1";
	}

	public boolean UseridCheck(String user_id) {
		try {
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}
			this.Qry.append("SELECT ");
			this.Qry.append("COUNT(*) ");
			this.Qry.append("FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE USER_ID='" + user_id + "'");

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				int rowCheck = 0;

				rowCheck = this.m_rs.getInt(1);
				if (rowCheck == 0) {
					return false;
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return false;
	}
}
