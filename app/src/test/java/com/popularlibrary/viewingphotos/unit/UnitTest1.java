package com.popularlibrary.viewingphotos.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnitTest1 {
    private Test1 test1;

    @Before
    public void before() {
        test1 = new Test1();
    }

    @Test
    public void get_sum_correct() {
        int sum = test1.add(1,5);
        Assert.assertEquals(sum,6);
    }

    @Test
    public void get_sum_incorrect() {
        int sum = test1.add(1,5);
        Assert.assertNotEquals(sum,7);
    }

}
