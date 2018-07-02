package kolas3.work.UserService.Form;



public class DeliveryResultForm
  
{
  private String title;
  private String vol;
  private String request_date;
  private String receipt_date;
  private String delivery_date;
  private String status;
  private String address;
  private String rec_key;
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getDelivery_date()
  {
    return this.delivery_date;
  }
  
  public void setDelivery_date(String delivery_date)
  {
    this.delivery_date = delivery_date;
  }
  
  public String getRec_key()
  {
    return this.rec_key;
  }
  
  public void setRec_key(String rec_key)
  {
    this.rec_key = rec_key;
  }
  
  public String getReceipt_date()
  {
    return this.receipt_date;
  }
  
  public void setReceipt_date(String receipt_date)
  {
    this.receipt_date = receipt_date;
  }
  
  public String getRequest_date()
  {
    return this.request_date;
  }
  
  public void setRequest_date(String request_date)
  {
    this.request_date = request_date;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setStatus(String status)
  {
    this.status = status;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setTitle(String title)
  {
    this.title = title;
  }
  
  public String getVol()
  {
    return this.vol;
  }
  
  public void setVol(String vol)
  {
    this.vol = vol;
  }
}
