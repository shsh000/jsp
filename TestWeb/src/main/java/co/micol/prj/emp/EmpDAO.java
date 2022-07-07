package co.micol.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {
	// jobs 전체 조회
	public ArrayList<JobsVO> selectJobs() {
		ArrayList<JobsVO> list = new ArrayList<JobsVO>();
		try {
			getConnect();
			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobID(rs.getString("job_id")); // 컬럼명
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 전체 조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1.연결
			getConnect();
			// 2.sql 구문 준비
			String sql = "select * from employees";
			if (departmentId != null && !departmentId.isEmpty()) {
				sql += " where department_id = ?"; // ? : 외부에서 전달하는 값
			}
			sql += " order by employee_id";
			psmt = conn.prepareStatement(sql);
			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}
			// 실행
			ResultSet rs = psmt.executeQuery();
			// 조회결과 list에 담기
			while (rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmployeeID(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobID(rs.getString("job_id"));
				vo.setDepartmentID(rs.getString("department_id"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4.연결해제
			disconnect();
		}
		return list;
	}

	// 단건 조회
	public EmpVO selectOne(String employeeID) {
		EmpVO vo = new EmpVO();
		try {
			getConnect();
			String sql = "select * from employees where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeID);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setEmployeeID(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobID(rs.getString("job_id"));
				vo.setDepartmentID(rs.getString("department_id"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 등록
	public int empInsert(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into"
					+ " employees(employee_id, last_name, email, hire_date, job_id, department_id)"
					+ " values((select max(employee_id)+1 from employees),?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobID());
			psmt.setString(5, vo.getDepartmentID());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 수정
	public int empUpdate(EmpVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "update employees set last_name = ?, email = ?, hire_date = ?, job_id = ?, department_id = ?"
					+ " where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobID());
			psmt.setString(5, vo.getDepartmentID());
			psmt.setString(6, vo.getEmployeeID());
			cnt = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 삭제
	public int empDelete(String employeeID) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "delete from employees where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeID);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}
}
