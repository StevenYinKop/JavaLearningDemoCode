package com.yinzifan.design_pattern._14_visitor;

public abstract class Visitor {
    public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
