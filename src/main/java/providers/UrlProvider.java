package providers;

import configuration.Config;

public class UrlProvider {
    private static String baseUrl = Config.getAppUrl();
    public static String cart = baseUrl + "?controller=cart&action=show";
    public static String login = baseUrl + "?controller=authentication&back=my-account";
    public static String homePage = baseUrl;

    // + budowanie innych URLi które byśmy wykorzystywali w teście
}
