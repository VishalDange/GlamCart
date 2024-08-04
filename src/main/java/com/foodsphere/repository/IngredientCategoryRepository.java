package com.foodsphere.repository;

import com.foodsphere.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory,Long> {

    public List<IngredientCategory> findByRestaurantId(Long id);

}