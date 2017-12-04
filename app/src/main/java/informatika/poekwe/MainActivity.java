package informatika.poekwe;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerview;
    private GridLayoutManager gridLayoutManager;
    private CustomAdapter adapter;
    private List<Poekwe> list_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        list_data = new ArrayList<>();
        load_data_from_server(0);
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerview.setLayoutManager(gridLayoutManager);

        adapter = new CustomAdapter (this,list_data);
        recyclerview.setAdapter(adapter);

        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(gridLayoutManager.findLastCompletelyVisibleItemPosition()==list_data.size()-1){
                    load_data_from_server(list_data.get(list_data.size()-1).getId_warung());
                }
            }
        });
    }

    private void load_data_from_server(final int id) {
        AsyncTask<Integer,Void,Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://poekwe.tk/warungs")
                        .build();
                try{


                Response response = client.newCall(request).execute();
                    JSONArray array = new JSONArray(response.body().string());

                 for (int i = 0; i<array.length(); i++){
                     JSONObject object = array.getJSONObject(i);
                     Poekwe data = new Poekwe(object.getInt("id_warung"),
                             object.getString("nama"),
                             object.getString("alamat"),
                             object.getString("gambar"));
                     list_data.add(data);
                 }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                catch (JSONException e)
                {
                    System.out.println("End of content");

                }

                return null;
            }
            @Override
            protected void onPostExecute (Void aVoid){
                adapter.notifyDataSetChanged();

            }
        };
        task.execute(id);
    }
}
