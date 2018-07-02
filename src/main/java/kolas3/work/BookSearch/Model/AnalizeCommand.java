package kolas3.work.BookSearch.Model;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Action.SearchAction;

public class AnalizeCommand {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Vector analize(String AnalizeBeforeData) {
		Util Util = new Util();
		Vector record = new Vector();
		int recordcnt = 0;
		String recordbody = "";
		logger.info(AnalizeBeforeData);
		String tmprecordcnt = Util.substr(AnalizeBeforeData, 6, 5);
		recordcnt = Integer.parseInt(tmprecordcnt.trim());
		String tmpframe_length = Util.substr(AnalizeBeforeData, 11, 6);

		int frame_length = Integer.parseInt(tmpframe_length.trim());

		recordbody = Util.substr(AnalizeBeforeData, 17, frame_length);

		Util.setIDX();

		record.clear();
		for (int i = 0; i < recordcnt; i++) {
			int last = recordbody.length();
			logger.info("##last" + last);
			recordbody = recordbody.substring(Util.idx, last);

			Util.setIDX();

			logger.info("##recordbody:" + recordbody);
			logger.info(String.valueOf(Util.idx + 4));
			logger.info(recordbody.substring(Util.idx, Util.idx + 4));
			int TagCnt = Integer.parseInt(recordbody.substring(Util.idx, Util.idx + 4));

			last = recordbody.length();

			recordbody = recordbody.substring(Util.idx + 4, last);

			String[] rRecord = new String[TagCnt];
			for (int s = 0; s < TagCnt; s++) {
				int pctmp = Integer.parseInt(Util.substr(recordbody, Util.idx, 5));

				Util.idx += Util.tmpidx;

				rRecord[s] = Util.substr(recordbody, Util.idx, pctmp);

				String[] tmpDataArr = Util.Split(rRecord[s], "\021");
				if (tmpDataArr.length < 2) {
					rRecord[s] = tmpDataArr[0];
				} else {
					rRecord[s] = tmpDataArr[0];
				}
				logger.info(rRecord[s]);

				Util.idx += Util.tmpidx;
			}
			record.addElement(rRecord);
			logger.info("!----------------!");
		}
		return record;
	}


}
