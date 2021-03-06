/**
 * Generated by Agitar build: JUnitFactory Version 2.1.2.000677 (Build date: Dec 21, 2007) [2.1.2.000677]
 * JDK Version: 1.5.0_11
 *
 * Generated on Jan 5, 2008 7:25:24 AM
 * Time to generate: 00:10.858 seconds
 *
 *
 *
 */

package org.gavaghan.geodesy;


import org.junit.Assert;
import org.junit.Test;

public class AngleAgitarTest {

    @Test
    public void testToDegrees() throws Throwable {
        double result = Angle.toDegrees(100.0);
        Assert.assertEquals("result", 5729.5779513082325, result, 1.0E-6);
    }

    @Test
    public void testToDegrees1() throws Throwable {
        double result = Angle.toDegrees(0.0);
        Assert.assertEquals("result", 0.0, result, 1.0E-6);
    }

    @Test
    public void testToRadians() throws Throwable {
        double result = Angle.toRadians(100.0);
        Assert.assertEquals("result", 1.7453292519943295, result, 1.0E-6);
    }

    @Test
    public void testToRadians1() throws Throwable {
        double result = Angle.toRadians(0.0);
        Assert.assertEquals("result", 0.0, result, 1.0E-6);
    }
}

