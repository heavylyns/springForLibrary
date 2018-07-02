package kolas3.work.UserService.Form;

import kolas3.common.utils.DateTime;


public class BookRequestForm
  
{
  private DateTime dateMgr = new DateTime();
  private String check_mode = "";
  private String memchk = "";
  private String user_id = "";
  private int rec_key = 0;
  private String request_date = DateTime.getDateString("/");
  private String user_no = "";
  private String applicant_name = "";
  private String civil_no_first = "";
  private String civil_no_second = "";
  private String civil_no_result = "";
  private String zip1 = "";
  private String zip2 = "";
  private String zip_code = "";
  private String address1 = "";
  private String tel = "";
  private String e_mail = "";
  private String hp_no = "";
  private String sms_yn = "";
  private String index_title = "";
  private String index_author = "";
  private String index_publisher = "";
  private String title = "";
  private String author = "";
  private String publisher = "";
  private String publisher_date = "";
  private String recom_opinion = "";
  private String furnish_status = "";
  private String mgc = "";
  private String reservation_yn = "";
  
  public String getReservation_yn()
  {
    return this.reservation_yn;
  }
  
  public void setReservation_yn(String reservation_yn)
  {
    this.reservation_yn = reservation_yn;
  }
  
  public String getMgc()
  {
    return this.mgc;
  }
  
  public void setMgc(String mgc)
  {
    this.mgc = mgc;
  }
  
  public String getAddress1()
  {
    return this.address1;
  }
  
  public void setAddress1(String address1)
  {
    this.address1 = address1;
  }
  
  public String getApplicant_name()
  {
    return this.applicant_name;
  }
  
  public void setApplicant_name(String applicant_name)
  {
    this.applicant_name = applicant_name;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public void setAuthor(String author)
  {
    this.author = author;
  }
  
  public String getCivil_no_first()
  {
    return this.civil_no_first;
  }
  
  public void setCivil_no_first(String civil_no_first)
  {
    this.civil_no_first = civil_no_first;
  }
  
  public String getCivil_no_result()
  {
    return this.civil_no_result;
  }
  
  public void setCivil_no_result(String civil_no_result)
  {
    this.civil_no_result = civil_no_result;
  }
  
  public String getCivil_no_second()
  {
    return this.civil_no_second;
  }
  
  public void setCivil_no_second(String civil_no_second)
  {
    this.civil_no_second = civil_no_second;
  }
  
  public String getE_mail()
  {
    return this.e_mail;
  }
  
  public void setE_mail(String e_mail)
  {
    this.e_mail = e_mail;
  }
  
  public String getHp_no()
  {
    return this.hp_no;
  }
  
  public void setHp_no(String hp_no)
  {
    this.hp_no = hp_no;
  }
  
  public String getPublisher()
  {
    return this.publisher;
  }
  
  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }
  
  public String getPublisher_date()
  {
    return this.publisher_date;
  }
  
  public void setPublisher_date(String publisher_date)
  {
    this.publisher_date = publisher_date;
  }
  
  public int getRec_key()
  {
    return this.rec_key;
  }
  
  public void setRec_key(int rec_key)
  {
    this.rec_key = rec_key;
  }
  
  public String getRecom_opinion()
  {
    return this.recom_opinion;
  }
  
  public void setRecom_opinion(String recom_opinion)
  {
    this.recom_opinion = recom_opinion;
  }
  
  public String getRequest_date()
  {
    return this.request_date;
  }
  
  public void setRequest_date(String request_date)
  {
    this.request_date = request_date;
  }
  
  public String getSms_yn()
  {
    return this.sms_yn;
  }
  
  public void setSms_yn(String sms_yn)
  {
    this.sms_yn = sms_yn;
  }
  
  public String getTel()
  {
    return this.tel;
  }
  
  public void setTel(String tel)
  {
    this.tel = tel;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getUser_no()
  {
    return this.user_no;
  }
  
  public void setUser_no(String user_no)
  {
    this.user_no = user_no;
  }
  
  public String getZip_code()
  {
    return this.zip_code;
  }
  
  public void setZip_code(String zip_code)
  {
    this.zip_code = zip_code;
  }
  
  public String getZip1()
  {
    return this.zip1;
  }
  
  public void setZip1(String zip1)
  {
    this.zip1 = zip1;
  }
  
  public String getZip2()
  {
    return this.zip2;
  }
  
  public void setZip2(String zip2)
  {
    this.zip2 = zip2;
  }
  
  public String getCheck_mode()
  {
    return this.check_mode;
  }
  
  public void setCheck_mode(String check_mode)
  {
    this.check_mode = check_mode;
  }
  
  public String getMemchk()
  {
    return this.memchk;
  }
  
  public void setMemchk(String memchk)
  {
    this.memchk = memchk;
  }
  
  public DateTime getDateMgr()
  {
    return this.dateMgr;
  }
  
  public void setDateMgr(DateTime dateMgr)
  {
    this.dateMgr = dateMgr;
  }
  
  public String getIndex_author()
  {
    return this.index_author;
  }
  
  public void setIndex_author(String index_author)
  {
    this.index_author = index_author;
  }
  
  public String getIndex_title()
  {
    return this.index_title;
  }
  
  public void setIndex_title(String index_title)
  {
    this.index_title = index_title;
  }
  
  public String getIndex_publisher()
  {
    return this.index_publisher;
  }
  
  public void setIndex_publisher(String index_publisher)
  {
    this.index_publisher = index_publisher;
  }
  
  public String getFurnish_status()
  {
    return this.furnish_status;
  }
  
  public void setFurnish_status(String furnish_status)
  {
    this.furnish_status = furnish_status;
  }
  
  public String getUser_id()
  {
    return this.user_id;
  }
  
  public void setUser_id(String user_id)
  {
    this.user_id = user_id;
  }
}
