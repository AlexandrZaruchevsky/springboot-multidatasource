package ru.zaa.springboot.multidatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        basePackages = {"ru.zaa.springboot.multidatasource.repository.mysql"},
        transactionManagerRef = "mysqlTransactionManager"
)
public class MySQLDBConfig {

    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.mysql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mysqlDatasource") DataSource dataSource
    ) {
        Map<String,Object> properties = new HashMap<String, Object>(){{
            put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
            put("hibernate.hbm2ddl.auto","update");
        }};
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("ru.zaa.springboot.multidatasource.domain.mysql")
                .persistenceUnit("MySQL")
                .build();
    }

    @Bean("mysqlTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
