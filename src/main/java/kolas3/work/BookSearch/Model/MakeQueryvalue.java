package kolas3.work.BookSearch.Model;

import kolas3.Kolas3Properties;
import kolas3.common.xml.Parser;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.work.BookSearch.Action.SearchAction;
import kolas3.work.BookSearch.Form.SearchForm;

public class MakeQueryvalue {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (MakeQueryvalue.class);
	public String makeQuery(SearchForm searchform) {

		String query = "";

		Parser parser = new Parser(Kolas3Properties.getXml_makequery_path()); // "c:/eco_config/xml/makequery.xml"

		String value1 = "";
		String value2 = "";
		String value3 = "";
		String buhovalue1 = "";
		String buhovalue2 = "";
		String buhovalue3 = "";
		String buhovalue4 = "";
		String local = "";
		String mgc = "";
		if (searchform.getMgc() != null) {
			mgc = searchform.getMgc().replace(" ", "");
		}
		if (searchform.getLocal() != null) {
			local = searchform.getLocal().replace(" ", "");
		}
		logger.info("mode: " + searchform.getMode());

		HanjaTrans hanja = new HanjaTrans();
		if ((searchform.getNobook() != null) && (!searchform.getNobook().equals(""))) {
			parser.setValue("nobook");
			String tmpquery = parser.getValue();
			if (tmpquery != null) {
				query = tmpquery.replace("nobook", searchform.getNobook());
			}
			parser.setValue("nobooksort");
			String nobooksort = parser.getValue();
			if (nobooksort != null) {
				searchform.setSort(nobooksort);
			}
			parser.setValue("nobookmsa");
			String nobookmsa = parser.getValue();
			if (nobooksort != null) {
				searchform.setMsa(nobookmsa);
			}
			parser.setValue("nobooklimitpage");
			String nobooklimitpage = parser.getValue();
			if (nobooklimitpage != null) {
				searchform.setLimitpage(nobooklimitpage);
			}
			parser.setValue("nobookstartpage");
			String nobookstartpage = parser.getValue();
			if (nobookstartpage != null) {
				searchform.setStartpage(nobookstartpage);
			}
			parser.setValue("nobookmode");
			String nobookmode = parser.getValue();
			if (nobookmode != null) {
				searchform.setMode(nobookmode);
			}
			parser.setValue("nobookjongbook");
			String nobookjongbook = parser.getValue();
			if (nobookjongbook != null) {
				searchform.setJongbook(nobookjongbook);
			}
			return query.toUpperCase();
		}
		if (!searchform.getMode().equals("1")) {
			value1 = searchform.getValue1().replace(" ", "");
			value2 = searchform.getValue2().replace(" ", "");
			value3 = searchform.getValue3().replace(" ", "");
			buhovalue1 = searchform.getBuhovalue1().replace(" ", "");
			buhovalue2 = searchform.getBuhovalue2().replace(" ", "");
			buhovalue3 = searchform.getBuhovalue3().replace(" ", "");
			buhovalue4 = searchform.getBuhovalue4().replace(" ", "");
			value1 = value1.replace("'", "");
			value2 = value2.replace("'", "");
			value3 = value3.replace("'", "");
			buhovalue1 = buhovalue1.replace("'", "");
			buhovalue2 = buhovalue2.replace("'", "");
			buhovalue3 = buhovalue3.replace("'", "");
			buhovalue4 = buhovalue4.replace("'", "");

			value1 = hanja._transHanja(value1);
			value2 = hanja._transHanja(value2);
			value3 = hanja._transHanja(value3);
			if (searchform.getBeforequery() != null) {
				query = query + searchform.getBeforequery();
				if (value1 != "") {
					query = query + " AND";
				}
			}
			if (!value1.equals("")) {
				if ((value1.substring(0, 1).equals("\""))
						&& (value1.substring(value1.length() - 1, value1.length()).equals("\""))) {
					parser.setValue("value1-1");
					String tmpquery = parser.getValue();
					String tmpquery1 = tmpquery.replace("field1", searchform.getField1());
					query = query
							+ tmpquery1.replace("value1", value1.substring(1, value1.length() - 1).replace(" ", ""));
				} else {
					parser.setValue("value1");
					String tmpquery = parser.getValue();
					String tmpquery1 = tmpquery.replace("field1", searchform.getField1());
					query = query + tmpquery1.replace("value1", value1.replace(" ", ""));
				}
			}
			if (!value2.equals("")) {
				if ((value2.substring(0, 1).equals("\""))
						&& (value2.substring(value2.length() - 1, value2.length()).equals("\""))) {
					parser.setValue("value2-1");
					String tmpquery = parser.getValue();
					String tmpquery1 = "";
					if (!value1.equals("")) {
						tmpquery1 = " " + searchform.getAon1() + tmpquery;
					} else {
						tmpquery1 = tmpquery;
					}
					String tmpquery2 = tmpquery1.replace("field2", searchform.getField2());
					query = query
							+ tmpquery2.replace("value2", value2.substring(1, value2.length() - 1).replace(" ", ""));
				} else {
					parser.setValue("value2");
					String tmpquery = parser.getValue();
					String tmpquery1 = "";
					if (!value1.equals("")) {
						tmpquery1 = " " + searchform.getAon1() + tmpquery;
					} else {
						tmpquery1 = tmpquery;
					}
					String tmpquery2 = tmpquery1.replace("field2", searchform.getField2());
					query = query + tmpquery2.replace("value2", value2.replace(" ", ""));
				}
			}
			if (!value3.equals("")) {
				if ((value3.substring(0, 1).equals("\""))
						&& (value3.substring(value3.length() - 1, value3.length()).equals("\""))) {
					parser.setValue("value3-1");
					String tmpquery = parser.getValue();
					String tmpquery1 = "";
					if ((!value1.equals("")) && (!value2.equals(""))) {
						tmpquery1 = " " + searchform.getAon2() + tmpquery;
					} else {
						tmpquery1 = tmpquery;
					}
					String tmpquery2 = tmpquery1.replace("field3", searchform.getField3());
					query = query
							+ tmpquery2.replace("value3", value3.substring(1, value3.length() - 1).replace(" ", ""));
				} else {
					parser.setValue("value3");
					String tmpquery = parser.getValue();
					String tmpquery1 = "";
					if ((!value1.equals("")) || (!value2.equals(""))) {
						tmpquery1 = " " + searchform.getAon2() + tmpquery;
					} else {
						tmpquery1 = tmpquery;
					}
					String tmpquery2 = tmpquery1.replace("field3", searchform.getField3());
					query = query + tmpquery2.replace("value3", value3.replace(" ", ""));
				}
			}
			if (!buhovalue1.equals("")) {
				parser.setValue("buhovalue1");
				String tmpquery = parser.getValue();
				String tmpquery1 = "";
				if ((!value1.equals("")) || (!value2.equals("")) || (!value3.equals(""))) {
					tmpquery1 = " " + searchform.getAon3() + tmpquery;
				} else {
					tmpquery1 = tmpquery;
				}
				String tmpquery2 = tmpquery1.replace("buho1", searchform.getBuho1());
				query = query + tmpquery2.replace("buhovalue1", buhovalue1);
			}
			if (!buhovalue2.equals("")) {
				parser.setValue("buhovalue2");
				String tmpquery = parser.getValue();
				String tmpquery1 = "";
				if ((!value1.equals("")) || (!value2.equals("")) || (!value3.equals("")) || (!buhovalue1.equals(""))) {
					tmpquery1 = " " + searchform.getAon4() + tmpquery;
				} else {
					tmpquery1 = tmpquery;
				}
				String tmpquery2 = tmpquery1.replace("buho2", searchform.getBuho2());
				query = query + tmpquery2.replace("buhovalue2", buhovalue2);
			}
			if (!buhovalue3.equals("")) {
				parser.setValue("buhovalue3");
				String tmpquery = parser.getValue();
				String tmpquery1 = tmpquery.replace("aon5", searchform.getAon5());
				query = query + tmpquery1.replace("buhovalue3", buhovalue3);
			}
			if (!buhovalue4.equals("")) {
				parser.setValue("buhovalue4");
				String tmpquery = parser.getValue();
				String tmpquery1 = tmpquery.replace("aon6", searchform.getAon6());
				query = query + tmpquery1.replace("buhovalue4", buhovalue4);
			}
			if ((!searchform.getStartyear().replace(" ", "").equals(""))
					&& (!searchform.getEndyear().replace(" ", "").equals(""))) {
				parser.setValue("pubyear");
				String tmpquery = parser.getValue();
				String tmpquery1 = tmpquery.replace("startyear", searchform.getStartyear().replace(" ", ""));
				query = query + tmpquery1.replace("endyear", searchform.getEndyear().replace(" ", ""));
			}
			if (searchform.getVod() != null) {
				parser.setValue("vod");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("vod", searchform.getVod());
			}
			if (searchform.getWon() != null) {
				parser.setValue("won");
				String tmpquery = parser.getValue();
				if (searchform.getVod() == null) {
					String tmpquery1 = tmpquery.replace("OR", "AND");
					query = query + tmpquery1.replace("won", searchform.getWon());
				} else {
					query = query + tmpquery.replace("won", searchform.getWon());
				}
			}
			if (searchform.getCd() != null) {
				parser.setValue("cd");
				String tmpquery = parser.getValue();
				if ((searchform.getVod() == null) && (searchform.getWon() == null)) {
					String tmpquery1 = tmpquery.replace("OR", "AND");
					query = query + tmpquery1.replace("cd", searchform.getCd());
				} else {
					query = query + tmpquery.replace("cd", searchform.getCd());
				}
			}
			if (!searchform.getTextlang().equals("")) {
				parser.setValue("textlang");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("textlang", searchform.getTextlang());
			}
			if (!searchform.getSimplelang().equals("")) {
				parser.setValue("simplelang");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("simplelang", searchform.getSimplelang());
			}
			if (!searchform.getMsa().equals("")) {
				parser.setValue("dbt");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("dbt", searchform.getMsa());
			}
			if (!searchform.getFormclass().equals("")) {
				String formclass = searchform.getFormclass();
				if (formclass.equals("일반도서")) {
					parser.setValue("form01");
					query = query + parser.getValue();
				}
				if (formclass.equals("학위논문")) {
					parser.setValue("form02");
					query = query + parser.getValue();
				}
				if (formclass.equals("교과서")) {
					parser.setValue("form03");
					query = query + parser.getValue();
				}
				if (formclass.equals("학습서")) {
					parser.setValue("form04");
					query = query + parser.getValue();
				}
				if (formclass.equals("만화")) {
					parser.setValue("form05");
					query = query + parser.getValue();
				}
				if (formclass.equals("아동/청소년도서")) {
					parser.setValue("form06");
					query = query + parser.getValue();
				}
				if (formclass.equals("잡지")) {
					parser.setValue("form07");
					query = query + parser.getValue();
				}
				if (formclass.equals("신문")) {
					parser.setValue("form08");
					query = query + parser.getValue();
				}
				if (formclass.equals("비도서")) {
					parser.setValue("form09");
					query = query + parser.getValue();
				}
				if (formclass.equals("점자자료")) {
					parser.setValue("form10");
					query = query + parser.getValue();
				}
			}
		} else {
			if (!searchform.getNew_start().equals("")) {
				parser.setValue("new_start");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("new_start", searchform.getNew_start());
			}
			if (!searchform.getReg_code().equals("")) {
				parser.setValue("reg_code");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("reg_code", searchform.getReg_code());
			}
			if (!searchform.getTen_new().equals("")) {
				parser.setValue("ten_new");
				String tmpquery = parser.getValue();
				query = query + tmpquery.replace("ten_new", searchform.getTen_new());
			}
		}
		local = local.replaceAll(" ", "");
		if (!local.equals("")) {
			parser.setValue("local");
			String tmpquery = parser.getValue();
			query = query + tmpquery.replace("local", local);
		}
		if (!mgc.equals("")) {
			parser.setValue("mgc");
			String tmpquery = parser.getValue();
			query = query + tmpquery.replace("mgc", mgc);
		}
		String select1 = "3";
		if (searchform.getSelect1() != null) {
			select1 = searchform.getSelect1();
			if ((select1.equals("1")) && (searchform.getSubselect1() != null)) {
				String subselect1 = searchform.getSubselect1();
				query = query + " AND " + subselect1;
			}
			if ((select1.equals("2")) && (searchform.getSubselect2() != null)) {
				String subselect2 = searchform.getSubselect2();
				query = query + " AND " + subselect2;
			}
		}
		if ((searchform.getRegno() != null) && (!searchform.getRegno().equals(""))) {
			query = "BRN:" + searchform.getRegno();
		}
		if ((searchform.getDuty() != null) && (!searchform.getDuty().equals("0"))) {
			parser.setValue("union");
			String union = "";
			if (parser.getValue() != null) {
				union = parser.getValue();
				query = query + union;
			}
		}
		query = query.replaceAll("%", "");
		return query.toUpperCase();
	}
}
