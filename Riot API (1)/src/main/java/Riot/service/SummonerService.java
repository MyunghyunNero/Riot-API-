package Riot.service;

import Riot.domain.SummonerDto;
import Riot.key.RiotKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class SummonerService {

    public SummonerDto searchSummoner(String sumname){
        SummonerDto summoner=null;
        BufferedReader bufferedReader;

        String summonerName=sumname.replaceAll(" ","%20");
        String requestUrl= "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+ summonerName + "?api_key=" + RiotKey.apiKey;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            bufferedReader =new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            StringBuilder result= new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null){
                result.append(line);
            }
            JsonObject jsonObject=(JsonObject) JsonParser.parseString(result.toString());
            String accountId=jsonObject.get("accountId").getAsString();
            int profileIconId=jsonObject.get("profileIconId").getAsInt();
            long revisionDate=jsonObject.get("revisionDate").getAsLong();
            String name=jsonObject.get("name").getAsString();
            String id=jsonObject.get("id").getAsString();
            String puuid=jsonObject.get("puuid").getAsString();
            long summonerLevel=jsonObject.get("summonerLevel").getAsLong();
            summoner=new SummonerDto(accountId,profileIconId,revisionDate,name,id,puuid,summonerLevel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return summoner;
    }

}
