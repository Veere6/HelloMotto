package my.android.hellomotto;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Dashboard extends Fragment {

    MyRecyclerAdapter3 adapter3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dashboard, container, false);


        RecyclerView recyclerView4=view.findViewById(R.id.recyclersub);
        recyclerView4.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapter3 = new MyRecyclerAdapter3();
        recyclerView4.setAdapter(adapter3);


   return view;
    }
}