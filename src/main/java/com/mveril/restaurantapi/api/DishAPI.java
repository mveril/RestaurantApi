/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mveril.restaurantapi.api;

import com.mveril.restaurantapi.business.Dish;
import com.mveril.restaurantapi.business.Menu;
import java.util.Collection;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 *
 * @author mikav
 */
@Path("dishes")
public class DishAPI {
    
    @GET()
    @Produces({MediaType.APPLICATION_JSON})        
    public Collection<Dish> list(){
        return Menu.list();
    }
    
    @POST()
    @Consumes({MediaType.APPLICATION_JSON})
    public int create(Dish dish){
        return Menu.create(dish);
    }
    
    @GET()
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") int id){
        Optional<Dish> opt = Menu.getById(id);
        if(opt.isPresent()){
            return Response.ok(opt.get()).build();
        } else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @PUT()
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(@PathParam("id") int id, Dish dishToUpdate){
        Menu.update(id,dishToUpdate);
    }
    
    @DELETE()
    @Path("/{id}")
    public void delete(@PathParam("id") int id){
        Menu.delete(id);
    }
}
