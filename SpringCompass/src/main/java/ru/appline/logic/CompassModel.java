package ru.appline.logic;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class CompassModel implements Serializable
{
    Gson gson = new Gson();
    private static final CompassModel compassModel = new CompassModel();
    private Map<String,String> directions;

    public CompassModel()
    {
        directions = new HashMap<String, String>();
    }

    public static CompassModel getInstance()
    {
        return compassModel;
    }

    public void CreateMap(String directionsStr)
    {
        directions = gson.fromJson(directionsStr, Map.class);
    }

    public Map<String,String> GetMap()
    {
        return directions;
    }

    public String FindDirection(int angle)
    {
        for(Map.Entry<String, String> entry : directions.entrySet())
        {
            String direction = entry.getKey();
            String range = entry.getValue();
            String[] part = range.split("-");
            int start = Integer.parseInt(part[0]);
            int end = Integer.parseInt(part[1]);

            if(isAngleRange(angle, start, end))
            {
                return direction;
            }
        }
        return "Неизвестное направление";
    }

    private boolean isAngleRange(int angle, int start, int end)
    {
        if (start < end) return angle >= start && angle <= end;
        else return angle >= start || angle <= end;
    }
}
