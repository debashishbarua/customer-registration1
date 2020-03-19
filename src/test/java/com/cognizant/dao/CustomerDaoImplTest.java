package com.cognizant.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.cognizant.config.TestConfig;
import com.cognizant.model.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
@Sql({ "/test-schema.sql", "/test-user-data.sql" })
@Rollback
@ActiveProfiles(TestConfig.PROFILE_TEST)
public class CustomerDaoImplTest {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public final void testCustomerDao() {
		assertEquals("public class com.cognizant.dao.CustomerDaoImpl", this.customerDao.getClass().toGenericString());

	}
	
	@Test
	public final void testjdbcTemplateField() throws NoSuchFieldException, IllegalAccessException {
		//given
        final CustomerDaoImpl dao = new CustomerDaoImpl();

        //when
       // dao.setJdbcTemplate(null);

        //then
        final Field field = dao.getClass().getDeclaredField("jdbcTemplate");
        field.setAccessible(true);
        System.out.println("field.getName() " + field.getName());
        assertEquals("Fields didn't match", field.getName(), "jdbcTemplate");

	}

	@Test
	@Rollback
	public final void testCreate() {
		String actual = customerDao.create(new Customer(105, "Soumitra", "s@gmail.com", "9677556548"));
		assertEquals(actual, "SUCCESS");
		List<Customer> actual1 = customerDao.findAll();
		assertNotNull(actual1);
		assertEquals(3, actual1.size());
	}

	@Test
	public final void testFindAll() {
		List<Customer> actual = customerDao.findAll();
		assertNotNull(actual);
		

	}

}
