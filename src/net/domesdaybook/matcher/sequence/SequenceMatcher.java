/*
 * Copyright Matt Palmer 2009-2011, All rights reserved.
 *
 * This code is licensed under a standard 3-clause BSD license:
 * http://www.opensource.org/licenses/BSD-3-Clause
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer.
 * 
 *  * Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 * 
 *  * Neither the "byteseek" name nor the names of its contributors 
 *    may be used to endorse or promote products derived from this software 
 *    without specific prior written permission. 
 *  
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package net.domesdaybook.matcher.sequence;

import net.domesdaybook.matcher.Matcher;
import net.domesdaybook.matcher.singlebyte.SingleByteMatcher;

/**
 * An extension to the {@link Matcher} interface to support sequences.
 *
 * @author Matt Palmer
 */
 public interface SequenceMatcher extends Matcher {

    /**
     * Returns a {@link SingleByteMatcher} which matches all the bytes at
     * the requested position in the sequence.
     *
     * @param position The position in the byte matcher to return a dedicated byte matcher for.
     * @return A SingleByteMatcher for the position in the sequence provided.
     */
    SingleByteMatcher getByteMatcherForPosition(final int position);

    
    
    /**
     * Returns whether there is a match or not at the given position in a byte array.
     * <p/>
     * It does not perform any bounds checking, so an IndexOutOfBoundsException
     * can be thrown by this method if matching is outside the bounds of the array.
     * 
     * @param bytes An array of bytes to read from.
     * @param matchPosition The position to try to match at.
     * @return Whether there is a match at the given position.
     */
    boolean matchesNoBoundsCheck(final byte[] bytes, final int matchPosition);    
    
    
    /**
     * Gets the length of the matching sequence.
     *
     * @return Returns the length of a matching byte sequence.
     */
    int length();

    
    /**
     * Returns a reversed SequenceMatcher
     * 
     * @return A SequenceMatcher which matches the reverse sequence.
     */
    SequenceMatcher reverse();
    
    
    /**
     * Returns a regular expression representation of the matching sequence.
     * 
     * @param prettyPrint whether to pretty print the regular expression with spacing.
     * @return A string containing a regular expression of the byte matcher.
     */
    String toRegularExpression(final boolean prettyPrint);

}
