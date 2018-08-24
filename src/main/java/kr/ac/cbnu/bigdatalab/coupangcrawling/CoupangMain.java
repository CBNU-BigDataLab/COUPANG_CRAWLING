package kr.ac.cbnu.bigdatalab.coupangcrawling;

import com.google.gson.Gson;
import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Item;
import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Pagination;
import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Product;
import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Review;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

public class CoupangMain {

    public static void main(String args[]) throws IOException {

//        Document totalCountDocument = Jsoup.connect("http://www.coupang.com/np/search?q=계절+가전제품&sorter=scoreDesc&listSize=72").get();
        Document totalCountDocument = Jsoup.connect("http://www.coupang.com/np/categories/227812?sorter=scoreDesc&listSize=72").get();
        Long totalProducts = Long.valueOf(totalCountDocument.select(".newcx-product-total-count").first().text().replaceAll("\\(","").replaceAll("\\)","").replaceAll(",",""));
        Pagination totalProductPagination = new Pagination();
        totalProductPagination.setLimit(72);
        totalProductPagination.setTotalCount(totalProducts);
        for(int i = 1; i < totalProductPagination.getTotalPages(); i++) {
            Document document = Jsoup.connect("http://www.coupang.com/np/search?q=계절+가전제품&sorter=scoreDesc&listSize=72&page=" + i).get();
            Elements productElements = document.select("#productList li a");

            for (Element productElement : productElements) {
                try {
                    Product product = new Product();
                    product.setProductId(Long.valueOf(productElement.attr("data-product-id")));
                    product.setItemId(Long.valueOf(productElement.attr("data-item-id")));
                    product.setVendorItemId(Long.valueOf(productElement.attr("data-vendor-item-id")));
                    product.setCategory(Jsoup.connect("http://www.coupang.com/vp/products/" + product.getProductId() + "/breadcrumb-gnbmenu").get().select("#breadcrumb").text());
                    System.out.println(product.getCategory());

                    InputStream input = new URL("http://www.coupang.com/vp/products/" + product.getProductId() + "/review-rating").openStream();
                    Reader reader = new InputStreamReader(input, "UTF-8");
                    Map<String, Double> data = new Gson().fromJson(reader, Map.class);
                    System.out.println(data);
                    product.setReviewCount(data.get("ratingCount").intValue());
                    product.setRating(data.get("ratingAverage"));
                    product.setRatingPercentage(data.get("ratingPercentage"));

                    String itemsURL = "http://www.coupang.com/vp/products/" + product.getProductId() + "/loadOptions?vendorItemId=" + product.getVendorItemId();
                    Document itemDocument = Jsoup.connect(itemsURL).get();
                    Elements itemElements = itemDocument.select("ul li.prod-option-select__item:not([selected])");
                    for (Element itemElement : itemElements) {
                        if (itemElement.attr("class").contains("selected")) {
                            continue;
                        }
                        Item item = new Item();
                        item.setTitle(itemElement.text());
                        item.setItemId(Long.valueOf(itemElement.attr("data-item-id")));
                        item.setVendorItemId(Long.valueOf(itemElement.attr("data-vendor-item-id")));
                        item.setSoldOut(itemElement.hasClass(".soldout"));

                        String itemURL = "http://www.coupang.com/vp/products/" + product.getProductId() + "/vendor-items/" + item.getVendorItemId() + "/sale-infos/sdp?sdpStyle=undefined";
                        Document itemDetailsDocument = Jsoup.connect(itemURL).get();
                        try {
                            item.setDiscountRate(Double.valueOf(itemDetailsDocument.select(".prod-price__discount").text().replaceAll("%", "").replaceAll(" ", "")));
                        } catch (Exception ex) {
                            item.setDiscountRate(0.0);
                        }
                        try {
                            item.setOrginalPrice(Double.valueOf(itemDetailsDocument.select(".prod-original-price").text().replaceAll(",", "").replaceAll("원", "").replaceAll(" ", "")));
                            item.setSalePrice(Double.valueOf(itemDetailsDocument.select(".prod-price__number").text().replaceAll(",", "").replaceAll("원", "").replaceAll(" ", "")));
                        } catch (Exception ex) {
                            item.setOrginalPrice(Double.valueOf(itemDetailsDocument.select("#totalPrice").text().replaceAll(",", "").replaceAll("원", "").replaceAll(" ", "")));
                            item.setSalePrice(item.getOrginalPrice());
                        }
                        item.setSellingInfo(Jsoup.connect("http://www.coupang.com/vp/products/" + product.getProductId() + "/vendor-items/" + product.getVendorItemId() + "/selling-infos?itemId=" + item.getItemId()).get().select(".prod-description-attribute").text());

                        //product.getItems().add(item);
                    }
                    Element productDetailsElement = Jsoup.connect(product.getProductDetailsSectionURL()).get().select(".product-item__detail").first();
                    try {
                        product.set색상(productDetailsElement.select("th:contains(색상)").first() != null ? productDetailsElement.select("th:contains(색상)").first().nextElementSibling().text() : null);
                        product.setKC(productDetailsElement.select("th:contains(KC 인증 필 유무)").first() != null ? productDetailsElement.select("th:contains(KC 인증 필 유무)").first().nextElementSibling().text() : null);
                        product.setAS(productDetailsElement.select("th:contains(A/S 책임자와 전화번호)").first() != null ? productDetailsElement.select("th:contains(A/S 책임자와 전화번호)").first().nextElementSibling().text() : null);
                        product.set품명_및_모델명(productDetailsElement.select("th:contains(품명 및 모델명)").first() != null ? productDetailsElement.select("th:contains(품명 및 모델명)").first().nextElementSibling().text() : null);
                        product.set품질보증기준(productDetailsElement.select("th:contains(품질보증기준)").first() != null ? productDetailsElement.select("th:contains(품질보증기준)").first().nextElementSibling().text() : null);
                        product.set제품_소재(productDetailsElement.select("th:contains(제품 소재)").first() != null ? productDetailsElement.select("th:contains(제품 소재)").first().nextElementSibling().text() : null);
                        product.set세탁방법_및_취급시_주의사항(productDetailsElement.select("th:contains(세탁방법 및 취급시 주의사항 )").first() != null ? productDetailsElement.select("th:contains(세탁방법 및 취급시 주의사항 )").first().nextElementSibling().text() : null);
                        product.set정격전압_소비전력(productDetailsElement.select("th:contains(정격전압, 소비전력)").first() != null ? productDetailsElement.select("th:contains(정격전압, 소비전력)").first().nextElementSibling().text() : null);
                        product.set무게(productDetailsElement.select("th:contains(무게)").first() != null ? productDetailsElement.select("th:contains(무게)").first().nextElementSibling().text() : null);
                        product.set제조국(productDetailsElement.select("th:contains(제조국)").first() != null ? productDetailsElement.select("th:contains(제조국)").first().nextElementSibling().text() : null);
                        product.set주요_사양(productDetailsElement.select("th:contains(주요 사양)").first() != null ? productDetailsElement.select("th:contains(주요 사양)").first().nextElementSibling().text() : null);
                        product.set제조자(productDetailsElement.select("th:contains(제조자\\(수입자\\))").first() != null ? productDetailsElement.select("th:contains(제조자\\(수입자\\))").first().nextElementSibling().text() : null);
                        product.set출시년월(productDetailsElement.select("th:contains(출시년월)").first() != null ? productDetailsElement.select("th:contains(출시년월)").first().nextElementSibling().text() : null);
                        product.set냉난방면적(productDetailsElement.select("th:contains(냉난방면적)").first() != null ? productDetailsElement.select("th:contains(냉난방면적)").first().nextElementSibling().text() : null);
                        product.set치수(productDetailsElement.select("th:contains(치수)").first() != null ? productDetailsElement.select("th:contains(치수)").first().nextElementSibling().text() : null);
                        product.set제품구성(productDetailsElement.select("th:contains(제품구성)").first() != null ? productDetailsElement.select("th:contains(제품구성)").first().nextElementSibling().text() : null);
                        product.set에너지소비효율등급(productDetailsElement.select("th:contains(에너지소비효율등급)").first() != null ? productDetailsElement.select("th:contains(에너지소비효율등급)").first().nextElementSibling().text() : null);
                        product.set추가설치비용(productDetailsElement.select("th:contains(추가설치비용)").first() != null ? productDetailsElement.select("th:contains(추가설치비용)").first().nextElementSibling().text() : null);
                        product.set크기(productDetailsElement.select("th:contains(크기)").first() != null ? productDetailsElement.select("th:contains(크기)").first().nextElementSibling().text() : null);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(product);
                    Document productDetailsDocument = Jsoup.connect(product.getProductDetailsPageURL()).get();
                    product.setTitle(productDetailsDocument.select(".prod-buy-header__title").first().text());

                    Document totalReviewCountDocument = Jsoup.connect("http://www.coupang.com/vp/product/reviews?productId=" + product.getProductId() + "&page=1&size=100&sortBy=ORDER_SCORE_ASC&ratings=&q=&ratingSummary=true").get();
                    Long totalCount = Long.valueOf(totalReviewCountDocument.select(".js_reviewArticleTotalCountHiddenValue").attr("data-review-total-count"));

                    Pagination pagination = new Pagination();
                    pagination.setLimit(100);
                    pagination.setTotalCount(totalCount);

                    System.out.println("REVIEWS TOTAL PAGES ==> " + pagination.totalPages());

                    for (int page = 1; page <= pagination.totalPages(); page++) {
                        String reviewURL = "http://www.coupang.com/vp/product/reviews?productId=" + product.getProductId() + "&page=" + page + "&size=100&sortBy=ORDER_SCORE_ASC&ratings=&q=&ratingSummary=true";
                        Document reviewDocument = Jsoup.connect(reviewURL).get();
                        Elements reviewArticles = reviewDocument.select("article.js_reviewArticleReviewList");

                        for (Element reviewArticle : reviewArticles) {
                            Review review = new Review();
                            review.setReviewer(reviewArticle.select(".sdp-review__article__list__info__user").text());
                            review.setRating(Double.valueOf(reviewArticle.select(".sdp-review__article__list__info__product-info__star-orange").attr("data-rating")));
                            review.setReviewDate(reviewArticle.select(".sdp-review__article__list__info__product-info__reg-date").text());
                            review.setProductName(reviewArticle.select(".sdp-review__article__list__info__product-info__name").text());
                            review.setReviewContent(reviewArticle.select(".sdp-review__article__list__review__content").text());
                            product.getReviews().add(review);
                            System.out.println(review);
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}