package edu.escuelaing.arem;

import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("files");
        get("/hello", (req, res) -> "Hello Heroku");

        get("/intraday",(req,res)  -> {
            res.type("application/json");
            return HttpConnectionExample.getAPI();
        });

        get("/homePage", (req, res) -> {
            res.redirect("/index.html");

            return null;
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            System.out.println(System.getenv("PORT"));
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}