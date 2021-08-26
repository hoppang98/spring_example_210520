package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan(basePackages = "com.example.*") // mapper scan 추가!!! @Repository가 붙어있는걸 스캔 - DatabaseConfig로 이동
// @ComponentScan(basePackages= {"com", "com.example"})
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) - DB연동하면서 주석처리
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}

//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource);
//
//		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); // resources에 mappers 패키지 만들기
//		sessionFactory.setMapperLocations(res);
//
//		return sessionFactory.getObject();
//	} -  DatabaseConfig로 이동
}
