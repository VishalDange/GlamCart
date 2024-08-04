package com.foodsphere.request;

import com.foodsphere.model.Category;
import com.foodsphere.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;

    private String description;

    private Long price;

    private Category category;

    private List<String> images;

    private Long restaurantId;

    private boolean isVegetarian;

    private boolean isSeasonal;

    private List<IngredientsItem> ingredientsItems;
}