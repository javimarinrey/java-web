package db;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class PoolConexiones {

    public DataSource dataSource;
    public String db = "test";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";

    public PoolConexiones(){
        inicializaDataSource();
    }

    private void inicializaDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        dataSource = basicDataSource;
    }
}
