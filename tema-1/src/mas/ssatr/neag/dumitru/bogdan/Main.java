package mas.ssatr.neag.dumitru.bogdan;

import mas.ssatr.neag.dumitru.bogdan.model.Location;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        Object object = new JSONParser().parse(new FileReader("src/mas/ssatr/neag/dumitru/bogdan/input/retea-petri.json"));
        JSONObject jo = (JSONObject) object;
        JSONObject jo2 = (JSONObject) jo.get("ReteaPetri");

        JSONArray jsonArray = (JSONArray) jo2.get("Locatii");
        for (int i = 0; i < jsonArray.size(); i++) {
            jo = (JSONObject) jsonArray.get(i);
            System.out.println(jo.toString());
        }
    }
}
