package kolas3.work.UserService.Model;

import kolas3.common.db.ECOMySQLManager;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.common.utils.StringChecker;
import java.sql.ResultSet;
import java.util.ArrayList;
import kolas3.work.UserService.Form.BookRequestDetailForm;
import kolas3.work.UserService.Form.BookRequestForm;
import kolas3.work.UserService.Form.BookRequestListForm;

public class BookRequestMgr {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private StringChecker StrMgr = new StringChecker();
	private ResultSet m_rs;
	private boolean isCheck = true;
	private StringBuffer Qry = new StringBuffer();
	private StringBuffer TempQry = new StringBuffer();
	private ArrayList TempAraay = new ArrayList();

	public BookRequestForm RequestLoanNumberCheck(BookRequestForm S_requestForm) {
		try {
			String S_userno = "";
			String S_applicant_name = "";
			String S_address_home = "";
			String S_zip_code = "";
			String S_phone_home = "";
			String S_e_mail = "";
			String S_civil_no = "";
			String S_handphone = "";

			S_userno = S_requestForm.getUser_no();

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_requestForm;
			}
			this.Qry.append("SELECT NAME, H_ADDR1, H_ZIPCODE, H_PHONE, E_MAIL, CIVIL_NO, HANDPHONE ");
			this.Qry.append(" FROM CO_LOAN_USER_TBL ");
			this.Qry.append("WHERE USER_NO = '" + S_userno + "'");

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (this.m_rs.next()) {
				S_applicant_name = this.m_rs.getString("NAME");
				S_address_home = this.m_rs.getString("H_ADDR1");
				S_zip_code = this.m_rs.getString("H_ZIPCODE");
				S_phone_home = this.m_rs.getString("H_PHONE");
				S_e_mail = this.m_rs.getString("E_MAIL");
				S_civil_no = this.m_rs.getString("CIVIL_NO");
				S_handphone = this.m_rs.getString("HANDPHONE");
				if (S_applicant_name == null) {
					S_applicant_name = "";
				}
				if (S_address_home == null) {
					S_address_home = "";
				}
				if (S_zip_code == null) {
					S_zip_code = "";
				}
				if (S_phone_home == null) {
					S_phone_home = "";
				}
				if (S_e_mail == null) {
					S_e_mail = "";
				}
				if (S_civil_no == null) {
					S_civil_no = "";
				}
				if (S_handphone == null) {
					S_handphone = "";
				}
				String[] Zipcode = new String[2];
				String[] CivilNo = new String[2];

				Zipcode = S_zip_code.split("-");
				CivilNo = S_civil_no.split("-");
				if (Zipcode[0] == null) {
					Zipcode[0] = "";
				}
				if (Zipcode[1] == null) {
					Zipcode[1] = "";
				}
				if (CivilNo[0] == null) {
					CivilNo[0] = "";
				}
				if (CivilNo[1] == null) {
					CivilNo[1] = "";
				}
				S_requestForm.setZip1(Zipcode[0]);
				S_requestForm.setZip2(Zipcode[1]);
				S_requestForm.setZip_code(S_zip_code);
				S_requestForm.setAddress1(S_address_home);
				S_requestForm.setApplicant_name(S_applicant_name);
				S_requestForm.setTel(S_phone_home);
				S_requestForm.setHp_no(S_handphone);
				S_requestForm.setE_mail(S_e_mail);
				S_requestForm.setCivil_no_result(S_civil_no);
				S_requestForm.setCivil_no_first(CivilNo[0]);
				S_requestForm.setCivil_no_second(CivilNo[1]);
				S_requestForm.setCheck_mode("EXIST");

				this.OraMgr.disconnect();

				return S_requestForm;
			}
			S_requestForm.setCheck_mode("NOT_EXIST");

			this.OraMgr.disconnect();

			return S_requestForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_requestForm;
	}

	public boolean RequestBookInsert(BookRequestForm S_RequestForm) {
		int Temp_RecKey = 0;
		try {
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}
			this.TempQry.append("SELECT MAX(REC_KEY) FROM BO_FURNISH_TBL");

			this.m_rs = this.OraMgr.selectQry(this.TempQry.toString());
			if (this.m_rs.next()) {
				Temp_RecKey = this.m_rs.getInt(1);

				S_RequestForm.setRec_key(Temp_RecKey + 1);
			}
			if ((S_RequestForm.getApplicant_name().equals("")) || (S_RequestForm.getTitle().equals(""))) {
				return false;
			}
			String tmpmgc = S_RequestForm.getMgc();
			if ((tmpmgc.equals("")) || (tmpmgc == null) || (tmpmgc.equals("null"))) {
				S_RequestForm.setMgc("MA");
			}
			String title = S_RequestForm.getTitle();
			String author = S_RequestForm.getAuthor();
			String publisher = S_RequestForm.getPublisher();
			String recomopinion = S_RequestForm.getRecom_opinion();
			String indextitle = S_RequestForm.getIndex_title();
			String indexauthor = S_RequestForm.getIndex_author();
			String indexpublisher = S_RequestForm.getIndex_publisher();
			if (title != null) {
				title = title.replace("'", "");
			}
			if (author != null) {
				author = author.replace("'", "");
			}
			if (publisher != null) {
				publisher = publisher.replace("'", "");
			}
			if (recomopinion != null) {
				recomopinion = recomopinion.replace("'", "");
			}
			if (indextitle != null) {
				indextitle = indextitle.replace("'", "");
			}
			if (indexauthor != null) {
				indexauthor = indexauthor.replace("'", "");
			}
			if (indexpublisher != null) {
				indexpublisher = indexpublisher.replace("'", "");
			}
			this.Qry.append("INSERT INTO BO_FURNISH_TBL ");
			this.Qry.append("(REC_KEY,APPLICANT_NAME, IDX_APPLICANT_NAME, ");
			this.Qry.append("CIVIL_NO,ZIP_CODE,");
			this.Qry.append("ADDRESS,APPLICANT_DATE,");
			this.Qry.append("TITLE,AUTHOR,");
			this.Qry.append("PUBLISHER,PUBLISH_YEAR,");
			this.Qry.append("RECOM_OPINION,INDEX_TITLE,");
			this.Qry.append("INDEX_AUTHOR,INDEX_PUBLISHER,");
			this.Qry.append("TEL,EMAIL,");
			this.Qry.append(
					"FURNISH_STATUS, HANDPHONE, SMS_RECEIPT_YN, MANAGE_CODE, USER_NO,FIRST_WORK,RESERVATION_YN) ");
			this.Qry.append("VALUES ");
			this.Qry.append("('" + S_RequestForm.getRec_key() + "',");
			this.Qry.append("'" + S_RequestForm.getApplicant_name() + "',");
			this.Qry.append("'" + S_RequestForm.getApplicant_name() + "',");
			this.Qry.append("'" + S_RequestForm.getCivil_no_result() + "',");
			this.Qry.append("'" + S_RequestForm.getZip_code() + "',");
			this.Qry.append("'" + S_RequestForm.getAddress1() + "',");
			this.Qry.append("sysdate,");
			this.Qry.append("'" + title + "',");
			this.Qry.append("'" + author + "',");
			this.Qry.append("'" + publisher + "',");
			this.Qry.append("'" + S_RequestForm.getPublisher_date() + "',");
			this.Qry.append("'" + recomopinion + "',");
			this.Qry.append("'" + indextitle + "',");
			this.Qry.append("'" + indexauthor + "',");
			this.Qry.append("'" + indexpublisher + "',");
			this.Qry.append("'" + S_RequestForm.getTel() + "',");
			this.Qry.append("'" + S_RequestForm.getE_mail() + "',");
			this.Qry.append("'" + S_RequestForm.getFurnish_status() + "',");
			this.Qry.append("'" + S_RequestForm.getHp_no() + "',");
			this.Qry.append("'" + S_RequestForm.getSms_yn() + "','" + S_RequestForm.getMgc() + "','"
					+ S_RequestForm.getUser_no() + "','검색대예약','" + S_RequestForm.getReservation_yn() + "')");
			this.LogMgr.fatal(this.Qry.toString());

			this.isCheck = this.OraMgr.insertQry(this.Qry.toString());

			this.OraMgr.disconnect();
			if (!this.isCheck) {
				return false;
			}
			return true;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		label1139: return false;
	}

	public ArrayList<BookRequestListForm> RequestBookListMgr(BookRequestListForm S_RequestListForm, String manage_code) {
		ArrayList<BookRequestListForm> ResultRequestList = new ArrayList<BookRequestListForm>();
		try {
			String S_chk_title = S_RequestListForm.getChk_title();
			String S_chk_name = S_RequestListForm.getChk_name();
			String S_keyword = S_RequestListForm.getKeyword();
			String S_book_no = S_RequestListForm.getBook_no();
			String S_rec_key = S_RequestListForm.getRec_key();
			String S_applicant_name = S_RequestListForm.getApplicant_name();
			String S_book_author = S_RequestListForm.getBook_author();
			String S_request_date = S_RequestListForm.getRequest_date();
			String S_furnish_status = S_RequestListForm.getFurnish_status();
			String S_cancel_reason = S_RequestListForm.getCancel_reason();
			String S_book_title = S_RequestListForm.getBook_title();

			int S_total_bookcount = Integer.parseInt(S_RequestListForm.getTotal_bookcount());
			int S_total_pagecount = Integer.parseInt(S_RequestListForm.getTotal_pagecount());
			int S_current_pagecount = Integer.parseInt(S_RequestListForm.getCurrent_pagecount());
			int S_prev_page = Integer.parseInt(S_RequestListForm.getPrev_page());
			int S_next_page = Integer.parseInt(S_RequestListForm.getNext_page());
			int S_listview_rowcount = Integer.parseInt(S_RequestListForm.getListview_rowcount());
			int S_listview_pagecount = Integer.parseInt(S_RequestListForm.getListview_pagecount());
			int S_pageGroupStart = Integer.parseInt(S_RequestListForm.getPageGroupStart());
			int S_pageGroupEnd = Integer.parseInt(S_RequestListForm.getPageGroupEnd());
			int S_width_page = Integer.parseInt(S_RequestListForm.getWidth_page());

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return ResultRequestList;
			}
			String S_search = "";
			String S_searchStr = "";
			String andmanage = "";
			if (!S_keyword.equals("")) {
				if ((S_chk_name.equals("1")) && (S_chk_title.equals(""))) {
					S_searchStr = "신청인";
					S_search = "(LOWER(APPLICANT_NAME) LIKE LOWER('%" + S_keyword + "%'))";
				}
				if ((S_chk_title.equals("2")) && (S_chk_name.equals(""))) {
					S_searchStr = "도서명";
					S_search = "(LOWER(TITLE) LIKE LOWER('%" + S_keyword + "%'))";
				}
				if ((S_chk_name.equals("1")) && (S_chk_title.equals("2"))) {
					S_searchStr = "신청인 or 도서명";
					S_search = "(LOWER(APPLICANT_NAME) LIKE LOWER('%" + S_keyword
							+ "%')) or (LOWER(TITLE) LIKE LOWER('%" + S_keyword + "%'))";
				}
				this.TempQry.append("SELECT COUNT(*) FROM BO_FURNISH_TBL WHERE (" + S_search + ") AND (REC_KEY > 0)");

				this.LogMgr.fatal(this.Qry.toString());
			}
			if (S_keyword.equals("")) {
				if (!manage_code.equals("")) {
					andmanage = " and manage_code='" + manage_code + "' ";
				}
				this.TempQry.append("SELECT COUNT(*) FROM BO_FURNISH_TBL WHERE REC_KEY > 0" + andmanage);
			}
			this.m_rs = this.OraMgr.selectQry(this.TempQry.toString());
			if (this.m_rs.next()) {
				S_total_bookcount = this.m_rs.getInt(1);

				S_total_pagecount = S_total_bookcount / S_listview_pagecount;
				if ((S_total_bookcount % 10 != 0) && (S_total_pagecount != 0)) {
					S_total_pagecount++;
				}
				if (S_total_pagecount == 0) {
					S_total_pagecount = 1;
				}
			}
			if (S_total_bookcount == 0) {
				S_RequestListForm.setTotal_pagecount(String.valueOf(S_total_pagecount));
				S_RequestListForm.setSearch_str(S_searchStr);

				return ResultRequestList;
			}
			int Temp_Rnum_First = S_total_bookcount - S_current_pagecount * S_listview_rowcount + 1;
			int Temp_Rnum_Second = S_total_bookcount - (S_current_pagecount - 1) * S_listview_rowcount;

			S_width_page = (int) Math.floor((S_current_pagecount - 1) / S_listview_pagecount + 1);

			S_pageGroupStart = (S_width_page - 1) * S_listview_pagecount + 1;
			S_pageGroupEnd = S_width_page * S_listview_pagecount;
			if (S_total_pagecount < S_pageGroupEnd) {
				S_pageGroupEnd = S_total_pagecount;
			}
			S_RequestListForm.setTotal_bookcount(String.valueOf(S_total_bookcount));
			S_RequestListForm.setTotal_pagecount(String.valueOf(S_total_pagecount));
			S_RequestListForm.setCurrent_pagecount(String.valueOf(S_current_pagecount));
			S_RequestListForm.setPrev_page(String.valueOf(S_prev_page));
			S_RequestListForm.setNext_page(String.valueOf(S_next_page));
			S_RequestListForm.setListview_rowcount(String.valueOf(S_listview_rowcount));
			S_RequestListForm.setListview_pagecount(String.valueOf(S_listview_pagecount));
			S_RequestListForm.setPageGroupStart(String.valueOf(S_pageGroupStart));
			S_RequestListForm.setPageGroupEnd(String.valueOf(S_pageGroupEnd));
			S_RequestListForm.setWidth_page(String.valueOf(S_width_page));
			S_RequestListForm.setSearch_str(String.valueOf(S_searchStr));

			this.TempAraay.add(S_RequestListForm);
			if (!S_keyword.equals("")) {
				this.Qry.append("SELECT * FROM ");
				this.Qry.append(
						"(SELECT ROWNUM AS RNUM, REC_KEY, APPLICANT_NAME, TITLE, AUTHOR, TO_CHAR(APPLICANT_DATE, 'YYYY-MM-DD') ");
				this.Qry.append("AS DTIME, FURNISH_STATUS, CANCEL_REASON FROM ");
				this.Qry.append(
						"(SELECT * FROM BO_FURNISH_TBL WHERE" + S_search + andmanage + "ORDER BY APPLICANT_DATE)) ");
				this.Qry.append("WHERE (RNUM >= '" + Temp_Rnum_First + "') ");
				this.Qry.append("AND (RNUM <= '" + Temp_Rnum_Second + "') ");
				this.Qry.append("ORDER BY RNUM DESC");
			}
			if (S_keyword.equals("")) {
				String wheremanage = "";
				if (!manage_code.equals("")) {
					wheremanage = " where manage_code='" + manage_code + "' ";
				}
				this.Qry.append("SELECT * FROM ");
				this.Qry.append(
						"(SELECT ROWNUM AS RNUM, REC_KEY, APPLICANT_NAME, TITLE, AUTHOR, TO_CHAR(APPLICANT_DATE, 'YYYY-MM-DD') ");
				this.Qry.append("AS DTIME, FURNISH_STATUS, CANCEL_REASON FROM ");
				this.Qry.append("(SELECT * FROM BO_FURNISH_TBL " + wheremanage + "ORDER BY APPLICANT_DATE)) ");
				this.Qry.append("WHERE (RNUM >= '" + Temp_Rnum_First + "') ");
				this.Qry.append("AND (RNUM <= '" + Temp_Rnum_Second + "') ");
				this.Qry.append("ORDER BY RNUM DESC");
			}
			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			while (this.m_rs.next()) {
				BookRequestListForm RequestListForm = new BookRequestListForm();
				if (!S_searchStr.equals("")) {
					RequestListForm.setSearch_str(S_searchStr);
				}
				S_book_no = String.valueOf(this.m_rs.getInt("RNUM"));
				S_rec_key = String.valueOf(this.m_rs.getInt("REC_KEY"));
				S_applicant_name = this.m_rs.getString("APPLICANT_NAME");
				S_book_title = this.m_rs.getString("TITLE");
				S_book_author = this.m_rs.getString("AUTHOR");
				S_request_date = this.m_rs.getString("DTIME");
				S_furnish_status = this.m_rs.getString("FURNISH_STATUS");
				if (S_furnish_status.equals("0")) {
					S_furnish_status = "비치안됨";
				} else if (S_furnish_status.equals("1")) {
					S_furnish_status = "신청중";
				} else if (S_furnish_status.equals("2")) {
					S_furnish_status = "처리중";
				} else if (S_furnish_status.equals("3")) {
					S_furnish_status = "소장중";
				} else {
					S_furnish_status = "취소됨";
					S_cancel_reason = this.m_rs.getString("CANCEL_REASON");	// 취소일때만 취소사유 넣어주기
				}
				
				RequestListForm.setTotal_bookcount(String.valueOf(S_total_bookcount));
				RequestListForm.setTotal_pagecount(String.valueOf(S_total_pagecount));
				RequestListForm.setCurrent_pagecount(String.valueOf(S_current_pagecount));
				RequestListForm.setPrev_page(String.valueOf(S_prev_page));
				RequestListForm.setNext_page(String.valueOf(S_next_page));
				RequestListForm.setListview_rowcount(String.valueOf(S_listview_rowcount));
				RequestListForm.setListview_pagecount(String.valueOf(S_listview_pagecount));
				RequestListForm.setPageGroupStart(String.valueOf(S_pageGroupStart));
				RequestListForm.setPageGroupEnd(String.valueOf(S_pageGroupEnd));
				RequestListForm.setWidth_page(String.valueOf(S_width_page));
				RequestListForm.setKeyword(String.valueOf(S_keyword));

				RequestListForm.setBook_no(S_book_no);
				RequestListForm.setRec_key(S_rec_key);
				RequestListForm.setApplicant_name(S_applicant_name);
				RequestListForm.setBook_title(S_book_title);
				RequestListForm.setBook_author(S_book_author);
				RequestListForm.setRequest_date(S_request_date);
				RequestListForm.setFurnish_status(S_furnish_status);
				RequestListForm.setCancel_reason(S_cancel_reason);

				ResultRequestList.add(RequestListForm);
			}
			this.OraMgr.disconnect();

			return ResultRequestList;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return ResultRequestList;
	}

	public BookRequestDetailForm RequestDetailMgr(BookRequestDetailForm S_RequestDetailForm) {
		try {
			if (S_RequestDetailForm.getRec_key() == 0) {
				S_RequestDetailForm.setError_code("이미 삭제된 자료이거나 잘못된 키 입니다.");

				return S_RequestDetailForm;
			}
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return null;
			}
			this.Qry.append(
					"SELECT REC_KEY, APPLICANT_NAME, USER_NO, CIVIL_NO, ADDRESS,  TITLE, AUTHOR, PUBLISHER, PUBLISH_YEAR, RECOM_OPINION, TEL, EMAIL, ");
			this.Qry.append("TO_CHAR(APPLICANT_DATE, 'YYYY/MM/DD') AS DTIME, FURNISH_STATUS, CANCEL_REASON ");
			this.Qry.append("FROM BO_FURNISH_TBL WHERE REC_KEY=" + S_RequestDetailForm.getRec_key());

			this.LogMgr.fatal(this.Qry.toString());

			this.m_rs = this.OraMgr.selectQry(this.Qry.toString());
			if (!this.m_rs.next()) {
				return null;
			}
			String recom_test = "";
			String S_furnish_status = "";

			String one_recom = "";
			String two_recom = "";
			String three_recom = "";

			S_RequestDetailForm.setApplicant_name(this.m_rs.getString("APPLICANT_NAME"));
			S_RequestDetailForm.setRec_key(this.m_rs.getInt("REC_KEY"));
			S_RequestDetailForm.setCvil_no(this.m_rs.getString("CIVIL_NO"));
			S_RequestDetailForm.setBook_title(this.m_rs.getString("TITLE"));
			S_RequestDetailForm.setBook_author(this.m_rs.getString("AUTHOR"));
			S_furnish_status = this.m_rs.getString("FURNISH_STATUS");
			if (S_furnish_status.equals("0")) {
				S_furnish_status = "비치안됨";
			} else if (S_furnish_status.equals("1")) {
				S_furnish_status = "신청중";
			} else if (S_furnish_status.equals("2")) {
				S_furnish_status = "처리중";
			} else if (S_furnish_status.equals("3")) {
				S_furnish_status = "소장중";
			} else {
				S_furnish_status = "취소됨";
			}
			S_RequestDetailForm.setFurnish_status(S_furnish_status);
			S_RequestDetailForm.setPublisher(this.m_rs.getString("PUBLISHER"));
			S_RequestDetailForm.setPublisher_date(this.m_rs.getString("PUBLISH_YEAR"));

			recom_test = this.m_rs.getString("RECOM_OPINION");
			if (recom_test == null) {
				recom_test = "";
			}
			if (!recom_test.equals("")) {
				if (recom_test.length() >= 80) {
					one_recom = recom_test.substring(0, 40);
					two_recom = recom_test.substring(40, 80);
					three_recom = recom_test.substring(80);

					recom_test = one_recom + "\r\n" + two_recom + "\r\n" + three_recom;
				} else if ((recom_test.length() < 80) && (recom_test.length() >= 40)) {
					one_recom = recom_test.substring(0, 40);
					two_recom = recom_test.substring(40);

					recom_test = one_recom + "\r\n" + two_recom;
				}
				recom_test = recom_test.replaceAll("\r\n", "<br>");
			}
			S_RequestDetailForm.setRecom_opinion(recom_test);
			S_RequestDetailForm.setRequest_date(this.m_rs.getString("DTIME"));
			S_RequestDetailForm.setCancel_reason(this.m_rs.getString("CANCEL_REASON"));
			S_RequestDetailForm.setAddress(this.m_rs.getString("ADDRESS"));
			S_RequestDetailForm.setTel(this.m_rs.getString("TEL"));
			S_RequestDetailForm.setEmail(this.m_rs.getString("EMAIL"));
			S_RequestDetailForm.setUser_no(this.m_rs.getString("USER_NO"));
			this.OraMgr.disconnect();

			this.isCheck = this.OraMgr.connect();
			if (this.isCheck) {
				String qry = "";
				String TempUserNo = "";

				qry = "SELECT USER_NO FROM CO_LOAN_USER_TBL WHERE USER_NO='" + S_RequestDetailForm.getUser_no() + "'";

				this.m_rs = this.OraMgr.selectQry(qry);
				if (this.m_rs.next()) {
					S_RequestDetailForm.setUser_no(this.m_rs.getString("USER_NO"));
				}
				this.OraMgr.disconnect();

				return S_RequestDetailForm;
			}
			S_RequestDetailForm.setError_code("이미 삭제된 자료이거나 잘못된 키 입니다.");

			this.OraMgr.disconnect();

			return S_RequestDetailForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		label768: S_RequestDetailForm.setError_code("이미 삭제된 자료이거나 잘못된 키 입니다.");
		this.OraMgr.disconnect();

		return S_RequestDetailForm;
	}

	public ArrayList getTempAraay() {
		return this.TempAraay;
	}

	public void setTempAraay(ArrayList tempAraay) {
		this.TempAraay = tempAraay;
	}

	public boolean RequestUpdateMgr(BookRequestDetailForm S_RequestDetailForm) {
		try {
			int UpdateCheck = 0;

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}
			int Rec_key = 0;
			String Applicant_name = "";
			String Cvil_no = "";
			String Book_title = "";
			String Book_author = "";
			String Publisher = "";
			String Publisher_date = "";
			String Recom_opinion = "";

			Rec_key = S_RequestDetailForm.getRec_key();
			Applicant_name = S_RequestDetailForm.getApplicant_name();
			Cvil_no = S_RequestDetailForm.getCvil_no();
			Book_title = S_RequestDetailForm.getBook_title();
			Book_author = S_RequestDetailForm.getBook_author();
			Publisher = S_RequestDetailForm.getPublisher();
			Publisher_date = S_RequestDetailForm.getPublisher_date().trim();
			Recom_opinion = S_RequestDetailForm.getRecom_opinion();

			this.Qry.append("UPDATE BO_FURNISH_TBL ");
			this.Qry.append("SET APPLICANT_NAME = '" + Applicant_name + "',");
			this.Qry.append("CIVIL_NO = '" + Cvil_no + "',");
			this.Qry.append("TITLE = '" + Book_title + "',");
			this.Qry.append("AUTHOR = '" + Book_author + "',");
			this.Qry.append("PUBLISHER = '" + Publisher + "',");
			this.Qry.append("PUBLISH_YEAR = '" + Publisher_date + "',");
			this.Qry.append("RECOM_OPINION = '" + Recom_opinion + "' ");
			this.Qry.append("WHERE REC_KEY = '" + Rec_key + "'");

			this.LogMgr.fatal(this.Qry.toString());

			UpdateCheck = this.OraMgr.updateQry(this.Qry.toString());
			if (UpdateCheck == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return false;
	}

	public boolean RequestDeleteMgr(BookRequestDetailForm S_RequestDetailForm) {
		try {
			int DeleteCheck = 0;

			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return false;
			}
			int Rec_key = 0;

			Rec_key = S_RequestDetailForm.getRec_key();

			this.Qry.append("DELETE FROM BO_FURNISH_TBL ");
			this.Qry.append("WHERE REC_KEY=" + Rec_key);

			this.LogMgr.fatal(this.Qry.toString());

			DeleteCheck = this.OraMgr.updateQry(this.Qry.toString());
			if (DeleteCheck == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return false;
	}

	public BookRequestForm RequestViewMgr(BookRequestForm S_RequestForm) {
		try {
			String TempUserNO = "";
			String qry = "";

			String[] CivilnoSpilt = new String[2];
			String FiirstCivil = "";
			String SecondCivil = "";
			String ResultCivil = "";

			String[] Zipspilt = new String[2];
			String TempZipFirst = "";
			String TempZipSecond = "";
			String TEmpZipResult = "";

			TempUserNO = S_RequestForm.getUser_no();
			if (TempUserNO.equals("")) {
				return S_RequestForm;
			}
			this.isCheck = this.OraMgr.connect();
			if (!this.isCheck) {
				return S_RequestForm;
			}
			qry = "SELECT USER_ID, NAME, H_ADDR1, H_ZIPCODE, H_PHONE, E_MAIL, HANDPHONE, CIVIL_NO ";
			qry = qry + "FROM CO_LOAN_USER_TBL ";
			qry = qry + "WHERE USER_NO='" + TempUserNO + "'";

			this.m_rs = this.OraMgr.selectQry(qry);
			if (!this.m_rs.next()) {
				return S_RequestForm;
			}
			ResultCivil = this.m_rs.getString("CIVIL_NO");
			if ((ResultCivil != null) && (!ResultCivil.equals(""))) {
				CivilnoSpilt = ResultCivil.split("-");
				FiirstCivil = CivilnoSpilt[0];
				SecondCivil = CivilnoSpilt[1];

				S_RequestForm.setCivil_no_first(FiirstCivil);
				S_RequestForm.setCivil_no_second(SecondCivil);
				S_RequestForm.setCivil_no_result(ResultCivil);
			}
			S_RequestForm.setApplicant_name(this.m_rs.getString("NAME"));
			S_RequestForm.setAddress1(this.m_rs.getString("H_ADDR1"));
			S_RequestForm.setE_mail(this.m_rs.getString("E_MAIL"));
			S_RequestForm.setHp_no(this.m_rs.getString("HANDPHONE"));
			S_RequestForm.setTel(this.m_rs.getString("H_PHONE"));

			TEmpZipResult = this.m_rs.getString("H_ZIPCODE");
			if ((!TEmpZipResult.equals("")) && (TEmpZipResult != null)) {
				Zipspilt = TEmpZipResult.split("-");
				TempZipFirst = Zipspilt[0];
				TempZipSecond = Zipspilt[1];

				S_RequestForm.setZip_code(TEmpZipResult);
				S_RequestForm.setZip1(TempZipFirst);
				S_RequestForm.setZip2(TempZipSecond);
			}
			this.OraMgr.disconnect();

			return S_RequestForm;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		return S_RequestForm;
	}
}
