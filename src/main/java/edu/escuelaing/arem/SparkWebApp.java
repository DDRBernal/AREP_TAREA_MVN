package edu.escuelaing.arem;

import spark.Filter;
import spark.Request;

import static spark.Spark.*;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        staticFiles.location("/files");

        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        get("/homePage","application/json", (req, res) -> HttpConnection.getAPI(req));
    }


    /**
     * Funcion destinada a retornar el puerto por el cual correrá nuestra app
     * @return el puerto que encuentre segun la variable de entorno PORT, sino el 4567 por defecto
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            System.out.println(System.getenv("PORT"));
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set(i.e. on localhost)
    }
}