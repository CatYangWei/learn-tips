package com.yang.learn.base.reflect;

/**
 * @author coffezcat
 * @title: Child
 * @description: TODO
 * @date 2019/6/5 14:51
 */
public class Child extends Parent {
    String childName;
    String childAge;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildAge() {
        return childAge;
    }

    public void setChildAge(String childAge) {
        this.childAge = childAge;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childName='" + childName + '\'' +
                ", childAge=" + childAge +
                ", parentName='" + parentName + '\'' +
                ", parentAge=" + parentAge +
                '}';
    }
}
