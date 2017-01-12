import org.jsoup.Jsoup;
import org.jsoup.safety.Jsoup;


public class WhitelistBadParctice {
    public static void main(String args[]) {
        Whiltelist whitelist = Whitelist.none();

        whitelist.addTags("i");

        Jsoup.isValid("<body></body>",b); // true
                                          // "<body></body>" -> "<html><head></head><body></body></html>"
                                          // Beside, <html> and <head> are allowed.
        Jsoup.isValid("<div><body onload=\"alert('XSS')\"></body></div>",b);
                                          // true, it seems so bad.
        
        // but, it is safly if with normalization. 
        // (no debug)
        String html = "<body></body>";
        html = Jsoup.parseBodyFragment(html).toString().replace("(^<body[^>]+>)|</body>$");
    }
}