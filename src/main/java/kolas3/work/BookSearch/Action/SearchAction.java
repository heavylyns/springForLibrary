package kolas3.work.BookSearch.Action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.work.BookSearch.Form.SearchForm;
import kolas3.work.BookSearch.Form.SearchListForm;
import kolas3.work.BookSearch.Model.AnalizeCommand;
import kolas3.work.BookSearch.Model.MakeFramevalue;
import kolas3.work.BookSearch.Model.MakeQueryvalue;
import kolas3.work.BookSearch.Model.SearchResultSet;
import kolas3.work.BookSearch.Model.SockProcess;

@Controller
@RequestMapping(value = "/kolas3")
public class SearchAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* 자료 검색 */
	@RequestMapping(value = "/book.search_result.do")
	@ExceptionHandler({ Kolas3Exception.class })
	public ModelAndView searchResult(HttpServletRequest request, HttpServletResponse response, SearchForm form)
			throws Kolas3Exception {
		try {

			ModelAndView mav = new ModelAndView();
			response.setHeader("P3P",
					"CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");
			String type = "";
			if(request.getParameter("p_type") != "" && request.getParameter("p_type") != null){
				type = request.getParameter("p_type");
			}
			
			SearchForm searchform = (SearchForm) form;
			String mainsearch = "0";
			if (request.getParameter("mainsearch") != null) {
				mainsearch = "1";
			}
			if (mainsearch.equals("1")) {
				searchform.setValue1(new String(searchform.getValue1().getBytes("8859_1"), "EUC-KR"));
			}
			MakeQueryvalue queryvalue = new MakeQueryvalue();

			MakeFramevalue framevalue = new MakeFramevalue();

			SockProcess sockprocess = new SockProcess();

			AnalizeCommand anlizecommand = new AnalizeCommand();

			SearchResultSet searchresultset = new SearchResultSet();

			String query = queryvalue.makeQuery(searchform);
			// logger.info(">>>:"+query);

			ArrayList frame = framevalue.makeFrame201(query, searchform);
			// logger.info((String) frame.get(0));
			// logger.info((String) frame.get(1));

			// send data
			String AnalizeBeforeData = sockprocess.searchsock((String) frame.get(0), (String) frame.get(1));
			// logger.info("<<<:" + AnalizeBeforeData);
			mav.addObject("sendframe", (String) frame.get(0));
			mav.addObject("getframe", AnalizeBeforeData);

			Vector analizecommand = anlizecommand.analize(AnalizeBeforeData);

			ArrayList<SearchListForm> searchlist = searchresultset.resultset(analizecommand, searchform);
			if (Integer.parseInt(searchform.getStartpage()) == 1) {
				mav.addObject("leftstartpage", String.valueOf(1));
			} else {
				mav.addObject("leftstartpage", String.valueOf(Integer.parseInt(searchform.getStartpage()) - 1));
			}
			String mat_class = "0";
			if (searchform.getMsa() == null) {
				mat_class = "0";
			} else if (searchform.getMsa().equals("")) {
				mat_class = "0";
			} else if (searchform.getMsa().equals("M")) {
				mat_class = "1";
			} else if (searchform.getMsa().equals("S")) {
				mat_class = "2";
			}
			mav.addObject("mat_class", mat_class);
			String jong = "";
			if (searchform.getJongbook().equals("")) {
				jong = "jong";
			} else {
				jong = "book";
			}
			mav.addObject("jong", jong);
			mav.addObject("mode", searchform.getMode());
			mav.addObject("jongbook", searchform.getJongbook());
			mav.addObject("resultcount", searchlist.get(0));
			mav.addObject("sort", searchform.getSort());
			mav.addObject("rightstartpage", String.valueOf(Integer.parseInt(searchform.getStartpage()) + 1));
			mav.addObject("startpage", String.valueOf(Integer.parseInt(searchform.getStartpage())));
			mav.addObject("beforelimitpage", String.valueOf(Integer.parseInt(searchform.getLimitpage())));
			mav.addObject("beforequery", query);
			mav.addObject("search_result", searchlist);
			if (searchform.getJongbook().equals("new")) {
				logger.info("resut_new");
				mav.addObject("menu_id", "result_new");
			} else {
				mav.addObject("menu_id", "search_result");
			}

			Enumeration params = request.getAttributeNames();
			logger.debug("----------------------------");
			while (params.hasMoreElements()) {
				String name = (String) params.nextElement();
				logger.debug(name + " : " + request.getAttribute(name));
			}
			logger.debug("----------------------------");

			searchform.reset();
			
			if(!type.equals("pop")){
				mav.setViewName("kolas3/BookSearch/search_result");
				return mav;
			}else {
				mav.setViewName("kolas3/BookSearch/search_result_pop");
				return mav;
			}
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}


	@RequestMapping(value = "/book.receipMng.do")
	public ModelAndView receipMng(HttpServletRequest request, HttpServletResponse response) throws Kolas3Exception {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("kolas3/BookSearch/receipMng");
			return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}

}
