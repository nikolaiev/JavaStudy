package com.core.patterns.behavior_patterns.template_method;

/**
 * Created by vlad on 20.02.17.
 */

class Common{
    public void algorithm(){
        System.out.println("commonPart");
    }
}

class AlgorithmA extends Common{
    @Override
    public void algorithm(){
        super.algorithm();
        System.out.println("Algo A!");
    }
}

class AlgorithmB extends Common{
    @Override
    public void algorithm(){
        super.algorithm();
        System.out.println("Algo B!");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        Common c=new AlgorithmA();
        c.algorithm();
    }

}
