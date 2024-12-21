package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.CompassModel;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller
{
    private static final CompassModel compassModel = CompassModel.getInstance();

    @PostMapping(value = "/set", consumes = "application/json", produces = "application/json")
    public Map<String, String> SetParameter(@RequestBody String directions)
    {
        compassModel.CreateMap(directions);
        return compassModel.GetMap();
    }

    @GetMapping(value = "/findDir", consumes = "application/json", produces = "application/json")
    public Map<String, String> FindDirection(@RequestBody Map<String, String> angle)
    {
        Map<String, String> sideMap = new HashMap<String, String>();
        String side = compassModel.FindDirection(Integer.parseInt(angle.get("Degree")));
        sideMap.put("Side", side);
        return sideMap;
    }
}
