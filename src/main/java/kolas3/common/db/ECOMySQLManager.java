package kolas3.common.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.ingrian.log4j.chainsaw.Main;

//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import kolas3.common.ECOClass;

public class ECOMySQLManager extends ECOClass {
	private Connection m_conn;
	private Statement m_stmt;
	private PreparedStatement m_pstmt;
	private ResultSet m_rs;
	private String m_strQuery;
	private StringBuffer m_strQry;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private final ApplicationContext ac = new ClassPathXmlApplicationContext("../../kolas3_datasource.xml", this.getClass());
	private final DataSource g_datasource = (DataSource) ac.getBean("dataSource-kolas3");

	public boolean connect() {
		DataSource t_datasource = null;
		try {
	        t_datasource = g_datasource;

			logger.debug(t_datasource.toString());
			if (t_datasource == null) {
				log.error("DataSource를 얻어오지 못했습니다.");
				return false;
			}
			this.m_conn = t_datasource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		if (this.m_conn == null) {
			log.error("Connection 객체가 NULL 입니다.");
			return false;
		}
		return true;
	}

	public void disconnect() {
		try {
			if (this.m_conn != null) {
				this.m_conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void closeResultset() {
		try {
			if (this.m_rs != null) {
				this.m_rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void closeStatement() {
		try {
			if (this.m_stmt != null) {
				this.m_stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void closePreparedStatment() {
		try {
			if (this.m_pstmt != null) {
				this.m_pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void closeConnection() {
		closeResultset();
		closePreparedStatment();
		closeStatement();
		disconnect();
	}

	public ResultSet selectQry(String f_qry) {
		try {
			log.info("조회쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			this.m_rs = this.m_stmt.executeQuery(f_qry);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
		return this.m_rs;
	}

	public ResultSet selectQry2(String msg, String f_qry) {
		try {
			log.info(msg + " : " + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			this.m_rs = this.m_stmt.executeQuery(f_qry);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
		return this.m_rs;
	}

	public boolean insertQry(String f_qry) {
		try {
			log.info("입력쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			if (this.m_stmt.execute(f_qry)) {
				log.error("DB 입력 작업에 실패하였습니다.[" + f_qry + "]");
				return false;
			}
			log.info("입력쿼리정상종료");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	public int updateQry(String f_qry) {
		int updatecount = 0;
		try {
			log.info("수정쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			updatecount = this.m_stmt.executeUpdate(f_qry);
			log.info("수정쿼리결과:" + updatecount);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return 0;
		}
		return updatecount;
	}

	public int updateQry2(String msg, String f_qry) {
		int updatecount = 0;
		try {
			log.info(msg + " : " + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			updatecount = this.m_stmt.executeUpdate(f_qry);
			log.info("수정쿼리결과:" + updatecount);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return -120;
		}
		return updatecount;
	}

	public boolean executeQry(String f_qry) {
		try {
			log.info("실행쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			if (this.m_stmt.execute(f_qry)) {
				log.info("실행성공");
			} else {
				log.info("실행실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	public void setAutoCommit(boolean f_isAutoCommit) {
		try {
			this.m_conn.setAutoCommit(f_isAutoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void rollback() {
		try {
			this.m_conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void commit() {
		try {
			this.m_conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public Connection getConnection() {
		return this.m_conn;
	}

	public int setPrepareStatement_qry(String query) {
		this.m_strQuery = query;
		if ((query == null) || (query.equals(""))) {
			logger.debug("[ setPrepareStatement_qry Error ] query is Null!!");
			return -100;
		}
		try {
			logger.debug("변경 : " + query);
			this.m_pstmt = this.m_conn.prepareStatement(query);
		} catch (SQLException e) {
			logger.debug("setPrepareStatement_qry Exception !!+[" + e.getMessage() + "]");
			e.printStackTrace();
			return -200;
		}
		return 0;
	}

	public int setPrepareStatement_setString(int index, String data) {
		try {
			this.m_pstmt.setString(index, data);
		} catch (SQLException e) {
			logger.debug("setPrepareStatement_setString Exception !!+[" + e.getMessage() + "]");
			e.printStackTrace();
			return -100;
		}
		return 0;
	}

	public int setPrepareStatement_excute() {
		try {
			this.m_pstmt.executeUpdate();
		} catch (SQLException e) {
			logger.debug("setPrepareStatement_setCharacterSteram Exception !!+[" + e.getMessage() + "]");
			e.printStackTrace();
			return -100;
		}
		return 0;
	}

	public boolean deleteQry(String f_qry) {
		try {
			log.info("삭제쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			if (this.m_stmt.execute(f_qry)) {
				log.error("DB 삭제 작업에 실패하였습니다.[" + f_qry + "]");
				return false;
			}
			log.info("삭제쿼리정상종료");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}

	public boolean createQry(String f_qry) {
		try {
			log.info("실행쿼리:" + f_qry);
			this.m_stmt = this.m_conn.createStatement();
			if (!this.m_stmt.execute(f_qry)) {
				log.info("실행성공");
			} else {
				log.info("실행실패");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
		}
		return true;
	}
}
