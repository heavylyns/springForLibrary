package kolas3.work.BookSearch.Action;

import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.work.BookSearch.Form.DetailViewForm;
import kolas3.work.BookSearch.Model.AnalizeCommand;
import kolas3.work.BookSearch.Model.MakeFramevalue;
import kolas3.work.BookSearch.Model.SearchResultSet;
import kolas3.work.BookSearch.Model.SockProcess;

@Controller
@RequestMapping(value = "/kolas3")
public class DetailViewAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (DetailViewAction.class);

	@RequestMapping(value="/book.detailview_result.do")
	public ModelAndView  detailviewResult(HttpServletRequest request, HttpServletResponse response, DetailViewForm form) throws Kolas3Exception {
		try {
			ModelAndView mav = new ModelAndView();
			String type = "";
			
			if(request.getParameter("p_type") != "" && request.getParameter("p_type") != null){
				type = request.getParameter("p_type");
			}
			
			DetailViewForm searchform = (DetailViewForm) form;

			ArrayList sojanglist = null;

			MakeFramevalue framevalue = new MakeFramevalue();

			SockProcess sockprocess = new SockProcess();

			AnalizeCommand anlizecommand = new AnalizeCommand();

			SearchResultSet searchresultset = new SearchResultSet();


			logger.debug("searchform:"+searchform.toString());

			ArrayList frame202 = framevalue.makeFrame202(searchform);
			logger.debug("frame202.get(0):"+(String) frame202.get(0));
			logger.debug("frame202.get(1):"+(String) frame202.get(1));
			ArrayList AnalizeBeforeData = sockprocess.detailviewsock((String) frame202.get(0), (String) frame202.get(1));
			mav.addObject("sendframe", (String) frame202.get(0));
			logger.debug(AnalizeBeforeData.toString());
			mav.addObject("getframe", AnalizeBeforeData);
			mav.addObject("getframe1", AnalizeBeforeData.get(0));
			mav.addObject("getframe2", AnalizeBeforeData.get(1));
			logger.debug("command" + AnalizeBeforeData.get(1));
			Vector analizecommand = anlizecommand.analize((String) AnalizeBeforeData.get(0));
			Vector analizecommandsojang = anlizecommand.analize((String) AnalizeBeforeData.get(1));
			ArrayList detaillist = searchresultset.resultsetdetail(analizecommand);
			if (searchform.getDuty() != null) {
				if (searchform.getDuty().equals("0")) {
					sojanglist = searchresultset.dutyresultsetsojang(analizecommandsojang, searchform.getMsa(), detaillist,searchform.getBook_code());
				} else {
					sojanglist = searchresultset.resultsetsojang(analizecommandsojang, searchform.getMsa(), detaillist,searchform.getBook_code());
				}
			} else {
				sojanglist = searchresultset.resultsetsojang(analizecommandsojang, searchform.getMsa(), detaillist,searchform.getBook_code());
			}
			int historycount = 0;
			if (searchform.getHistorycount() != null) {
				historycount = Integer.parseInt(searchform.getHistorycount());
			}
			mav.addObject("historycount", String.valueOf(historycount + 1));
			mav.addObject("offset", searchform.getOffset());
			mav.addObject("sort", searchform.getSort());
			mav.addObject("maxoffset", searchform.getMaxoffset());
			mav.addObject("beforequery", searchform.getBeforequery());
			mav.addObject("detailviewmsa", searchform.getMsa());
			mav.addObject("detaillist", detaillist);
			mav.addObject("sojanglist", sojanglist);
			mav.addObject("menu_id", "detailview");



			if(!type.equals("pop")){
				mav.setViewName("kolas3/BookSearch/detailview_result");
				return mav;
			}else {
				mav.setViewName("kolas3/BookSearch/detailview_result_pop");
				return mav;
			}

		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
