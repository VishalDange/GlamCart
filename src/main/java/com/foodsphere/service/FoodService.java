package com.foodsphere.service;

import com.foodsphere.model.Category;
import com.foodsphere.model.Food;
import com.foodsphere.model.Restaurant;
import com.foodsphere.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);

    public void deleteFood(long foodId) throws Exception;

    public List<Food> getRestaurantFood(Long restaurantId,boolean isVegetarian,boolean isNonVeg,boolean isSeasonal, String foodCategory);

    public List<Food> searchFood(String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailability(Long foodId) throws Exception;


}