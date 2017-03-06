package com.core.patterns.structure_patterns.composite;

/**
 * Created by vlad on 15.02.17.
 * <p>
 * Composite pattern
 */

abstract class Component {
    public abstract int calculate();
}

class Number extends Component {
    int value;

    public Number(int value) {
        this.value = value;
    }

    public int calculate() {
        return value;
    }
}

class OperationPlus extends Component {
    Component left;
    Component right;

    public OperationPlus(Component leftCompoennt, Component rightCompoment) {
        this.left = leftCompoennt;
        this.right = rightCompoment;
    }


    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}

class OperationMult extends Component {
    Component left;
    Component right;

    public OperationMult(Component leftCompoennt, Component rightCompoment) {
        this.left = leftCompoennt;
        this.right = rightCompoment;
    }


    @Override
    public int calculate() {
        return left.calculate() * right.calculate();
    }
}


//
class TreeFactory {
    static Component getCalculateTree() {
        Component plus1 = new OperationPlus(new Number(1), new Number(2));
        Component mult1 = new OperationMult(plus1, new Number(3));
        Component mult2 = new OperationMult(new Number(4), new Number(5));
        Component plus2= new OperationPlus(mult1,mult2);
        return plus2;
    }
}

public class Main {

    public static void main(String[] args) {
        Component c= TreeFactory.getCalculateTree();
        System.out.println(c.calculate());
    }

}
