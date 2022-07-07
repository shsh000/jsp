package co.micol.prj.dept;

import java.sql.ResultSet;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;
import co.micol.prj.emp.EmpVO;

public class DeptDAO extends DAO {
	// 전체 조회
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			getConnect();
			String sql = "select * from departments";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDepartmentId(rs.getString("department_id")); // 컬럼명
				vo.setDepartmentName(rs.getString("department_name"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 단건 조회
	public DeptVO selectOne(String department_id) {
		// 결과값 저장할 VO 생성
		DeptVO vo = new DeptVO();
		try {
			getConnect();
			String sql = "select * from departments where department_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, department_id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setDepartmentId(rs.getString("department_id")); // 컬럼명
				vo.setDepartmentName(rs.getString("department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}

	// 등록
	public int deptInsert(DeptVO vo) {
		int cnt = 0; // 리턴값을 저장할 변수
		try {
			getConnect();
			String sql = "insert into departments(department_id, department_name) values(?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentId());
			psmt.setString(2, vo.getDepartmentName());
			cnt = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 수정
	public int deptUpdate(DeptVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "update departments set department_name = ? where department_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getDepartmentName());
			psmt.setString(2, vo.getDepartmentId());
			cnt = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return cnt;
	}

	// 삭제

}
