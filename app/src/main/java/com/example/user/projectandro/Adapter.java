package com.example.tcc.cardlistiudesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context mContext;
    List<item> ndata;

    public Adapter(Context mContext, List<item> ndata) {
        this.mContext = mContext;
        this.ndata = ndata;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        View v=inflater.inflate(R.layout.card_item,parent,false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.background_img.setImageResource(ndata.get(position).getBackground());
        holder.profile_photo.setImageResource(ndata.get(position).getProfilephoto());
        holder.tv_title.setText(ndata.get(position).getProfilename());
        holder.tv_nbfollower.setText(ndata.get(position).getNbfollowers()+" Followers");

    }

    @Override
    public int getItemCount() {
        return ndata.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        ImageView profile_photo,background_img;
        TextView tv_title,tv_nbfollower;
        public myViewHolder(View itemView){
            super (itemView);
            profile_photo=itemView.findViewById(R.id.profileimg);
            background_img=itemView.findViewById(R.id.cardbackground);
            tv_title=itemView.findViewById(R.id.title);
            tv_nbfollower=itemView.findViewById(R.id.nbfollower);
        }
    }
}
