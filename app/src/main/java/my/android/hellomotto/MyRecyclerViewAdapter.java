package my.android.hellomotto;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    Integer[] img ={R.drawable.bird,R.drawable.bird,R.drawable.bird};



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        MyRecyclerViewAdapter.ViewHolder viewHolder=new MyRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.imageView.setImageResource(img[position]);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return img.length;
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
      ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView3);



        }
    }
}
