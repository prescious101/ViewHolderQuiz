package sidespell.tech.viewholderquiz.fragments;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import sidespell.tech.viewholderquiz.DetailsActivity;
import sidespell.tech.viewholderquiz.MovieAdapter;
import sidespell.tech.viewholderquiz.MovieImage;
import sidespell.tech.viewholderquiz.R;

/**
 * A placeholder fragment containing a {@link android.widget.GridView}.
 */
public class GridViewFragment extends Fragment {


    private GridView mGridview;
    private MovieAdapter gridAdapter;



    public static GridViewFragment newInstance() {
        return new GridViewFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gridview, container, false);

        mGridview = (GridView) rootView.findViewById(R.id.gridView);
        gridAdapter = new MovieAdapter(getContext(),R.layout.fragment_gridview,getData());
        mGridview.setAdapter(gridAdapter);


        mGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                MovieImage item = (MovieImage) parent.getItemAtPosition(position);

                //Create intent
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());

                //Start details activity
                startActivity(intent);
            }
        });

        return rootView;
    }

//        return inflater.inflate(R.layout.fragment_gridview, container, false);




    private ArrayList<MovieImage> getData() {
        final ArrayList<MovieImage> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.MovieImage);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new MovieImage(bitmap, "Image#" + i));
        }
        return imageItems;
    }




}
