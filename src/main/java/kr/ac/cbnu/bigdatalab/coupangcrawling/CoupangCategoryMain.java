package kr.ac.cbnu.bigdatalab.coupangcrawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;

public class CoupangCategoryMain {

    public static void main(String args[]) throws IOException {
        Document document = Jsoup.connect("http://www.coupang.com/").get();


        String[] menus = new String[]{"child-birth","kitchen","life","home_decoration","appliances-digital","hobby"};
        String[] strMenus = new String[]{"출산/유아동","주방용품","생활용품","홈인테리어","가전디지털","완구/취미"};
        String[] strLinks = new String[]{"http://www.coupang.com/np/categories/221934",
                "http://www.coupang.com/np/categories/185669",
                "http://www.coupang.com/np/categories/115673",
                "http://www.coupang.com/np/categories/184555",
                "http://www.coupang.com/np/categories/178255",
                "http://www.coupang.com/np/categories/317779"};
        for(int i = 0; i < menus.length; i++) {
            List<Element> secondDepthListElements = document.select(".category-layer ." + menus[i] + " li.second-depth-list");
            //System.out.println(strMenus[i]);
            for (Element secondDepthListElement : secondDepthListElements) {
                //System.out.print("," + secondDepthListElement.select("a").first().text());
                List<Element> thirdDepthListElements = secondDepthListElement.select(".third-depth-list li");
                for (Element thirdDepthListElement : thirdDepthListElements) {
                    System.out.println(strMenus[i] + "," + strLinks[i] + "," + secondDepthListElement.select("a").first().text() + ",http://www.coupang.com" + secondDepthListElement.select("a").first().attr("href") + "," +thirdDepthListElement.text() + ",http://www.coupang.com" + thirdDepthListElement.select("a").attr("href"));
                }
            }
        }
    }
}
