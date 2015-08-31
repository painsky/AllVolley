package gzu.example.zty.testvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//if you want to use get
//    String url="http://apis.juhe.cn/mobile/get?phone=13100816663&key=623e1c0aeb71f2c2292b5e52ff961cc9";
//if you want to use post follow this
    private String url="http://apis.juhe.cn/mobile/get?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   volley_get();
        volley_post();
        //volley_post_jo();
    }

    private void volley_post_jo() {
        HashMap<String,String> map=new HashMap<String,String>();
        map.put("phone", "13100816663");
        map.put("key", "623e1c0aeb71f2c2292b5e52ff961cc9");
        JSONObject jsonObject=new JSONObject(map);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        jsonObjectRequest.setTag("jo_post");
        MainApplication.getRequestQueue().add(jsonObjectRequest);
    }

    private void volley_post() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("phone", "13100816663");
                map.put("key", "623e1c0aeb71f2c2292b5e52ff961cc9");
                return map;

            }
        };
        stringRequest.setTag("localpost");
        MainApplication.getRequestQueue().add(stringRequest);
    }

    private void volley_get() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        stringRequest.setTag("localget");
        MainApplication.getRequestQueue().add(stringRequest);
    }

}
