package kr.ac.cbnu.bigdatalab.coupangcrawling.repositories;


import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Product;
import kr.ac.cbnu.bigdatalab.coupangcrawling.models.Review;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HP1 on 4/10/2017.
 */
@Repository
public interface ProductRepository {

    public void save(Product product);

    public void saveReviews(@Param("product") Product product);

}
