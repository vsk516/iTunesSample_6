package com.gopi.itunes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 *
 */
public class ParseJSON {
    /*
    {
      "kind": "song",  /// us it as short disc
     >"trackName": "Pussy (Suck My Pussy)", 0-1
     >"artworkUrl30": "http://is4.mzstatic.com/image/thumb/Music/v4/c0/af/b2/c0afb280-39cc-15df-eb25-9f8558ec485d/source/30x30bb.jpg",
     >"artworkUrl100": "http://is4.mzstatic.com/image/thumb/Music/v4/c0/af/b2/c0afb280-39cc-15df-eb25-9f8558ec485d/source/100x100bb.jpg",
     >"trackPrice": 0.99,
     >"longDescription": "You loved him in Shrek, now see where the one-and-only swashbuckling feline found his fame– and a very big pair of boots– in this hilariously funny film.  Lover, fighter and outlaw Puss In Boots (Antonio Banderas) is on the adventure of his nine lives as he teams up with Kitty Softpaws (Salma Hayek) and Humpty Dumpty (Zack Galifianakis) for the ultimate showdown with the notorious Jack and Jill."
    }*/
    public static final String JSON_ARRAY = "results";
    public static final String KEY_SHORT_DESCRIPTION = "kind";
    public static final String KEY_TRACK_NAME = "trackName";
    public static final String KEY_TUMBNAIL = "artworkUrl30";
    public static final String KEY_TRACK_IMAGE = "artworkUrl100";
    public static final String KEY_TRACK_PRICE = "trackPrice";
    public static final String KEY_LONG_DESCRIPTION = "longDescription";
    public static final String KEY_ARTIST_NAME = "artistName";

    private JSONArray iTunesArray = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    public ArrayList<ITunesItem> getITunesList(){
        ArrayList<ITunesItem> iTunesList = new ArrayList<>();
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            iTunesArray = jsonObject.getJSONArray(JSON_ARRAY);
            if(iTunesArray!=null)
            {
                for(int i=0;i<iTunesArray.length();i++){
                    ITunesItem iTunesItem = new ITunesItem();
                   JSONObject itemJsonObject = iTunesArray.getJSONObject(i);
                    if(!itemJsonObject.isNull(KEY_TRACK_NAME))
                       iTunesItem.setTrackName(itemJsonObject.getString(KEY_TRACK_NAME));
                    if(!itemJsonObject.isNull(KEY_LONG_DESCRIPTION))
                        iTunesItem.setLongDescription(itemJsonObject.getString(KEY_LONG_DESCRIPTION));
                    if(!itemJsonObject.isNull(KEY_SHORT_DESCRIPTION))
                        iTunesItem.setShortDescription(itemJsonObject.getString(KEY_SHORT_DESCRIPTION));
                    if(!itemJsonObject.isNull(KEY_TRACK_IMAGE))
                        iTunesItem.setTrackImage(itemJsonObject.getString(KEY_TRACK_IMAGE));
                    if(!itemJsonObject.isNull(KEY_TRACK_PRICE))
                        iTunesItem.setTrackPrice("$ "+itemJsonObject.getString(KEY_TRACK_PRICE));
                    if(!itemJsonObject.isNull(KEY_TUMBNAIL))
                        iTunesItem.setTrackTumbnail(itemJsonObject.getString(KEY_TUMBNAIL));
                    if(!itemJsonObject.isNull(KEY_ARTIST_NAME))
                        iTunesItem.setArtistName(itemJsonObject.getString(KEY_ARTIST_NAME));
                    iTunesList.add(iTunesItem);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return iTunesList;
    }
}
