package org.itsallcode.openfasttrace.report.view.html;

/*-
 * #%L
 * OpenFastTrace
 * %%
 * Copyright (C) 2016 - 2018 itsallcode.org
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * The <code>MarkdownLineState</code> represents the Markdown states that can be
 * switched by newlines and the way the next line starts.
 */
enum MarkdownLineState
{
    START, //
    PARAGRAPH, //
    UNORDERED_LIST, //
    UNORDERED_LIST_CONTINUED, //
    ORDERED_LIST, //
    ORDERED_LIST_CONTINUED, //
    PREFORMATTED, //
    TERMINATOR
}