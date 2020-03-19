package com.cognizant.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	} 

	@Override
	@Transactional
	public String create(Customer customer) {
		String query = "insert into tbl_customer values(?,?,?,?)";
		int res = jdbcTemplate.update(query, new Object[] { customer.getCustId(), customer.getCustName(),
				customer.getCustEmail(), customer.getCustPhoneNo() });
		
		
		if(res>0){
			return "SUCCESS";
		}else{
			return "FAIL";
		}
	}
	public List<Customer> findAll() {
		String query = "select * from tbl_customer";
		return jdbcTemplate.query(query,
				(rs, rowNum) -> 
		new Customer(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4)));

	}

}
