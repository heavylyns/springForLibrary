package kolas3.work.UserService.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
public class UserLoanReserCancelAction {
	private ECOLogManager LogMgr = new ECOLogManager();
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 *
	 * <action path="/ReserveCancel" name="LoanDelayForm"
	 * type="kolas3.work.UserService.Action.UserLoanReserCancelAction">
	 *
	 * <forward name="ListView" path=".Layout_Service"></forward> </action>
	 */
	@RequestMapping(value="/user.ReserveCancel.do")
	public ModelAndView ReserveCancel(HttpServletRequest request,HttpServletResponse reponse , UserLoanDelayForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		SessionManager Session = new SessionManager(request);
		UserLoanDelayForm LoanReserCacelForm = (UserLoanDelayForm) form;
		UserLoanStatusMgr LoanReserCacelMgr = new UserLoanStatusMgr();

		String Sucount_Message = "";
		String UserMessage = "";

		boolean UpdateCheck = false;
		if ((Session.getAttribute("USER_NO") == null) || (Session.getAttribute("USER_NO").equals(""))) {
			mav.addObject("path", "/kolas3/UserService/LoanStatus.do");
			mav.addObject("menu_id", "Login");

			//return map.findForward("ListView");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;

		}
		String User_NO = (String) Session.getAttribute("USER_NO");

		LoanReserCacelForm.setUser_no(User_NO);
		if (request.getParameter("rec_key") != null) {
			String Temp_Reckey = "";

			Temp_Reckey = request.getParameter("rec_key");
			String[] Temp_Reckey_Set = Temp_Reckey.split("/");
			if (Temp_Reckey_Set.length > 0) {
				LoanReserCacelForm.setReserv_ca(Temp_Reckey_Set);
			}
		}
		if ((LoanReserCacelForm.getReserv_ca() != null) && (LoanReserCacelForm.getReserv_ca().length > 0)) {
			UpdateCheck = LoanReserCacelMgr.LoanReservationCancelMgr(LoanReserCacelForm);
		}
		if (UpdateCheck) {
			UserMessage = LoanReserCacelForm.getUser_message();
			mav.addObject("USER_MESSAGE", UserMessage);
			mav.addObject("COUNT_MESSAGE", LoanReserCacelForm.getScount_message());

			//return new ActionForward("/LoanStatus.do", false);
			mav.setViewName("forward:/kolas3/user.LoanStatus.do");
			return mav;
		}
		UserMessage = LoanReserCacelForm.getUser_message();
		mav.addObject("USER_MESSAGE", UserMessage);
		mav.addObject("COUNT_MESSAGE", LoanReserCacelForm.getScount_message());

		//return new ActionForward("/LoanStatus.do", false);
		mav.setViewName("forward:/kolas3/user.LoanStatus.do");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}

	}
}
