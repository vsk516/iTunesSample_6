package com.gopi.itunes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gopi on 11/18/2016.
 */

public class ITunesAdapter extends RecyclerView.Adapter<ITunesAdapter.ViewHolder> {
    private ArrayList<ITunesItem> mDataset;
    private Context mContext;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView tumbnailImageView;
        public TextView trackNameTextView;
        public TextView trackshortDesTextView;
        public TextView trackPriceTextView;
        public TextView artistNameTextView;

        public ViewHolder(View view) {
            super(view);
            tumbnailImageView = (ImageView) view.findViewById(R.id.list_item_track_tumbnail);
            trackNameTextView = (TextView) view.findViewById(R.id.list_item_track_name);
            trackshortDesTextView = (TextView) view.findViewById(R.id.list_item_track_short_des);
            trackPriceTextView = (TextView) view.findViewById(R.id.list_item_track_price);
            artistNameTextView = (TextView) view.findViewById(R.id.list_item_artist_name);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ITunesAdapter(ArrayList<ITunesItem> myDataset, Context context) {
        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itunes_list_item_card_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ITunesItem item = mDataset.get(position);
        holder.trackNameTextView.setText(item.getTrackName());
        holder.trackshortDesTextView.setText(item.getShortDescription());
        holder.trackPriceTextView.setText(item.getTrackPrice());
        holder.artistNameTextView.setText(item.getArtistName());

        Picasso.with(mContext).load(item.getTrackImage()).into(holder.tumbnailImageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
