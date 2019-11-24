package com.example.studentpi.model.Bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultipleItem implements MultiItemEntity {
    public static final int GRID = 1;
    public static final int CARD = 2;

    private Commodity commodity;
    private int itemType;

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public MultipleItem(int itemType) {
        this.itemType = itemType;
    }
    public MultipleItem(int itemType,Commodity commodity) {
        this.itemType = itemType;
        this.commodity=commodity;
    }
    @Override
    public int getItemType() {
        return itemType;
    }



}
