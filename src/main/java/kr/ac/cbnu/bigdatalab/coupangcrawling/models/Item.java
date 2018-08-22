package kr.ac.cbnu.bigdatalab.coupangcrawling.models;

public class Item {
    private Long itemId;
    private Long vendorItemId;
    private String title;
    private boolean isSoldOut; //view-source:http://www.coupang.com/vp/products/4964690/vendor-items/3008757111/sale-infos/sdp?sdpStyle=undefined
    private Double salePrice;
    private Double discountRate;
    private Double orginalPrice;
    private String sellingInfo; //http://www.coupang.com/vp/products/4964690/vendor-items/3033167739/selling-infos?itemId=22672086

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Double getOrginalPrice() {
        return orginalPrice;
    }

    public void setOrginalPrice(Double orginalPrice) {
        this.orginalPrice = orginalPrice;
    }

    public String getSellingInfo() {
        return sellingInfo;
    }

    public void setSellingInfo(String sellingInfo) {
        this.sellingInfo = sellingInfo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", vendorItemId=" + vendorItemId +
                ", title='" + title + '\'' +
                ", isSoldOut=" + isSoldOut +
                ", salePrice=" + salePrice +
                ", discountRate=" + discountRate +
                ", orginalPrice=" + orginalPrice +
                ", sellingInfo='" + sellingInfo + '\'' +
                '}';
    }
}
