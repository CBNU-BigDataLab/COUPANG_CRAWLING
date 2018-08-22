package kr.ac.cbnu.bigdatalab.coupangcrawling.models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Long productId;
    private Long itemId;
    private Long vendorItemId;
    private String title;
    private int reviewCount;
    private Double rating;
    private Double ratingPercentage;
    private String category;
    private String 색상;
    private String AS; //A/S 책임자와 전화번호,
    private String 품명_및_모델명; //품명 및 모델명,
    private String 품질보증기준; //품질보증기준,
    private String 제품_소재; //제품 소재,
    private String 세탁방법_및_취급시_주의사항; //세탁방법 및 취급시 주의사항,
    private String 정격전압_소비전력;// 정격전압, 소비전력,
    private String 무게;        // 무게,
    private String 제조국; // 제조국,
    private String 주요_사양; // 주요 사양,
    private String 제조자; // 제조자(수입자),
    private String 출시년월; // 출시년월,
    private String 냉난방면적; // 냉난방면적
    private String 치수; // 치수,
    private String KC; // KC 인증 필 유무
    private String 제품구성; // 제품구성
    private String 에너지소비효율등급; // 에너지소비효율등급
    private String 추가설치비용; // 추가설치비용
    private String 크기; // 크기
    private String URL;
    private boolean isSoldOut; //view-source:http://www.coupang.com/vp/products/4964690/vendor-items/3008757111/sale-infos/sdp?sdpStyle=undefined
    private Double salePrice;
    private Double discountRate;
    private Double originalPrice;
    private String sellingInfo; //http://www.coupang.com/vp/products/4964690/vendor-items/3033167739/selling-infos?itemId=22672086
    private String URLMain;

    private List<Review> reviews = new ArrayList<>();
//    private List<Item> items = new ArrayList<>();

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getVendorItemId() {
        return vendorItemId;
    }

    public void setVendorItemId(Long vendorItemId) {
        this.vendorItemId = vendorItemId;
    }

    public String get색상() {
        return 색상;
    }

    public void set색상(String 색상) {
        this.색상 = 색상;
    }

    public String getAS() {
        return AS;
    }

    public void setAS(String AS) {
        this.AS = AS;
    }

    public String get품명_및_모델명() {
        return 품명_및_모델명;
    }

    public void set품명_및_모델명(String 품명_및_모델명) {
        this.품명_및_모델명 = 품명_및_모델명;
    }

    public String get품질보증기준() {
        return 품질보증기준;
    }

    public void set품질보증기준(String 품질보증기준) {
        this.품질보증기준 = 품질보증기준;
    }

    public String get제품_소재() {
        return 제품_소재;
    }

    public void set제품_소재(String 제품_소재) {
        this.제품_소재 = 제품_소재;
    }

    public String get세탁방법_및_취급시_주의사항() {
        return 세탁방법_및_취급시_주의사항;
    }

    public void set세탁방법_및_취급시_주의사항(String 세탁방법_및_취급시_주의사항) {
        this.세탁방법_및_취급시_주의사항 = 세탁방법_및_취급시_주의사항;
    }

    public String get정격전압_소비전력() {
        return 정격전압_소비전력;
    }

    public void set정격전압_소비전력(String 정격전압_소비전력) {
        this.정격전압_소비전력 = 정격전압_소비전력;
    }

    public String get무게() {
        return 무게;
    }

    public void set무게(String 무게) {
        this.무게 = 무게;
    }

    public String get제조국() {
        return 제조국;
    }

    public void set제조국(String 제조국) {
        this.제조국 = 제조국;
    }

    public String get주요_사양() {
        return 주요_사양;
    }

    public void set주요_사양(String 주요_사양) {
        this.주요_사양 = 주요_사양;
    }

    public String get제조자() {
        return 제조자;
    }

    public void set제조자(String 제조자) {
        this.제조자 = 제조자;
    }

    public String get출시년월() {
        return 출시년월;
    }

    public void set출시년월(String 출시년월) {
        this.출시년월 = 출시년월;
    }

    public String get냉난방면적() {
        return 냉난방면적;
    }

    public void set냉난방면적(String 냉난방면적) {
        this.냉난방면적 = 냉난방면적;
    }

    public String get치수() {
        return 치수;
    }

    public void set치수(String 치수) {
        this.치수 = 치수;
    }

    public String getKC() {
        return KC;
    }

    public void setKC(String KC) {
        this.KC = KC;
    }

    public String get제품구성() {
        return 제품구성;
    }

    public void set제품구성(String 제품구성) {
        this.제품구성 = 제품구성;
    }

    public String get에너지소비효율등급() {
        return 에너지소비효율등급;
    }

    public void set에너지소비효율등급(String 에너지소비효율등급) {
        this.에너지소비효율등급 = 에너지소비효율등급;
    }

    public String get추가설치비용() {
        return 추가설치비용;
    }

    public void set추가설치비용(String 추가설치비용) {
        this.추가설치비용 = 추가설치비용;
    }

    public String get크기() {
        return 크기;
    }

    public void set크기(String 크기) {
        this.크기 = 크기;
    }

    public String getProductDetailsPageURL() {
        return "http://www.coupang.com/vp/products/" + this.productId + "?itemId=" + this.itemId + "&vendorItemId=" + this.vendorItemId;
    }

    public String getProductDetailsSectionURL() {
        return "http://www.coupang.com/vp/products/" + this.productId + "/vendor-items/" + this.vendorItemId + "?isFixedVendorItem=true&type=sdp";
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSellingInfo() {
        return sellingInfo;
    }

    public void setSellingInfo(String sellingInfo) {
        this.sellingInfo = sellingInfo;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getRatingPercentage() {
        return ratingPercentage;
    }

    public void setRatingPercentage(Double ratingPercentage) {
        this.ratingPercentage = ratingPercentage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getURLMain() {
        return URLMain;
    }

    public void setURLMain(String URLMain) {
        this.URLMain = URLMain;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", itemId=" + itemId +
                ", vendorItemId=" + vendorItemId +
                ", title='" + title + '\'' +
                ", reviewCount=" + reviewCount +
                ", rating=" + rating +
                ", ratingPercentage=" + ratingPercentage +
                ", category='" + category + '\'' +
                ", 색상='" + 색상 + '\'' +
                ", AS='" + AS + '\'' +
                ", 품명_및_모델명='" + 품명_및_모델명 + '\'' +
                ", 품질보증기준='" + 품질보증기준 + '\'' +
                ", 제품_소재='" + 제품_소재 + '\'' +
                ", 세탁방법_및_취급시_주의사항='" + 세탁방법_및_취급시_주의사항 + '\'' +
                ", 정격전압_소비전력='" + 정격전압_소비전력 + '\'' +
                ", 무게='" + 무게 + '\'' +
                ", 제조국='" + 제조국 + '\'' +
                ", 주요_사양='" + 주요_사양 + '\'' +
                ", 제조자='" + 제조자 + '\'' +
                ", 출시년월='" + 출시년월 + '\'' +
                ", 냉난방면적='" + 냉난방면적 + '\'' +
                ", 치수='" + 치수 + '\'' +
                ", KC='" + KC + '\'' +
                ", 제품구성='" + 제품구성 + '\'' +
                ", 에너지소비효율등급='" + 에너지소비효율등급 + '\'' +
                ", 추가설치비용='" + 추가설치비용 + '\'' +
                ", 크기='" + 크기 + '\'' +
                ", URL='" + URL + '\'' +
                ", isSoldOut=" + isSoldOut +
                ", salePrice=" + salePrice +
                ", discountRate=" + discountRate +
                ", originalPrice=" + originalPrice +
                ", sellingInfo='" + sellingInfo + '\'' +
                ", URLMain='" + URLMain + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
