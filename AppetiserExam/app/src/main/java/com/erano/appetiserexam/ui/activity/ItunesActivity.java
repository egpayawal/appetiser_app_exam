package com.erano.appetiserexam.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.erano.appetiserexam.AppetiserExamApplication;
import com.erano.appetiserexam.Impl.ItunesActivityImpl;
import com.erano.appetiserexam.R;
import com.erano.appetiserexam.ui.RecyclerItemClickListener;
import com.erano.appetiserexam.ui.adapter.ItunesAdapter;
import com.erano.appetiserexam.viewmodel.ItunesData;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ItunesActivity extends AppCompatActivity implements ItunesActivityImpl.View, SwipeRefreshLayout.OnRefreshListener {

    public Unbinder mUnBinder;

    @Inject
    ItunesActivityImpl.Presenter mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.txt_empty_state)
    TextView mTxtEmptyState;

    ItunesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnBinder = ButterKnife.bind(this);

        if (AppetiserExamApplication.getInstance().getAPIComponent() != null) {
            AppetiserExamApplication.getInstance()
                    .getAPIComponent()
                    .inject(this);
        }

        if (mPresenter != null) {
            mPresenter.setView(this);
            mPresenter.initViews();
            mPresenter.rxUISubscribe();
            mPresenter.checkLastScreen();
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
        if (mPresenter != null) {
            mPresenter.setEmptyLastScreen();
        }

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.rxUnsubscribe();
        }
        super.onDestroy();
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
            TextView txtTitle = (TextView) mToolbar.findViewById(R.id.txt_title);
            ImageView btnClose = (ImageView) mToolbar.findViewById(R.id.btn_close);
            btnClose.setVisibility(View.GONE);
        }
    }

    @Override
    public void setupAdapter() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ItunesAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, (view, position) -> {
            if (position != -1 && mAdapter != null) {
                ItunesData item = mAdapter.getItemAtPosition(position);
                if (item != null) {

                    String transitionName = getString(R.string.transition_string);
                    Intent intent = new Intent(this, ItunesDetailActivity.class);
                    intent.putExtra("transitionName", transitionName);
                    intent.putExtra("Id", item.getReleaseDate());

                    // create the transition animation - the views in the layouts
                    // of both activities are defined
                    ActivityOptionsCompat activityOptions =

                            ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                                    view,   // Starting view
                                    transitionName    // The String
                            );

                    // Now we can start the Activity, providing the activity options as a bundle
                    ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
                }
            }
        }));
    }

    @Override
    public void setupPullToRefresh() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setOnRefreshListener(this);
            mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            mSwipeRefreshLayout.canChildScrollUp();
        }
    }

    @Override
    public void updateAdapter(List<ItunesData> list) {
        if (mAdapter != null) {
            mAdapter.updateDataList(list);
        }
    }

    @Override
    public void onRefresh() {
        if (mPresenter != null) {
            mPresenter.loadData();
        }
    }

    @Override
    public void showSwipeToRefreshAnim() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(true);
                }
            });
        }
    }

    @Override
    public void cancelShowToRefreshAnim() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }

    @Override
    public void showEmptyState(boolean isVisible) {
        if (mTxtEmptyState != null) {
            mTxtEmptyState.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDetailScreen(String releaseDate) {
        String transitionName = getString(R.string.transition_string);
        Intent intent = new Intent(this, ItunesDetailActivity.class);
        intent.putExtra("transitionName", transitionName);
        intent.putExtra("Id", releaseDate);
        startActivity(intent);
    }
}
