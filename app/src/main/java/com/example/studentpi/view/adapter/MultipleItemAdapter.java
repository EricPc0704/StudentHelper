package com.example.studentpi.view.adapter;

import android.content.Context;
import android.widget.SimpleAdapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.studentpi.R;
import com.example.studentpi.model.Bean.MultipleItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;

public class MultipleItemAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {

    private Context context;
    private String[] iconName = {"数码电器", "潮流服饰", "今日爆款", "充值缴费", "电影票", "女朋友"};
    private int[] icon = {R.mipmap.digital, R.mipmap.cloth, R.mipmap.boom, R.mipmap.recharge, R.mipmap.movie,
            R.mipmap.girl
    };

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemAdapter(List<MultipleItem> data, Context context) {
        super(data);
        this.context = context;
        addItemType(MultipleItem.GRID, R.layout.grid_view);
        addItemType(MultipleItem.CARD,R.layout.card_view);
    }

    private List<Map<String, Object>> getDataList() {
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;

    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultipleItem item) {
        switch (helper.getItemViewType()) {
            case MultipleItem.GRID:
                String[] from = {"image", "text"};
                int[] to = {R.id.icon, R.id.text};
                helper.setAdapter(R.id.grid_view, new SimpleAdapter(context, getDataList(), R.layout.grid_item, from, to));
                break;

            case MultipleItem.CARD:

                break;
        }
    }
}
