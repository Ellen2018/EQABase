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
        testViewHolder.textView.setText(data);
        int p;
        if (position == 0) {
            p = -1;
        } else if (position == getDataList().size() - 1) {
            p = 1;
        } else {
            p = 0;
        }
        junFen(testViewHolder.rl, 20, 3.5f, p);
        switch (position) {
            case 0:
                testViewHolder.textView.setBackgroundColor(Color.RED);
                break;
            case 1:
                testViewHolder.textView.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                testViewHolder.textView.setBackgroundColor(Color.YELLOW);
                break;
        }
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
