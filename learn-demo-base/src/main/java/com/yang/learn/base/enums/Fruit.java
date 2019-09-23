package com.yang.learn.base.enums;

/**
 * @author coffezcat
 * @title: Fruit
 * @description: TODO
 * @date 2019/5/13 15:16
 */
public enum  Fruit implements Base{
    Apple(1);

    private Integer code;

    Fruit(Integer code){
        this.code =code;
    }
    @Override
    public Integer getCode() {
        return code;
    }
}
