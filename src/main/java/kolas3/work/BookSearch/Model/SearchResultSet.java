package kolas3.work.BookSearch.Model;

import java.util.ArrayList;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.Kolas3Properties;
import kolas3.common.xml.Parser;
import kolas3.work.BookSearch.Form.DetailViewListForm;
import kolas3.work.BookSearch.Form.MarcViewListForm;
import kolas3.work.BookSearch.Form.SearchForm;
import kolas3.work.BookSearch.Form.SearchListForm;

public class SearchResultSet {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	String loc = Kolas3Properties.getXml_nosearch_path(); // "c:/eco_config/xml/nosearch.xml";

	public ArrayList<SearchListForm> resultset(Vector analizecommand, SearchForm searchform) {
		BookWorkingStatus bookworkingstatus = new BookWorkingStatus();
		ConvertCode convertcode = new ConvertCode();
		ArrayList<SearchListForm> searchlist = new ArrayList<SearchListForm>();
		for (int i = 0; i < analizecommand.size(); i++) {
			String[] tmplist = (String[]) analizecommand.get(i);
			int tmplistlength = tmplist.length;
			SearchListForm searchlistform = new SearchListForm();
			if (!tmplist[0].equals("EMP")) {
				if (i == 0) {
					searchlistform.setResultcount(tmplist[0]);
					int pagecount = 0;
					if (Integer.parseInt(tmplist[0]) % Integer.parseInt(searchform.getLimitpage()) == 0) {
						pagecount = Integer.parseInt(tmplist[0]) / Integer.parseInt(searchform.getLimitpage());
					} else {
						pagecount = (Integer.parseInt(tmplist[0])
								- Integer.parseInt(tmplist[0]) % Integer.parseInt(searchform.getLimitpage()))
								/ Integer.parseInt(searchform.getLimitpage()) + 1;
					}
					searchlistform.setPagecount(String.valueOf(pagecount));
					searchlist.add(searchlistform);
				} else {
					if (searchform.getStartpage().equals("1")) {
						searchlistform.setOffset(String.valueOf(i));
					} else {
						searchlistform.setOffset(String.valueOf((Integer.parseInt(searchform.getStartpage()) - 1) * Integer.parseInt(searchform.getLimitpage()) + i));
					}
					if (!searchform.getJongbook().equals("_book")) {
						searchlistform.setReckey(tmplist[0]);
						searchlistform.setTitle_info(tmplist[1]);
						searchlistform.setAuthor_info(tmplist[2]);
						searchlistform.setPub_info(tmplist[3]);
						searchlistform.setPub_year_info(tmplist[4]);
						searchlistform.setCalno(tmplist[5]);
						searchlistform.setUserlevelinfo(tmplist[6]);
						searchlistform.setPlace_info(tmplist[7]);
						searchlistform.setMat_code(tmplist[8]);
						searchlistform.setContents_yn(tmplist[9]);
						searchlistform.setAbstracts_yn(tmplist[10]);
						if (tmplistlength > 11) {
							searchlistform.setMsa(tmplist[11]);
						} else {
							searchlistform.setMsa("M");
						}
						if ((!searchform.getJongbook().equals("new")) && (searchform.getDuty() != null)
								&& (searchform.getDuty().equals("0"))) {
							searchlistform.setWorkingstatus(bookworkingstatus.returnworkingstatus_simple(tmplist[12]));
						}
					} else if (searchform.getJongbook().equals("_book")) {
						searchlistform.setReckey(tmplist[0]);
						searchlistform.setTitle_info(tmplist[1]);
						searchlistform.setAuthor_info(tmplist[2]);
						searchlistform.setPub_info(tmplist[3]);
						searchlistform.setPub_year_info(tmplist[4]);
						searchlistform.setCalno(tmplist[5]);
						searchlistform.setUserlevelinfo(tmplist[6]);
						searchlistform.setPlace_info(convertcode.convert(tmplist[7], "자료실구분"));
						searchlistform.setMat_code(tmplist[8]);
						searchlistform.setContents_yn(tmplist[9]);
						searchlistform.setAbstracts_yn(tmplist[10]);
						searchlistform.setCalno_book(tmplist[11]);

						searchlistform.setWorkingstatus(bookworkingstatus.returnworkingstatus_simple(tmplist[12]));
						searchlistform.setBook_code(tmplist[13]);
						searchlistform.setMsa(tmplist[14]);
					}
					searchlist.add(searchlistform);
				}
			} else {
				searchlistform.setResultcount("EMP");
				searchlist.add(searchlistform);
			}
		}
		return searchlist;
	}

	public ArrayList resultsetdetail(Vector analizecommand) {
		ArrayList detaillist = new ArrayList();
		for (int i = 0; i < analizecommand.size(); i++) {
			String[] tmplist = (String[]) analizecommand.get(i);
			DetailViewListForm detailviewlistform = new DetailViewListForm();
			detailviewlistform.setTitle(tmplist[0]);
			detailviewlistform.setValue(tmplist[1]);
			detaillist.add(detailviewlistform);
		}
		return detaillist;
	}

	public ArrayList resultsetsojang(Vector analizecommand, String msa, ArrayList detaillist, String book_code) {
		BookWorkingStatus bookworkingstatus = new BookWorkingStatus();
		String use_reserv = bookworkingstatus.valuegeter(detaillist, "예약기능사용여부");
		String loan_limit = bookworkingstatus.valuegeter(detaillist, "예약허용인원");

		Parser parser = new Parser(this.loc);

		parser.setValue("noloancode");
		String noloancodes = parser.getValue();
		String[] noloancode = noloancodes.split("/");
		logger.debug("noloancode: " + noloancode[0]);

		parser.setValue("noloancodeplace");
		String noloancodesplace = parser.getValue();
		if (noloancodesplace == null) {
			noloancodesplace = "";
		}
		String[] noloancodeplace = noloancodesplace.split("/");
		logger.debug("noloancodeplace: " + noloancodeplace[0]);

		parser.setValue("nosearchcode");
		String nosearchcodes = parser.getValue();
		String[] nosearchcode = nosearchcodes.split("/");
		logger.debug("nosearchcode: " + nosearchcode[0]);

		parser.setValue("nosearchcodeplace");
		String nosearchcodesplace = parser.getValue();
		if (nosearchcodesplace == null) {
			nosearchcodesplace = "";
		}
		String[] nosearchcodeplace = nosearchcodesplace.split("/");
		logger.debug("nosearchcodesplace: " + nosearchcodeplace[0]);

		ArrayList sojanglist = new ArrayList();
		for (int i = 0; i < analizecommand.size(); i++) {
			if (msa.equals("M")) {
				boolean noscode = true;
				boolean nolcode = true;
				String[] tmplist = (String[]) analizecommand.get(i);
				DetailViewListForm detailviewlistform = new DetailViewListForm();
				if (!tmplist[0].equals("EMP")) {
					for (int b = 0; b < nosearchcode.length; b++) {
						if ((tmplist[0].length() > 2) && (tmplist[0].substring(0, 2).equals(nosearchcode[b]))) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancode.length; a++) {
						if ((tmplist[0].length() > 2) && (tmplist[0].substring(0, 2).equals(noloancode[a]))) {
							nolcode = false;
						}
					}
					for (int b = 0; b < nosearchcodeplace.length; b++) {
						if (tmplist[2].equals(nosearchcodeplace[b])) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancodeplace.length; a++) {
						if (tmplist[2].equals(noloancodeplace[a])) {
							nolcode = false;
						}
					}
				}
				logger.debug("noscode" + noscode);
				logger.debug("nolcode" + nolcode);
				if ((noscode) && (!tmplist[0].equals("EMP"))) {
					detailviewlistform.setReg_code(tmplist[0]);
					detailviewlistform.setNatgun(tmplist[1]);
					detailviewlistform.setPlaceinfo(tmplist[2]);
					detailviewlistform.setPay(tmplist[3]);
					if ((!tmplist[4].equals("n")) && (!tmplist[4].equals("N"))) {
						detailviewlistform.setReturnplanday(tmplist[4]);
					} else {
						detailviewlistform.setReturnplanday(" ");
					}
					detailviewlistform.setBookkey(tmplist[5]);
					detailviewlistform.setCodeloanuse(tmplist[10]);
					detailviewlistform.setChungubuho(tmplist[11]);
					detailviewlistform.setMatcode(tmplist[12]);
					detailviewlistform.setLoanyn(tmplist[14]);
					detailviewlistform.setBurok(tmplist[15]);
					String strworkingstatus = bookworkingstatus.returnworkingstatus(tmplist[13], tmplist[10],
							tmplist[14], use_reserv);
					detailviewlistform.setWorkingstatus(strworkingstatus);
					int loan_now_cnt = loan_now_count(tmplist[14]);
					logger.debug("YYYY list10 : " + tmplist[10]);
					logger.debug("true limit>now : " + (Integer.parseInt(loan_limit) > loan_now_cnt));
					logger.debug("!A list15 : " + tmplist[15]);
					logger.debug("1,2 user_reserv : " + use_reserv);
					logger.debug("true loanstatus: " + isloanstatus(tmplist[13]));
					logger.debug("!N list14 : " + tmplist[14]);
					if ((tmplist[10].equals("YYYY")) && (Integer.parseInt(loan_limit) > loan_now_cnt)
							&& (((!tmplist[15].equals("A")) && (use_reserv.equals("1"))) || (use_reserv.equals("2")))) {
						if (((use_reserv.equals("1")) && (isloanstatus(tmplist[13])))
								|| ((use_reserv.equals("1")) && (!tmplist[14].equals("N"))
										&& (Integer.parseInt(loan_limit) > loan_now_cnt))
								|| ((use_reserv.equals("2")) && (nolcode))) {
							detailviewlistform.setLoancheck("Y");
						} else {
							detailviewlistform.setLoancheck("N");
						}
						if (strworkingstatus.equals("대출가능(비치)")) {
							detailviewlistform.setLoancheck("N");
						}
					} else {
						detailviewlistform.setLoancheck("N");
					}
					if (tmplist[0].equals(book_code)) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			} else {
				String[] tmplist = (String[]) analizecommand.get(i);
				if (!tmplist[0].equals("EMP")) {
					DetailViewListForm detailviewlistform = new DetailViewListForm();
					for (int b = 0; b < nosearchcode.length; b++) {
						if (!tmplist[0].substring(0, 2).equals(nosearchcode[b])) {
							detailviewlistform.setJongkey(tmplist[0]);
							detailviewlistform.setGunhokey(tmplist[1]);
							detailviewlistform.setBookkey(tmplist[2]);
							detailviewlistform.setGunhoname(tmplist[5]);
							detailviewlistform.setSubgunhoname(tmplist[6]);
							detailviewlistform.setBurokname(tmplist[7]);
							detailviewlistform.setPubyear(tmplist[8]);
							detailviewlistform.setInputyear(tmplist[9]);
							detailviewlistform.setChungubuho(tmplist[10]);
							detailviewlistform.setRecnum(tmplist[11]);
							detailviewlistform.setPlaceinfo(tmplist[12]);
							detailviewlistform.setLoanyn(tmplist[14]);
							if ((!tmplist[15].equals("n")) && (!tmplist[15].equals("N"))) {
								detailviewlistform.setReturnplanday(tmplist[15]);
							} else {
								detailviewlistform.setReturnplanday(" ");
							}
							detailviewlistform.setBurok(tmplist[17]);
							String strworkingstatus = bookworkingstatus.returnworkingstatus(tmplist[4], tmplist[13],
									tmplist[14], use_reserv);
							detailviewlistform.setWorkingstatus(strworkingstatus);
						}
					}
					if ((!tmplist[11].equals("")) && (tmplist[11].equals(book_code))) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			}
		}
		return sojanglist;
	}

	public ArrayList resultsetmarc(Vector analizecommand) {
		ArrayList detaillist = new ArrayList();
		for (int i = 0; i < analizecommand.size(); i++) {
			String[] tmplist = (String[]) analizecommand.get(i);
			String[] tmplist1 = tmplist[0].split("\n");
			for (int j = 0; j < tmplist1.length; j++) {
				logger.debug("tmplist" + tmplist1[j]);
				MarcViewListForm marcviewlistform = new MarcViewListForm();
				if (j == 0) {
					marcviewlistform.setValue(tmplist1[j]);
				} else if ((j < 4) && (j > 0)) {
					marcviewlistform.setTag(tmplist1[j].substring(0, 3));
					marcviewlistform.setInd("  ");
					marcviewlistform.setValue(tmplist1[j].substring(3));
				} else {
					marcviewlistform.setTag(tmplist1[j].substring(0, 3));
					marcviewlistform.setInd(tmplist1[j].substring(3, 6));
					marcviewlistform.setValue(tmplist1[j].substring(6));
				}
				detaillist.add(marcviewlistform);
			}
		}
		return detaillist;
	}

	public int loan_now_count(String loanyn) {
		int loan_now_cont = 0;
		if ((!loanyn.equals("N")) && (!loanyn.equals("n"))) {
			logger.debug("loanyn:" + loanyn);
			if (loan_now_cont < 10) {
				loan_now_cont = Integer.parseInt(loanyn.substring(3, loanyn.length() - 2));
			} else {
				loan_now_cont = Integer.parseInt(loanyn.substring(5, 2));
			}
		} else {
			loan_now_cont = 0;
		}
		return 0;
	}

	public boolean isloanstatus(String working_status) {
		logger.debug("workingstatus" + working_status);
		if ((working_status.equals("BOL211O")) || (working_status.equals("BOL212O"))
				|| (working_status.equals("BOL213O")) || (working_status.equals("BOL214O"))
				|| (working_status.equals("BOL215O"))) {
			return true;
		}
		if ((working_status.equals("SEL311O")) || (working_status.equals("SEL312O"))
				|| (working_status.equals("SEL313O")) || (working_status.equals("SEL314O"))
				|| (working_status.equals("SEL315O"))) {
			return true;
		}
		return false;
	}

	public ArrayList deliveryresultsetsojang(Vector analizecommand, String msa, ArrayList detaillist,
			String book_code) {
		BookWorkingStatus bookworkingstatus = new BookWorkingStatus();
		String use_reserv = bookworkingstatus.valuegeter(detaillist, "예약기능사용여부");
		String loan_limit = bookworkingstatus.valuegeter(detaillist, "예약허용인원");
		Parser parser = new Parser(this.loc);

		parser.setValue("deliverynoloancode");
		String noloancodes = parser.getValue();
		String[] noloancode = noloancodes.split("/");
		logger.debug("deliverynoloancode: " + noloancode[0]);

		parser.setValue("deliverynoloancodeplace");
		String noloancodesplace = parser.getValue();
		if (noloancodesplace == null) {
			noloancodesplace = "";
		}
		String[] noloancodeplace = noloancodesplace.split("/");
		logger.debug("deliverynoloancodeplace: " + noloancodeplace[0]);

		parser.setValue("deliverynosearchcode");
		String nosearchcodes = parser.getValue();
		String[] nosearchcode = nosearchcodes.split("/");
		logger.debug("deliverynosearchcode: " + nosearchcode[0]);

		parser.setValue("deliverynosearchcodeplace");
		String nosearchcodesplace = parser.getValue();
		if (nosearchcodesplace == null) {
			nosearchcodesplace = "";
		}
		String[] nosearchcodeplace = nosearchcodesplace.split("/");
		logger.debug("deliverynosearchcodesplace: " + nosearchcodeplace[0]);

		ArrayList sojanglist = new ArrayList();
		for (int i = 0; i < analizecommand.size(); i++) {
			if (msa.equals("M")) {
				boolean noscode = true;
				boolean nolcode = true;
				String[] tmplist = (String[]) analizecommand.get(i);
				DetailViewListForm detailviewlistform = new DetailViewListForm();
				if (!tmplist[0].equals("EMP")) {
					for (int b = 0; b < nosearchcode.length; b++) {
						if (tmplist[0].substring(0, 2).equals(nosearchcode[b])) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancode.length; a++) {
						if (tmplist[0].substring(0, 2).equals(noloancode[a])) {
							nolcode = false;
						}
					}
					for (int b = 0; b < nosearchcodeplace.length; b++) {
						if (tmplist[2].equals(nosearchcodeplace[b])) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancodeplace.length; a++) {
						if (tmplist[2].equals(noloancodeplace[a])) {
							nolcode = false;
						}
					}
				}
				logger.debug("deliverynoscode" + noscode);
				logger.debug("deliverynolcode" + nolcode);
				if ((noscode) && (!tmplist[0].equals("EMP"))) {
					detailviewlistform.setReg_code(tmplist[0]);
					detailviewlistform.setNatgun(tmplist[1]);
					detailviewlistform.setPlaceinfo(tmplist[2]);
					detailviewlistform.setPay(tmplist[3]);
					if ((!tmplist[4].equals("n")) && (!tmplist[4].equals("N"))) {
						detailviewlistform.setReturnplanday(tmplist[4]);
					} else {
						detailviewlistform.setReturnplanday(" ");
					}
					detailviewlistform.setBookkey(tmplist[5]);
					detailviewlistform.setCodeloanuse(tmplist[10]);
					detailviewlistform.setChungubuho(tmplist[11]);
					detailviewlistform.setMatcode(tmplist[12]);
					detailviewlistform.setLoanyn(tmplist[14]);
					detailviewlistform.setBurok(tmplist[15]);
					String strworkingstatus = bookworkingstatus.returnworkingstatus(tmplist[13], tmplist[10],
							tmplist[14], use_reserv);
					detailviewlistform.setWorkingstatus(strworkingstatus);
					int loan_now_cnt = loan_now_count(tmplist[14]);
					logger.debug("YYYY list10 : " + tmplist[10]);
					logger.debug("true limit>now : " + (Integer.parseInt(loan_limit) > loan_now_cnt));
					logger.debug("!A list15 : " + tmplist[15]);
					logger.debug("1,2 user_reserv : " + use_reserv);
					logger.debug("true loanstatus: " + isloanstatus(tmplist[13]));
					logger.debug("!N list14 : " + tmplist[14]);
					if ((tmplist[10].equals("YYYY")) && (Integer.parseInt(loan_limit) > loan_now_cnt)
							&& (!tmplist[15].equals("A"))) {
						if (((tmplist[13].equals("BOL112N")) || (tmplist[13].equals("SEL112N"))) && (nolcode)
								&& (tmplist[14].equals("N"))) {
							detailviewlistform.setLoancheck("Y");
						} else {
							detailviewlistform.setLoancheck("N");
						}
					} else {
						detailviewlistform.setLoancheck("N");
					}
					if (tmplist[0].equals(book_code)) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			} else {
				String[] tmplist = (String[]) analizecommand.get(i);
				if (!tmplist[0].equals("EMP")) {
					DetailViewListForm detailviewlistform = new DetailViewListForm();
					for (int b = 0; b < nosearchcode.length; b++) {
						if (!tmplist[0].substring(0, 2).equals(nosearchcode[b])) {
							detailviewlistform.setJongkey(tmplist[0]);
							detailviewlistform.setGunhokey(tmplist[1]);
							detailviewlistform.setBookkey(tmplist[2]);
							detailviewlistform.setGunhoname(tmplist[5]);
							detailviewlistform.setSubgunhoname(tmplist[6]);
							detailviewlistform.setBurokname(tmplist[7]);
							detailviewlistform.setPubyear(tmplist[8]);
							detailviewlistform.setInputyear(tmplist[9]);
							detailviewlistform.setChungubuho(tmplist[10]);
							detailviewlistform.setRecnum(tmplist[11]);
							detailviewlistform.setPlaceinfo(tmplist[12]);
							detailviewlistform.setLoanyn(tmplist[14]);
							if ((!tmplist[15].equals("n")) && (!tmplist[15].equals("N"))) {
								detailviewlistform.setReturnplanday(tmplist[15]);
							} else {
								detailviewlistform.setReturnplanday(" ");
							}
							detailviewlistform.setBurok(tmplist[17]);
							String strworkingstatus = bookworkingstatus.returnworkingstatus(tmplist[4], tmplist[13],
									tmplist[15], use_reserv);
							detailviewlistform.setWorkingstatus(strworkingstatus);
						}
					}
					if (tmplist[11].equals(book_code)) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			}
		}
		return sojanglist;
	}

	public ArrayList dutyresultsetsojang(Vector analizecommand, String msa, ArrayList detaillist, String book_code) {
		BookWorkingStatus bookworkingstatus = new BookWorkingStatus();
		String use_reserv = bookworkingstatus.valuegeter(detaillist, "예약기능사용여부");
		String loan_limit = bookworkingstatus.valuegeter(detaillist, "예약허용인원");

		Parser parser = new Parser(this.loc);

		parser.setValue("noloancode");
		String noloancodes = parser.getValue();
		String[] noloancode = noloancodes.split("/");
		logger.debug("noloancode: " + noloancode[0]);

		parser.setValue("noloancodeplace");
		String noloancodesplace = parser.getValue();
		if (noloancodesplace == null) {
			noloancodesplace = "";
		}
		String[] noloancodeplace = noloancodesplace.split("/");
		logger.debug("noloancodeplace: " + noloancodeplace[0]);

		parser.setValue("nosearchcode");
		String nosearchcodes = parser.getValue();
		String[] nosearchcode = nosearchcodes.split("/");
		logger.debug("nosearchcode: " + nosearchcode[0]);

		parser.setValue("nosearchcodeplace");
		String nosearchcodesplace = parser.getValue();
		if (nosearchcodesplace == null) {
			nosearchcodesplace = "";
		}
		String[] nosearchcodeplace = nosearchcodesplace.split("/");
		logger.debug("nosearchcodesplace: " + nosearchcodeplace[0]);

		ArrayList sojanglist = new ArrayList();
		for (int i = 0; i < analizecommand.size(); i++) {
			if (msa.equals("M")) {
				boolean noscode = true;
				boolean nolcode = true;
				String[] tmplist = (String[]) analizecommand.get(i);
				DetailViewListForm detailviewlistform = new DetailViewListForm();
				if (!tmplist[0].equals("EMP")) {
					for (int b = 0; b < nosearchcode.length; b++) {
						if ((tmplist[0].length() > 2) && (tmplist[0].substring(0, 2).equals(nosearchcode[b]))) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancode.length; a++) {
						if ((tmplist[0].length() > 2) && (tmplist[0].substring(0, 2).equals(noloancode[a]))) {
							nolcode = false;
						}
					}
					for (int b = 0; b < nosearchcodeplace.length; b++) {
						if (tmplist[2].equals(nosearchcodeplace[b])) {
							noscode = false;
						}
					}
					for (int a = 0; a < noloancodeplace.length; a++) {
						if (tmplist[2].equals(noloancodeplace[a])) {
							nolcode = false;
						}
					}
				}
				logger.debug("noscode" + noscode);
				logger.debug("nolcode" + nolcode);
				if ((noscode) && (!tmplist[0].equals("EMP"))) {
					detailviewlistform.setReg_code(tmplist[0]);
					detailviewlistform.setNatgun(tmplist[1]);
					detailviewlistform.setPlaceinfo(tmplist[2]);
					detailviewlistform.setPay(tmplist[3]);
					if ((!tmplist[4].equals("n")) && (!tmplist[4].equals("N"))) {
						detailviewlistform.setReturnplanday(tmplist[4]);
					} else {
						detailviewlistform.setReturnplanday(" ");
					}
					detailviewlistform.setBookkey(tmplist[5]);
					detailviewlistform.setCodeloanuse(tmplist[10]);
					detailviewlistform.setChungubuho(tmplist[11]);
					detailviewlistform.setMatcode(tmplist[12]);
					detailviewlistform.setLoanyn(tmplist[14]);
					detailviewlistform.setBurok(tmplist[15]);
					String strworkingstatus = bookworkingstatus.returnworkingstatus_simple(tmplist[13]);
					String loanyn = "";
					if (!tmplist[14].equals("N")) {
						loanyn = "(" + tmplist[14] + ")";
					}
					detailviewlistform.setWorkingstatus(strworkingstatus + loanyn);
					int loan_now_cnt = loan_now_count(tmplist[14]);
					logger.debug("YYYY list10 : " + tmplist[10]);
					logger.debug("true limit>now : " + (Integer.parseInt(loan_limit) > loan_now_cnt));
					logger.debug("!A list15 : " + tmplist[15]);
					logger.debug("1,2 user_reserv : " + use_reserv);
					logger.debug("true loanstatus: " + isloanstatus(tmplist[13]));
					logger.debug("!N list14 : " + tmplist[14]);
					if ((tmplist[10].equals("YYYY")) && (Integer.parseInt(loan_limit) > loan_now_cnt)
							&& (((!tmplist[15].equals("A")) && (use_reserv.equals("1"))) || (use_reserv.equals("2")))) {
						if (((use_reserv.equals("1")) && (isloanstatus(tmplist[13])))
								|| ((use_reserv.equals("1")) && (!tmplist[14].equals("N"))
										&& (Integer.parseInt(loan_limit) > loan_now_cnt))
								|| ((use_reserv.equals("2")) && (nolcode))) {
							detailviewlistform.setLoancheck("Y");
						} else {
							detailviewlistform.setLoancheck("N");
						}
						if (strworkingstatus.equals("대출가능(비치)")) {
							detailviewlistform.setLoancheck("N");
						}
					} else {
						detailviewlistform.setLoancheck("N");
					}
					if (tmplist[0].equals(book_code)) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			} else {
				String[] tmplist = (String[]) analizecommand.get(i);
				if (!tmplist[0].equals("EMP")) {
					DetailViewListForm detailviewlistform = new DetailViewListForm();
					for (int b = 0; b < nosearchcode.length; b++) {
						if (!tmplist[0].substring(0, 2).equals(nosearchcode[b])) {
							detailviewlistform.setJongkey(tmplist[0]);
							detailviewlistform.setGunhokey(tmplist[1]);
							detailviewlistform.setBookkey(tmplist[2]);
							detailviewlistform.setGunhoname(tmplist[5]);
							detailviewlistform.setSubgunhoname(tmplist[6]);
							detailviewlistform.setBurokname(tmplist[7]);
							detailviewlistform.setPubyear(tmplist[8]);
							detailviewlistform.setInputyear(tmplist[9]);
							detailviewlistform.setChungubuho(tmplist[10]);
							detailviewlistform.setRecnum(tmplist[11]);
							detailviewlistform.setPlaceinfo(tmplist[12]);
							detailviewlistform.setLoanyn(tmplist[14]);
							if ((!tmplist[15].equals("n")) && (!tmplist[15].equals("N"))) {
								detailviewlistform.setReturnplanday(tmplist[15]);
							} else {
								detailviewlistform.setReturnplanday(" ");
							}
							detailviewlistform.setBurok(tmplist[17]);
							String strworkingstatus = bookworkingstatus.returnworkingstatus_simple(tmplist[13]);
							String loanyn = "";
							if (!tmplist[14].equals("N")) {
								loanyn = "(" + tmplist[14] + ")";
							}
							detailviewlistform.setWorkingstatus(strworkingstatus + loanyn);
						}
					}
					if ((!tmplist[11].equals("")) && (tmplist[11].equals(book_code))) {
						detailviewlistform.setSearch_book("Y");
					}
					sojanglist.add(detailviewlistform);
				}
			}
		}
		return sojanglist;
	}
}
