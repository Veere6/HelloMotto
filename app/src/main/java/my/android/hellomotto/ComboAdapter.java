package my.android.hellomotto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ComboAdapter extends RecyclerView.Adapter<ComboAdapter.ViewHolder> {

    Integer[] img ={R.drawable.bird,R.drawable.bird,R.drawable.bird};
    String[] text1={"Family Combo Offers","Family Combo Offers","Family Combo Offers",};
    String[] text2={"Family Combo Offers","Family Combo Offers","Family Combo Offers",};




    @Override
    public ComboAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.combo_offers,parent,false);
        ComboAdapter.ViewHolder viewHolder=new ComboAdapter.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ComboAdapter.ViewHolder holder, int position) {

        holder.imageView.setImageResource(img[position]);
        holder.textView.setText(text1[position]);
        holder.textView2.setText(text2[position]);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return text1.length;
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,textView2;

        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgcombo);
            textView=itemView.findViewById(R.id.text_combo);
            textView2=itemView.findViewById(R.id.text2_combo);
        }
    }
}