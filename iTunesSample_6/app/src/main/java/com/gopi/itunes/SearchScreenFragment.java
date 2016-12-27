package com.gopi.itunes;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.Response;
import java.util.ArrayList;
import java.util.HashMap;

/**.
 */

public class SearchScreenFragment extends Fragment implements Response.Listener<String>{

    private EditText searchKeywordEditText;
    private String searchKeywordText = "";
    private String URL = "https://itunes.apple.com/search?term=jack+johnson&entity=musicVideo ";
    private String jsonResponse ="";
    private Button searchButton;

    private Spinner entitySpinner;
    private String entityKeyword = "";
    private static final HashMap<String, String> entityMap;
    static {
        entityMap = new HashMap<String, String>();
        entityMap.put("Movie","movie");
        entityMap.put("Album","album");
        entityMap.put("All Artist","allArtist");
        entityMap.put("Music video","musicVideo");
        entityMap.put("Mix","mix");
        entityMap.put("Audio book","audioBook");
        entityMap.put("Tv Season","tvSeason");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_main_layout, container, false);
        searchKeywordEditText = (EditText) view.findViewById(R.id.music_search_text);
        searchButton = (Button) view.findViewById(R.id.music_search_button);
        entitySpinner = (Spinner) view.findViewById(R.id.entity_spinner_list);
        setListeners();
        return view;
    }

    private void setListeners() {

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchKeywordText = searchKeywordEditText.getText().toString();
                String[] list = searchKeywordText.split(" ");
                Log.i("TAG" , ""+list.length);
                String searchKeyword="";
                for(int i = 0 ; i <list.length; i++)
                {
                    searchKeyword = searchKeyword +list[i]+"+";
                }

                entityKeyword = entitySpinner.getSelectedItem().toString();


                Uri.Builder builder = new Uri.Builder();
                builder.scheme("https")
                        .authority("itunes.apple.com")
                        .appendPath("search")
                        .appendQueryParameter("term", searchKeyword)
                        .appendQueryParameter("entity", entityMap.get(entitySpinner.getSelectedItem().toString()));
                String myUrl = builder.build().toString();
                Log.i("URL", "URL : "+myUrl);
                new VolleyRequestHelper(getActivity()).sendRequest(myUrl,SearchScreenFragment.this);
                /*FetchData data = new FetchData();

                data.JSON_URL=URL+searchKeyword;
                data.execute();*/

            }
        });
    }

    @Override
    public void onResponse(String response) {
        Log.i("MainActivity", "Response:: "+response);
        ParseJSON parseJSON = new ParseJSON(response);
        ArrayList<ITunesItem> iTunesItemArrayList = parseJSON.getITunesList();
        if(iTunesItemArrayList!=null && iTunesItemArrayList.size()>0)
        {
            ITunesRecyclerViewFragment recyclerViewFragment = new ITunesRecyclerViewFragment();
            recyclerViewFragment.setData(iTunesItemArrayList);
            getFragmentManager().beginTransaction().replace(R.id.container, recyclerViewFragment).addToBackStack(null).commit();
        }
        else
            Toast.makeText(getActivity(),"No Records Found.", Toast.LENGTH_LONG);
    }
}