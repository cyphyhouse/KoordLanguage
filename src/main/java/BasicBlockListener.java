public interface BasicBlockListener {

    void enterTrue(BasicBlock block);

    void exitTrue(BasicBlock block);

    void enterFalse(BasicBlock block);

    void exitFalse(BasicBlock block);

    void enterSingle(BasicBlock block);

    void exitSingle(BasicBlock block);


    void enterNode(BasicBlock block);

    void exitNode(BasicBlock block);


}
