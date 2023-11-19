package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.util.Random;

public interface Helper {

    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiYWJjQGRlZi5jb20iLCJpc3MiOiJSZWd1bGFpdCIsImV4cCI6MTcwMTAxNTQ0MywiaWF0IjoxNzAwNDE1NDQzfQ._G3n-nN6o0yqb4_de87yCNmw6Maf06u6FSZNOVoEvOo";

    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");

    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    String baseURL = "https://contactapp-telran-backend.herokuapp.com";

    int i = new Random().nextInt(1000) + 1000;


}
