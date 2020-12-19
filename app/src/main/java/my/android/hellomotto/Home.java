package my.android.hellomotto;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class Home extends Fragment {
     MyRecyclerViewAdapter2 adapter2;
     MyRecyclerAdapter madapter;
     MyRecyclerAdapter2 nadapter;
     MyRecyclerViewAdapter adapter;
          ScrollView scrollView;

          RecyclerView recyclerView1;



//     FrameLayout frameLayout;
     NavigationView navigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rvAnimals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

       recyclerView1=view.findViewById(R.id.recycler);
        recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 3));
        madapter = new MyRecyclerAdapter();
        recyclerView1.setAdapter(madapter);


        RecyclerView recyclerView2=view.findViewById(R.id.recycler2);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
        nadapter = new MyRecyclerAdapter2();
        recyclerView2.setAdapter(nadapter);

        RecyclerView recyclerView3 = view.findViewById(R.id.recycler3);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView3.setLayoutManager(linearLayoutManager2);
        adapter2 = new MyRecyclerViewAdapter2();
        recyclerView3.setAdapter(adapter2);
        scrollView=view.findViewById(R.id.rv_autoScroll);




        return view;
    }
}