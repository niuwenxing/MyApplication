package com.example.jiyin.utils.intefacestruct;

/**
 * 没有参数   没有  返回值
 * abstract 为什么是抽象的呢    我们有个未实现的抽象体   所以我们没有定义实现的抽象体必须要定义成抽象的
 */

public abstract class FunctionNoParamNoResult extends function {

    public FunctionNoParamNoResult(String functionName) {
        super(functionName);
    }
    /**
     * 为什么是 void 呢     我们没有返回值
     */
    public abstract void function();


}
