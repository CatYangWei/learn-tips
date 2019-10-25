package com.yang.learn.base.datatype;

/**
 * @author coffezcat
 * @title: TestData
 * @description: TODO
 * @date 2019-10-15 13:17
 */
public class TestData {
    public String getValue() {
		 String value = "";
        try {
			value = "test1";
			return value;
        } catch (Exception e) {
		 e.printStackTrace();
        } finally {
            value = "test2";
            System.out.println(value);
        }
        System.out.println(1111);
		 return value;
    }

    public static void main(String[] args) {
        TestData testData = new TestData();
        String value = testData.getValue();
        System.out.println(value);
    }
}