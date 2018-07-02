package kolas3.work.UserService.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.common.login.SessionManager;
import kolas3.common.utils.ECOLogManager;
import kolas3.work.UserService.Form.UserLoanDelayForm;
import kolas3.work.UserService.Model.UserLoanStatusMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class UserLoanReturnDelayAction {
	private ECOLogManager LogMgr = new ECOLogManager();

	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (BookRequestListAction.class);

	/*
		<action path="/ReturnDelay"
					name="LoanDelayForm"
					type="work.UserService.Action.UserLoanReturnDelayAction">

					<forward name="ListView" path="/iframe/UserService/ServiceLendCondition.jsp"></forward>
		</action>
		*/

	@RequestMapping(value = "/user.ReturnDelay.do")
	public ModelAndView ReturnDelay(HttpServletRequest request, HttpServletResponse reponse , UserLoanDelayForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		SessionManager Session = new SessionManager(request);
		UserLoanDelayForm LoanDelayForm = (UserLoanDelayForm) form;
		UserLoanStatusMgr LoanDelayMgr = new UserLoanStatusMgr();

		String[] Temp_Reckey_Set = new String[100];

		String Sucount_Message = "";
		String UserMessage = "";

		boolean UpdateCheck = false;

		int sucount = 0;
		int totalcount = 0;
		if ((Session.getAttribute("USER_NO") == null) || (Session.getAttribute("USER_NO").equals(""))) {
			mav.addObject("path", "/user.LoanStatus.do");
			mav.addObject("menu_id", "Login");

			//return map.findForward("ListView");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;
		}
		String User_no = (String) Session.getAttribute("USER_NO");
		LoanDelayForm.setUser_no(User_no);
		if (request.getParameter("rec_key") != null) {
			String Temp_Reckey = "";

			Temp_Reckey = request.getParameter("rec_key");
			Temp_Reckey_Set = Temp_Reckey.split("/");
			if (Temp_Reckey_Set.length > 0) {
				LoanDelayForm.setDelay_ca(Temp_Reckey_Set);
			}
		}
		for (int i = 0; i < Temp_Reckey_Set.length; i++) {
			totalcount++;

			String S_recKey = "";
			String S_bookKey = "";
			if (Temp_Reckey_Set[i] == null) {
				break;
			}
			S_recKey = Temp_Reckey_Set[i];
			S_bookKey = LoanDelayMgr.LoanBookKeyMgr(S_recKey);
			if ((S_recKey != null) && (S_bookKey != null)) {
				LoanDelayForm.setColoan_reckey(S_recKey);
				LoanDelayForm.setBook_key(S_bookKey);
			}
			LoanDelayForm = LoanDelayMgr.LoanReservationMgr(LoanDelayForm);
			if (!LoanDelayForm.getUser_message().equals("")) {
				UserMessage = UserMessage + "√ " + LoanDelayForm.getUser_message() + "<br>";

				LoanDelayForm.setUser_message("");
			} else {
				LoanDelayForm = LoanDelayMgr.LoanReturnDelayMgr(LoanDelayForm);

				LoanDelayForm = LoanDelayMgr.LoanUserClassMgr(LoanDelayForm);
				LoanDelayForm = LoanDelayMgr.LoanReturnDelayModeMgr(LoanDelayForm);
				if (!LoanDelayForm.getUser_message().equals("")) {
					UserMessage = LoanDelayForm.getUser_message();

					UserMessage = UserMessage + "√ " + LoanDelayForm.getUser_message() + "<br>";

					LoanDelayForm.setUser_message("");
				} else {
					LoanDelayForm = LoanDelayMgr.LoanReturnDelayDateMgr(LoanDelayForm);
					if (!LoanDelayForm.getUser_message().equals("")) {
						UserMessage = UserMessage + "√ " + LoanDelayForm.getUser_message() + "<br>";

						LoanDelayForm.setUser_message("");
					} else {
						LoanDelayForm = LoanDelayMgr.LoanReturnDelayCountMgr(LoanDelayForm);
						if (!LoanDelayForm.getUser_message().equals("")) {
							UserMessage = UserMessage + "√ " + LoanDelayForm.getUser_message() + "<br>";

							LoanDelayForm.setUser_message("");
						} else {
							LoanDelayForm = LoanDelayMgr.LoanReturnDelayHolidayMgr(LoanDelayForm);

							LoanDelayForm = LoanDelayMgr.LoanHolidayInfoMgr(LoanDelayForm);

							UpdateCheck = LoanDelayMgr.LoanDelayUpdateMgr(LoanDelayForm);
							if (UpdateCheck) {
								sucount++;
							}
						}
					}
				}
			}
		}
		Sucount_Message = "전체: " + totalcount + "건" + "  " + "완료: " + sucount + "  건";

		mav.addObject("COUNT_MESSAGE", Sucount_Message);
		mav.addObject("USER_MESSAGE", UserMessage);

		//return new ActionForward("/LoanStatus.do", false);

		mav.setViewName("forward:/kolas3/user.LoanStatus.do");
		//mav.setViewName("redirect:/kolas3/user.LoanStatus.do");
		//mav.setViewName("kolas3/UserService/ServiceLoanStatus");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
