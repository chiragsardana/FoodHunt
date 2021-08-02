package com.huawei.SBK_FoodHunt;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.huawei.SBK_FoodHunt.ResturantActivity.FARM_KEY;

public class ResturantRecyclerViewAdapter extends RecyclerView.Adapter<ResturantRecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "FarmRecyclerViewAdapter";

    private ArrayList<Resturant> resturants;
    private Context mContext;

    // data is passed into the constructor
    ResturantRecyclerViewAdapter(Context context, ArrayList<Resturant> resturants) {
        this.mContext = context;
        this.resturants = resturants;
    }

    // inflates the row layout from xml when needed, returns viewholder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_farm, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView and ImageView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.name.setText(resturants.get(position).getName());
        String ownerText = "by " + resturants.get(position).getOwner();
        holder.owner.setText(ownerText);
        Glide.with(mContext)
                .asBitmap()
                .load(resturants.get(position)
                .getImageUrl())
                .transform(new RoundedCornersTransformation(30, 0))
                .into(holder.farmImage);

        // on click see more
        holder.seeMoreButton.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, ResturantActivity.class);
            intent.putExtra(FARM_KEY, resturants.get(position).getId());
            mContext.startActivity(intent);
        });
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return resturants.size();
    }


    // stores and recycles views as they are scrolled off screen
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView farmImage;
        private TextView name;
        private TextView owner;
        private Button seeMoreButton;

        ViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            farmImage = itemView.findViewById(R.id.imageFarm);
            name = itemView.findViewById(R.id.name);
            owner = itemView.findViewById(R.id.owner);
            seeMoreButton = itemView.findViewById(R.id.seeMoreButton);
        }
    }


}
