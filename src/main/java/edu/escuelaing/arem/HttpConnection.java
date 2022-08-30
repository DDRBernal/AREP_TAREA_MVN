package edu.escuelaing.arem;

import edu.escuelaing.arem.cache.Cache;
import spark.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static spark.Spark.staticFiles;

public class HttpConnection {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String SerialKEY = "4M76WMCIMJW816IN";
    //"https://api.polygon.io/v1/open-close/AAPL/2020-10-14?adjusted=true&apiKey=zrGIGJki8d4Mv0WvPo1mSA73b2nFWsl4";

    public static String getAPI(Request req) throws IOException {
        Cache cache = Cache.getCache();
        String GET_URL = "https://www.alphavantage.co/query?function=%s&symbol=%s&apikey="+SerialKEY;
        URL obj = new URL(GET_URL);
        String reponseAPI  = "";
        if (cache.getCacheMap().containsKey("keycache")){
            reponseAPI = cache.getCacheMap().get("keycache");
        } else {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            //The following invocation perform the connection implicitly before getting the code
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) response.append(inputLine);
                in.close();
                // print result
                System.out.println(response.toString());
                reponseAPI =  response.toString();
                cache.getCacheMap().put("",reponseAPI);
                System.out.println(reponseAPI);
            } else {
                System.out.println("GET request not worked");
            }
            System.out.println("GET DONE");
        } return reponseAPI;
    }

} 