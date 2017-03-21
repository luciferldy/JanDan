package io.luciferldy.jandan.ui.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;

import io.luciferldy.jandan.R;
import io.luciferldy.jandan.api.JanDanService;
import io.luciferldy.jandan.model.BeautyModel;
import io.luciferldy.jandan.ui.activity.MainActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Lucifer on 2017/3/18.
 */

public class PageFragment extends Fragment {

    private ArrayList<BeautyModel> beauties;

    public PageFragment() {
        super();
        beauties = new ArrayList<>();
        // init data
        for (int i = 0; i < 7; i++) {
            BeautyModel beauty = new BeautyModel();
            beauty.title = "蛋友们，wannan";
            beauty.summary = "这是一个妹纸";
            beauty.editor = "XiaoJan";
            beauty.comment = "吐槽 4";
            beauty.oo = "OO  12";
            beauty.xx = "XX  23";
            beauty.timeStamp = "12分钟前";
            beauty.imageUrl = "http://wx4.sinaimg.cn/mw600/005vbOHfgy1fdr9n4mh0vj30ei0q6q49.jpg";

            beauties.add(beauty);
        }
    }

    public static PageFragment newInstance(String category) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putString(MainActivity.CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_page, container, false);
        RecyclerView rv = (RecyclerView) root.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRvAdapter());
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(MainActivity.BASE_URL)
                .build();
        JanDanService service = retrofit.create(JanDanService.class);
        Bundle bundle = getArguments();
        String category = bundle.getString(MainActivity.CATEGORY, MainActivity.NEWS);
        if (category.equals(MainActivity.NEWS)) {
            Call<ResponseBody> call = service.getNews("");
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // convert sth
                    try {
                        String result = response.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
        if (category.equals(MainActivity.INTERESTING)) {
            Call<ResponseBody> call = service.getInteresting("");
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // convert sth

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
        if (category.equals(MainActivity.BEAUTY)) {
            Call<ResponseBody> call = service.getOOXX("");
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // convert sth

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
        if (category.equals(MainActivity.JOKE)) {
            Call<ResponseBody> call = service.getJoke("");
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    // convert sth

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }
    }

    class SimpleRvAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_ooxx, parent, false);
            return new SimpleViewHolder(viewDataBinding);
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            ViewDataBinding viewDataBinding = holder.getViewDataBinding();
            viewDataBinding.setVariable(io.luciferldy.jandan.BR.beauty, beauties.get(position));
            viewDataBinding.executePendingBindings();

        }

        @Override
        public int getItemCount() {
            return beauties.size();
        }
    }

    static class SimpleViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding mViewDataBinding;

        public SimpleViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            mViewDataBinding = binding;
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }
}
