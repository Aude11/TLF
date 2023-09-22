package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import org.json.JSONObject;
import org.json.JSONArray;



// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        //HttpRequest.newBuilder(request, (name, value) -> !name.equalsIgnoreCase("Foo-Bar"));
        String primaryKey  = "397256a3b0654a46b63a758163c53338";
        String secondarykey = "9bae51974fcb43f8ba530d9387179395";
        String urlString = "https://api.tfl.gov.uk/Line/1/Route";
        String responseBody;
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(urlString))
                .header("Cache-Control", "no-cache")
                .version(HttpClient.Version.HTTP_2).GET().build();
        try {
            HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
            HttpHeaders responseHeaders = response.headers();
            responseBody = response.body();
            System.out.println(responseBody);
         } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //System.out.println(responseBody);
        JSONObject json = new JSONObject(responseBody);
        String a = json.toString();
        System.out.println(a);
        String modeName= json.getString("modeName");
        JSONArray jsonArray = new JSONArray();
        jsonArray  = json.getJSONArray("routeSections");
                System.out.println(jsonArray);
                System.out.println(modeName);
                for(int i=0; i < jsonArray .length(); i++)
        {
            JSONObject object = jsonArray .getJSONObject(i);
            System.out.println(object.getString("originationName"));
            System.out.println(object.getString("serviceType"));
        }

        }
}