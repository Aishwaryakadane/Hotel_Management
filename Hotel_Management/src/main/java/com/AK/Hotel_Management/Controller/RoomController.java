package com.AK.Hotel_Management.Controller;

import com.AK.Hotel_Management.Model.Room;
import com.AK.Hotel_Management.Model.RoomType;
import com.AK.Hotel_Management.Service.RoomService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("room")
    public String addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @PostMapping("rooms")
    public String addRooms(@RequestBody List<Room> room){
        return roomService.addRooms(room);
    }

    @GetMapping("rooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("room/{id}")
    public Optional<Room> getById(@PathVariable Integer id){
        return roomService.getById(id);
    }

    @GetMapping("available-by-type/{roomType}")
    public List<Room>getAvailableRoomsByType(@PathVariable RoomType roomType){
        return roomService.getAvailableRoomsByType(roomType);
    }

    @GetMapping("available-by-type-condition/{roomType}")
    public List<Room>getRoomsByType(@PathVariable RoomType roomType){
        return roomService.getRoomsByType(roomType);
    }

    @DeleteMapping("roomm/{id}")
    public String deleteById(@PathVariable Integer id){
        return roomService.deleteById(id);
    }

    @PutMapping("room/priceIncreased")
    public String updateByPrice(@RequestParam RoomType roomType,@RequestParam Double newprice){
        return roomService.updateRoomPriceByType(roomType,newprice);
    }

}
