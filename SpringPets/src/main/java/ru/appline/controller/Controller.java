package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.PetModel;
import ru.appline.logic.Pet;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller
{
    private static PetModel petModel = PetModel.getInstance();
    private static AtomicInteger atomicInteger = new AtomicInteger();

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String CreatePet(@RequestBody Pet pet)
    {
        petModel.Add(pet, atomicInteger.getAndIncrement());
        return "Питомец успешно создан";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> GetAll()
    {
        return petModel.GetAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet GetPet(@RequestBody Map<String, Integer> id)
    {
        return petModel.GetFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public String DeletePet(@RequestBody Map<String, Integer> id)
    {
        petModel.Delete(id.get("id"));
        return "Питомец успешно удален";
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public String UpdatePet(@RequestBody Map<String, Object> updatedPet)
    {
        Pet newPet = new Pet((String)updatedPet.get("name"), (String)updatedPet.get("type"), (Integer)updatedPet.get("age"));
        petModel.Update(newPet, (Integer)updatedPet.get("id"));
        return "Питомец обновлен";
    }
}
