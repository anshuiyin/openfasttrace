package org.itsallcode.openfasttrace.report.view;

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
 * Contains static helper methods for indentation.
 */
public final class IndentationHelper
{
    private static final int INDENT_SPACES_PER_LEVEL = 2;

    private IndentationHelper()
    {
        // prevent instantiation.
    }

    /**
     * Create indentation prefix (i.e. white spaces)
     * 
     * @param level
     *            indentation level
     * @return <code>level</code> white spaces
     */
    public static String createIndentationPrefix(final int level)
    {
        return new String(new char[level * INDENT_SPACES_PER_LEVEL]).replace("\0", " ");
    }
}
