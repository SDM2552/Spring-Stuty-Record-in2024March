//package config;
//
//import javax.sql.DataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//@Configuration
//@ComponentScan(basePackages = {"dao","service","controller"})
//public class DataSourceConfig {
//    
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        dataSource.setUsername("scott");
//        dataSource.setPassword("tiger");
//        return dataSource;
//    }
//    
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//}
