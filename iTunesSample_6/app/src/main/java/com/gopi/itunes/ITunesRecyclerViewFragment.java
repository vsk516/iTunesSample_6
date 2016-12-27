package com.gopi.itunes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 *
 */

public class ITunesRecyclerViewFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ITunesItem> iTunesItemList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.itunes_list_main_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.itunes_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ITunesAdapter(iTunesItemList,getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                // TODO Handle item click
                //Toast.makeText(getActivity(),"Item Clicked...", Toast.LENGTH_SHORT).show();
                ITuneDetailsFragment iTuneDetailsFragment = new ITuneDetailsFragment();
                iTuneDetailsFragment.setData(iTunesItemList.get(position));
                getActivity().getFragmentManager().beginTransaction().replace(R.id.container,iTuneDetailsFragment ).addToBackStack(null).commit();
            }
        }));
        return view;
    }

    public void setData(ArrayList<ITunesItem> iTunesItemList)
    {
        this.iTunesItemList = iTunesItemList;
    }
}