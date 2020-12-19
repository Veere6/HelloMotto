package my.android.hellomotto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter2 extends RecyclerView.Adapter<MyRecyclerAdapter2.ViewHolder> {

    Integer[] image ={R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird,R.drawable.bird};
    String[] title={"Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30","Whiseper Napkin Ultra Clean Wings XL+30",};
    String[] rupee={"₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece","₹310 Per 1 Piece",};
    @NonNull
    @Override
    public MyRecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featuredproduct,parent,false);
        MyRecyclerAdapter2.ViewHolder viewHolder=new MyRecyclerAdapter2.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter2.ViewHolder holder, int position) {
        holder.imageView.setImageResource(image[position]);
        holder.textView1.setText(title[position]);
        holder.textView2.setText(rupee[position]);
    }


    @Override
    public int getItemCount() {
        return image.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2;
        Button btn;
        ViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView4);
            textView1=itemView.findViewById(R.id.productname);
            textView2=itemView.findViewById(R.id.rupee);
            btn=itemView.findViewById(R.id.button);
        }
    }
}
