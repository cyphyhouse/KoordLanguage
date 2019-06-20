/**
 * Listener for traversing a control flow graph.
 */
public interface BasicBlockListener {

    /**
     * Called when the traversal enters a true block.
     * @param block the block entered.
     */
    void enterTrue(BasicBlock block);

    /**
     * Called when the traversal exits a true block.
     * @param block the block exited.
     */
    void exitTrue(BasicBlock block);

    /**
     * Called when the traversal enters a false block.
     * @param block the block entered.
     */
    void enterFalse(BasicBlock block);

    /**
     * Called when the traversal exits a false block.
     * @param block the block exited.
     */
    void exitFalse(BasicBlock block);

    /**
     * Called when the traversal enters a merge block.
     * @param block the block entered.
     */
    void enterSingle(BasicBlock block);

    /**
     * Called when the traversal exits a merge block.
     * @param block the block exited.
     */
    void exitSingle(BasicBlock block);


    /**
     * Called when the traversal enters any block.
     * @param block the block entered.
     */
    void enterNode(BasicBlock block);

    /**
     * Called when the traversal exits any block.
     * @param block the block exited.
     */
    void exitNode(BasicBlock block);


}
