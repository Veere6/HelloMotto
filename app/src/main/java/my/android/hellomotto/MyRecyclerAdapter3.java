package my.android.hellomotto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyRecyclerAdapter3 extends RecyclerView.Adapter<MyRecyclerAdapter3.ViewHolder> {

    Integer[] image ={R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,
            R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,
            R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,
            R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird};
    String[] title={"Beverages","Baby Care","Noodles","Sauce & Instant Food","Break Fast & dairy",
            "Biscuits", "Snacks & Chocolates", "House Hold Item","Personal Care", "Grocery & Staples",
            "Beverages","Beverages","Baby Care","Noodles","Sauce & Instant Food","Break Fast & dairy",
            "Biscuits", "Snacks & Chocolates", "House Hold Item","Personal Care", "Grocery & Staples","Beverages"};

    @NonNull
    @Override
    public MyRecyclerAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.productcard,parent,false);
        MyRecyclerAdapter3.ViewHolder viewHolder=new MyRecyclerAdapter3.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter3.ViewHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.textView.setText(title[position]);
    }


    @Override
    public int getItemCount() {
        return image.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textView;
        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.circulerimage);
            textView=itemView.findViewById(R.id.textname);
        }
    }
}

