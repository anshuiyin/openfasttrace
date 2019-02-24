package org.itsallcode.openfasttrace;

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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.itsallcode.openfasttrace.core.Newline;
import org.itsallcode.openfasttrace.exporter.ExportSettings;
import org.itsallcode.openfasttrace.exporter.ExporterConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestExportSettings
{
    private ExportSettings.Builder builder;

    @BeforeEach
    void beforeEach()
    {
        this.builder = ExportSettings.builder();
    }

    @Test
    void testDefaultOutputFormat()
    {
        assertThat(this.builder.build().getOutputFormat(),
                equalTo(ExporterConstants.DEFAULT_OUTPUT_FORMAT));
    }

    @Test
    void testDefaultNewline()
    {
        assertThat(this.builder.build().getNewline(), equalTo(Newline.UNIX));
    }

    @Test
    void testBuildWithOutputFormat()
    {
        assertThat(this.builder.outputFormat("foo").build().getOutputFormat(), equalTo("foo"));
    }

    @Test
    void testBuildWithNewline()
    {
        assertThat(this.builder.newline(Newline.OLDMAC).build().getNewline(),
                equalTo(Newline.OLDMAC));
    }
}
