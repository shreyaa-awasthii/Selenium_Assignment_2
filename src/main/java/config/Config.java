package config;

public class Config {
    private String browser;
    private String baseUrl;

    public Config(String browser, String baseUrl) {
        this.browser = browser;
        this.baseUrl = baseUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
