package wim.example.com.androidgridlayout.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wim.example.com.androidgridlayout.R;
import wim.example.com.androidgridlayout.adapter.SingleListAdapter;
import wim.example.com.androidgridlayout.model.Single;
import wim.example.com.androidgridlayout.widgets.GridMarginDecoration;

/**
 * Created by docotel on 4/14/16.
 */
public class FragmentSingle extends Fragment implements SingleListAdapter.OnGridItemSelectedListener{

    private RecyclerView lvSingle;
    private GridLayoutManager gridLayoutManager;
    private SingleListAdapter singleListAdapter;

    private Context context;

    public static FragmentSingle newInstance() {
        return new FragmentSingle();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single, container, false);

        lvSingle = (RecyclerView) rootView.findViewById(R.id.lvSingle);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        singleListAdapter = new SingleListAdapter(this);
        gridLayoutManager = new GridLayoutManager(context, 2);

        lvSingle.setLayoutManager(gridLayoutManager);
        lvSingle.addItemDecoration(new GridMarginDecoration(context, 2, 2, 2, 2));
        lvSingle.setAdapter(singleListAdapter);

        loadData();
    }

    private void loadData(){
        List<Single> singleList = new ArrayList<>();
        Single single;

        int img[] = {R.drawable.akb48_43rd_single_kimi_wa_melody, R.drawable.akb48_42nd_single_kuchibiru_ni_be_my_baby,
                    R.drawable.akb48_41st_single_halloween_night, R.drawable.akb48_40th_single_bokutachi_wa_tatakawanai,
                    R.drawable.akb48_39th_single_green_flash, R.drawable.akb48_38th_single_kibouteki_refrain,
                    R.drawable.akb48_37th_single_kokoro_no_placard, R.drawable.akb48_36th_single_labrador_retriever};

        String title[] = {"AKB48 43rd Single - Kimi wa Melody", "AKB48 42nd Single - Kuchibiru ni Be My Baby",
                        "AKB48 41st Single - Halloween Night", "AKB48 40th Single - Bokutachi wa Tatakawanai",
                        "AKB48 39th Single - Green Flash", "AKB48 38th Single - Kibouteki Refrain",
                        "AKB48 37th Single - Kokoro no Placard", "AKB48 36th Single - Labrador Retriever"};

        for (int i = 0; i < img.length; i++){
            single = new Single();

            single.setImg(img[i]);
            single.setTitle(title[i]);

            singleList.add(single);
        }

        singleListAdapter.addAll(singleList);
    }

    @Override
    public void onGridItemClick(View v, int position) {
        Toast.makeText(context, singleListAdapter.getItem(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
