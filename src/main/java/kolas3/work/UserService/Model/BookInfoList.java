package kolas3.work.UserService.Model;

import java.sql.ResultSet;
import java.util.ArrayList;

import kolas3.common.ECOClass;
import kolas3.common.db.ECOMySQLManager;
import kolas3.common.paging.PagingBoard;
import kolas3.common.utils.DateTime;
import kolas3.common.utils.ECOLogManager;
import kolas3.common.utils.StringChecker;
import kolas3.work.UserService.Form.BoardListForm;
import kolas3.work.UserService.Form.BookInfoListForm;

public class BookInfoList extends ECOClass {
	private ECOMySQLManager OraMgr = new ECOMySQLManager();
	private ECOLogManager LogMgr = new ECOLogManager();
	private DateTime DateMgr = new DateTime();
	private StringChecker StrMgr = new StringChecker();
	private ResultSet m_rs;
	private ArrayList list_array = null;
	private boolean res = true;
	private String Qry = "";

	public ArrayList ListEventBoard(String menu_num, String page_num, String chk_flag, String keyword, String orderby) {
		String board_table_name = "";
		String mng_key = "";
		if ((page_num == null) || (page_num.equals(""))) {
			System.out.println("페이지 변수 전달값 없음");
			return null;
		}
		int start_num = (Integer.parseInt(page_num) - 1) * 6 + 1;
		int last_num = start_num + 5;

		this.Qry = ("select rec_key, board_table_name from web_eco_board_mng_tbl where menu_num = " + menu_num);
		this.m_rs = this.OraMgr.selectQry2("테이블", this.Qry);
		try {
			this.m_rs.next();
			board_table_name = this.m_rs.getString("board_table_name").toString();
			mng_key = this.m_rs.getString("rec_key").toString();

			this.list_array = new ArrayList();
			int tmp_cnt = 0;
			String[] arr_style = { "list", "list2" };

			this.Qry =

			(" select * from (  select mng.menu_num,  row_number() over (order by reg_date desc) row_num,  no,board.rec_key, mng.rec_key as mng_key, mng.board_table_name,to_char(reg_date, 'YYYY-MM-DD')as reg_date , title,author, company ,file_name,db_file_name,   contents  from "
					+ board_table_name + " board, web_eco_board_mng_tbl mng ");

			this.Qry = (this.Qry + " where board.mng_key = mng.rec_key  and board.mng_key = " + mng_key);

			this.Qry = (this.Qry + " order by board.no desc, board.rec_key ) where row_num >= " + start_num
					+ " and row_num <= " + last_num);
			if ((chk_flag != null) && (!chk_flag.equalsIgnoreCase("null")) && (!chk_flag.equals(""))) {
				String[] chk = chk_flag.split("_");

				String title = "";
				String company = "";
				String contents = "";

				this.Qry += " and(";
				for (int i = 0; i < chk.length; i++) {
					System.out.println("chk_flag" + chk_flag);
					if (chk[i].equals("title")) {
						title = "Y";
						this.Qry = (this.Qry + " title like '" + keyword + "%'");
					} else if (chk[i].equals("company")) {
						if (title.equals("Y")) {
							this.Qry += " or";
						}
						company = "Y";
						this.Qry = (this.Qry + " company like '" + keyword + "%'");
					} else if (chk[i].equals("content")) {
						if ((title.equals("Y")) || (company.equals("Y"))) {
							this.Qry += " or";
						}
						this.Qry = (this.Qry + " contents like '" + keyword + "%'");
					}
				}
				this.Qry += ")";
			}
			this.m_rs = this.OraMgr.selectQry2("게시판 검색", this.Qry);
			while (this.m_rs.next()) {
				BookInfoListForm list_form = new BookInfoListForm();

				list_form.setMenu_num(menu_num);
				list_form.setNo(this.m_rs.getString("no"));
				list_form.setRec_key(this.m_rs.getString("rec_key"));
				list_form.setTitle(this.m_rs.getString("title"));
				list_form.setAuthor(this.m_rs.getString("author"));
				list_form.setCompany(this.m_rs.getString("company"));
				list_form.setFile_name(this.m_rs.getString("file_name"));
				list_form.setDb_file_name(this.m_rs.getString("db_file_name"));
				list_form.setContents(this.m_rs.getString("contents"));
				list_form.setReg_date(this.m_rs.getString("reg_date"));

				list_form.setStyle_value(arr_style[(tmp_cnt % 2)]);
				tmp_cnt++;

				this.list_array.add(list_form);
			}
		} catch (Exception e) {
			System.out.println("exception 글 검색 에러");
			e.printStackTrace();
			return null;
		}
		return this.list_array;
	}

	public String changeHtmlCode(String tmp_html) {
		String result_html = "";
		if (tmp_html == null) {
			tmp_html = "";
		}
		result_html = tmp_html.replaceAll("\"", "&#34;");
		result_html = tmp_html.replaceAll("%", "&#37;");

		return result_html;
	}

	public ArrayList loadArrayList() {
		System.out.println("호출되면 안됨 : + BoardList.java");
		return this.list_array;
	}

	public BoardListForm loadContentsForHTML(BoardListForm list_form, String board_table_name, String rec_key) {
		this.res = this.OraMgr.connect();
		if (!this.res) {
			System.out.println("DB 접속 에러 ");
			return null;
		}
		this.Qry =

		("select    board.rec_key as rec_key, mng.rec_key as mng_key, board.title, board.name, to_char(board.reg_date, 'YYYY-MM-DD') as reg_date,  board.contents, mng.board_name, mng.board_table_name from "
				+ board_table_name + " board, web_eco_board_mng_tbl mng ");

		this.Qry = (this.Qry + " where board.mng_key = mng.rec_key  and board.rec_key = " + rec_key);

		System.out.println("상세보기 : " + this.Qry);
		this.m_rs = this.OraMgr.selectQry(this.Qry);
		try {
			this.m_rs.next();

			list_form.setMng_key(this.m_rs.getString("mng_key"));
			list_form.setTitle(this.m_rs.getString("title"));
			list_form.setName(this.m_rs.getString("name"));
			list_form.setReg_date(this.m_rs.getString("reg_date"));
			list_form.setBoard_name(this.m_rs.getString("board_name"));

			String contents = this.m_rs.getString("contents").toString();
			contents = contents.replaceAll("\n", "<br>");
			list_form.setContents(contents);
		} catch (Exception e) {
			System.out.println("상세보기 검색 에러");
			return null;
		}
		this.OraMgr.disconnect();

		return list_form;
	}

	public int DeleteContents(String menu_num, String rec_key) {
		String board_table_name = "";
		this.Qry = ("select board_table_name from web_eco_board_mng_tbl where menu_num = " + menu_num);

		this.m_rs = this.OraMgr.selectQry2("테이블", this.Qry);
		try {
			this.m_rs.next();
			board_table_name = this.m_rs.getString("board_table_name").toString();

			this.Qry = ("delete " + board_table_name + " where rec_key = " + rec_key);

			System.out.println("글 삭제 : " + this.Qry);
			if (this.OraMgr.deleteQry(this.Qry)) {
				// break label186;
			}
			// System.out.println("삭제 에러");
			return 1;
		} catch (Exception e) {
			System.out.println("BoardList.java 삭제 exception : " + e.getMessage());
			return 0;
		}
		// label186: return 0;
	}

	public String getPaging(String menu_num, String page_num, String chk_flag, String keyword) {
		String result_str = null;
		int total_cnt = 0;
		String board_table_name = "";

		this.Qry = ("select board_table_name from web_eco_board_mng_tbl where menu_num = " + menu_num);
		this.m_rs = this.OraMgr.selectQry2("테이블검색", this.Qry);
		try {
			this.m_rs.next();
			board_table_name = this.m_rs.getString("board_table_name").toString();

			this.Qry = ("select count(*) from " + board_table_name);
			if ((chk_flag != null) && (!chk_flag.equalsIgnoreCase("null")) && (!chk_flag.equals(""))) {
				String[] chk = chk_flag.split("_");
				String title = "";
				String company = "";
				String contents = "";

				this.Qry += " where ";
				for (int i = 0; i < chk.length; i++) {
					System.out.println("chk_flag" + chk_flag);
					if (chk[i].equals("title")) {
						title = "Y";
						this.Qry = (this.Qry + " title like '" + keyword + "%'");
					} else if (chk[i].equals("company")) {
						if (title.equals("Y")) {
							this.Qry += " or";
						}
						company = "Y";
						this.Qry = (this.Qry + " company like '" + keyword + "%'");
					} else if (chk[i].equals("content")) {
						if ((title.equals("Y")) || (company.equals("Y"))) {
							this.Qry += " or";
						}
						this.Qry = (this.Qry + " contents like '" + keyword + "%'");
					}
				}
				this.Qry += " ";
			}
			this.m_rs = this.OraMgr.selectQry2("건수검색", this.Qry);

			this.m_rs.next();
			total_cnt = this.m_rs.getInt(1);
		} catch (Exception e) {
			System.out.println("BoardList.java 건수검색 exception : " + e.getMessage());
			return null;
		}
		return getPagingIn(total_cnt, page_num, menu_num);
	}

	public String getPagingIn(int total_cnt, String page_num, String menu_num) {
		String result_str = "";
		int cur_page = Integer.parseInt(page_num);
		int total_page = 0;
		int tmp = 0;

		PagingBoard pagingBoard = new PagingBoard(cur_page, total_cnt, 6, 10);

		int startPage = pagingBoard.getStartPage();
		int endPage = pagingBoard.getEndPage();
		boolean isPrevPage = pagingBoard.isPrevPage();
		boolean isNextPage = pagingBoard.isNextPage();
		int totalPage = pagingBoard.getTotalPage();

		System.out.println("토탈페이지" + totalPage);
		System.out.println("토탈로우" + total_cnt);
		System.out.println("현재페이지 " + cur_page);

		result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\"" + 1
				+ "\")'> << </a></strong>&nbsp;";
		if (!isPrevPage) {
			result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\"" + 1
					+ "\")'> < </a></strong>&nbsp;";
		} else {
			result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\""
					+ (cur_page - 10) + "\")'> < </a></strong>&nbsp;";
		}
		for (int i = startPage; i <= endPage; i++) {
			if (i == cur_page) {
				result_str = result_str + "&nbsp;<strong><a href='#' onclick='list_page_move(\"" + menu_num + "\",\""
						+ i + "\")'>[" + i + "]</a></strong>";
			} else {
				result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\"" + i
						+ "\")'>[" + i + "]</a></strong>";
			}
		}
		if (isNextPage) {
			result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\""
					+ (startPage + 10) + "\")'> > </a></strong>&nbsp;";
		} else {
			result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\"" + cur_page
					+ "\")'> > </a></strong>&nbsp;";
		}
		result_str = result_str + "&nbsp;<a href='#' onclick='list_page_move(\"" + menu_num + "\",\"" + totalPage
				+ "\")'> >> </a></strong>&nbsp;";

		return result_str + "*" + total_cnt + "*" + totalPage + "*" + cur_page;
	}

	public boolean DBConnect() {
		if (!this.OraMgr.connect()) {
			System.out.println("db connect error");
			return false;
		}
		return true;
	}

	public boolean DBDisConnect() {
		this.OraMgr.disconnect();
		return true;
	}
}
