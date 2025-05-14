import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPeli {
    public Pelicula buscarPelicula (int numeroDePelicula){
        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+numeroDePelicula+"/");
        System.out.println("URI: "+direccion);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion).build();
        try {
            HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response: "+response.body());
            return new Gson().fromJson(response.body(), Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontrò pelicula");
        }



    }
}
