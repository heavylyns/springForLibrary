package kolas3.work.BookSearch.Action;

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
import kolas3.work.BookSearch.Model.InsertLoan;

@Controller
@RequestMapping(value = "/kolas3")
public class InsertLoanAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (InsertLoanAction.class);

	@RequestMapping(value="/book.insertloan.do")
	public ModelAndView  insertloan(HttpServletRequest request,	HttpServletResponse response) throws Kolas3Exception {
		try {

		ModelAndView mav = new ModelAndView();
		String loginselbook = request.getParameter("Loginselbook");
		String[] selbooks;
		if (loginselbook != null) {
			selbooks = loginselbook.split("/");
		} else {
			selbooks = request.getParameterValues("selbook");
		}
		String msa = request.getParameter("msa");
		logger.debug("selbooks[0]==>" + selbooks[0]);

		ArrayList insertloanresult = new ArrayList();
		InsertLoan insertloan = new InsertLoan();
		SessionManager Session = new SessionManager(request);
		if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
			String userid = (String) Session.getAttribute("USER_NO");
			String user_manage = (String) Session.getAttribute("USER_MANAGE");
			String insertloancheck = "";
			for (int i = 0; i < selbooks.length; i++) {
				insertloancheck = insertloan.insert(selbooks[i], userid, msa, user_manage);
				logger.debug("loancheck:" + insertloancheck);
				insertloanresult.add(insertloancheck);
			}
			mav.addObject("insertloan_result", insertloanresult);
			mav.addObject("menu_id", "insertloan_result");
			//mav.setViewName("kolas3/BookSearch/searchResult");
			//return mapping.findForward("insertloan_result");
			mav.setViewName("kolas3/BookSearch/insertloan_result");
			return mav ;//mapping.findForward("Login");
		}
		mav.addObject("path", "/kolas3/book.insertloan.do");
		mav.addObject("menu_id", "Login");
		mav.addObject("data", selbooks);

		mav.setViewName("kolas3/UserService/ServiceLendCondition");
		return mav ;//mapping.findForward("Login");
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
