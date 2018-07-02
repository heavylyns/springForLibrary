package kolas3.common.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter
  implements Filter
{
  private String Contentype = null;
  private String encoding = null;
  protected FilterConfig filterConfig = null;
  
  public void init(FilterConfig filterConfig)
    throws ServletException
  {
    this.filterConfig = filterConfig;
    this.Contentype = filterConfig.getInitParameter("contentype");
    this.encoding = filterConfig.getInitParameter("encoding");
  }
  
  public FilterConfig getFilterConfig()
  {
    return this.filterConfig;
  }
  
  public void setFilterConfig(FilterConfig cfg)
  {
    this.filterConfig = cfg;
  }
  
  public void destroy()
  {
    this.encoding = null;
    this.Contentype = null;
    this.filterConfig = null;
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    if (request.getCharacterEncoding() == null) {
      request.setCharacterEncoding(this.encoding);
    }
    request.setCharacterEncoding(this.encoding);
    
    chain.doFilter(request, response);
  }
}
