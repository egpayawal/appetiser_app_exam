package com.erano.appetiserexam.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.erano.appetiserexam.AppetiserExamApplication;
import com.erano.appetiserexam.Impl.ItunesDetailActivityImpl;
import com.erano.appetiserexam.R;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ItunesDetailActivity extends AppCompatActivity implements ItunesDetailActivityImpl.View, View.OnClickListener {

    public Unbinder mUnBinder;

    @Inject
    ItunesDetailActivityImpl.Presenter mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.card_view)
    CardView mCardView;

    @BindView(R.id.txt_track_name)
    TextView mTxtTrackName;

    @BindView(R.id.txt_genre)
    TextView mTxtGenre;

    @BindView(R.id.txt_price)
    TextView mTxtPrice;

    @BindView(R.id.image_thumbnail)
    ImageView mImageThumbnail;

    @BindView(R.id.txt_description)
    TextView mTxtDescription;

    private String transitionName;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itunes_detail);
        mUnBinder = ButterKnife.bind(this);

        // Retrieve the correct Item instance, using the ID provided in the Intent
        if (getIntent().getExtras() != null) {
            transitionName = getIntent().getExtras().getString("transitionName");
            id = getIntent().getExtras().getString("Id");
        }

        if (mCardView != null) {
            ViewCompat.setTransitionName(mCardView, transitionName);
        }

        if (AppetiserExamApplication.getInstance().getAPIComponent() != null) {
            AppetiserExamApplication.getInstance()
                    .getAPIComponent()
                    .inject(this);
        }

        if (mPresenter != null) {
            mPresenter.setView(this);
            mPresenter.initViews();
            mPresenter.loadData();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.saveLastScreen();
        }
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn_close) {
            supportFinishAfterTransition();
        }
    }

    @Override
    public void setupToolbar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        if (mToolbar != null) {
            mToolbar.setBackgroundColor(getColor(R.color.colorPrimaryDark));
            TextView txtTitle = (TextView) mToolbar.findViewById(R.id.txt_title);
            ImageView btnClose = (ImageView) mToolbar.findViewById(R.id.btn_close);
            btnClose.setVisibility(View.VISIBLE);
            txtTitle.setVisibility(View.GONE);
            btnClose.setOnClickListener(this);
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setTrackName(String trackName) {
        if (mTxtTrackName != null) {
            mTxtTrackName.setText(trackName);
        }
    }

    @Override
    public void setGenre(String genre) {
        if (mTxtGenre != null) {
            mTxtGenre.setText(genre);
        }
    }

    @Override
    public void setPrice(String price) {
        if (mTxtPrice != null) {
            mTxtPrice.setText(price);
        }
    }

    @Override
    public void setThumbnail(String imageUrl) {
        if (mImageThumbnail != null) {
            Picasso.get()
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_placeholder_error)
                    .into(mImageThumbnail);
        }
    }

    @Override
    public void setDescription(String description) {
        if (mTxtDescription != null) {
            mTxtDescription.setText(description);
        }
    }
}
