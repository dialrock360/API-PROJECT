package com.yemmback.store.repository;

import com.yemmback.store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dialrock361 on 01/08/20.
 */

@Repository
public interface  ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT v FROM Product v where v.flag = 0 and v.category.id=:categoryid")
    List<Product> findProductsByCategory(@Param("categoryid") Long categoryid);



    @Query("SELECT v FROM Product v where v.flag = :flagproduct ")
    List<Product> findProducts(@Param("flagproduct") int flagproduct);
    @Query("SELECT v FROM Product v where v.conditioning.id = :conditioningid ")
    List<Product> findProductsContitionningId(@Param("conditioningid") Integer flagproduct);


    @Query("SELECT v FROM Product v where v.productname = :name or v.productref = :name ")
    Product findProducts(@Param("name") String name);
/*
    @Query(value = "SELECT *  FROM v_product_conditioning", nativeQuery = true)
    List<ProductConditioningReponse> getAllProductConditioningReponse();
    @Query(value = "SELECT *  FROM v_product_conditioning  where conditioning_id = :conditioningid ", nativeQuery = true)
    List<ProductConditioningReponse> getAllProductConditioningReponseContitionningId(@Param("conditioningid") Integer conditioningid);
    */

    List<Product>  findProductsByConditioningId(Long conditioning_id);
    Product findByProductname(String username);
    Boolean existsByProductname(String username);
    Boolean existsProductById(Long id);
}
