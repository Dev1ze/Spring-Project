package ru.appline.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.logic.CompassModel;
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

    @PostMapping(value = "/findDir", consumes = "application/json", produces = "application/json")
    public String FindDirection(@RequestBody Map<String, String> angle)
    {
        return compassModel.FindDirection(Integer.parseInt(angle.get("Degree")));
    }
}
