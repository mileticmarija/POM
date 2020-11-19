package selenium_core;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager= new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager= new FirefoxDriverManager();
                break;
            case IE:
                driverManager= new IEdriverManager();
                break;
            case EDGE:
                driverManager= new EDGEdriverManager();
                break;
            default:
                driverManager= new ChromeDriverManager();
        }
        return driverManager;
    }
}
