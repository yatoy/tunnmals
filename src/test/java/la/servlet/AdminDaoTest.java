package la.servlet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdminDaoTest extends AdminDao {

	@Test
	void test() {
		AdminDao dao = new AdminDao();

		AdminBeans bean = dao.searchByIdPassword(1, "himitu");

		Assertions.assertEquals(1, bean.getId());
		Assertions.assertEquals("himitu", bean.getPassword());
	}

}
