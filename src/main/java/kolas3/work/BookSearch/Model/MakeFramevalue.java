package kolas3.work.BookSearch.Model;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Form.DetailViewForm;
import kolas3.work.BookSearch.Form.MarcViewForm;
import kolas3.work.BookSearch.Form.SearchForm;

public class MakeFramevalue {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String stx = "\002";
	private String etx = "\003";

	public ArrayList makeFrame201(String query, SearchForm searchform) throws Exception {
		ArrayList returnframe = new ArrayList();
		String frame = "";
		String quitframe = "";

		frame = makeAD201Frame(query, searchform);
		quitframe = setQuitFrame("AD201");
		returnframe.add(frame);
		returnframe.add(quitframe);

		return returnframe;
	}

	public ArrayList makeFrame202(DetailViewForm searchform) throws Exception {
		ArrayList returnframe = new ArrayList();
		String frame = "";
		String quitframe = "";

		frame = makeAD202Frame(searchform);
		quitframe = setQuitFrame("AD202");
		returnframe.add(frame);
		returnframe.add(quitframe);

		return returnframe;
	}

	public ArrayList makeFrame207(MarcViewForm searchform) throws Exception {
		ArrayList returnframe = new ArrayList();
		String frame = "";
		String quitframe = "";

		frame = makeA0207Frame(searchform);
		quitframe = setQuitFrame("A0207");
		returnframe.add(frame);
		returnframe.add(quitframe);

		return returnframe;
	}

	public String makeAD201Frame(String query, SearchForm searchform) throws Exception {
		String body = "";
		String head = "";
		String collection = "";
		String field = "";
		logger.debug("종,책검색" + searchform.getJongbook());
		if (!searchform.getJongbook().equals("new")) {
			if (searchform.getJongbook().equals("_book")) {
				collection = "tot_book";
				field = "TI,AI,PI,YR,CALLNOINFO,USERLEVELINFO,BSL,MC,CY,AY,CAI,BWS,BRN,DBT";
			} else {
				field = "TI,AI,PI,YR,CALLNOINFO,USERLEVELINFO,MPL,MC,CY,AY,DBT";
				collection = "tot";
			}
		} else if (searchform.getJongbook().equals("new")) {
			collection = "dan";

			query = query + " AND SPC:1 NOT ULC:CL";
			field = "TI,AI,PI,YR,CALLNOINFO,USERLEVELINFO,MPL,MC,CY,AY";
		}
		if ((!searchform.getJongbook().equals("new")) && (searchform.getDuty() != null)
				&& (searchform.getDuty().equals("0"))) {
			if (searchform.getJongbook().equals("_book")) {
				field = "TI,AI,PI,YR,CALLNOINFO,USERLEVELINFO,BSL,MC,CY,AY,CAI,BWS,BRN,DBT";
				collection = "tot_book_work";
			} else {
				field = "TI,AI,PI,YR,CALLNOINFO,USERLEVELINFO,MPL,MC,CY,AY,DBT,WS";
				collection = "tot_work";
			}
		}
		String command = "AD201";
		String st = String.format("%1s", new Object[] { this.stx });
		String et = String.format("%1s", new Object[] { this.etx });

		head = head + String.format("%5s", new Object[] { command });
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		body = body + String.format("%4d", new Object[] { Integer.valueOf(7) });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(collection.getBytes("UTF-8").length) });
		body = body + String.format(collection, new Object[0]);
		body = body + String.format("%5d", new Object[] { Integer.valueOf(query.getBytes("UTF-8").length) });
		body = body + String.format(new String(query.getBytes("UTF-8"), "UTF-8"), new Object[0]);
		body = body
				+ String.format("%5d", new Object[] { Integer.valueOf(searchform.getSort().getBytes("UTF-8").length) });
		body = body + String.format(searchform.getSort(), new Object[0]);
		body = body + String.format("%5d", new Object[] { Integer.valueOf(6) });
		body = body + String.format("%6s", new Object[] { searchform.getStartpage() });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(6) });
		body = body + String.format("%6s", new Object[] { searchform.getLimitpage() });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(6) });
		body = body + String.format("%6d", new Object[] { Integer.valueOf(100) });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(field.getBytes("UTF-8").length) });
		body = body + String.format(field, new Object[0]);

		String bodyleng = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		String tmpframe = st + head + bodyleng + body + et;
		String frame = new String(tmpframe.getBytes("UTF-8"), "UTF-8");
		return frame;
	}

	public String makeAD202Frame(DetailViewForm searchform) throws Exception {
		String command = "AD202";
		String msa = searchform.getMsa();
		String offset = searchform.getOffset();
		String tmpquery = new String(searchform.getBeforequery().getBytes("UTF-8"), "UTF-8");
		String body = "";
		String head = "";
		String collection = "tot";
		if (searchform.getJongbook().equals("new")) {
			tmpquery = tmpquery + " AND SPC:1 NOT ULC:CL";
			collection = "dan";
		}
		String jongbook = "";

		if (!searchform.getMsa().equals("M")) {
			if (!searchform.getMsa().equals("S")) {
				searchform.getMsa().equals("A");
			}
		}
		if (searchform.getJongbook().equals("_book")) {
			jongbook = "_book";
		} else {
			jongbook = "";
		}
		collection = collection + jongbook;
		if ((searchform.getDuty() != null) && (searchform.getDuty().equals("0"))) {
			collection = collection + "_work";
		}
		
		String st = String.format("%1s", new Object[] { this.stx });
		String et = String.format("%1s", new Object[] { this.etx });

		head = head + String.format("%5s", new Object[] { command });
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		body = body + String.format("%4d", new Object[] { Integer.valueOf(5) });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(collection.getBytes("UTF-8").length) });
		body = body + String.format(collection, new Object[0]);
		body = body + String.format("%5d", new Object[] { Integer.valueOf(1) });
		body = body + String.format("%1s", new Object[] { msa });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(tmpquery.getBytes("UTF-8").length) });
		body = body + String.format(tmpquery, new Object[0]);
		body = body + String.format("%5d", new Object[] { Integer.valueOf(6) });
		body = body + String.format("%6s", new Object[] { offset });
		body = body
				+ String.format("%5d", new Object[] { Integer.valueOf(searchform.getSort().getBytes("UTF-8").length) });
		body = body + String.format(searchform.getSort(), new Object[0]);
		String bodyleng = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		String tmpframe = st + head + bodyleng + body + et;
		String frame = new String(tmpframe.getBytes("UTF-8"), "UTF-8");
		return frame;
	}

	public String makeA0207Frame(MarcViewForm searchform) throws Exception {
		String body = "";
		String head = "";
		String command = "A0207";
		String bodyleng = "";

		head = String.format("%5s", new Object[] { command });
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		body = String.format("%4d", new Object[] { Integer.valueOf(2) });
		body = body + String.format("%5d", new Object[] { Integer.valueOf(1) });
		body = body + String.format("%1s", new Object[] { searchform.getMsa() });
		body = body + String.format("%5d",
				new Object[] { Integer.valueOf(searchform.getReckey().getBytes("UTF-8").length) });
		body = body + String.format(searchform.getReckey(), new Object[0]);

		bodyleng = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		String tmpframe = this.stx + head + bodyleng + body + this.etx;
		String frame = new String(tmpframe.getBytes("UTF-8"), "UTF-8");
		return frame;
	}

	public String setQuitFrame(String command) throws Exception {
		String SendBuffer = "";
		String tmpframe = "";
		String strTmp = "";
		String ctmp = "";
		String Msg = "QUIT";
		ctmp = String.format("%5s", new Object[] { command });
		SendBuffer = SendBuffer + ctmp;

		ctmp = String.format("%05d", new Object[] { Integer.valueOf(1) });
		SendBuffer = SendBuffer + ctmp;

		ctmp = String.format("%04d", new Object[] { Integer.valueOf(1) });
		strTmp = strTmp + ctmp;

		ctmp = String.format("%05d", new Object[] { Integer.valueOf(Msg.getBytes("UTF-8").length) });
		strTmp = strTmp + ctmp + Msg;

		ctmp = String.format("%06d", new Object[] { Integer.valueOf(strTmp.getBytes("UTF-8").length) });
		SendBuffer = SendBuffer + ctmp + strTmp;

		tmpframe = this.stx + SendBuffer + this.etx;
		String frame = new String(tmpframe.getBytes("UTF-8"), "UTF-8");
		return frame;
	}
}
