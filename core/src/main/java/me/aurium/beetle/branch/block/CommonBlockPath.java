package me.aurium.beetle.branch.block;

import java.util.LinkedList;
import java.util.List;

public class CommonBlockPath implements BlockPath {

    public final static String COMMON_SPLITTER = "-";

    private final BlockPath root;
    private final BlockPath parent;
    private final LinkedList<Block> blocks;
    private final boolean isSevered;
    private final String splitter;

    public CommonBlockPath(BlockPath root, BlockPath parent, LinkedList<Block> blocks, boolean isSevered, String splitter) {
        this.root = root;
        this.parent = parent;
        this.blocks = blocks;
        this.isSevered = isSevered;
        this.splitter = splitter;
    }

    public CommonBlockPath(LinkedList<Block> list, boolean isSevered, String splitter) {
        this.root = this;
        this.parent = this;
        this.blocks = list;
        this.isSevered = isSevered;
        this.splitter = splitter;
    }

    public CommonBlockPath(String splitter) {
        this.root = this;
        this.parent = this;
        this.blocks = new LinkedList<>();
        this.isSevered = true;
        this.splitter = splitter;
    }

    @Override
    public boolean isEmpty() {
        return blocks.isEmpty();
    }

    @Override
    public boolean isSevered() {
        return isSevered;
    }

    @Override
    public boolean endsWith(Block path) {
        return blocks.getLast().equals(path);
    }

    @Override
    public boolean startsWith(Block path) {
        return blocks.getFirst().equals(path);
    }

    @Override
    public BlockPath getRoot() {
        return root;
    }

    @Override
    public BlockPath getParent() {
        return parent;
    }

    @Override
    public BlockPath resolve(BlockPath path) {

        LinkedList<Block> pathBlocks = this.blocks;

        for (Block block : path.getAllBlocks()) {
            block.addLast(pathBlocks);
        }

        return new CommonBlockPath(root,this,pathBlocks,pathBlocks.size() > 1,this.splitter);
    }

    @Override
    public BlockPath resolve(Block block) {

        LinkedList<Block> pathBlocks = this.blocks;

        block.addLast(pathBlocks);

        return new CommonBlockPath(root,this,pathBlocks,pathBlocks.size() > 1,this.splitter);
    }

    @Override
    public BlockPath withoutBase() {
        return fromIndex(0);
    }

    @Override
    public BlockPath fromIndex(int index) {
        LinkedList<Block> clone = new LinkedList<>(blocks.subList(index, blocks.size()));

        return new CommonBlockPath(clone.get(0).asSingleBlockpath(),this.parent,clone,clone.size() > 1,splitter);
    }

    @Override
    public int length() {
        return blocks.size();
    }

    @Override
    public List<Block> getAllBlocks() {
        return this.blocks;
    }

    @Override
    public String toString() {

        StringBuilder base = new StringBuilder();

        for (Block block : this.blocks) {
            base.append('{').append(block.getIdentifier()).append('}');
        }


        //TODO: fix this:
        return base.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonBlockPath that = (CommonBlockPath) o;
        return blocks.equals(that.blocks);
    }

    @Override
    public int hashCode() {
        return blocks.hashCode();
    }

    public static BlockPath ofEmpty() {
        return new CommonBlockPath(COMMON_SPLITTER);
    }

    public static BlockPath of(String string, String splitter) {
        String[] subparts = string.split(splitter);

        return of(subparts,splitter);
    }

    public static BlockPath of(String[] commandArguments, String splitter) {
        LinkedList<Block> blocklist = new LinkedList<>();

        for (String s : commandArguments) {
            blocklist.addLast(StringBlock.of(s));
        }

        return new CommonBlockPath(blocklist,commandArguments.length > 1,splitter);
    }

    public static BlockPath of(Block block, String splitter) {
        LinkedList<Block> send = new LinkedList<>();
        send.addLast(block);
        return new CommonBlockPath(send,true,splitter);
    }

    public static BlockPath of(String string) {
        return of(string,COMMON_SPLITTER);
    }

    public static BlockPath of(String[] commandArguments) {
        return of(commandArguments,COMMON_SPLITTER);
    }

    public static BlockPath of(Block block) {
        return of(block,COMMON_SPLITTER);
    }
}
