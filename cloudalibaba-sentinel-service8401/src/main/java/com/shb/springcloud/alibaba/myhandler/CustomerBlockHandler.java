package com.shb.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.shb.springcloud.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global blockException----1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global blockException----2");
    }
}
