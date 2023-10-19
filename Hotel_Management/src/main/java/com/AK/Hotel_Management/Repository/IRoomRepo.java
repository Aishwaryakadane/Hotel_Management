package com.AK.Hotel_Management.Repository;

import com.AK.Hotel_Management.Model.Room;
import com.AK.Hotel_Management.Model.RoomType;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRoomRepo extends CrudRepository<Room, Integer> {

    List<Room> findByRoomType(RoomType roomType);

    List<Room> findByRoomTypeAndRoomAvailableStatus(RoomType roomType, boolean b);
}

