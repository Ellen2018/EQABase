package com.ellen.eqabase;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ellen.baselibrary.eqa.adapter.recyclerview.BaseSingleRecyclerViewAdapter;
import com.ellen.baselibrary.eqa.adapter.recyclerview.BaseViewHolder;

import java.util.List;

public class BaseAdapter extends BaseSingleRecyclerViewAdapter<String, BaseAdapter.TestViewHolder> {


    public BaseAdapter(Context context, List<String> dataList) {
        super(context, dataList);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_text;
    }

    @Override
    protected TestViewHolder getNewViewHolder(View view) {
        return new TestViewHolder(view);
    }

    @Override
    protected void showData(TestViewHolder testViewHolder, String data, int position) {
        junFenMeasureWidth(testViewHolder.rl,20,4,  position);
        testViewHolder.textView.setText(data);
    }

    static class TestViewHolder extends BaseViewHolder {

        TextView textView;
        RelativeLayout rl;

        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = findViewById(R.id.tv);
            rl = findViewById(R.id.rl_test);
        }
    }

}
