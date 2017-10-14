package com.stackroute.gitapp.Github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, 
		JpaRepositoriesAutoConfiguration.class})
public class GitApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GitApplication.class,args);
    }
}
