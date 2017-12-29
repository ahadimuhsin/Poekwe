package informatika.poekwe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Muhsin Ahadi on 12/4/2017.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;
    private List<Poekwe> my_data;

    public CustomAdapter(Context context, List<Poekwe> my_data) {
        this.context=context;
        this.my_data=my_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card,parent,false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) { //menampilkan data
        holder.nama.setText(my_data.get(position).getNama());
        holder.alamat.setText(my_data.get(position).getAlamat());
        Glide.with(context).load(my_data.get(position).getgambar()).into(holder.image);

    }

    @Override
    public int getItemCount() {

        return my_data.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView nama, alamat;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            nama = (TextView) itemView.findViewById(R.id.text_nama);
            alamat = (TextView) itemView.findViewById(R.id.text_alamat);
        }
    }
}
