package com.example.shivani.loginapplication;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class GalleryAdapter extends
        RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private List<Gallery> list;

    public GalleryAdapter(List<Gallery> contactList) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder galleryViewHolder, int i) {
        Gallery ci = list.get(i);
        galleryViewHolder.title.setText(getItemCount());
     /*  // galleryViewHolder.setText(ci.surname);
        galleryViewHolder.description.setText(ci.email);
        galleryViewHolder.title.setText(ci.name + " " + ci.surname);*/
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.recycler_view_main, viewGroup, false);
        return new GalleryViewHolder(itemView);
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        protected ImageView thumbnail;
        protected ImageView fav;
        protected TextView description;
        protected TextView title;
        protected CardView cardView;

        public GalleryViewHolder(View view) {
            super(view);
            cardView=(CardView)view.findViewById(R.id.card);
            title = (TextView) view.findViewById(R.id.title);
            description = (TextView) view.findViewById(R.id.cardContent);
            thumbnail = (ImageView) view.findViewById(R.id.cardImage);
            fav = (ImageView) view.findViewById(R.id.favBtn);
        }
    }
    public class GalleryInfo {
        protected String gtitle;
        protected String gdescription;
        protected int gthumbnail;
        protected int gfav;
    }
}