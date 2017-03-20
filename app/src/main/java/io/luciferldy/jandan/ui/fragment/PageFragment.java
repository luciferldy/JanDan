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

import java.util.ArrayList;

import io.luciferldy.jandan.R;
import io.luciferldy.jandan.model.BeautyModel;

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

    public static PageFragment newInstance() {
        PageFragment fragment = new PageFragment();
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
