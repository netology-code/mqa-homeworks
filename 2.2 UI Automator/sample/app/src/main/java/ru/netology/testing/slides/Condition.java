package ru.netology.testing.slides;

abstract class Condition<T, R> {

    /**
     * Applies the given arguments against this condition. Returns a non-null, non-false result if
     * the condition is satisfied.
     */
    abstract R apply(T args);
}