package com.gcit.lms;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gcit.lms.dao.AuthorDAO;
import com.gcit.lms.dao.BookDAO;
import com.gcit.lms.service.AdministratorService;

@EnableTransactionManagement
@Configuration
public class LMSConfig {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/library";
	private String user = "root";
	private String pass = "root";
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pass);
		return ds;
	}
	
	@Bean
	public JdbcTemplate template(){
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		return template;
	}
	
	@Bean
	public PlatformTransactionManager txManager(){
		DataSourceTransactionManager tx = new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	
	@Bean
	AuthorDAO aDAO(){
		AuthorDAO adao = new AuthorDAO();
		
		return adao;
	}
	
	@Bean
	BookDAO bDAO(){
		BookDAO bdao = new BookDAO();
		
		return bdao;
	}
	
	@Bean
	AdministratorService service(){
		AdministratorService service = new AdministratorService();
		return service;
	}
	
//	@Bean
//	AuthorDAO aDAO(){
//		AuthorDAO adao = new AuthorDAO();
//		
//		return adao;
//	}
//	@Bean
//	AuthorDAO aDAO(){
//		AuthorDAO adao = new AuthorDAO();
//		
//		return adao;
//	}
}
