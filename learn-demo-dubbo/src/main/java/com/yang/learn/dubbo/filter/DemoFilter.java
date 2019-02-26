package com.yang.learn.dubbo.filter;


import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
@Activate(group = { Constants.PROVIDER })
public class DemoFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.err.println("call before");
        Result result = invoker.invoke(invocation);
        System.err.println("call after");
        return result;
    }
}
