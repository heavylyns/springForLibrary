package kolas3.work.UserService.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.common.login.SessionManager;
import kolas3.work.UserService.Form.UserLoanTotalForm;
import kolas3.work.UserService.Model.UserLoanTotalListMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class UserLoanTotalAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoanTotalAction.class);
/*
		<forward name="ListView" path="/iframe/UserService/ServiceLendCondition.jsp"></forward>
		<forward name="TotalList" path="/iframe/UserService/ServiceLoanTotalList.jsp"></forward>
	*/
	@RequestMapping(value="/user.LoanTotalLsit.do")
	public ModelAndView LoanTotalLsit(HttpServletRequest request,	HttpServletResponse response, UserLoanTotalForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		response.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");
		SessionManager Session = new SessionManager(request);
		UserLoanTotalForm LoanTotalStatusForm = (UserLoanTotalForm) form;
		UserLoanTotalListMgr LoanTotalListlMgr = new UserLoanTotalListMgr();

		ArrayList LoanTotalArray = new ArrayList();
		if ((Session.getAttribute("USER_NO") == null) || (Session.getAttribute("USER_NO").equals(""))) {
			mav.addObject("path", "/LoanTotalLsit.do?mode=default");
			mav.addObject("menu_id", "Login");

			//return map.findForward("ListView");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;

		}
		String User_no = (String) Session.getAttribute("USER_NO");
		LoanTotalStatusForm.setUser_no(User_no);
		if (request.getParameter("mode") != null) {
			String mode = "";

			mode = request.getParameter("mode");
			LoanTotalStatusForm.setTerm_search_flag(mode);
			if (mode.equals("default")) {
				mav.addObject("search_mode", mode);
			} else if (mode.equals("search")) {
				mav.addObject("search_mode", mode);
				mav.addObject("s_year", LoanTotalStatusForm.getS_year());
				mav.addObject("s_month", LoanTotalStatusForm.getS_month());
				mav.addObject("s_day", LoanTotalStatusForm.getS_day());
				mav.addObject("e_year", LoanTotalStatusForm.getE_year());
				mav.addObject("e_month", LoanTotalStatusForm.getE_month());
				mav.addObject("e_day", LoanTotalStatusForm.getE_day());
				mav.addObject("select_field", LoanTotalStatusForm.getSelect_field());
			}
		}
		LoanTotalArray = LoanTotalListlMgr.LoanListMgr(LoanTotalStatusForm);
		if (LoanTotalListlMgr.getTempAraay().size() != 0) {
			LoanTotalStatusForm = (UserLoanTotalForm) LoanTotalListlMgr.getTempAraay().get(0);
		}
		if (LoanTotalArray == null) {
			mav.addObject("LoanTotalArray", LoanTotalArray);
			mav.addObject("menu_id", "LoanTotalList");
			mav.addObject("LoanTotalForm", LoanTotalStatusForm);

			//return map.findForward("TotalList");
			mav.setViewName("kolas3/UserService/ServiceLoanTotalList");
			return mav;

		}
		mav.addObject("total_pagecount", String.valueOf(LoanTotalStatusForm.getTotal_pagecount()));
		mav.addObject("current_pagecount", String.valueOf(LoanTotalStatusForm.getCurrent_pagecount()));
		mav.addObject("pageGroupStart", String.valueOf(LoanTotalStatusForm.getPageGroupStart()));
		mav.addObject("pageGroupEnd", String.valueOf(LoanTotalStatusForm.getPageGroupEnd()));
		mav.addObject("width_page", String.valueOf(LoanTotalStatusForm.getWidth_page()));
		mav.addObject("prev_page", String.valueOf(LoanTotalStatusForm.getPrev_page()));
		mav.addObject("next_page", String.valueOf(LoanTotalStatusForm.getNext_page()));
		mav.addObject("LoanTotalArray", LoanTotalArray);
		mav.addObject("menu_id", "LoanTotalList");
		mav.addObject("LoanTotalForm", LoanTotalStatusForm);

		//return map.findForward("TotalList");
		mav.setViewName("kolas3/UserService/ServiceLoanTotalList");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
