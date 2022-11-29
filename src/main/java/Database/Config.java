package Database;

public class Config {

    Mode mode;
    private  String url = "";
    private String user ="";
    private String password="";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }


    public Config(Mode mode) {
        this.mode = mode;
        switch (mode){
            case DEV:
                this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_DEVINT";
                this.user = "CSCI5308_12_DEVINT_USER";
                this.password = "AR6aixaephie7voo";
                break;
            case TEST:
                this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_TEST";
                this.user = "CSCI5308_12_TEST_USER";
                this.password = "EJaiqueigahNg6cu";
                break;

            case PROD:
                this.url = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_12_PRODUCTION";
                this.user = "CSCI5308_12_PRODUCTION_USER";
                this.password = "iewavi5AiZee7mah";
                break;
        }


    }

}
