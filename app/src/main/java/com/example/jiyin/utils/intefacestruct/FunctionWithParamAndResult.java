package com.example.jiyin.utils.intefacestruct;

/**
 * 有返回值   有参数
 * @param <Result>
 * @param <Param>
 */

public abstract class FunctionWithParamAndResult<Result,Param> extends function {

    public FunctionWithParamAndResult(String functionName) {
        super(functionName);
    }

    public abstract Result function(Param param);

}
