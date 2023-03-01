/**
 *
 */
package org.jfree.data.range.test;

import static org.junit.Assert.*;
import org.jmock.Expectations;
import org.jmock.Mockery;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Thevin Mahawatte
 *
 */
public class RangeTest  {

    private class RangeTestClass extends Range {
        public RangeTestClass(double lower, double upper) {
            super(lower, upper);
        }
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }


    @Test // combine()
    public void testCombineWithBothRangesNull() {
        Range range1 = null;
        Range range2 = null;
        Range result = Range.combine( range1, range2);
        assertNull("We are combining two null ranges. Result should be null.", result);
    }

    @Test // combine()
    public void testCombineWithRange1Null() {
        Range range1 = null;
        Range range2 = new Range(0, 10);
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range2, result);
    }

    @Test // combine()
    public void testCombineWithRange2Null() {
        Range range1 = new Range(0, 10);
        Range range2 = null;
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining one null range and one non-null one. Result should be 0-10",range1, result);
    }

    @Test // combine()
    public void testCombineWithBothRangesNotNull() {
        Range range1 = new Range(0, 5);
        Range range2 = new Range(5, 10);
        Range expectedResult = new Range(0, 10);
        Range result = Range.combine(range1, range2);
        assertEquals("We are combining two non-null ranges. Result should be 0-10", expectedResult, result);
    }

    @Test // constrain()
    public void constrainTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertEquals("Expected output is equal to the input since 0.1 falls within the defined range.",0.1,exampleRange.constrain(0.1), .000000001d);
    }

    @Test // contains()
    public void containsTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertTrue("Expected output is True as 0.1 falls within the defined range.", exampleRange.contains(0.1));
    }


    @Test // equals()
    public void testEquals_withEqualObjects_returnsTrue() {
        java.lang.Object obj1 = new Object();
        java.lang.Object obj2 = new Object();
        assertTrue("The two object are equal, so we should receive True here.", obj1.equals(obj2));
    }

    @Test // equals()
    public void testEquals_withNonEqualObjects_returnsFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse("The two object aren't equal, so we should receive False here.", obj1.equals(obj2));
    }

    @Test // equals()
    public void testEquals_withNullObject_returnsFalse() {
        Object obj = new Object();
        assertFalse("We are comparing an object with null, so expectation is false", obj.equals(null));
    }

    @Test //expand()
    public void testExpandWithValidInputs1() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion", 1, expandedRange.getLowerBound(), .000000001d);
    }

    @Test //expand()
    public void testExpandWithValidInputs2() {
        Range range = new Range(2, 6);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        assertEquals("The current range is 2-6, and expanded range should be 1-8. Here we are testing the correctness of the lower bound after expansion.", 8, expandedRange.getUpperBound(), .000000001d);
    }

    @Test //expandToInclude()
    public void testExpandToInclude() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expandToInclude(range, 12);
        assertTrue("Number 13 should be in the range now.", range.contains(12));
    }

    @Test // getCentralValue()
    public void testGetCentralValue()
    {
        Range exampleRange;
        exampleRange = new Range(-2, 2);
        double actual = exampleRange.getCentralValue();
        assertEquals("The expected central value is 0",0,actual, .000000001d);
    }

    @Test // getLength()
    public void getLengthTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertEquals("The expected length between lower-bound and upper-bound is 6",6,exampleRange.getLength(), .000000001d);
    }

    @Test // getLowerBound()
    public void getUpperBoundTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertEquals("The expected upper bound of the range is 4",4,exampleRange.getLowerBound(), .000000001d);
    }

    @Test // getUpperBound()
    public void getLowerBoundTest() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertEquals("The expected lower bound of the range is -2",-2,exampleRange.getUpperBound(), .000000001d);
    }

    @Test // hashCode()
    public void testRangeHashCode()
    {
        int returnHashCode = hashCode();
        assertEquals("HashCode for the range -2, 4 should be 1", 1, returnHashCode);
    }

    @Test // intersect()
    public void testRangeIntersect() {
        Range exampleRange;
        exampleRange = new Range(-2, 4);
        assertTrue("The intersection between (-2, 4) and (3, 10) should be true.", exampleRange.intersects(3, 10));
    }


    @Test // shift() - Zero Crossing is not alowed
    public void testShiftNotAllowZeroCrossingLowerBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 2.1;
        Range returnRange = Range.shift(base, delta);
        assertEquals("Lower bound of range after shifted from -5.0 by 2.1 to the right should -2.9", returnRange.getLowerBound(), base.getLowerBound(), .000000001d);
    }

    @Test  // shift() - Zero Crossing is not alowed
    public void testShiftNotAllowZeroCrossingUpperBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 2.1;
        Range returnRange = Range.shift(base, delta);
        assertEquals("Upper bound of range after shifted from 5.0 by 2.1 to the right should 7.1", returnRange.getUpperBound(), base.getUpperBound(), .000000001d);
    }

    @Test  // shift() - Zero Crossing is alowed
    public void testShiftAllowZeroCrossingLowerBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 5.1;
        boolean allowZeroCrossing = true;
        Range returnRange = Range.shift(base, delta, allowZeroCrossing);
        assertEquals("Lower bound of range after shifted from -5.0 by 2.1 to the right should 0.1", returnRange.getLowerBound(), base.getLowerBound(), .000000001d);
    }

    @Test  // shift() - Zero Crossing is alowed
    public void testShiftAllowZeroCrossingUpperBound()
    {
        Range base;
        base = new Range(-5.0, 5.0);
        double delta = 5.1;
        boolean allowZeroCrossing = true;
        Range returnRange = Range.shift(base, delta, allowZeroCrossing);
        assertEquals("Upper bound of range after shifted from 5.0 by 2.1 to the right should 10.1", returnRange.getUpperBound(), base.getUpperBound(), .000000001d);
    }

    @Test // toString()
    public void testRangeToString()
    {
        Range exampleRange;
        exampleRange = new Range(-2.0, 3.0);
        String rangeString = "Range[-2.0,3.0]";
        assertEquals("Range using toString function should be Range[-2.0,3.0]", rangeString, exampleRange.toString());
    }
}
