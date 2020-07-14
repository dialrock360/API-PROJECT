package com.yemmback.store.repository;

import com.yemmback.store.model.Category;
import com.yemmback.store.model.Category;
import com.yemmback.store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by dialrock361 on 01/08/20.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT v FROM Category v where v.flag = :flagcategory ")
    List<Category> findCategorys(@Param("flagcategory") int flagcategory);

    @Query("SELECT v FROM Category v where   v.categoryname = :categoryname")
    Category findByname(@Param("categoryname") String categoryname);

    Category findByCategoryname(String categoryname);
    Boolean existsByCategoryname(String categoryname);
    Boolean existsCategoriesById(Long id);
}
