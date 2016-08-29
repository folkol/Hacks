package com.atex.onecms.content.repository.storage;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FunWithExceptions
{
    public static void main(String[] args)
            throws Throwable
    {
        unwrap(() -> Stream.of(1).map(wrap(thrower()))).collect(toList());
    }

    private static FunWithException<Integer, Object> thrower()
    {
        return i -> {
            throw new Exception();
        };
    }

    public static <T, R> Function<T, R> wrap(FunWithException<T, R> f) {
        return (x) -> {
            try {
                return f.apply(x);
            }
            catch (RuntimeException|Error e) {
                throw e;
            }
            catch (Throwable t) {
                throw new WrappedException(t);
            }
        };
    }

    public static <T, E extends Throwable> T unwrap(Supplier<T> f)
            throws E
    {
        try {
            return f.get();
        }
        catch (WrappedException e) {
            throw (E) e.getCause();
        }
    }

    public interface FunWithException<T, R> {
        R apply(T arg) throws Throwable;
    }


    private static class WrappedException
            extends RuntimeException
    {
        public WrappedException(final Throwable t)
        {
            super(t);
        }
    }
}
