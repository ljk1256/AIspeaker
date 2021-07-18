package com.eatingtoday.eatingtoday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class apiController extends naverApicontroller{

    @Autowired
    private ResturantRepository resturantRepository;

    @GetMapping("/test/{localdata}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public List<Resturant> getnaverApi(@PathVariable String localdata) throws JsonProcessingException {

        String clientId = "VhbUCLMP0G9GktY1da2R"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "aPV80eOIok"; //애플리케이션 클라이언트 시크릿값"

        String text = localdata + "맛집";
        String sort = "comment";
        int display = 5;

        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }

        List<Resturant> result = getResturant(localdata);

        if(result.size() != 0){
            System.out.println(localdata + "is found");
            return result;
        }

        String apiURL = "https://openapi.naver.com/v1/search/local?query=" + text +"&display=" + display + "&sort=" + sort;    // json 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);


        List<Resturant> info = new ArrayList();
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseBody.toString());
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray getArray = (JSONArray) jsonObject.get("items");
            System.out.println(getArray);
            for(int i = 0; i < getArray.size(); ++i){

                //JSON to String
                JSONObject object = (JSONObject) getArray.get(i);


                String getTitle = (String) object.get("title");
                String link = (String) object.get("link");
                String category = (String) object.get("category");
                String description = (String) object.get("description");
                String telephone = (String) object.get("telephone");
                String address = (String) object.get("address");
                String roadAddress = (String) object.get("roadAddress");
                String mapx = (String) object.get("mapx");
                String mapy = (String) object.get("mapy");


                String titleFilter = getTitle.replaceAll("<b>", "");
                String title = titleFilter.replaceAll("</b>", "");


                //String to JSON
                Resturant resturant = new Resturant(
                        localdata, title,link, category,description,telephone, address, roadAddress, mapx, mapy);

                insertResturant(resturant);
                info.add(resturant);

            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        return info;
    }

    //Get Data
   public List<Resturant> getResturant(String localdata){
        return resturantRepository.findByLocaldata(localdata);
   }
    //insert Data
   public Resturant insertResturant(Resturant res){
        return resturantRepository.insert(res);
   }
}


