package com.example.jiyin.utils.intefacestruct;

import android.text.TextUtils;

import java.util.HashMap;

/**
 * 接口管理类
 */

public class FunctionsManager {

    private static FunctionsManager mFunctionsManager;

    //创建容器
    private FunctionsManager() {
        mFunctionNoParamNoResult =new HashMap<>();
        mFunctionWithParamAndResult =new HashMap<>();
        mFunctionWithParamOnly =new HashMap<>();
        mFunctionWithResultOnly =new HashMap<>();

    }

    public static FunctionsManager getInstance(){

        if(mFunctionsManager==null){
            mFunctionsManager=new FunctionsManager();
        }
        return mFunctionsManager;
    }

    /**
     * 创建存储容器
     */
    private HashMap<String ,FunctionNoParamNoResult>    mFunctionNoParamNoResult;
    private HashMap<String ,FunctionWithParamAndResult> mFunctionWithParamAndResult;
    private HashMap<String ,FunctionWithParamOnly>      mFunctionWithParamOnly;
    private HashMap<String ,FunctionWithResultOnly>     mFunctionWithResultOnly;


    //容器添加
    public FunctionsManager addFunction(FunctionNoParamNoResult function){
        mFunctionNoParamNoResult.put(function.mFunctionName,function);
        //逆向回调
        return this;
    }
    /**
     * 没有返回值 * 没有参数
     * @param functionName 名字
     */
    public void invokeFunction(String functionName) {
        if(TextUtils.isEmpty(functionName)==true){
            return ;
        }
        if(mFunctionNoParamNoResult!=null){
            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(functionName);
            if(f!=null){
                f.function();
            }
            if(f==null){
                try {
                    throw new FunctionException("没有这个接口"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    //容器添加
    public FunctionsManager addFunction(FunctionWithResultOnly function){
        mFunctionWithResultOnly.put(function.mFunctionName,function);
        //逆向回调
        return this;
    }
    /**
     * 有返回值没有 参数
     * @param functionName  名字
     * @param mClass
     * @param <Result>
     * @return
     */
    public <Result> Result  invokeFunction(String functionName,Class<Result> mClass)   {
        if(TextUtils.isEmpty(functionName)==true){
            return null;
        }
        if(mFunctionWithResultOnly!=null){
            FunctionWithResultOnly  f = mFunctionWithResultOnly.get(functionName);
            if(f!=null){
                if(mClass != null){
                    return mClass.cast(f.function());
                }else{
                    return (Result) f.function();
                }
            }else{
                try {
                    throw new FunctionException("没有这个接口"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }



    //容器添加
    public FunctionsManager addFunction(FunctionWithParamOnly function){
        mFunctionWithParamOnly.put(function.mFunctionName,function);
        //逆向回调
        return this;
    }

    /**
     * 有参数  无返回值
     * @param functionName
     */
    public <Param> void  invokeFunction(String functionName,Param data)   {
        if(TextUtils.isEmpty(functionName)==true){
            return ;
        }
        if(mFunctionWithParamOnly!=null){
            FunctionWithParamOnly  f = mFunctionWithParamOnly.get(functionName);
            if(f!=null){
                f.function(data);
            }else{
                try {
                    throw new FunctionException("没有这个接口"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //容器添加
    public FunctionsManager addFunction(FunctionWithParamAndResult function){
        mFunctionWithParamAndResult.put(function.mFunctionName,function);
        //逆向回调
        return this;
    }

    public <Result,Param> Result invokeFunction(String functionName,Param data,Class<Result> mClass)   {
        if(TextUtils.isEmpty(functionName)==true){
            return null ;
        }
        if(mFunctionWithParamAndResult!=null){
            FunctionWithParamAndResult  f = mFunctionWithParamAndResult.get(functionName);
            if(f!=null){
                if(mClass!=null){
                    return mClass.cast(f.function(data));
                }else{
                    return (Result) f.function(data);
                }
            }else{
                try {
                    throw new FunctionException("没有这个接口"+functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return  null;
    }

}
