package com.mari.shop.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = { "com.mari.shop.mapper" })
@EnableTransactionManagement
public class MybatisConfig {

	
	/*
	 * @Bean public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
	 * throws Exception{ SqlSessionFactoryBean sessionFactory = new
	 * SqlSessionFactoryBean(); sessionFactory.setDataSource(dataSource); return
	 * sessionFactory.getObject(); }
	 * 
	 * @Bean public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory
	 * sqlSessionFactory) throws Exception { return new
	 * SqlSessionTemplate(sqlSessionFactory); }
	 */
	 
}
