package com.example.dovezi2.loadnsave;

import com.example.dovezi2.model_classes.Artikal;
import com.example.dovezi2.model_classes.enums;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ItemLoader
{
    private HashMap<String, Artikal> allItems = new HashMap<>();
    private JSONParser jsonParser = new JSONParser();

    private String path = ItemSaver.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    public ItemLoader(){
        loadItems();
    }

    public void loadItems()
    {
        try {
            JSONArray array = (JSONArray) jsonParser.parse(new FileReader(path + "../../data/items.json"));

            for(Object obj : array)
            {
                JSONObject jsonObject = (JSONObject) obj;

                String id = (String) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                String cena = (String) jsonObject.get("price");
                double price = Double.parseDouble(cena);
                String description = (String) jsonObject.get("description");
                String kolicina = (String) jsonObject.get("quantity");
                double quantity = Integer.parseInt(kolicina);
                String tip = (String) jsonObject.get("typeOfItem");
                enums.ArtikalTypes type;

                if (tip.equals("HRANA"))
                    type = enums.ArtikalTypes.HRANA;
                if (tip.equals("PICE"))
                    type = enums.ArtikalTypes.PICE;
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, Artikal> getAllItems()
    {
        return allItems;
    }

    public void setAllItems(HashMap<String, Artikal> allItems)
    {
        this.allItems = allItems;
    }
}
