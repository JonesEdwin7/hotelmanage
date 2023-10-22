package com.Jones.Hotel_management.repository;

import com.Jones.Hotel_management.model.HotelRoom;
import com.Jones.Hotel_management.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRoomRepository extends JpaRepository<HotelRoom,Integer> {

    List<HotelRoom> findByRoomStatus(Boolean roomStatus);

    List<HotelRoom> findByRoomStatusAndRoomType(Boolean status, RoomType type);

    List<HotelRoom> findByRoomStatusAndRoomTypeAndRoomPriceGreaterThanAndRoomPriceLessThan(Boolean status, RoomType type, Double lLimit, Double uLimit);

    List<HotelRoom> findByRoomTypeOrderByRoomPriceDesc(RoomType type);

    List<HotelRoom> findByRoomTypeAndRoomPriceBetweenOrRoomType(RoomType type1,Double lLimit, Double uLimit,RoomType type2);

    @Query(value = "select * from Room where room_id = :id" , nativeQuery = true)
    HotelRoom getAllRoomById(Integer id);

}
