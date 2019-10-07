package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Artikal;
import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ItemSaver
{
    private Collection<Artikal> items = new ArrayList<>();
    private JSONArray itemsJSON = new JSONArray();

    private String path = ItemSaver.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public ItemSaver() {}

    public void save(Collection<Artikal> pItems)
    {
        this.items = pItems;

        for(Artikal artikal : items)
        {
            JSONObject newItem = new JSONObject();

            newItem.put("id", artikal.getId());
            newItem.put("name", artikal.getNaziv());
            newItem.put("price", String.valueOf(artikal.getCena()));
            newItem.put("description", artikal.getOpis());
            newItem.put("quantity", String.valueOf(artikal.getKolicina()));
            newItem.put("restaurant", String.valueOf(artikal.getRestoran()));

            if(artikal.getType().equals(enums.ArtikalTypes.HRANA)){
                newItem.put("typeOfItem", "HRANA");
            }
            else
                newItem.put("typeOfItem", "PICE");

            itemsJSON.add(newItem);
        }
        saveItemsJson();
    }

    private void saveItemsJson()
    {
        try(FileWriter fileItems = new FileWriter(path + "../../data/items.json")){
            fileItems.write(itemsJSON.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
