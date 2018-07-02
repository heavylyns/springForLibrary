package kolas3.work.UserService.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.login.SessionManager;
import kolas3.common.utils.IndexKeywordManager;
import kolas3.work.UserService.Form.BookRequestForm;
import kolas3.work.UserService.Model.BookRequestMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class BookRequestAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (BookRequestDataViewAction.class);
	private boolean BookRequestCheck = false;
	private String ZipCodeResult = "";
	private String CivilNoResult = "";
	private String TempIndexTtile = "";
	private String TempIndexAuthor = "";
	private String TempIndexPublisher = "";

	@RequestMapping(value="/user.BookRequest.do")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse reponse, BookRequestForm form) {
		ModelAndView mav = new ModelAndView();
	    IndexKeywordManager KeywordMgr = new IndexKeywordManager();
	    BookRequestMgr RequestMgr = new BookRequestMgr();
	    BookRequestForm RequestForm = (BookRequestForm)form;
	    SessionManager Session = new SessionManager(request);
	    reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");
	    if ((Session.getAttribute("USER_NO") == null) && (Session.getAttribute("USER_NO").equals("")))
	    {
	      //request.setAttribute("menu_id", "service_menu1");
	      //return map.findForward("Login");
	
			mav.addObject("path", "/kolas3/UserService/LoanStatus.do");
			mav.addObject("menu_id", "Login");
	
			//return map.findForward("ListView");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;
	
	    }
	    this.TempIndexTtile = RequestForm.getTitle();
	    this.TempIndexAuthor = RequestForm.getAuthor();
	    this.TempIndexPublisher = RequestForm.getPublisher();
	    
	
	
	    this.CivilNoResult = (RequestForm.getCivil_no_first() + "-" + RequestForm.getCivil_no_second());
	    RequestForm.setCivil_no_result(this.CivilNoResult);
	    
	
	    this.ZipCodeResult = (RequestForm.getZip1() + "-" + RequestForm.getZip2());
	    RequestForm.setZip_code(this.ZipCodeResult);
	    
	
	    RequestForm.setFurnish_status("1");
	    if (RequestForm.getSms_yn().equals("")) {
	      RequestForm.setSms_yn("N");
	    }
	    if ((RequestForm.getReservation_yn().equals("")) || (RequestForm.getReservation_yn() == null)) {
	      RequestForm.setReservation_yn("N");
	    }
	    if ((this.TempIndexTtile != null) && (!this.TempIndexTtile.equals(""))) {
	      RequestForm.setIndex_title(KeywordMgr.CharacterSetControl(this.TempIndexTtile));
	    }
	    if ((this.TempIndexAuthor != null) && (!this.TempIndexAuthor.equals(""))) {
	      RequestForm.setIndex_author(KeywordMgr.CharacterSetControl(this.TempIndexAuthor));
	    }
	    if ((this.TempIndexPublisher != null) && (!this.TempIndexPublisher.equals(""))) {
	      RequestForm.setIndex_publisher(KeywordMgr.CharacterSetControl(this.TempIndexPublisher));
	    }
	    String tmpuser_no = (String)Session.getAttribute("USER_NO");
	    RequestForm.setUser_no(tmpuser_no);
	    this.BookRequestCheck = RequestMgr.RequestBookInsert(RequestForm);
	    if (this.BookRequestCheck) {
	      //return new ActionForward("/RequestListBook.do?List_mode=insert&page=1", false);
			mav.setViewName("forward:/kolas3/user.RequestListBook.do?List_mode=insert&page=1");
	    	return mav;
	    }
	    //return new ActionForward("/RequestListBook.do?List_mode=insert&page=1", false);
		mav.setViewName("forward:/kolas3/user.RequestListBook.do?List_mode=insert&page=1");
    	return mav;
	}
}
