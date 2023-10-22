package com.Jones.Hotel_management.controller;

import com.Jones.Hotel_management.model.*;
import com.Jones.Hotel_management.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    Service service;

    // Crud Operations

    @PostMapping("room")
    public void addRoom(@RequestBody HotelRoom hotelRoom){
        service.addRooms(hotelRoom);
    }

    @PostMapping("rooms")
    public String addRoom(@RequestBody List<HotelRoom> rooms){
        return service.addRooms(rooms);
    }


    @GetMapping("room/{id}")
    public HotelRoom getRoomById(@PathVariable Integer id){
        return service.getRoomById(id);
    }

    @GetMapping("rooms")
    public Iterable<HotelRoom> getAllRooms(){
        return service.getAllRooms();
    }

    @GetMapping("room/{id}/exists")
    public boolean checkRoomExists(@PathVariable Integer id){
        return service.checkRoomExists(id);
    }

    @GetMapping("rooms/count")
    public Integer getTotalRooms(){
        return service.getTotalRooms();
    }

    @DeleteMapping("room/{id}")
    public String deleteRoomById(@PathVariable Integer id){
        return service.deleteRoomById(id);
    }


    @PutMapping("room/{id}/{type}")
    public String updateRoomById(@PathVariable Integer id,@PathVariable RoomType type){
        return service.updateRoomById(id,type);
    }


    //find rooms by status

    @GetMapping("rooms/status/{status}")
    public List<HotelRoom> getRoomsByStatus(@PathVariable Boolean status)
    {
        return service.getRoomsByStatus(status);
    }

    @GetMapping("rooms/status/{status}/type/{type}")
    public List<HotelRoom> getRoomsByStatusAndType(@PathVariable Boolean status,@PathVariable RoomType type)
    {
        return service.getRoomsByStatusAndType(status,type);
    }

    @GetMapping("rooms/status/{status}/type/{type}/priceRange")
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(@PathVariable Boolean status, @PathVariable RoomType type, @RequestParam Double lLimit, @RequestParam Double uLimit)
    {
        return service.getRoomsByStatusAndTypeAndPrice(status,type,lLimit,uLimit);
    }

    @GetMapping("rooms/type/{roomType}")
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(@PathVariable RoomType roomType)
    {
        return service.getRoomsByTypeAndPriceSortedDesc(roomType);
    }

    @GetMapping("rooms/type1/{roomType1}/type2/{roomType2}")
    public List<HotelRoom> getBudgetedAcOrNonAC(@PathVariable RoomType roomType1,@PathVariable RoomType roomType2, @RequestParam Double lLimit,@RequestParam Double uLimit)
    {
        return service.getBudgetedAcOrNonAC( roomType1, roomType2, lLimit,uLimit);
    }

}
