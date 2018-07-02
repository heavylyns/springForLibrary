package kolas3.work.BookSearch.Model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Form.DetailViewListForm;

public class BookWorkingStatus {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public String valuegeter(ArrayList detaillist, String value) {
		String use_reserv = "";
		for (int i = 0; i < detaillist.size(); i++) {
			DetailViewListForm detailviewlistform = new DetailViewListForm();
			detailviewlistform = (DetailViewListForm) detaillist.get(i);
			if (detailviewlistform.getTitle().equals(value)) {
				use_reserv = detailviewlistform.getValue();
				logger.debug(value + use_reserv);
			}
		}
		return use_reserv;
	}

	public String returnworkingstatus(String workingstatus, String codeloanuse, String loanyn, String use_reserv) {
		String resolve_result = "";
		if (workingstatus.equals("BOL112N")) {
			if (codeloanuse.equals("YYYY")) {
				if (!loanyn.equals("N")) {
					resolve_result = "대출불가" + loanyn;
				} else {
					resolve_result = "대출가능(비치)";
				}
			} else {
				resolve_result = "대출불가(비치)";
			}
		} else if (workingstatus.equals("BOL113O")) {
			resolve_result = "대출불가(수리제본)";
		} else if (workingstatus.equals("BOL114O")) {
			resolve_result = "대출불가(파손)";
		} else if (workingstatus.equals("BOL115O")) {
			resolve_result = "대출불가(제적)";
		} else if (workingstatus.equals("BOL116O")) {
			resolve_result = "대출불가(재정리)";
		} else if (workingstatus.equals("BOL252N")) {
			resolve_result = "대출불가(분실)";
		} else if ((workingstatus.equals("BOL211O")) || (workingstatus.equals("BOL213O"))
				|| (workingstatus.equals("BOL214O")) || (workingstatus.equals("BOL215O"))) {
			if (!loanyn.equals("N")) {
				resolve_result = "관외 대출중" + loanyn;
			} else if ((use_reserv.equals("1")) || (use_reserv.equals("2"))) {
				resolve_result = "관외 대출중(예약0명)";
			} else {
				resolve_result = "관외 대출중";
			}
		} else if (workingstatus.equals("BOL212O")) {
			if (!loanyn.equals("N")) {
				resolve_result = "관내 대출중" + loanyn;
			} else if ((use_reserv.equals("1")) || (use_reserv.equals("2"))) {
				resolve_result = "관내 대출중(예약0명)";
			} else {
				resolve_result = "관내 대출중";
			}
		} else if (workingstatus.equals("SEL112N")) {
			if (codeloanuse.equals("YYYY")) {
				if (!loanyn.equals("N")) {
					resolve_result = "대출불가" + loanyn;
				} else {
					resolve_result = "대출가능(비치)";
				}
			} else {
				resolve_result = "대출불가(비치)";
			}
		} else if (workingstatus.equals("SEL212N")) {
			if (codeloanuse == "YYYY") {
				if (loanyn.equals("N")) {
					resolve_result = "대출불가" + loanyn;
				} else {
					resolve_result = "대출가능(비치)";
				}
			} else {
				resolve_result = "대출불가(비치)";
			}
		} else if (workingstatus.equals("SEL213O")) {
			resolve_result = "대출불가(수리제본)";
		} else if (workingstatus.equals("SEL214O")) {
			resolve_result = "대출불가(파손)";
		} else if (workingstatus.equals("SEL215O")) {
			resolve_result = "대출불가(제적)";
		} else if (workingstatus.equals("SEL216O")) {
			resolve_result = "대출불가(분실)";
		} else if (workingstatus.equals("SEL217O")) {
			resolve_result = "대출불가(재정리)";
		} else if ((workingstatus.equals("SEL311O")) || (workingstatus.equals("SEL313O"))
				|| (workingstatus.equals("SEL314O")) || (workingstatus.equals("SEL315O"))) {
			if (loanyn.equals("N")) {
				resolve_result = "관외 대출중" + loanyn;
			} else if ((use_reserv.equals("1")) || (use_reserv.equals("2"))) {
				resolve_result = "관외 대출중(예약0명)";
			} else {
				resolve_result = "관외 대출중";
			}
		} else if (workingstatus.equals("SEL312O")) {
			if (loanyn.equals("N")) {
				resolve_result = "관내 대출중" + loanyn;
			} else if ((use_reserv.equals("1")) || (use_reserv.equals("2"))) {
				resolve_result = "관내 대출중(예약0명)";
			} else {
				resolve_result = "관내 대출중";
			}
		} else {
			resolve_result = workingstatus;
		}
		return resolve_result;
	}

	public String returnworkingstatus_simple(String working_status) {
		String resolve_result = "";
		if (working_status.equals("BOT111O")) {
			resolve_result = "기초자료";
		} else if (working_status.equals("BOT112O")) {
			resolve_result = "반입자료";
		} else if (working_status.equals("BOA111N")) {
			resolve_result = "구입대상자료";
		} else if (working_status.equals("BOA112N")) {
			resolve_result = "검수대상자료(주문자료)";
		} else if (working_status.equals("BOA113O")) {
			resolve_result = "미납품자료";
		} else if (working_status.equals("BOA114O")) {
			resolve_result = "(구입))인계대상자료";
		} else if (working_status.equals("BOA211O")) {
			resolve_result = "기증접수자료(인계대상자료)";
		} else if (working_status.equals("BOA212O")) {
			resolve_result = "기증당부자료";
		} else if (working_status.equals("BOR111N")) {
			resolve_result = "등록인계자료";
		} else if (working_status.equals("BOR112N")) {
			resolve_result = "등록자료(정리인계대상자료)";
		} else if (working_status.equals("BOR113O")) {
			resolve_result = "가원부번호부여자료";
		} else if (working_status.equals("BOC111O")) {
			resolve_result = "복본조사대상자료";
		} else if (working_status.equals("BOC112O")) {
			resolve_result = "분류대상자료";
		} else if (working_status.equals("BOC113N")) {
			resolve_result = "정리대상자료";
		} else if (working_status.equals("BOC114O")) {
			resolve_result = "열람인계대상자료(정리완료자료)";
		} else if (working_status.equals("BOC211O")) {
			resolve_result = "긴급정리대상자료";
		} else if (working_status.equals("BOL111O")) {
			resolve_result = "열람인계자료(배가대상자료)";
		} else if (working_status.equals("BOL112N")) {
			resolve_result = "배가자료(소장자료)";
		} else if (working_status.equals("BOL113O")) {
			resolve_result = "수리제본자료";
		} else if (working_status.equals("BOL114O")) {
			resolve_result = "파손자료";
		} else if (working_status.equals("BOL115O")) {
			resolve_result = "제적자료";
		} else if (working_status.equals("BOL211O")) {
			resolve_result = "관외대출자료";
		} else if (working_status.equals("BOL212O")) {
			resolve_result = "관내대출자료";
		} else if (working_status.equals("BOL213O")) {
			resolve_result = "특별대출자료";
		} else if (working_status.equals("BOL214O")) {
			resolve_result = "긴급대출자료";
		} else if (working_status.equals("BOL215O")) {
			resolve_result = "배달자료";
		} else if (working_status.equals("SEA111N")) {
			resolve_result = "구입입수자료(인계대상자료)";
		} else if (working_status.equals("SEA112N")) {
			resolve_result = "구입결호자료";
		} else if (working_status.equals("SEA211N")) {
			resolve_result = "기증입수자료(인계대상자료)";
		} else if (working_status.equals("SEA212N")) {
			resolve_result = "기증결호자료";
		} else if (working_status.equals("SEB111N")) {
			resolve_result = "제본인계자료";
		} else if (working_status.equals("SEB112N")) {
			resolve_result = "제본결정자료";
		} else if (working_status.equals("SEB113N")) {
			resolve_result = "제본발주자료";
		} else if (working_status.equals("SEB114N")) {
			resolve_result = "제본검수자료(등록인계대상자료)";
		} else if (working_status.equals("SEL111O")) {
			resolve_result = "실시간인계자료(실시간배가대상자료)";
		} else if (working_status.equals("SEL112N")) {
			resolve_result = "실시간배가자료";
		} else if (working_status.equals("SEL113O")) {
			resolve_result = "실시간폐기자료";
		} else if (working_status.equals("SER111N")) {
			resolve_result = "등록인계자료";
		} else if (working_status.equals("SER112N")) {
			resolve_result = "등록자료(정리인계대상자료)";
		} else if (working_status.equals("SER113O")) {
			resolve_result = "가원부번호부여자료";
		} else if (working_status.equals("SEC111N")) {
			resolve_result = "정리대상자료";
		} else if (working_status.equals("SEC112O")) {
			resolve_result = "열람인계대상자료(정리완료자료)";
		} else if (working_status.equals("SEL211O")) {
			resolve_result = "열람인계자료(배가대상자료)";
		} else if (working_status.equals("SEL212N")) {
			resolve_result = "배가자료(소장자료)";
		} else if (working_status.equals("SEL213O")) {
			resolve_result = "수리제본자료";
		} else if (working_status.equals("SEL214O")) {
			resolve_result = "파손자료";
		} else if (working_status.equals("SEL215O")) {
			resolve_result = "제적자료";
		} else if (working_status.equals("SEL311O")) {
			resolve_result = "관외대출자료";
		} else if (working_status.equals("SEL312O")) {
			resolve_result = "관내대출자료";
		} else if (working_status.equals("SEL313O")) {
			resolve_result = "특별대출자료";
		} else if (working_status.equals("SEL314O")) {
			resolve_result = "긴급대출자료";
		} else if (working_status.equals("SEL315O")) {
			resolve_result = "배달자료";
		} else {
			resolve_result = working_status;
		}
		return resolve_result;
	}
}
