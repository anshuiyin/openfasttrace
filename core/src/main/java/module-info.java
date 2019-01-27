/*-
 * #%L
 * OpenFastTrace Core
 * %%
 * Copyright (C) 2016 - 2019 itsallcode.org
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
module openfasttrace
{
    exports org.itsallcode.openfasttrace;
    exports org.itsallcode.openfasttrace.core;
    exports org.itsallcode.openfasttrace.importer.tag.config;
    exports org.itsallcode.openfasttrace.report;
    exports org.itsallcode.openfasttrace.exporter;
    exports org.itsallcode.openfasttrace.importer.specobject;
    exports org.itsallcode.openfasttrace.core.xml;
    exports org.itsallcode.openfasttrace.core.xml.tree;
    exports org.itsallcode.openfasttrace.cli;
    exports org.itsallcode.openfasttrace.importer;
    exports org.itsallcode.openfasttrace.importer.input;
    exports org.itsallcode.openfasttrace.report.html;
    exports org.itsallcode.openfasttrace.report.plaintext;
    exports org.itsallcode.openfasttrace.importer.zip;
    exports org.itsallcode.openfasttrace.cli.commands;
    exports org.itsallcode.openfasttrace.core.xml.event;
    exports org.itsallcode.openfasttrace.importer.markdown;
    exports org.itsallcode.openfasttrace.report.view;
    exports org.itsallcode.openfasttrace.importer.tag;
    exports org.itsallcode.openfasttrace.report.view.html;
    exports org.itsallcode.openfasttrace.exporter.specobject;
    exports org.itsallcode.openfasttrace.core.serviceloader;

    requires java.compiler;
    requires java.logging;
    requires java.xml;
}
