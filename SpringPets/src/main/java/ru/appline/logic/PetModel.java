package ru.appline.logic;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PetModel implements Serializable
{
    private AtomicInteger atomicInteger = new AtomicInteger();
    private final Map<Integer, Pet> model;
    private static final PetModel instance = new PetModel();

    public PetModel()
    {
        model = new HashMap<Integer, Pet>();
    }
    public static PetModel getInstance()
    {
        return instance;
    }

    public void Add(Pet pet, int id)
    {
        model.put(id, pet);
    }

    public Pet GetFromList(int id)
    {
        return model.get(id);
    }

    public Map<Integer, Pet> GetAll()
    {
        return model;
    }

    public void Delete(int id)
    {
        model.remove(id);
    }
}
