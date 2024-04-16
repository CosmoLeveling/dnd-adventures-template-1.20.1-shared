package com.cosmo.dndadventures.races;

import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class CodecClass {

    private final int beansAmount;
    private final Item beanType;
    private final List<BlockPos> beanPositions;

    public CodecClass(int beansAmount, Item beanType, List<BlockPos> beanPositions, int beansAmount1, Item beanType1, List<BlockPos> beanPositions1) {

        this.beansAmount = beansAmount1;
        this.beanType = beanType1;
        this.beanPositions = beanPositions1;
    }

    public int getBeansAmount() { return this.beansAmount; }
    public Item getBeanType() { return this.beanType; }
    public List<BlockPos> getBeanPositions() { return this.beanPositions; }
}