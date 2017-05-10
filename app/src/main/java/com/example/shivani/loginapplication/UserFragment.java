package com.example.shivani.loginapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;


public class UserFragment extends Fragment {
    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    Gallery a;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //  prepareGallery();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        adapter = new GalleryAdapter(getImageList());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
       // LinearLayoutManager llm = new LinearLayoutManager(getActivity());
       // recyclerView.setLayoutManager(llm);
       /* try {
            Glide.with(this).load(R.drawable.background).into((ImageView) rootView.findViewById(R.id.cardImage));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        

       
       /* final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout)rootView.findViewById(R.id.collapsing_layout);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout)rootView.findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });*/
        return rootView;
    }
    private ArrayList<Gallery> getImageList() {
        int[] images= new int[]{
                R.drawable.wallthree,
                R.drawable.walltwo,
                R.drawable.wallone,
                R.drawable.wallthree,
                R.drawable.walltwo,
                R.drawable.wallone,
                R.drawable.wallthree,
                R.drawable.walltwo,
                R.drawable.wallone};
        ArrayList<Gallery> imageList=new ArrayList<>();
        a = new Gallery("Assam","Situated in the northeast part of India," +
                " Assam is one of the country's best holiday destinations." +
                " the state of West Bengal and international border with Bhutan and Bangladesh. The capital of the state is Dispur.", images[0]);
        imageList.add(a);

        a = new Gallery("Ladakh","Ladakh is a part of the Indian state of Jammu and Kashmir." +
                " Ladakh consists of two districts - Leh and Kargil.", images[1]);
        imageList.add(a);

        a = new Gallery("Sikkim","Sikkim is the second smallest state of India. This landlocked state is least populated and has Gangtok as its capital." +
                " The world's third highest peak, Kanchenjunga, is located here", images[2]);
        imageList.add(a);

        a = new Gallery("Assam","", images[3]);
        imageList.add(a);

        a = new Gallery("Ladakh","", images[4]);
        imageList.add(a);

        a = new Gallery("Sikkim", "", images[5]);
        imageList.add(a);

        a = new Gallery("Assam","", images[6]);
        imageList.add(a);

        a = new Gallery("Ladakh","", images[7]);
        imageList.add(a);

        a = new Gallery("Sikkim","", images[8]);
        imageList.add(a);
      //  adapter.notifyDataSetChanged();
        return imageList;
    }

    // Inflate the layout for this fragment
       

    }

       




