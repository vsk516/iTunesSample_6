package com.gopi.itunes;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * .
 */

public class VolleyRequestHelper {
    Context mContext;
    public VolleyRequestHelper(Context context)
    {
        this.mContext = context;
    }
    public void sendRequest(String JSON_URL, Response.Listener<String> responseListener){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                responseListener,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(stringRequest);
    }
}
