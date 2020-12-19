package my.android.hellomotto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class TimingAdapter extends RecyclerView.Adapter<TimingAdapter.ViewHolder> {

    Integer[] img ={R.drawable.bird};
    String[] text3={"New year Offer 2021"};
    String[] text4={"Shop for INR 2000 rupee or get 1 Kg Super Free"};




    @Override
    public TimingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timing_offers,parent,false);
        TimingAdapter.ViewHolder viewHolder=new TimingAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(TimingAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(img[position]);
        holder.textView.setText(text3[position]);
        holder.textView2.setText(text4[position]);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return text3.length;
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView2;

        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgtime);
            textView=itemView.findViewById(R.id.text_timeoffer);
            textView2=itemView.findViewById(R.id.text_timeoffer2);
        }
    }
}