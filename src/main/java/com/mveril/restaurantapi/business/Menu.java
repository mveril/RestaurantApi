/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mveril.restaurantapi.business;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author mikav
 */
public class Menu {
    
    private static Map<Integer,Dish> dishes = new HashMap<Integer,Dish>();    
    
    private static int index=0;
    
    public static Collection<Dish> list(){
        return dishes.values();
    }
    
    public static int create(Dish dish){
        index++;
        dish.setId(index);
        dishes.put(index, dish);
        return index;
    } 
    
    public static Optional<Dish> getById(int id){
        if(dishes.containsKey(id)){
            return Optional.of(dishes.get(id));
        } else {
            return Optional.empty();
        }
    }
    
    public static void delete(int id){
        dishes.remove(id);
    }
    
    public static void update(int id,Dish dish){
        dishes.replace(id,dish);
    }
}
