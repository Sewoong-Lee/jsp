package dao;

import org.apache.ibatis.session.SqlSession;

import dto.FileDTO;



public class FileDAO {
	
	public int insert(FileDTO fdto) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardFileMapper.insert", fdto);
		}
	}

	public int delete(int bnum) {
		try(SqlSession session = MBConn.getSession()){
			return session.update("BoardFileMapper.delete", bnum);
		}
	}
	
}
