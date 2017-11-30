/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Yegor Bugayenko
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
package org.cactoos.iterable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import org.cactoos.collection.CollectionOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test of range implementation.
 *
 * @author Sven Diedrichsen (sven.diedrichsen@gmail.com)
 * @version $Id$
 * @since 1.0
 * @checkstyle JavadocMethodCheck (500 lines)
 * @checkstyle MagicNumber (500 lines)
 */
public class RangeOfTest {

    @Test
    public final void testIntegerRange() throws Exception {
        MatcherAssert.assertThat(
            "Can't generate a range of integers",
            new CollectionOf<>(
                new RangeOf<>(1, 5, input -> input + 1)
            ),
            Matchers.contains(1, 2, 3, 4, 5)
        );
    }

    @Test
    public final void testIntegerEmptyRange() throws Exception {
        MatcherAssert.assertThat(
            "Can't generate an empty range of integers",
            new CollectionOf<>(
                new RangeOf<Integer>(null, null, null)
            ),
            Matchers.empty()
        );
    }

    @Test
    public final void testCharacterRange() throws Exception {
        MatcherAssert.assertThat(
            "Can't generate a range of characters",
            new CollectionOf<>(
                new RangeOf<>('a', 'c', value -> ++value)
            ),
            Matchers.contains('a', 'b', 'c')
        );
    }

    @Test
    public final void testLocalDateRange() throws Exception {
        MatcherAssert.assertThat(
            "Can't generate a range of local dates.",
            new CollectionOf<>(
                new RangeOf<>(
                    LocalDate.of(2017, 1, 1),
                    LocalDate.of(2017, 1, 3),
                    value -> value.plus(1, ChronoUnit.DAYS)
                )
            ),
            Matchers.contains(
                LocalDate.of(2017, 1, 1),
                LocalDate.of(2017, 1, 2),
                LocalDate.of(2017, 1, 3)
            )
        );
    }

}
