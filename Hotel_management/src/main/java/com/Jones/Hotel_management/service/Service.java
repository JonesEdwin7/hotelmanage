package com.Jones.Hotel_management.service;

import com.Jones.Hotel_management.model.HotelRoom;
import com.Jones.Hotel_management.model.RoomType;
import com.Jones.Hotel_management.repository.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    IRoomRepository roomRepository;

    // returns list of all rooms
    public Iterable<HotelRoom> getAllRooms() {
        return roomRepository.findAll();
    }

    // adding a single room to database
    public void addRooms(HotelRoom hotelRoom) {
        roomRepository.save(hotelRoom);
    }

    // adding list of room to database
    public String addRooms(List<HotelRoom> rooms) {
        roomRepository.saveAll(rooms);
        return "rooms added"+rooms;
    }

    // get a room by their room I'd
    public HotelRoom getRoomById(Integer id) {
        return roomRepository.getAllRoomById(id);
    }

    // check the room is occupied or not
    public boolean checkRoomExists(Integer id) {
        return roomRepository.existsById(id);
    }

    // counts the total number of rooms
    public Integer getTotalRooms() {
        return (int) roomRepository.count();
    }

    // deletes the room by room I'd
    public String deleteRoomById(Integer id) {
        roomRepository.deleteById(id);
        return "room deleted successfully of id "+id;
    }

    // Update room type by room I'd
    public String updateRoomById(Integer id, RoomType type) {
        Optional<HotelRoom> myRoomOpt = roomRepository.findById(id);
        HotelRoom myRoom = null;
        if(myRoomOpt.isPresent())
        {
            myRoom = myRoomOpt.get();
            myRoom.setRoomType(type);
            roomRepository.save(myRoom);
            return "room type updated";
        }
        else {
            return "Id not Found!!!";
        }
    }

    // returns list of room based on the status(available / or not)
    public List<HotelRoom> getRoomsByStatus(Boolean status) {

        return roomRepository.findByRoomStatus(status);
    }

    // get room by room status and room type
    public List<HotelRoom> getRoomsByStatusAndType(Boolean status, RoomType type) {
        return roomRepository.findByRoomStatusAndRoomType(status, type);
    }

    // get room by room status, room type and price range
    public List<HotelRoom> getRoomsByStatusAndTypeAndPrice(Boolean status, RoomType type, Double lLimit, Double uLimit) {

        return roomRepository.findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan( status,  type,  lLimit,  uLimit);
    }

    // get room by room type and price in descending order ( 499, 429, 400)
    public List<HotelRoom> getRoomsByTypeAndPriceSortedDesc(RoomType roomType) {

        return roomRepository.findByRoomTypeOrderByRoomPriceDesc(roomType);
    }

    // get rooms based on budget or type
    public List<HotelRoom> getBudgetedAcOrNonAC(RoomType roomType1, RoomType roomType2, Double lLimit, Double uLimit) {
        return roomRepository.findByRoomTypeAndRoomPriceBetweenOrRoomType(roomType1,lLimit, uLimit,roomType2);
    }
}
