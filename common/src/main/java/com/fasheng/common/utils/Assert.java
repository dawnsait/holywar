package com.fasheng.common.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Comprehensive Assert API, for extensible ,you can use inheritance machanism,
 * naming your class as Assert2 or AssertUtils and so on.
 * 
 * <pre>
 * notice: I strongly recommend the isTrue method,very versatile.
 * </pre>
 * 
 * @author vongosling
 */
public abstract class Assert {
    /**
     * Assert that an object is <code>null</code> .
     * 
     * <pre class="code">
     * Assert.isNull(value, &quot;The value must be null&quot;);
     * </pre>
     * 
     * @param object the object to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is not <code>null</code>
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that an object is <code>null</code> .
     * 
     * <pre class="code">
     * Assert.isNull(value);
     * </pre>
     * 
     * @param object the object to check
     * @throws IllegalArgumentException if the object is not <code>null</code>
     */
    public static void isNull(Object object) {
        isNull(object, "the argument must be null");
    }

    /**
     * Assert that an object is not <code>null</code> .
     * 
     * <pre class="code">
     * Assert.notNull(clazz, &quot;The class must not be null&quot;);
     * </pre>
     * 
     * @param object the object to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object is <code>null</code>
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that an object is not <code>null</code> .
     * 
     * <pre class="code">
     * Assert.notNull(clazz);
     * </pre>
     * 
     * @param object the object to check
     * @throws IllegalArgumentException if the object is <code>null</code>
     */
    public static void notNull(Object object) {
        notNull(object, "this argument is required; it must not be null");
    }

    /**
     * Assert that the given String is not empty; that is, it must not be
     * <code>null</code> and not the empty String.
     * 
     * <pre class="code">
     * Assert.hasLength(name, &quot;Name must not be empty&quot;);
     * </pre>
     * 
     * @param text the String to check
     * @param message the exception message to use if the assertion fails
     */
    public static void hasLength(String text, String message) {
        if (text == null || "".equals(text.trim())) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that the given String is not empty; that is, it must not be
     * <code>null</code> and not the empty String.
     * 
     * <pre class="code">
     * Assert.hasLength(name);
     * </pre>
     * 
     * @param text the String to check
     */
    public static void hasLength(String text) {
        hasLength(text, "this String argument must have length; it must not be null or empty");
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * <code>null</code> and must have at least one element.
     * 
     * <pre class="code">
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     * 
     * @param collection the collection to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the collection is <code>null</code>
     *             or has no elements
     */
    public static <T> void notEmpty(Collection<T> collection, String message) {
        if (collection == null || collection.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a collection has elements; that is, it must not be
     * <code>null</code> and must have at least one element.
     * 
     * <pre class="code">
     * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
     * </pre>
     * 
     * @param collection the collection to check
     * @throws IllegalArgumentException if the collection is <code>null</code>
     *             or has no elements
     */
    public static <T> void notEmpty(Collection<T> collection) {
        notEmpty(collection,
                "this collection must not be empty: it must contain at least 1 element");
    }

    /**
     * Assert that a map has elements; that is, it must not be <code>null</code>
     * and must have at least one element.
     * 
     * <pre class="code">
     * Assert.notEmpty(map, &quot;Map must have elements&quot;);
     * </pre>
     * 
     * @param map the Map to check
     * @return whether the given Map is empty
     * @throws IllegalArgumentException if the map is <code>null</code> or has
     *             no elements
     */
    public static <T, K> void notEmpty(Map<T, K> map, String message) {
        if (map == null || map.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that a Map has entries; that is, it must not be <code>null</code>
     * and must have at least one entry.
     * 
     * <pre class="code">
     * Assert.notEmpty(map);
     * </pre>
     * 
     * @param map the map to check
     * @throws IllegalArgumentException if the map is <code>null</code> or has
     *             no entries
     */
    public static <T, K> void notEmpty(Map<T, K> map) {
        notEmpty(map, "this map must not be empty; it must contain at least one entry");
    }

    /**
     * Assert that the given String is not empty.
     * 
     * <pre class="code">
     * Assert.notEmpty(name, &quot;Name must not be empty&quot;);
     * </pre>
     * 
     * @param text the sting to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the string is empty.
     * @see #hasLength
     */
    public static void notEmpty(String text, String message) {
        hasLength(text, message);
    }

    /**
     * Assert that an array has elements; that is, it must not be
     * <code>null</code> and must have at least one element.
     * 
     * <pre class="code">
     * Assert.notEmpty(array, &quot;The array must have elements&quot;);
     * </pre>
     * 
     * @param array the array to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object array is <code>null</code>
     *             or has no elements
     */
    public static void notEmpty(Object[] array, String message) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that an array has elements; that is, it must not be
     * <code>null</code> and must have at least one element.
     * 
     * <pre class="code">
     * Assert.notEmpty(array);
     * </pre>
     * 
     * @param array the array to check
     * @throws IllegalArgumentException if the object array is <code>null</code>
     *             or has no elements
     */
    public static void notEmpty(Object[] array) {
        notEmpty(array, "this array must not be empty: it must contain at least 1 element");
    }

    /**
     * Assert that an array has no null elements.
     * 
     * <pre class="code">
     * Assert.noNullElements(array, &quot;The array must have non-null elements&quot;);
     * </pre>
     * 
     * @param array the array to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the object array contains a
     *             <code>null</code> element
     */
    public static void noNullElements(Object[] array, String message) {
        notEmpty(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Assert that an array has no null elements. Note: Does not complain if the
     * array is empty!
     * 
     * <pre class="code">
     * Assert.noNullElements(array);
     * </pre>
     * 
     * @param array the array to check
     * @throws IllegalArgumentException if the object array contains a
     *             <code>null</code> element
     */
    public static void noNullElements(Object[] array) {
        noNullElements(array, "this array must not contain any null elements");
    }

    /**
     * Assert that an collection has no null elements.
     * 
     * <pre class="code">
     * Assert.noNullElements(collection, &quot;The collection must have non-null elements&quot;);
     * </pre>
     * 
     * @param collection the collection to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the collection contains a
     *             <code>null</code> element
     */
    public static <T> void noNullElements(Collection<T> collection, String message) {
        notEmpty(collection);
        for (Iterator<T> it = collection.iterator(); it.hasNext();) {
            if (it.next() == null) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    /**
     * Assert that an collection has no null elements.
     * 
     * <pre class="code">
     * Assert.noNullElements(collection);
     * </pre>
     * 
     * @param collection the collection to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the collection contains a
     *             <code>null</code> element
     */
    public static <T> void noNullElements(Collection<T> collection) {
        notEmpty(collection);
        int i = 0;
        for (Iterator<T> it = collection.iterator(); it.hasNext(); i++) {
            if (it.next() == null) {
                throw new IllegalArgumentException(
                        "The validated collection contains null element at index: " + i);
            }
        }
    }

    /**
     * Assert the less than operation validity.
     * 
     * <pre class="code">
     * Assert.lessThan(number, compareNumber, &quot;number must be less Than compareNumber&quot;);
     * </pre>
     * 
     * @param number
     * @param compareNumber
     * @param message
     */
    public static void lessThan(Number number, Number compareNumber, String message) {
        if (number == null || compareNumber == null) {
            throw new IllegalArgumentException("one of the arguments is null");
        }
        if (number.longValue() > compareNumber.longValue()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert the less than operation validity.
     * 
     * <pre class="code">
     * Assert.lessThan(number, compareNumber);
     * </pre>
     * 
     * @param number
     * @param compareNumber
     * @param message
     */
    public static void lessThan(Number number, Number compareNumber) {
        if (number == null || compareNumber == null) {
            throw new IllegalArgumentException("one of the arguments is null");
        }
        if (number.longValue() > compareNumber.longValue()) {
            throw new IllegalArgumentException("less than operation not satisfied");
        }
    }

    /**
     * Assert the more than operation validity.
     * 
     * <pre class="code">
     * Assert.moreThan(number, compareNumber, &quot;number must be more Than compareNumber&quot;);
     * </pre>
     * 
     * @param number
     * @param compareNumber
     * @param message
     */
    public static void moreThan(Number number, Number compareNumber, String message) {
        if (number == null || compareNumber == null) {
            throw new IllegalArgumentException("one of the arguments is null");
        }
        if (number.longValue() < compareNumber.longValue()) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert the more than operation validity.
     * 
     * <pre class="code">
     * Assert.moreThan(number, compareNumber);
     * </pre>
     * 
     * @param number
     * @param compareNumber
     * @param message
     */
    public static void moreThan(Number number, Number compareNumber) {
        if (number == null || compareNumber == null) {
            throw new IllegalArgumentException("one of the arguments is null");
        }
        if (number.longValue() < compareNumber.longValue()) {
            throw new IllegalArgumentException("more than operation not satisfied");
        }
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * 
     * <pre class="code">
     * Assert.instanceOf(Foo.class, foo);
     * </pre>
     * 
     * @param clazz the required class
     * @param obj the object to check
     * @throws IllegalArgumentException if the object is not an instance of
     *             clazz
     * @see Class#isInstance
     */
    public static <T> void isInstanceOf(Class<T> clazz, Object obj) {
        isInstanceOf(clazz, obj, "");
    }

    /**
     * Assert that the provided object is an instance of the provided class.
     * 
     * <pre class="code">
     * Assert.instanceOf(Foo.class, foo, &quot;object must be an instance of class Foo&quot;);
     * </pre>
     * 
     * @param type the type to check against
     * @param obj the object to check
     * @param message a message which will be prepended to the message produced
     *            by the function itself, and which may be used to provide
     *            context. It should normally end in a ": " or ". " so that the
     *            function generate message looks ok when prepended to it.
     * @throws IllegalArgumentException if the object is not an instance of
     *             clazz
     * @see Class#isInstance
     */
    public static <T> void isInstanceOf(Class<T> type, Object obj, String message) {
        notNull(type, "Type to check must not be null");
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(message + "Object of class ["
                    + (obj != null ? obj.getClass().getName() : "null")
                    + "] must be an instance of " + type);
        }
    }

    /**
     * Assert that <code>superType.isAssignableFrom(subType)</code> is
     * <code>true</code>.
     * 
     * <pre class="code">
     * Assert.isAssignable(Number.class, myClass);
     * </pre>
     * 
     * @param superType the super type to check
     * @param subType the sub type to check
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static <T, P> void isAssignable(Class<T> superType, Class<P> subType) {
        isAssignable(superType, subType, "");
    }

    /**
     * Assert that <code>superType.isAssignableFrom(subType)</code> is
     * <code>true</code>.
     * 
     * <pre class="code">
     * Assert.isAssignable(Number.class, myClass, &quot;subType must be assignable to superType&quot;);
     * </pre>
     * 
     * @param superType the super type to check against
     * @param subType the sub type to check
     * @param message a message which will be prepended to the message produced
     *            by the function itself, and which may be used to provide
     *            context. It should normally end in a ": " or ". " so that the
     *            function generate message looks ok when prepended to it.
     * @throws IllegalArgumentException if the classes are not assignable
     */
    public static <T, P> void isAssignable(Class<T> superType, Class<P> subType, String message) {
        notNull(superType, "Type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new IllegalArgumentException(message + subType + " is not assignable to "
                    + superType);
        }
    }

    /**
     * Assert a boolean expression, throwing
     * <code>IllegalArgumentException</code> if the test result is
     * <code>false</code>.
     * 
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, &quot;The value must be greater than zero&quot;);
     * </pre>
     * 
     * @param expression a boolean expression
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if expression is <code>false</code>
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing
     * <code>IllegalArgumentException</code> if the test result is
     * <code>false</code>.
     * 
     * <pre class="code">
     * Assert.isTrue(i &gt; 0);
     * </pre>
     * 
     * @param expression a boolean expression
     * @throws IllegalArgumentException if expression is <code>false</code>
     */
    public static void isTrue(boolean expression) {
        isTrue(expression, "this expression must be true");
    }

}
