package me.aurium.beetle.branch.block;

import java.util.List;

public class DelegatingBlockList implements BlockList{

    private final List<Block> blocks;

    public DelegatingBlockList(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public void addFirst(Block block) {
        blocks.add(0,block);
    }

    @Override
    public void addLast(Block block) {
        blocks.add(block);
    }

    @Override
    public void removeLast() {
        blocks.remove(blocks.size()-1);
    }

    @Override
    public Block getFirst() {
        return blocks.get(0);
    }

    @Override
    public Block getLast() {
        return blocks.get(blocks.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    @Override
    public int size() {
        return blocks.size();
    }

    @Override
    public List<Block> getBackingList() {
        return blocks;
    }
}
