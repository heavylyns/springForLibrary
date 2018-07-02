package kolas3.work.BookSearch.Model;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public int idx = 0;
	public int tmpidx = 0;

	public String[] Split(String pData, String cutTag) {
		String[] result = (String[]) null;
		String selfData = "";
		pData = pData + cutTag;

		int pDataLen = pData.length();
		if (pDataLen > 0) {
			int cnt = 0;
			for (int i = 0; i < pDataLen; i++) {
				if (pData.substring(i, i + 1).equals(cutTag)) {
					cnt++;
				}
			}
			result = new String[cnt];

			int s = 0;
			for (int i = 0; i < pDataLen; i++) {
				String oneData = pData.substring(i, i + 1);
				if (oneData.indexOf(cutTag) != 0) {
					selfData = selfData + oneData;
				} else {
					result[s] = selfData;
					selfData = "";
					s++;
				}
			}
		} else {
			result = new String[0];
			result[0] = "";
		}
		return result;
	}

	public int setIDX() {
		this.idx = 0;
		return 0;
	}

	public String substr(String data, int subidx, int cnt) {
		byte[] utf8 = (byte[]) null;
		int strLen = 0;
		int start = this.idx;
		int end = this.idx + cnt;
		String result_Str = "";

		this.tmpidx = 0;
		while (start < end) {
			String tmp = data.substring(subidx, subidx + 1);
			try {
				utf8 = tmp.getBytes("UTF-8");
				result_Str = result_Str + tmp;

				strLen = utf8.length;
				start += strLen;

				subidx++;
				this.tmpidx += 1;
			} catch (UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
		return result_Str;
	}

	public void print(String Mag) {
		logger.debug(Mag);
	}
}
