package com.AK.Hotel_Management.Service;

import com.AK.Hotel_Management.Model.Room;
import com.AK.Hotel_Management.Model.RoomType;
import com.AK.Hotel_Management.Repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    IRoomRepo roomRepo;

    public String addRoom(Room room) {
        roomRepo.save(room);
        return "Room added";
    }

    public String addRooms(List<Room> room) {
        roomRepo.saveAll(room);
        return "Rooms added";

    }

    public List<Room> getAllRooms() {
        return (List<Room>) roomRepo.findAll();
    }

    public Optional<Room> getById(Integer id) {
        return roomRepo.findById(id);
    }

    public List<Room> getAvailableRoomsByType(RoomType roomType) {
        return roomRepo.findByRoomType(roomType);
    }

    public List<Room> getRoomsByType(RoomType roomType) {
        return roomRepo.findByRoomTypeAndRoomAvailableStatus(roomType,true);
    }

    public String deleteById(Integer id) {
     Room rr = roomRepo.findById(id).orElse(null);
       if(rr!=null){
           roomRepo.deleteById(id);
           return "Id deleted";
       }else{
           return "id not found";
       }
    }

    public String updateRoomPriceByType(RoomType roomType, Double percentIncrease) {
        List<Room> rooms = roomRepo.findByRoomType(roomType);

        for (Room room : rooms) {
            double currentPrice = room.getRoomPrice();
            double increaseAmount = (currentPrice * percentIncrease) / 100;
            double newRoomPrice = currentPrice + increaseAmount;
            room.setRoomPrice(newRoomPrice);
        }

        roomRepo.saveAll(rooms);

        return "All " + roomType.toString() + " room prices increased by " + percentIncrease + "%";
    }


}
