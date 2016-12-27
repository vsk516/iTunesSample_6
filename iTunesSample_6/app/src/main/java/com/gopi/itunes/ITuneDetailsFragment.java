package com.gopi.itunes;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 *
 */

public class ITuneDetailsFragment extends Fragment {
    private ITunesItem mITunesItem;
    private TextView trackNameTextView;
    private TextView artistNameTextView;
    private TextView trackLongDescriptionTextView;
    private ImageView trackTumbnail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.itumes_details_main_layout, container, false);
        trackNameTextView = (TextView) view.findViewById(R.id.details_track_name);
        trackNameTextView.setText(mITunesItem.getTrackName());
        artistNameTextView = (TextView) view.findViewById(R.id.details_artist_name);
        artistNameTextView.setText(mITunesItem.getArtistName());
        trackLongDescriptionTextView = (TextView) view.findViewById(R.id.details_track_long_des);
        trackLongDescriptionTextView.setText(mITunesItem.getLongDescription());
        trackTumbnail = (ImageView) view.findViewById(R.id.trackThumbnail);
        Picasso.with(getActivity()).load(mITunesItem.getTrackImage()).into(trackTumbnail);
        return view;
    }

    public void setData(ITunesItem item)
    {
        this.mITunesItem = item;
    }
}