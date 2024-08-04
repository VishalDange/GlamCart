package com.foodsphere.Controller;

import com.foodsphere.dto.RestaurantDto;
import com.foodsphere.model.Restaurant;
import com.foodsphere.model.User;
import com.foodsphere.request.CreateRestaurantRequest;
import com.foodsphere.service.RestaurantService;
import com.foodsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> createRestaurant(@RequestHeader("Authorization") String jwt,@RequestParam String keyword) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.searchRestaurant(keyword);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestHeader("Authorization") String jwt) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant=restaurantService.getAllRestaurant();

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/addToFavourites")
    public ResponseEntity<RestaurantDto> addToFavourites(@RequestHeader("Authorization") String jwt,@PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(jwt);
       RestaurantDto restaurantDto =restaurantService.addFavourites(id,user);

        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }
}