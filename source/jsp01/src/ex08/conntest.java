package ex08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class conntest {

	@Test
	void test() {
		DBConn_DBCP.getConn();
	}

}
