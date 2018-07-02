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
import kolas3.common.utils.ECOLogManager;
import kolas3.work.UserService.Form.UserLoanStatusForm;
import kolas3.work.UserService.Model.UserLoanStatusMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class UserLoanStatusAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoanStatusAction.class);
	private ECOLogManager LogMgr = new ECOLogManager();


	/*
		      <forward name="Success" path="/iframe/UserService/ServiceLoanStatus.jsp"></forward>
  		      <forward name="Login" path="/iframe/UserService/ServiceLendCondition.jsp"></forward>
	 * */
	@RequestMapping(value="/user.LoanStatus.do")
	public ModelAndView LoanStatus(HttpServletRequest request,	HttpServletResponse reponse , UserLoanStatusForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		SessionManager Session = new SessionManager(request);
		UserLoanStatusForm LoanStatusForm = (UserLoanStatusForm) form;
		UserLoanStatusMgr LoanStatusMgr = new UserLoanStatusMgr();
		reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");
		try {
			String TempErrorCode = "";
			if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
				ArrayList LoanStatusList = new ArrayList();
				String User_no = (String) Session.getAttribute("USER_NO");

				LoanStatusForm.setUser_no(User_no);
				if (request.getAttribute("USER_MESSAGE") != null) {
					TempErrorCode = (String) request.getAttribute("USER_MESSAGE");

					mav.addObject("USER_MESSAGE", TempErrorCode);
				}
				LoanStatusForm = LoanStatusMgr.SetEnvironmentMgr(LoanStatusForm);

				LoanStatusForm = LoanStatusMgr.LoanClassMgr(LoanStatusForm);
				if (LoanStatusForm.getInferior_class().equals("1")) {
					String ErrorMessage = "";
					if ((LoanStatusForm.getLoan_stopdate() != null)
							&& (!LoanStatusForm.getLoan_stopdate().equals(""))) {
						String name = (String) Session.getAttribute("NAME");
						ErrorMessage = "[" + name + "]님은 대출정지회원 입니다.대출정지일(" + LoanStatusForm.getLoan_stopdate()
								+ ")까지 책을 대출하실 수 없습니다.<br>연체중인 도서를 반납시 연체된 기간만큼 대출정지일이 부여됩니다.";

						mav.addObject("STOP_USER", ErrorMessage);
					} else if ((LoanStatusForm.getLoan_stopdate() == null)
							|| (LoanStatusForm.getLoan_stopdate().equals(""))) {
						String name = (String) Session.getAttribute("NAME");

						ErrorMessage = "[" + name
								+ "]님은 대출정지회원 입니다.대출정지일까지 책을 대출하실 수 없습니다.<br>연체중인 도서를 반납시 연체된 기간만큼 대출정지일이 부여됩니다.";
						mav.addObject("STOP_USER", ErrorMessage);
					}
				} else if (LoanStatusForm.getInferior_class().equals("2")) {
					LoanStatusForm.setError_code("도서관 제적회원 입니다. 책을 대여하실수 없습니다.");
				}
				String user_manage = (String) Session.getAttribute("USER_MANAGE");
				LoanStatusList = LoanStatusMgr.LoanInfoListMgr(LoanStatusForm, user_manage);
				if (LoanStatusList == null) {
					mav.addObject("LoanStatusForm", LoanStatusForm);
					mav.addObject("LoanStatusList", LoanStatusList);
					mav.addObject("menu_id", "LoanStatus");
					mav.setViewName("kolas3/UserService/ServiceLoanStatus");

					//return map.findForward("Success");
					///iframe/UserService/ServiceLoanStatus.jsp
					return mav;
				}
				mav.addObject("LoanStatusForm", LoanStatusForm);
				mav.addObject("LoanStatusList", LoanStatusList);
				mav.addObject("menu_id", "LoanStatus");
				//return map.findForward("Success");
				///iframe/UserService/ServiceLoanStatus.jsp
				mav.setViewName("kolas3/UserService/ServiceLoanStatus");
				return mav;
			}
			mav.addObject("path", "/kolas3/UserService/LoanStatus.do");
			mav.addObject("menu_id", "Login");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			//return map.findForward("Login");
			///iframe/UserService/ServiceLendCondition.jsp
			return mav;
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		//return map.findForward("Login");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
