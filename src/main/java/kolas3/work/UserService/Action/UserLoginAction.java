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
import kolas3.work.UserService.Form.UserLoginForm;
import kolas3.work.UserService.Model.UserLoginMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class UserLoginAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoginAction.class);

	private boolean LoginCheck = false;
	private String User_id = "";
	private String User_pwd = "";

	@RequestMapping(value="/user.login.do")
	public ModelAndView login(HttpServletRequest request,	HttpServletResponse response, UserLoginForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		response.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");

		logger.debug("headerstarted");

		UserLoginMgr LoginMgr = new UserLoginMgr();
		UserLoginForm LoginForm = (UserLoginForm) form;
		logger.debug(LoginForm.getUrl());
		String user_id = "";
		String user_no = "";

		LoginForm.setIdcheck("");
		try {
			String temp = LoginForm.getUser_id();
			if (!temp.equals("")) {
				user_id = temp;

				LoginForm.setUser_id(user_id);
			}
			user_no = LoginForm.getUser_no();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!LoginForm.getUser_id().equals("")) {
			LoginForm = LoginMgr.UserLoginCheck(LoginForm);

			LoginForm.setLogin_flag("USER_ID");

			logger.debug("사용자ID 로그인 방식");
		} else if ((!LoginForm.getUser_no().equals("")) && (LoginForm.getUser_card().equals(""))) {
			user_no = LoginForm.getUser_no();
			LoginForm = LoginMgr.UserNoCheck(LoginForm);

			LoginForm.setLogin_flag("USER_NO");

			logger.debug("대출자 번호 로그인 방식");
		} else if (!LoginForm.getUser_card().equals("")) {
			LoginForm = LoginMgr.UserCardCheck(LoginForm);

			LoginForm.setLogin_flag("USER_CARD");

			logger.debug("카드 비번 로그인 방식");
		}
		logger.debug(LoginForm.getIdcheck());
		if (LoginForm.getIdcheck().equals("SUCCESS")) {
			SessionManager Session = new SessionManager(request);

			Session.getSession().setAttribute("USER_KEY", LoginForm.getUser_id());
			Session.getSession().setAttribute("USER_NO", LoginForm.getUser_no());
			Session.getSession().setAttribute("USER_MANAGE", LoginForm.getUser_manage());
			Session.getSession().setAttribute("NAME", LoginForm.getName());
			Session.getSession().setAttribute("admin_check", "2");
			LoginForm.setUser_no("");
			LoginForm.setUser_id("");

			Session.setMaxInterval(6000);

			int SessionTime = Session.getMaxInterval();
			if (Session.getSession().getAttribute("MODE") != null) {
				if ((LoginForm.getUrl().equals("/menu_select.do?method=service&menu_id=service_menu3"))
						&& (Session.getSession().getAttribute("MODE").equals("search"))) {
					//return new ActionForward("/RequestDataView.do", true);
					mav.setViewName("redirect:/kolas3/user.menu_select.do?method=service&menu_id=service_menu3");
					return mav;
				}
			}
			if (LoginForm.getUrl().equals("/service_move.do")) {
				//return new ActionForward("/service_move.do", true);
				mav.setViewName("redirect:/kolas3/user.service_move.do");
				return mav;

			}
			if (LoginForm.getUrl().equals("/menu_select.do?method=service&menu_id=service_menu3")) {
				//return new ActionForward("/menu_select.do?method=service&menu_id=service_menu3", true);
				mav.setViewName("redirect:/kolas3/user.menu_select.do?method=service&menu_id=service_menu3");
				return mav;

			}
			if (LoginForm.getUrl().equals("/menu_select.do?method=service&menu_id=service_menu1")) {
				//return new ActionForward("/menu_select.do?method=service&menu_id=service_menu1", true);
				mav.setViewName("redirect:/kolas3/user./menu_select.do?method=service&menu_id=service_menu1");
				return mav;

			}
			if (LoginForm.getUrl().equals("../pb/add_pb.jsp")) {
				mav.addObject("bookkeys", request.getParameterValues("bookkeys"));
				mav.addObject("titles", request.getParameterValues("titles"));
				mav.addObject("authors", request.getParameterValues("authors"));
				mav.addObject("publishers", request.getParameterValues("publishers"));
				mav.addObject("pubyears", request.getParameterValues("pubyears"));
				mav.addObject("jongbooks", request.getParameterValues("jongbooks"));
				mav.addObject("offsets", request.getParameterValues("offsets"));
				mav.addObject("beforequerys", request.getParameterValues("beforequerys"));
				mav.addObject("msas", request.getParameterValues("msas"));
				mav.addObject("sorts", request.getParameterValues("sorts"));

				//return new ActionForward("/homepage/pb/submit_pb.jsp", false);
				mav.setViewName("redirect:/kolas3/user./homepage/pb/submit_pb.jsp");
				return mav;
			}
			if (LoginForm.getUrl().equals("../pb/main.jsp")) {
				//return new ActionForward("/homepage/pb/main.jsp", false);
				mav.setViewName("redirect:/homepage/pb/main.jsp");
				return mav;
			}
			if (LoginForm.getUrl().equals("/insertloan.do")) {
				String[] TempRec_key = LoginForm.getRec_key();
				String RecKeyStr = "";
				for (int i = 0; i < TempRec_key.length; i++) {
					RecKeyStr = RecKeyStr + TempRec_key[i];
					RecKeyStr = RecKeyStr + "/";
				}
				//return new ActionForward("/homepage/book/insertloan.do?Loginselbook=" + RecKeyStr, true);\
				mav.setViewName("redirect:/homepage/book/insertloan.do?Loginselbook=" + RecKeyStr);
				return mav;
			}
			if (LoginForm.getUrl().equals("/loanStatus.do")) {
				LoginForm.setUrl("");
				logger.debug("path1");
				//return new ActionForward("/LoanStatus.do", true);
				mav.setViewName("redirect:/kolas3/user.LoanStatus.do");
				return mav;
			}
			if (LoginForm.getUrl().equals("/delivery.do")) {
				LoginForm.setUrl("");
				//return new ActionForward("/delivery.do", true);
				mav.setViewName("redirect:/kolas3/user.delivery.do");
				return mav;
			}
			if (LoginForm.getUrl().equals("/LoanTotalLsit.do?mode=default")) {
				LoginForm.setUrl("");
				//return new ActionForward("/LoanTotalLsit.do?mode=default", true);
				mav.setViewName("redirect:/kolas3/user.LoanTotalLsit.do?mode=default");
				return mav;
			}
			if (LoginForm.getUrl().equals("/LoanTotalLsit.do")) {
				LoginForm.setUrl("");
				//return new ActionForward("/LoanTotalLsit.do", true);
				mav.setViewName("redirect:/kolas3/user.LoanTotalLsit.do");
				return mav;
			}
			if (LoginForm.getUrl().equals("/RequestDateView.do")) {
				LoginForm.setUrl("");
				//return new ActionForward("/RequestDateView.do", true);
				mav.setViewName("redirect:/kolas3/user.RequestDateView.do");
				return mav;
			}
			if (LoginForm.getUrl().equals("/RequestListBook.do")) {
				LoginForm.setUrl("");
				//return new ActionForward("/RequestListBook.do", true);
				mav.setViewName("redirect:/kolas3/user.RequestListBook.do");
				return mav;
			}
			//return new ActionForward("/service_move.do", true);
			System.out.println("uid::::::::::::::::::::"+LoginForm.getGpin_hash());
			System.out.println("pw::::::::::::::::::::"+LoginForm.getIpin_hash());
			mav.addObject("name",LoginForm.getName());
			mav.addObject("user_no",user_no);
			mav.addObject("user_id",LoginForm.getUser_id());
			mav.addObject("user_pwd",LoginForm.getUser_pwd());
			mav.addObject("uid",LoginForm.getGpin_hash());
			mav.addObject("pw",LoginForm.getIpin_hash());
			mav.addObject("returnUrl","/kolas3/user.LoanStatus.do");
			mav.setViewName("redirect:/bizsiren/siren.jsp");
			//mav.setViewName("redirect:/kolas3/user.service_move.do");
			return mav;
		}
		logger.debug("사용자 로그인 정보 오류!");
		mav.addObject("LoginForm",LoginForm);
		//mav.setViewName("redirect:/kolas3/user.ServiceLoginFailed.do");
		mav.setViewName("kolas3/UserService/ServiceLoginFailed");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
