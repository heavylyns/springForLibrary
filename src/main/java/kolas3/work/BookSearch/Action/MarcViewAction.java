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
import kolas3.work.BookSearch.Form.MarcViewForm;
import kolas3.work.BookSearch.Model.AnalizeCommand;
import kolas3.work.BookSearch.Model.MakeFramevalue;
import kolas3.work.BookSearch.Model.SearchResultSet;
import kolas3.work.BookSearch.Model.SockProcess;

@Controller
@RequestMapping(value = "/kolas3")
public class MarcViewAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (MarcViewAction.class);

	@RequestMapping(value="/book.marcview.do")
	public ModelAndView  marcView(HttpServletRequest request, HttpServletResponse response , MarcViewForm form) throws Kolas3Exception {
		try {
			ModelAndView mav = new ModelAndView();
			MarcViewForm marcviewform = (MarcViewForm) form;

			MakeFramevalue framevalue = new MakeFramevalue();

			SockProcess sockprocess = new SockProcess();

			AnalizeCommand anlizecommand = new AnalizeCommand();

			SearchResultSet searchresultset = new SearchResultSet();

			logger.debug(marcviewform.getMsa());
			logger.debug(marcviewform.getReckey());

			// create 207 frame
			ArrayList marcviewframe = framevalue.makeFrame207(marcviewform);
			logger.debug((String) marcviewframe.get(0));
			logger.debug((String) marcviewframe.get(1));

			// send and receive data to/from the KOLAS server
			String AnalizeBeforeData = sockprocess.pro3sock((String) marcviewframe.get(0), (String) marcviewframe.get(1));

			// decipher returned data
			Vector analizecommand = anlizecommand.analize(AnalizeBeforeData);

			// convert result into array list
			ArrayList marcviewlist = searchresultset.resultsetmarc(analizecommand);
			//logger.debug();

			// add array-form data into view
			mav.addObject("search_result", marcviewlist);
			mav.setViewName("kolas3/BookSearch/marcview");

			return mav; //mapping.findForward("search_result");
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
