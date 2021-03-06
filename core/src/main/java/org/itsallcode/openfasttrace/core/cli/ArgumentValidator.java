package org.itsallcode.openfasttrace.core.cli;

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
import java.util.Optional;
import java.util.stream.Collectors;

import org.itsallcode.openfasttrace.api.report.ReportVerbosity;
import org.itsallcode.openfasttrace.core.cli.commands.ConvertCommand;
import org.itsallcode.openfasttrace.core.cli.commands.TraceCommand;
import org.itsallcode.openfasttrace.core.exporter.ExporterFactoryLoader;

/**
 * The {@link ArgumentValidator} checks whether the command line arguments given
 * by the user contain valid values and are valid in combination.
 */
public class ArgumentValidator
{
    private static final List<String> AVAILABLE_COMMANDS = asList(ConvertCommand.COMMAND_NAME,
            TraceCommand.COMMAND_NAME);

    private final CliArguments arguments;
    private String error = "";
    private String suggestion = "";
    private final boolean valid;

    /**
     * Create a new {@link ArgumentValidator}
     * 
     * @param arguments
     *            the command line arguments to be validated
     */
    public ArgumentValidator(final CliArguments arguments)
    {
        this.arguments = arguments;
        this.valid = validate();
    }

    private boolean validate()
    {
        final Optional<String> command = this.arguments.getCommand();
        boolean ok = false;
        if (!command.isPresent())
        {
            this.error = "Missing command";
            this.suggestion = "Add one of " + listCommands();
        }
        else if (TraceCommand.COMMAND_NAME.equals(command.get()))
        {
            ok = validateTraceCommand();
        }
        else if (ConvertCommand.COMMAND_NAME.equals(command.get()))
        {
            ok = validateConvertCommand();
        }
        else
        {
            this.error = "'" + command.orElse(null) + "' is not an OFT command.";
            this.suggestion = "Choose one of " + listCommands() + ".";
        }

        return ok;
    }

    private boolean validateTraceCommand()
    {
        boolean ok = false;
        if (this.arguments.getReportVerbosity() == ReportVerbosity.QUIET
                && this.arguments.getOutputPath() != null)
        {
            this.error = "combining stream verbosity 'quiet' and ouput to file is not supported.";
            this.suggestion = "remove output file parameter.";
        }
        else
        {
            ok = true;
        }
        return ok;
    }

    private boolean validateConvertCommand()
    {
        boolean ok = false;
        final String format = this.arguments.getOutputFormat();
        if (format != null && !new ExporterFactoryLoader(null).isFormatSupported(format))
        {
            this.error = "export format '" + format + "' is not supported.";
        }
        else
        {
            ok = true;
        }
        return ok;
    }

    private String listCommands()
    {
        return AVAILABLE_COMMANDS.stream().map(text -> "'" + text + "'")
                .collect(Collectors.joining(","));
    }

    /**
     * Check if the command line arguments are valid
     * 
     * @return <code>true</code> if the command line arguments are valid
     */
    public boolean isValid()
    {
        return this.valid;
    }

    /**
     * Get the error message
     * 
     * @return the error message
     */
    public String getError()
    {
        return this.error;
    }

    /**
     * Get a suggestion on how to solve an error
     * 
     * @return the error resolution suggestion
     */
    public String getSuggestion()
    {
        return this.suggestion;
    }

}
