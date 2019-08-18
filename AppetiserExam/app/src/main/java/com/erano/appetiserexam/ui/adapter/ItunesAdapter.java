package com.erano.appetiserexam.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erano.appetiserexam.R;
import com.erano.appetiserexam.viewmodel.ItunesData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eraño Payawal on 2019-08-18.
 * hunterxer31@gmail.com
 */
public class ItunesAdapter extends RecyclerView.Adapter<ItunesAdapter.ViewHolder> {

    private Context mContext;
    private List<ItunesData> mList;

    public ItunesAdapter(Context context) {
        this.mContext = context;
        mList = new ArrayList<>();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_view)
        CardView mCardView;

        @BindView(R.id.txt_title)
        TextView mTxtTrackName;

        @BindView(R.id.txt_genre)
        TextView mTxtGenre;

        @BindView(R.id.txt_price)
        TextView mTxtPrice;

        @BindView(R.id.image_thumbnail)
        ImageView mImageThumbnail;

        @BindView(R.id.txt_description)
        TextView mTxtDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_itunes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (mList != null) {
            ItunesData item = mList.get(i);
            if (item != null) {

                String trackName = item.getTrackName();
                String genre = item.getPrimaryGenreName();
                String price = String.valueOf(item.getCollectionPrice());
                String imageUrl = item.getArtworkUrl100();
                String description = item.getLongDescription();

                if (viewHolder.mTxtTrackName != null) {
                    if (!TextUtils.isEmpty(trackName)) {
                        viewHolder.mTxtTrackName.setText(trackName);
                    } else {
                        viewHolder.mTxtTrackName.setText("");
                    }
                }

                if (viewHolder.mTxtGenre != null) {
                    if (!TextUtils.isEmpty(genre)) {
                        viewHolder.mTxtGenre.setText(genre);
                    } else {
                        viewHolder.mTxtGenre.setText("");
                    }
                }

                if (viewHolder.mTxtPrice != null) {
                    if (!TextUtils.isEmpty(price)) {
                        price = "$" + price;
                        viewHolder.mTxtPrice.setText(price);
                    } else {
                        price = "$0.00";
                        viewHolder.mTxtPrice.setText(price);
                    }
                }

                if (!TextUtils.isEmpty(imageUrl) && viewHolder.mImageThumbnail != null) {
                    Picasso.get()
                            .load(imageUrl)
                            .placeholder(R.drawable.ic_placeholder)
                            .error(R.drawable.ic_placeholder_error)
                            .into(viewHolder.mImageThumbnail);
                }

                if (viewHolder.mTxtDescription != null) {
                    if (!TextUtils.isEmpty(description)) {
                        viewHolder.mTxtDescription.setText(description);
                        viewHolder.mTxtDescription.setVisibility(View.VISIBLE);
                    } else {
                        viewHolder.mTxtDescription.setVisibility(View.GONE);
                    }
                }

            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public void updateDataList(List<ItunesData> list) {
        if (mList != null) {
            this.mList = list;
            notifyDataSetChanged();
        }
    }

    public ItunesData getItemAtPosition(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }

}
