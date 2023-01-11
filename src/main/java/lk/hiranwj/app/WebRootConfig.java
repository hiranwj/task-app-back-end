package lk.hiranwj.app;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class WebRootConfig {

    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
        jndi.setJndiName("java:comp/enc/jdbc/task-app");
        jndi.setExpectedType(DataSource.class);
        return jndi;
    }

    @Bean(destroyMethod = "close")
    @Scope("request")
    public Connection connection(DataSource dataSource) throws SQLException {
            return dataSource.getConnection();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
