package com.example.jiyin.utils.intefacestruct;

/**
 * 有参数  没有返回值
 *
 */

public abstract class FunctionWithParamOnly<Param> extends function {

    public FunctionWithParamOnly(String functionName) {
        super(functionName);
    }

    public abstract void function(Param param);

}
