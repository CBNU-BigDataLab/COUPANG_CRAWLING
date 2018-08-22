package kr.ac.cbnu.bigdatalab.coupangcrawling.models;

public class Review {
    private String reviewer;
    private String reviewDate;
    private double rating;
    private String productName;
    private String reviewContent;

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewer='" + reviewer + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                ", rating=" + rating +
                ", productName='" + productName + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}
