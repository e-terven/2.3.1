package web.config;

        import org.apache.commons.dbcp2.BasicDataSource;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.core.env.Environment;
        import org.springframework.orm.jpa.JpaTransactionManager;
        import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
        import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
        import org.springframework.transaction.PlatformTransactionManager;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

        import javax.sql.DataSource;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;


@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.addConnectionProperty("hibernate.hbm2ddl.auto", "");
        dataSource.addConnectionProperty("hibernate.dialect", "");
        dataSource.addConnectionProperty("hibernate.show.sql", "");

        dataSource.setInitialSize(Integer.parseInt(env.getRequiredProperty("db.initialSize")));
        dataSource.setMinIdle(Integer.valueOf(env.getRequiredProperty("db.minIdle")));
        dataSource.setMaxIdle(Integer.valueOf(env.getRequiredProperty("db.maxIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("db.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("db.minEvictableIdleTTimeMillis")));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("db.testOnBorrow")));
        dataSource.setValidationQuery(env.getRequiredProperty("db.validationQuery"));

        return dataSource;
    }

    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());
        return manager;
    }

    public Properties getHibernateProperties() {
            Properties properties = new Properties();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot find hibernate.properties");
        }
            return properties;
    }
}

