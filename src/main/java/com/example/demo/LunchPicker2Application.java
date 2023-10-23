package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.example.demo.entity.Lunch;
import com.example.demo.repository.LunchRepository;


@SpringBootApplication
public class LunchPicker2Application implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(LunchPicker2Application.class, args);
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("my-app", initJpaProperties());
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager= new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
	
	private final Map<String,String> initJpaProperties(){
		final Map<String,String> ret = new HashMap<>();
		ret.put(PersistenceUnitProperties.JDBC_DRIVER,"oracle.jdbc.OracleDriver");
		ret.put(PersistenceUnitProperties.JDBC_URL,"jdbc:oracle:thin:@mydb.chbgnew9ytag.ap-southeast-1.rds.amazonaws.com:1521:ORCL");
		ret.put(PersistenceUnitProperties.JDBC_USER,"admin");
		ret.put(PersistenceUnitProperties.JDBC_PASSWORD,"020497xM!");
		ret.put(PersistenceUnitProperties.DDL_GENERATION_MODE,PersistenceUnitProperties.DDL_SQL_SCRIPT_GENERATION);
		ret.put(PersistenceUnitProperties.DDL_GENERATION,PersistenceUnitProperties.NONE);
		
		return ret;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//				String sql = "Select * from Lunch";
//				
//				List<Lunch> lunchList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Lunch.class));
//			
//				lunchList.forEach(System.out :: println);
				
//				List<Lunch> listLunch = lunchRepository.findAll();
//				listLunch.forEach(System.out :: println);
//				long sl = 1;
//		
//				Lunch l = lunchRepository.findByLunchId(sl);
//				System.out.println(l);
		
	}

}
