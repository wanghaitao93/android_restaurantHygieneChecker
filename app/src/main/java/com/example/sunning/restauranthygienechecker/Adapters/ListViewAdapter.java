package com.example.sunning.restauranthygienechecker.Adapters;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunning.restauranthygienechecker.Models.Establishment;
import com.example.sunning.restauranthygienechecker.R;

import java.util.List;


public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Establishment> establishmentList;

    public ListViewAdapter(Context context, List<Establishment> establishmentList) {
        this.mContext = context;
        this.establishmentList = establishmentList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return establishmentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        public ImageView imageView;
        public TextView tvTile, tvRating;
        public ImageView favouriteView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            final ViewHolder holder = new ViewHolder();


            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.imageView.setBackgroundColor(ContextCompat.getColor(holder.imageView.getContext(), R.color.imageBackground));

            if (establishmentList.get(position).getBusinessType().equals("Restaurant/Cafe/Canteen")) {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.restaurant_logo));
            } else if (establishmentList.get(position).getBusinessType().equals("Takeaway/sandwich shop")) {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.sandwich_logo));
            } else if (establishmentList.get(position).getBusinessType().equals("School/college/university")) {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.school_logo));
            } else if (establishmentList.get(position).getBusinessType().equals("Pub/bar/nightclub")) {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.bar_logo));
            } else if (establishmentList.get(position).getBusinessType().equals("Hospitals/Childcare/Caring Premises")) {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.hospital_logo));
            } else {
                holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.building_logo));
            }


            holder.tvTile = convertView.findViewById(R.id.tv_tile);
            holder.tvTile.setText(establishmentList.get(position).getBusinessName());

            holder.tvRating = convertView.findViewById(R.id.tv_rating);
            holder.tvRating.setText(establishmentList.get(position).getRatingValue());


            // favourite buttom
            holder.favouriteView = convertView.findViewById(R.id.favouriteButton);
            holder.favouriteView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(holder.favouriteView.getDrawable().getConstantState().equals(ContextCompat.getDrawable(mContext, R.drawable.heart_off).getConstantState()
                    )){
                        holder.favouriteView.setImageResource(R.drawable.heart_on);
                        Toast.makeText(mContext, "liked", Toast.LENGTH_SHORT).show();
                    }else{
                        holder.favouriteView.setImageResource(R.drawable.heart_off);
                        Toast.makeText(mContext, "not like", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            convertView.setTag(holder);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
