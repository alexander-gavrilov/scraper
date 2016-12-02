package scraper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alexa on 30.11.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, KeyManagementException, NoSuchAlgorithmException {
        //String url = args[0];
        Scraper scraper = new Scraper();
        String province = "ANCONA";


        String url = "https://www.alboautotrasporto.it/web/portale-albo/imprese-iscritte";

        Document doc = scraper.getDocument(url);
        Element element = doc.getElementById("_impreseiscritte_WAR_serviziportalealbo100SNAPSHOTesercizioalbo_provinceList");
        element.getElementsByTag("option").forEach((option) -> {
            System.out.println("option = " + option.val() + "\t" + option.text());
        });
        Element pe = element.getElementsByTag("option").stream().filter((option) -> {
            if (option.text().equals(province)) {
                return true;
            }
            return false;
        }).findFirst().get();
        System.out.println("Chosen option is "+pe.text());
        
    }

}
