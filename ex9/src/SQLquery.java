import java.sql.Connection;

public class SQLquery {
    private String dbURL;
    private String username;
    private String password;
    Connection myConnection;
    public SQLquery(String dbURL, String username, String password){
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }
    void setQuery(String query){

    }
}
