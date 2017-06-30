package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.sql.DataSource;

@Singleton
@Startup
public class DatabaseSetup {
    
    @Resource(lookup="java:comp/DefaultDataSource")
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        
        executeUpdate(dataSource, "CREATE TABLE employee (name VARCHAR(64) PRIMARY KEY, org VARCHAR(64))");
        
        executeUpdate(dataSource, "INSERT INTO employee VALUES('Foo', 'oracle')");
        executeUpdate(dataSource, "INSERT INTO employee VALUES('Bar', 'oracle')");
        executeUpdate(dataSource, "INSERT INTO employee VALUES('Alex', 'oracle')");;
    }
    
    @PreDestroy
    public void destroy() {
    	try {
    		executeUpdate(dataSource, "DROP TABLE employee");
    	} catch (Exception e) {
    		// silently ignore, concerns in-memory database
    	}
    }
    
    private void executeUpdate(DataSource dataSource, String query) {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        } catch (SQLException e) {
           throw new IllegalStateException(e);
        }
    }
    
}
