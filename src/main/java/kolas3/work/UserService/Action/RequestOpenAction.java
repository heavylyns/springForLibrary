package kolas3.work.UserService.Action;

import kolas3.common.Kolas3Exception;
import kolas3.common.login.SessionManager;
import java.io.PrintStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/kolas3")
public class RequestOpenAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (BookRequestListAction.class);

	@RequestMapping(value="/user.hope.do")
	public ModelAndView hope(HttpServletRequest request, HttpServletResponse reponse) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");

		SessionManager Session = new SessionManager(request);
		if (request.getParameter("manage_code") != null) {
			Session.getSession().setAttribute("BOOK_MANAGE", request.getParameter("manage_code"));
			logger.debug("book_manage:" + request.getParameter("manage_code"));
			Session.setMaxInterval(600000000);
		}
		logger.debug("book_manage:" + request.getParameter("manage_code"));

		int DumpFlag = 0;
		if (DumpFlag == 0) {
			//return new ActionForward("/menu_select.do?method=service&menu_id=service_menu3&mode=search", false);
			mav.setViewName("forward:/kolas3/user.menu_select.do?method=service&menu_id=service_menu3&mode=search");
			//mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;
		}
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
