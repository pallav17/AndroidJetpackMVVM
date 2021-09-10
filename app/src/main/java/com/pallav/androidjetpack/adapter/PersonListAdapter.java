package com.pallav.androidjetpack.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.pallav.androidjetpack.R;
import com.pallav.androidjetpack.model.PersonModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonListAdapter  extends RecyclerView.Adapter<PersonListAdapter.MyViewHolder> {
    private Context context;
    private List<PersonModel> personlist;
    public PersonListAdapter( Context context,List<PersonModel> personlist) {
            this.context = context;
            this.personlist = personlist;
    }

    public void setPersonlist(List<PersonModel> personlist)
    {
        this.personlist = personlist;
        notifyDataSetChanged();

    }
    @NonNull
    @NotNull
    @Override
    public PersonListAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull @NotNull PersonListAdapter.MyViewHolder holder, int position) {
            holder.tvTitle.setText(this.personlist.get(position).getFirstname().toString());
        Glide.with(context)
                .load(this.personlist.get(position).getPicture())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(this.personlist != null)
        {
            return this.personlist.size();
        }
        return 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvTitle;
                    ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView)itemView.findViewById(R.id.titleView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);

        }

    }
}
