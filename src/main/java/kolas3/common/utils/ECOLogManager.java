package kolas3.common.utils;

import org.apache.log4j.Logger;

public class ECOLogManager
{
  static Logger logger = Logger.getLogger("ECOLogManager");
  
  public void debug(String msg)
  {
    if (logger.isDebugEnabled()) {
      try
      {
        throw new Exception("");
      }
      catch (Exception e)
      {
        StackTraceElement ste = e.getStackTrace()[1];
        logger.error(ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName() + " (" + ste.getLineNumber() + ")]-[" + msg + "]");
      }
    }
  }
  
  public void error(String msg)
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception e)
    {
      StackTraceElement ste = e.getStackTrace()[1];
      logger.error(ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName() + " (" + ste.getLineNumber() + ")]-[" + msg + "]");
    }
  }
  
  public void fatal(String msg)
  {
    try
    {
      throw new Exception("");
    }
    catch (Exception e)
    {
      StackTraceElement ste = e.getStackTrace()[1];
      logger.fatal(ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName() + " (" + ste.getLineNumber() + ")]-[" + msg + "]");
    }
  }
  
  public void info(String msg)
  {
    if (logger.isInfoEnabled()) {
      try
      {
        throw new Exception("");
      }
      catch (Exception e)
      {
        StackTraceElement ste = e.getStackTrace()[1];
        logger.info(ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName() + " (" + ste.getLineNumber() + ")]-[" + msg + "]");
      }
    }
  }
  
  public void warn(String msg)
  {
    if (logger.isDebugEnabled()) {
      try
      {
        throw new Exception("");
      }
      catch (Exception e)
      {
        StackTraceElement ste = e.getStackTrace()[1];
        logger.warn(ste.getFileName().substring(0, ste.getFileName().indexOf(".")) + "." + ste.getMethodName() + " (" + ste.getLineNumber() + ")]-[" + msg + "]");
      }
    }
  }
}
