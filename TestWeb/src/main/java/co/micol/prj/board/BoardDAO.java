package co.micol.prj.board;

import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO {
	// 전체 조회
	public ArrayList<BoardVO> selectAll() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getConnect();
			String sql = "select * from board order by rdt desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRdt(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
