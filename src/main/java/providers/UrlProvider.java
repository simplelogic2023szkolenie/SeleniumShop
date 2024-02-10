package providers;

public class UrlProvider {
    private static String baseUrl="http://146.59.32.4/index.php";

    public static String cart = baseUrl + "?controller=cart&action=show";
    public static String homePage = baseUrl;

    // + budowanie innych URLi które byśmy wykorzystywali w teście
}
