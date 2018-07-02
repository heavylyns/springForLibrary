package kolas3.work.BookSearch.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.Kolas3Properties;

public class HanjaTrans {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String hanjaFilePath = Kolas3Properties.getXml_hanja_path();
	private String hanjaFile = "hanja.txt";
	private Hashtable<String, String> HanjaData = new Hashtable();
	private String Before;
	private String Result;

	private void _hanjaFileOpen() {
		BufferedReader br = null;
		FileInputStream bs = null;
		try {
			File file = new File(this.hanjaFilePath, this.hanjaFile);
			if (!file.exists()) {
				throw new FileNotFoundException("File Not Found");
			}
			bs = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(bs, "UTF-8"));

			int i = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] _tmpData = line.split("\\|");
				this.HanjaData.put(_tmpData[0], _tmpData[1]);
				i++;
			}
			if (br != null) {
				br.close();
			}
			if (bs != null) {
				bs.close();
			}
		} catch (IOException e) {
			logger.debug("[FileOpenException]" + e);
		}
	}

	private void _hanjaTrans() {
		for (int i = 0; i < this.Before.length(); i++) {
			String _tmpData = this.Before.substring(i, i + 1);
			if (_HanjaExp(_UniToHex(_tmpData)).equals("H")) {
				this.Result += (String) this.HanjaData.get(_tmpData);
			} else {
				this.Result += _tmpData;
			}
		}
	}

	private String _HanjaExp(String HexCode) {
		String rst;
		if (((HexCode.compareTo("9fa5") <= 0) && (HexCode.compareTo("3400") >= 0))
				|| ((HexCode.compareTo("fa2d") <= 0) && (HexCode.compareTo("f900") >= 0))) {
			rst = "H";
		} else {
			rst = "E";
		}
		return rst;
	}

	private String _UniToHex(String str) {
		StringBuffer uni_s = new StringBuffer();
		String temp_s = null;
		for (int i = 0; i < str.length(); i++) {
			temp_s = Integer.toHexString(str.charAt(i));
			uni_s.append("00" + temp_s);
		}
		return uni_s.toString();
	}

	public String _transHanja(String str) {
		this.Before = "";
		this.Result = "";
		try {
			this.Before = str;
			_hanjaFileOpen();
			_hanjaTrans();
		} catch (Exception e) {
			logger.error("",e);
			e.printStackTrace();
		}
		return this.Result;
	}
}
