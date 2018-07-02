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

@Controller
@RequestMapping(value = "/kolas3")
public class UserLogoutAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLogoutAction.class);

	@RequestMapping(value="/user.Logout.do")
	public ModelAndView execute(HttpServletRequest request,	HttpServletResponse reponse) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");

		SessionManager Session = new SessionManager(request);

		Session.getSession().removeAttribute("USER_KEY");
		Session.getSession().removeAttribute("USER_NO");
		Session.getSession().removeAttribute("admin_check");
		Session.getSession().removeAttribute("USER_MANAGE");
		Session.getSession().removeAttribute("NAME");
		String manage_code = (String) Session.getAttribute("BOOK_MANAGE");
		if (manage_code != null) {
			manage_code = "?manage_code=" + manage_code;
		} else {
			manage_code = "";
		}
		logger.debug("manage" + manage_code);
		if (request.getParameter("menu_id") != null) {
			String LogoutMenu = "";

			LogoutMenu = request.getParameter("menu_id");

			logger.debug("LogoutMenu===>" + LogoutMenu);
			if (LogoutMenu.equals("RequestBookList")) {
				mav.addObject("path", "/kolas3/book.RequestListBook.do");
				if (Session.getAttribute("MODE") != null) {
					if (Session.getAttribute("MODE").equals("search")) {
						Session.SessionExit();
						//return new ActionForward("/BookStand/hope.do" + manage_code, true);
						mav.setViewName("redirect:/kolas3/book.hope.do"+ manage_code);
						return mav;
					}
				}
			}
			if (LogoutMenu.equals("MyBook")) {
				mav.addObject("path", "../pb/main.jsp");
			}
			if (LogoutMenu.equals("delivery")) {
				//return new ActionForward("/delivery.do", true);
				mav.setViewName("forward:/kolas3/user.delivery.do");
				return mav;
			}
		}
		Session.SessionExit();

		//return map.findForward("Login");
		mav.setViewName("kolas3/UserService/ServiceLendCondition");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
