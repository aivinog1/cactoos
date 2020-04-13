/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.func;

import org.cactoos.BiFunc;

/**
 * BiFunc check for no nulls.
 *
 * @param <X> Type of input
 * @param <Y> Type of input
 * @param <Z> Type of output
 * @since 0.11
 */
public final class BiFuncNoNulls<X, Y, Z> implements BiFunc<X, Y, Z> {

    /**
     * The function.
     */
    private final BiFunc<X, Y, Z> origin;

    /**
     * Ctor.
     * @param func The function
     */
    public BiFuncNoNulls(final BiFunc<X, Y, Z> func) {
        this.origin = func;
    }

    @Override
    public Z apply(final X first, final Y second) throws Exception {
        if (this.origin == null) {
            throw new IllegalArgumentException(
                "NULL instead of a valid function"
            );
        }
        if (first == null) {
            throw new IllegalArgumentException(
                "NULL instead of a valid first argument"
            );
        }
        if (second == null) {
            throw new IllegalArgumentException(
                "NULL instead of a valid second argument"
            );
        }
        final Z result = this.origin.apply(first, second);
        if (result == null) {
            throw new IllegalStateException(
                "NULL instead of a valid result"
            );
        }
        return result;
    }
}
