package la.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import la.bean.AdminBeans;
import la.dao.AdminDao;

class AdminDaoTest extends AdminDao {

	@Test
	void test() {
		AdminDao dao = new AdminDao();

		AdminBeans bean = dao.searchByIdPassword(1, "himitu");

		Assertions.assertEquals(1, bean.getId());
		Assertions.assertEquals("himitu", bean.getPassword());
	}

}
