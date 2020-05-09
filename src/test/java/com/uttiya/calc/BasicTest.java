package com.uttiya.calc;

import org.junit.Assert;
import org.junit.Test;

public class BasicTest {

    @Test
    public void testAdd(){

        Basic basic=new Basic();
        Assert.assertEquals(basic.add(55.3f, 28.9f),84.2f,0.01f);
        Assert.assertEquals(basic.add(19.62f, 20.12f),39.74f,0.01f);

    }

    @Test
    public void testSubstract(){

        Basic basic=new Basic();
        Assert.assertEquals(basic.subtract(55.3f, 28.9f),26.4f,0.01f);
        Assert.assertEquals(basic.subtract(19.62f, 20.12f),-0.5f,0.01f);

    }

    @Test
    public void testMultiply(){

        Basic basic=new Basic();
        Assert.assertEquals(basic.multiply(55.3f, 28.9f),1598.17f,0.01f);
        Assert.assertEquals(basic.multiply(19.62f, -20.12f),-394.7544f,0.01f);
        Assert.assertEquals(basic.multiply(-1.8f, 1.1f),-1.98f,0.01f);
        Assert.assertEquals(basic.multiply(-2.12f, -16.36f),34.6832f,0.01f);

    }

    @Test
    public void testDivide(){

        Basic basic=new Basic();
        Assert.assertEquals(basic.divide(55.3f, 28.9f),1.913f,0.01f);
        Assert.assertEquals(basic.divide(19.62f, -20.12f),-0.975f,0.01f);
        Assert.assertEquals(basic.divide(-1.8f, 1.1f),-1.636f,0.01f);
        Assert.assertEquals(basic.divide(-2.12f, -16.36f),0.12958f,0.01f);
        Assert.assertEquals(basic.divide(-2.12f, 0f),Float.POSITIVE_INFINITY,0.01f);

    }
}