package com.example.jiyin.utils.intefacestruct;

/**
 * 没有有参数  有返回值
 *
 */

public abstract class FunctionWithResultOnly<Result> extends function {

    public FunctionWithResultOnly(String functionName) {
        super(functionName);
    }

    public abstract Result function();

}
