package studio.codeocean.models.dao;

import java.util.List;
import java.util.ArrayList;
import studio.codeocean.models.domain.Student;
import studio.codeocean.utils.ConnectionUtil;
import java.sql.Connection;
import studio.codeocean.common.Result;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDao {
	
	public Result insert(Student student) {
		Result result = new Result();
		Connection conn = ConnectionUtil.getConnection();		
		String sql = "insert into student(name, sex, age, school, major, clazz) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSex());
			pstmt.setInt(3, student.getAge());
			pstmt.setString(4, student.getSchool());
			pstmt.setString(5, student.getMajor());
			pstmt.setString(6, student.getClazz());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.setResult(student);
		return result;
	}

	public List<Student> selects() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "select * from student";
		PreparedStatement pstmt;
		try{
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Student> studentList = new ArrayList<Student>();
			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setSchool(rs.getString("school"));
				student.setMajor(rs.getString("major"));
				student.setClazz(rs.getString("clazz"));
				studentList.add(student);
			}
			pstmt.close();
			conn.close();
			return studentList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Result select(String name) {
		Result result = new Result();
		Connection conn = ConnectionUtil.getConnection();
		String sql = "select * from student where name = ?";
		PreparedStatement pstmt;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			Student student = new Student();
			while (rs.next()) {
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
				student.setSchool(rs.getString("school"));
				student.setMajor(rs.getString("major"));
				student.setClazz(rs.getString("clazz"));
			}
			if(student.getName() == null ){
				result.setStatus(0, "操作失败");
				return result;
			}
			pstmt.close();
			conn.close();
			result.setResult(student);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Result update(Student student) {
		Result result = new Result();
		Connection conn = ConnectionUtil.getConnection();
		String sql = "update student set  sex = ?, age = ?, school = ?, major = ?, clazz = ?  where name =?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getSex());
			pstmt.setInt(2, student.getAge());
			pstmt.setString(3, student.getSchool());
			pstmt.setString(4, student.getMajor());
			pstmt.setString(5, student.getClazz());
			pstmt.setString(6, student.getName());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		result.setResult(student);
		return result;
	}

	public Result delete(String name) {
		Result result = new Result();
		Connection conn = ConnectionUtil.getConnection();
		String sql = "delete from student where name = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
