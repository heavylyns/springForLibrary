package kolas3.work.UserService.Form;

import org.apache.struts.action.ActionForm;

public class BoardListForm {
  private String title = "";
  private String rec_key = "";
  private String mng_key = "";
  private String name = "";
  private String reg_date = "";
  private String contents = "";
  private String menu_id = "";
  private String board_name = "";
  private String board_table_name = "";
  private String hit = "";
  private String no = "";
  private String total_count;
  private String style_value = "";
  private String menu_num = "";
  private String page_num = "";
  private String re_no = "";
  private String file_name = "";
  private String db_file_name = "";
  private String disk_img_file = "";
  private String new_img = "";

  public String getNew_img()
  {
    return this.new_img;
  }

  public void setNew_img(String new_img)
  {
    this.new_img = new_img;
  }

  public String getDisk_img_file()
  {
    return this.disk_img_file;
  }

  public void setDisk_img_file(String disk_img_file)
  {
    this.disk_img_file = disk_img_file;
  }

  public String getDb_file_name()
  {
    return this.db_file_name;
  }

  public void setDb_file_name(String db_file_name)
  {
    this.db_file_name = db_file_name;
  }

  public String getFile_name()
  {
    return this.file_name;
  }

  public void setFile_name(String file_name)
  {
    this.file_name = file_name;
  }

  public String getRe_no()
  {
    return this.re_no;
  }

  public void setRe_no(String re_no)
  {
    this.re_no = re_no;
  }

  public String getPage_num()
  {
    return this.page_num;
  }

  public void setPage_num(String page_num)
  {
    this.page_num = page_num;
  }

  public String getMenu_num()
  {
    return this.menu_num;
  }

  public void setMenu_num(String menu_num)
  {
    this.menu_num = menu_num;
  }

  public String getReg_date()
  {
    return this.reg_date;
  }

  public void setReg_date(String reg_date)
  {
    this.reg_date = reg_date;
  }

  public String getContents()
  {
    return this.contents;
  }

  public void setContents(String contents)
  {
    this.contents = contents;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getRec_key()
  {
    return this.rec_key;
  }

  public void setRec_key(String rec_key)
  {
    this.rec_key = rec_key;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getMenu_id()
  {
    return this.menu_id;
  }

  public void setMenu_id(String menu_id)
  {
    this.menu_id = menu_id;
  }

  public String getBoard_name()
  {
    return this.board_name;
  }

  public void setBoard_name(String board_name)
  {
    this.board_name = board_name;
  }

  public String getMng_key()
  {
    return this.mng_key;
  }

  public void setMng_key(String mng_key)
  {
    this.mng_key = mng_key;
  }

  public String getBoard_table_name()
  {
    return this.board_table_name;
  }

  public void setBoard_table_name(String board_table_name)
  {
    this.board_table_name = board_table_name;
  }

  public String getHit()
  {
    return this.hit;
  }

  public void setHit(String hit)
  {
    this.hit = hit;
  }

  public String getNo()
  {
    return this.no;
  }

  public void setNo(String no)
  {
    this.no = no;
  }

  public String getStyle_value()
  {
    return this.style_value;
  }

  public void setStyle_value(String style_value)
  {
    this.style_value = style_value;
  }

  public String getTotal_count()
  {
    return this.total_count;
  }

  public void setTotal_count(String total_count)
  {
    this.total_count = total_count;
  }
}
