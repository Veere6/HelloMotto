package my.android.hellomotto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Offers extends Fragment {

    ComboAdapter comboAdapter;
    TimingAdapter timingAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_offers, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        comboAdapter = new ComboAdapter();
        recyclerView.setAdapter(comboAdapter);

        RecyclerView recyclerView1=view.findViewById(R.id.recycler5);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager1);
        timingAdapter = new TimingAdapter();
        recyclerView1.setAdapter(timingAdapter);






        return view;
    }
}