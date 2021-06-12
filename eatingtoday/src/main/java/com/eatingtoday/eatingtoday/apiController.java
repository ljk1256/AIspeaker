package com.eatingtoday.eatingtoday;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class apiController extends naverApicontroller{

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getnaverApi(String localdata){
        String clientId = "VhbUCLMP0G9GktY1da2R"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "aPV80eOIok"; //애플리케이션 클라이언트 시크릿값"

        localdata = "강남 맛집";        //이거 지워야됨
        String text = localdata;
        String sort = "comment";
        int display = 5;

        try {
            text = URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        String apiURL = "https://openapi.naver.com/v1/search/local?query=" + text +"&display=" + display + "&sort=" + sort;    // json 결과

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        String [] info = {};
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseBody.toString());
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray getArray = (JSONArray) jsonObject.get("items");

            for(int i = 0; i < getArray.size(); ++i){

                //JSON to String
                JSONObject object = (JSONObject) getArray.get(i);

                String getTitle = (String) object.get("title");
                String address = (String) object.get("address");
                String roadAddress = (String) object.get("roadAddress");

                String titleFilter = getTitle.replaceAll("<b>", "");
                String title = titleFilter.replaceAll("</b>", "");


                //String to JSON
                ObjectMapper mapper = new ObjectMapper();

                Map<String, String> map = new HashMap<>();
                map.put("title", title);
                map.put("address", address);
                map.put("roadAddress", roadAddress);

                try{
                    //New JSON
                    String MyResponseBody = mapper.writeValueAsString(map);
                    System.out.println(MyResponseBody);
                }
                catch (JsonProcessingException e){
                    e.printStackTrace();
                }
            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        return responseBody;
    }
}


