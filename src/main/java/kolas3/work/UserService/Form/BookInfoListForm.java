package kolas3.work.UserService.Form;

import org.apache.struts.upload.FormFile;

public class BookInfoListForm {
  private String rec_key = "";
  private String mng_key = "";
  private String name = "";
  private String reg_date = "";
  private String board_table_name = "";
  private String hit = "";
  private String no = "";
  private String total_count;
  private String style_value = "";
  private String menu_num = "";
  private String page_num = "";
  private String file_name = "";
  private String db_file_name = "";
  private String title = "";
  private String author = "";
  private String company = "";
  private String division = "";
  private String contents = "";
  private FormFile userfile;

  public FormFile getUserfile()
  {
    return this.userfile;
  }

  public void setUserfile(FormFile userfile)
  {
    this.userfile = userfile;
  }

  public String getAuthor()
  {
    return this.author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public String getBoard_table_name()
  {
    return this.board_table_name;
  }

  public void setBoard_table_name(String board_table_name)
  {
    this.board_table_name = board_table_name;
  }

  public String getCompany()
  {
    return this.company;
  }

  public void setCompany(String company)
  {
    this.company = company;
  }

  public String getContents()
  {
    return this.contents;
  }

  public void setContents(String contents)
  {
    this.contents = contents;
  }

  public String getDb_file_name()
  {
    return this.db_file_name;
  }

  public void setDb_file_name(String db_file_name)
  {
    this.db_file_name = db_file_name;
  }

  public String getDivision()
  {
    return this.division;
  }

  public void setDivision(String division)
  {
    this.division = division;
  }

  public String getFile_name()
  {
    return this.file_name;
  }

  public void setFile_name(String file_name)
  {
    this.file_name = file_name;
  }

  public String getHit()
  {
    return this.hit;
  }

  public void setHit(String hit)
  {
    this.hit = hit;
  }

  public String getMenu_num()
  {
    return this.menu_num;
  }

  public void setMenu_num(String menu_num)
  {
    this.menu_num = menu_num;
  }

  public String getMng_key()
  {
    return this.mng_key;
  }

  public void setMng_key(String mng_key)
  {
    this.mng_key = mng_key;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getNo()
  {
    return this.no;
  }

  public void setNo(String no)
  {
    this.no = no;
  }

  public String getPage_num()
  {
    return this.page_num;
  }

  public void setPage_num(String page_num)
  {
    this.page_num = page_num;
  }

  public String getRec_key()
  {
    return this.rec_key;
  }

  public void setRec_key(String rec_key)
  {
    this.rec_key = rec_key;
  }

  public String getReg_date()
  {
    return this.reg_date;
  }

  public void setReg_date(String reg_date)
  {
    this.reg_date = reg_date;
  }

  public String getStyle_value()
  {
    return this.style_value;
  }

  public void setStyle_value(String style_value)
  {
    this.style_value = style_value;
  }

  public String getTitle()
  {
    return this.title;
  }

  public void setTitle(String title)
  {
    this.title = title;
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
