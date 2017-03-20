package com.core.lection20.optional_type;

import java.util.Optional;

/**
 * Created by vlad on 17.03.17.
 * Optional is immutable (we dont have sets)
 */
class Test{
    public Integer s=1;
}
public class Main {
    public static void main(String[] args) throws Exception {
        Test test=new Test();
        test.s=100;

        Optional<Test> elem = Optional.ofNullable(test);
        test.s=-1;
        System.out.println(elem.get().s);

    }
}
