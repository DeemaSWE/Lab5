package com.example.lab5.EventSystem.Controller;

import com.example.lab5.Api.ApiResponse;
import com.example.lab5.EventSystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/event")

public class EventController {

    ArrayList<Event> events = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event){
        events.add(event);
        return new ApiResponse("Event added");
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateEvent(@PathVariable String id, @RequestBody Event event){
        for(Event e : events){
            if(e.getId().equals(id)){
                events.set(events.indexOf(e), event);
                return new ApiResponse("Event updated");
            }
        }
        return new ApiResponse("Event not found");
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteEvent(@PathVariable String id){
        for(Event e : events){
            if(e.getId().equals(id)){
                events.remove(e);
                return new ApiResponse("Event deleted");
            }
        }
        return new ApiResponse("Event not found");
    }

    @PutMapping("/change/capacity/{id}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable String id, @PathVariable int capacity){
        for(Event e : events){
            if(e.getId().equals(id)) {
                e.setCapacity(capacity);
                return new ApiResponse("Event capacity changed");
            }
        }
        return new ApiResponse("Event not found");
    }

    @GetMapping("/search/{id}")
    public Event searchEventById(@PathVariable String id){
        for(Event e : events){
            if(e.getId().equals(id))
                return e;
        }
        return null;
    }

}
