package kolas3.work.UserService.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.common.db.ECOMySQLManager;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.common.utils.StringChecker;
import kolas3.work.UserService.Form.UserMemberInfoForm;
import kolas3.work.UserService.Form.UserZipcodeForm;

public class UserMemberShipMgr {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private StringChecker StrMgr = new StringChecker();
	private ResultSet m_rs;
	private boolean isCheck = true;
	private StringBuffer Qry = new StringBuffer();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserMemberShipMgr.class);

	public UserMemberInfoForm MemberInfoCheck(UserMemberInfoForm S_MemberInfoForm, String SessionMode) {
		try {
			String user_name = "";
			String civil_no1 = "";
			String civil_no2 = "";

			String birthday_day = "";
			String birthday_year = "";
			String birthday_month = "";
			String birthday_type = "";
			String address_home = "";
			String address_work = "";
			String zip_code_home1 = "";
			String zip_code_home2 = "";
			String zip_code_work1 = "";
			String zip_code_work2 = "";
			String phone_home = "";
			String phone_work = "";
			String handphone = "";
			String e_mail = "";
			String inferior_class = "";
			String Temp_UserName = S_MemberInfoForm.getUser_name();
			String Temp_UserCivilno = S_MemberInfoForm.getCivil_no1() + "-" + S_MemberInfoForm.getCivil_no2();
			String Temp_Userid = "";
			String Temp_UserPass = "";

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return null;
			}
			this.Qry.append("SELECT USER_NO, TRIM(USER_ID) AS USER_ID, TRIM(PASSWORD) AS ");
			this.Qry.append("PASSWORD, NAME, CIVIL_NO, BIRTHDAY, BIRTHDAY_TYPE, H_ADDR1, W_ADDR1, ");
			this.Qry.append("H_ZIPCODE, W_ZIPCODE, H_PHONE, W_PHONE, HANDPHONE, E_MAIL, USER_CLASS ");
			this.Qry.append("FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE NAME='" + Temp_UserName + "' ");
			this.Qry.append("AND CIVIL_NO='" + Temp_UserCivilno + "'");

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				Temp_Userid = this.m_rs.getString("USER_ID");
				Temp_UserPass = this.m_rs.getString("PASSWORD");
				if ((Temp_Userid == null) && (Temp_UserPass == null)) {
					String FlagStatus = "";

					user_name = this.m_rs.getString("NAME");
					civil_no1 = this.m_rs.getString("CIVIL_NO");
					birthday_day = this.m_rs.getString("BIRTHDAY");
					birthday_type = this.m_rs.getString("BIRTHDAY_TYPE");

					phone_home = this.m_rs.getString("H_PHONE");
					phone_work = this.m_rs.getString("W_PHONE");
					handphone = this.m_rs.getString("HANDPHONE");

					zip_code_home1 = this.m_rs.getString("H_ZIPCODE");
					address_home = this.m_rs.getString("H_ADDR1");
					zip_code_work1 = this.m_rs.getString("W_ZIPCODE");

					address_work = this.m_rs.getString("W_ADDR1");
					e_mail = this.m_rs.getString("E_MAIL");
					inferior_class = this.m_rs.getString("USER_CLASS");
					if (user_name != null) {
						S_MemberInfoForm.setUser_name(user_name);
					}
					if (civil_no1 != null) {
						String[] CivilNo = new String[2];

						CivilNo = civil_no1.split("-");
						if (CivilNo.length >= 2) {
							civil_no1 = CivilNo[0].trim();
							civil_no2 = CivilNo[1].trim();

							S_MemberInfoForm.setCivil_no1(civil_no1 + "-" + civil_no2);
						}
					}
					if (birthday_day != null) {
						String[] BirStr = new String[3];

						BirStr = birthday_day.split("-");
						if (BirStr.length >= 3) {
							birthday_year = BirStr[0];
							birthday_month = BirStr[1].replaceFirst("0", "");
							birthday_day = BirStr[2].substring(0, 2).replaceFirst("0", "");

							S_MemberInfoForm.setBirthday_year(birthday_year);
							S_MemberInfoForm.setBirthday_month(birthday_month);
							S_MemberInfoForm.setBirthday_day(birthday_day);
						}
					}
					if (birthday_type != null) {
						S_MemberInfoForm.setBirthday_type(birthday_type);
					}
					if (phone_home != null) {
						S_MemberInfoForm.setPhone_home(phone_home);
					}
					if (phone_work != null) {
						S_MemberInfoForm.setPhone_work(phone_work);
					}
					if (handphone != null) {
						S_MemberInfoForm.setHandphone(handphone);
					}
					logger.debug("zipcode");
					if (zip_code_home1 != null) {
						String[] Zipcodehome = new String[2];
						Zipcodehome = zip_code_home1.split("-");
						if (Zipcodehome.length >= 2) {
							zip_code_home1 = Zipcodehome[0];
							zip_code_home2 = Zipcodehome[1];

							S_MemberInfoForm.setZip_code_home1(zip_code_home1);
							S_MemberInfoForm.setZip_code_home2(zip_code_home2);
						}
					}
					logger.debug("zipcodeend");
					if (address_home != null) {
						S_MemberInfoForm.setAddress_home(address_home);
					}
					logger.debug("wzipcode");
					if (zip_code_work1 != null) {
						String[] Zipcodework = new String[2];
						Zipcodework = zip_code_work1.split("-");
						if (Zipcodework.length >= 2) {
							zip_code_work1 = Zipcodework[0];
							zip_code_work2 = Zipcodework[1];

							S_MemberInfoForm.setZip_code_work1(zip_code_work1);
							S_MemberInfoForm.setZip_code_work2(zip_code_work2);
						}
					}
					logger.debug("wzipcodeend");
					if (address_work != null) {
						S_MemberInfoForm.setAddress_work(address_work);
					}
					if (e_mail != null) {
						S_MemberInfoForm.setE_mail(e_mail);
					}
					if (inferior_class != null) {
						S_MemberInfoForm.setInferior_class(inferior_class);
					}
					logger.debug("!!!");
					S_MemberInfoForm.setMember_status("NEW");

					return S_MemberInfoForm;
				}
				if ((Temp_Userid != null) && (Temp_UserPass != null)) {
					S_MemberInfoForm.setMember_status("OLD");
					return S_MemberInfoForm;
				}
			}
			S_MemberInfoForm.setMember_status("NOT");
			return S_MemberInfoForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		label932: S_MemberInfoForm.setMember_status("-1");
		return S_MemberInfoForm;
	}

	public ArrayList UserZipcodeFind(String S_ZipcodeStr) {
		ArrayList ZipcodeResult = new ArrayList();
		try {
			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				this.Qry.append("select sido,gugun,dong,bunji,zip_code ");
				this.Qry.append("from co_zip_code_tbl ");
				this.Qry.append("where dong like'" + S_ZipcodeStr + "%'  order by zip_code ");

				this.LogMgr.fatal(this.Qry.toString());

				this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
				if (this.m_rs.next()) {
					do {
						UserZipcodeForm ZipcodeForm = new UserZipcodeForm();

						String S_sido = "";
						String S_gugun = "";
						String S_dong = "";
						String S_bunji = "";
						String S_zipcode = "";
						String S_Result1 = "";
						String S_Result2 = "";

						S_sido = this.m_rs.getString("SIDO");
						S_gugun = this.m_rs.getString("GUGUN");
						S_dong = this.m_rs.getString("DONG");
						S_bunji = this.m_rs.getString("BUNJI");
						S_zipcode = this.m_rs.getString("ZIP_CODE");
						if (S_sido == null) {
							S_sido = "";
						}
						if (S_gugun == null) {
							S_gugun = "";
						}
						if (S_dong == null) {
							S_dong = "";
						}
						if (S_bunji == null) {
							S_bunji = "";
						}
						if (S_zipcode == null) {
							S_zipcode = "";
						}
						ZipcodeForm.setSido(S_sido);
						ZipcodeForm.setGugun(S_gugun);
						ZipcodeForm.setDong(S_dong);
						ZipcodeForm.setBunji(S_bunji);
						ZipcodeForm.setZip_code(S_zipcode);
						if (!S_zipcode.equals("")) {
							String[] Zipcode = new String[2];
							Zipcode = S_zipcode.split("-");
							if (Zipcode.length >= 2) {
								ZipcodeForm.setZip1(Zipcode[0]);
								ZipcodeForm.setZip2(Zipcode[1]);
							}
						}
						S_Result1 = S_zipcode + " " + S_sido + " " + S_gugun + " " + S_dong + " " + S_bunji;
						S_Result2 = S_sido + " " + S_gugun + " " + S_dong + " " + S_bunji;

						ZipcodeForm.setZipcode_result1(S_Result1.trim());
						ZipcodeForm.setZipcode_result2(S_Result2.trim());

						ZipcodeResult.add(ZipcodeForm);
					} while (

					this.m_rs.next());
				}
			}
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return ZipcodeResult;
	}

	public boolean MemberInfoInsert(UserMemberInfoForm MemberForm) {
		try {
			int UpdateCheck = 0;

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}
			String S_birday = "";
			String S_birmonth = "";
			String S_biryear = "";
			String S_birresult = "";
			String S_birtype = "";
			String S_zipcodeHome = "";
			String S_zipcodeWork = "";

			S_biryear = MemberForm.getBirthday_year();
			S_birmonth = MemberForm.getBirthday_month();
			S_birday = MemberForm.getBirthday_day();
			S_birtype = MemberForm.getBirthday_type();
			if ((MemberForm.getZip_code_home1().equals("")) || (MemberForm.getZip_code_home2().equals(""))) {
				S_zipcodeHome = "";
			} else {
				S_zipcodeHome = MemberForm.getZip_code_home1() + "-" + MemberForm.getZip_code_home2();
			}
			if ((MemberForm.getZip_code_work1().equals("")) || (MemberForm.getZip_code_work2().equals(""))) {
				S_zipcodeWork = "";
			} else {
				S_zipcodeWork = MemberForm.getZip_code_work1() + "-" + MemberForm.getZip_code_work2();
			}
			if (S_birmonth.length() == 1) {
				S_birmonth = "0" + S_birmonth;
			}
			if (S_birday.length() == 1) {
				S_birday = "0" + S_birday;
			}
			S_birresult = S_biryear + "/" + S_birmonth + "/" + S_birday;

			this.Qry.append("UPDATE CO_LOAN_USER_TBL ");
			this.Qry.append("SET USER_ID = '" + MemberForm.getUser_id() + "',");
			this.Qry.append("PASSWORD = '" + MemberForm.getPassword1() + "',");
			this.Qry.append("BIRTHDAY = to_date('" + S_birresult + "', 'yyyy/mm/dd'),");
			this.Qry.append("BIRTHDAY_TYPE = '" + S_birtype + "',");
			this.Qry.append("H_ADDR1 = '" + MemberForm.getAddress_home() + "',");
			this.Qry.append("W_ADDR1 = '" + MemberForm.getAddress_work() + "',");
			this.Qry.append("H_ZIPCODE = '" + S_zipcodeHome + "',");
			this.Qry.append("W_ZIPCODE = '" + S_zipcodeWork + "',");
			this.Qry.append("H_PHONE = '" + MemberForm.getPhone_home() + "',");
			this.Qry.append("W_PHONE = '" + MemberForm.getPhone_work() + "',");
			this.Qry.append("HANDPHONE = '" + MemberForm.getHandphone() + "',");
			this.Qry.append("E_MAIL = '" + MemberForm.getE_mail() + "' ");

			this.Qry.append("WHERE NAME = '" + MemberForm.getUser_name() + "'");
			this.Qry.append("AND CIVIL_NO= '" + MemberForm.getCivil_no1() + "'");

			this.LogMgr.fatal(this.Qry.toString());

			UpdateCheck = this.OraMgr.updateQry(this.Qry.toString());
			if (UpdateCheck == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
			return false;
		}
	}
}
