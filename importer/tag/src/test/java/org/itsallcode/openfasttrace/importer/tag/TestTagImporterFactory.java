package org.itsallcode.openfasttrace.importer.tag;

/*-
 * #%L
 \* OpenFastTrace
 * %%
 * Copyright (C) 2016 - 2017 itsallcode.org
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

import static java.util.Arrays.asList;

import java.util.List;

import org.itsallcode.openfasttrace.importer.ImporterContext;
import org.itsallcode.openfasttrace.importer.ImporterFactoryTestBase;

/**
 * Tests for {@link TagImporterFactory}
 */
// [utest->dsn~import.full-coverage-tag~1]
class TestTagImporterFactory extends ImporterFactoryTestBase<TagImporterFactory>
{
    @Override
    protected TagImporterFactory createFactory()
    {
        final TagImporterFactory factory = new TagImporterFactory();
        factory.init(new ImporterContext(null));
        return factory;
    }

    @Override
    protected List<String> getSupportedFilenames()
    {
        return asList("file.java", "file.JAVA", "FILE.java", "FILE.JAVA", "file.md.java");
    }

    @Override
    protected List<String> getUnsupportedFilenames()
    {
        return asList("file.md", "file.jav", "file.ml", "file.1java", "file.java1", "file.java.md",
                "file_java", "filejava");
    }
}
