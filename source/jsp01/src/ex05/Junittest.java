package ex05;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class Junittest {

	@Test
	void dbconntest() {
		Connection conn = DBConn.getConn();
		
		//널이 아니면 성공
		assertNotNull(conn);
		
	}

}
