package com.mari.shop.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = { "com.mari.shop.mapper.**" })
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
public class MybatisConfig {
	/*
	 * @Bean public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
	 * throws Exception{ SqlSessionFactoryBean sessionFactory = new
	 * SqlSessionFactoryBean(); sessionFactory.setDataSource(dataSource); return
	 * sessionFactory.getObject(); }
	 */
	  
			/*
			 * @Bean public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory
			 * sqlSessionFactory) throws Exception { return new
			 * SqlSessionTemplate(sqlSessionFactory); }
			 */
	  
}
