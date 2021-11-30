package com.otlb.semi.emp.model.dao;

import static com.otlb.semi.common.JdbcTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.otlb.semi.emp.model.exception.EmpException;
import com.otlb.semi.emp.model.vo.Emp;

public class EmpDao {

	private Properties prop = new Properties();
	
	public EmpDao() {
		String filepath = EmpDao.class.getResource("/emp-query.properties").getPath();
		try {
			prop.load(new FileReader(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Emp selectOneEmp(Connection conn, int no) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectOneEmp");
		ResultSet rset = null;
		Emp emp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				emp = new Emp();
				emp.setNo(rset.getInt("no"));
				emp.setEmpName(rset.getString("emp_name"));
				emp.setPassword(rset.getString("password"));
				emp.setBirthdate(rset.getDate("birthdate"));
				emp.setDeptCode(rset.getString("dept_code"));
				emp.setJobCode(rset.getString("job_code"));
				emp.setEmpRole(rset.getString("emp_role"));
				emp.setGender(rset.getString("gender"));
				emp.setEmail(rset.getString("email"));
				emp.setPhone(rset.getString("phone"));
				emp.setQuitYn(rset.getString("quit_yn"));
				emp.setBanYn(rset.getString("ban_yn"));
			}
		} catch (SQLException e) {
			throw new EmpException("회원가입 오류", e);
		} finally {
			close(rset);
			close(pstmt);
		}
		return emp;
	}

	public int updateEmp(Connection conn, Emp emp) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateEmp");
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getPassword());
			pstmt.setString(2, emp.getPhone());
			pstmt.setString(3, emp.getEmail());			
			pstmt.setInt(4, emp.getNo());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertEmp(Connection conn, Emp emp) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertEmp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getPassword());
			pstmt.setDate(3, emp.getBirthdate());
			pstmt.setString(4, emp.getEmpRole());
			pstmt.setString(5, emp.getGender());
			pstmt.setString(6, emp.getEmail());
			pstmt.setString(7, emp.getPhone());
			pstmt.setString(8, emp.getQuitYn());
			pstmt.setString(9, emp.getBanYn());
			pstmt.setInt(10, emp.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new EmpException("회원가입 오류", e);
		}
		return result;
	}
}
