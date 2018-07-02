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
import kolas3.work.UserService.Form.BookRequestForm;
import kolas3.work.UserService.Model.BookRequestMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class BookRequestDataViewAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (BookRequestDataViewAction.class);


	/*
 					<forward name="Request_search" path="/iframe/UserService/ServiceBookRequest.jsp"></forward>
 					<forward name="Request" path="/iframe/UserService/ServiceBookRequest.jsp"></forward>
 					<forward name="Login" path="/iframe/UserService/ServiceLendCondition.jsp"></forward>
	 * */
	@RequestMapping(value="/user.RequestDataView.do")
	public ModelAndView RequestDataView(HttpServletRequest request, HttpServletResponse reponse, BookRequestForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		BookRequestForm RequestForm = (BookRequestForm) form;
		SessionManager Session = new SessionManager(request);
		BookRequestMgr RequestViewMgr = new BookRequestMgr();
		reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");

			if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
				String user_no = "";
		
				user_no = (String) Session.getAttribute("USER_NO");
		
				logger.debug("접속한 대출자 번호==>" + user_no);
		
				RequestForm.setUser_no(user_no);
		
				RequestForm = RequestViewMgr.RequestViewMgr(RequestForm);
		
				logger.debug("신청자:" + RequestForm.getApplicant_name());
				logger.debug("주소:" + RequestForm.getAddress1());
				logger.debug("저자:" + RequestForm.getAuthor());
				logger.debug("주민번호:" + RequestForm.getCivil_no_result());
				logger.debug("이메일:" + RequestForm.getE_mail());
				logger.debug("비치상태:" + RequestForm.getFurnish_status());
				logger.debug("전화번호:" + RequestForm.getTel());
		
				mav.addObject("LoanRequestForm", RequestForm);
		
				mav.addObject("menu_id", "service_menu3");
				if (Session.getSession().getAttribute("MODE") != null) {
					if (Session.getSession().getAttribute("MODE").equals("search")) {
						//return map.findForward("Request_search");
						mav.setViewName("kolas3/UserService/ServiceBookRequest");
						return mav;
					}
				}
				//return map.findForward("Request");
				mav.setViewName("kolas3/UserService/ServiceBookRequest");
				return mav;
			}

			mav.addObject("path", "/kolas3/user.RequestDataView.do");
			mav.addObject("menu_id", "Login");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			//return map.findForward("Login");
			///iframe/UserService/ServiceLendCondition.jsp
			return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
