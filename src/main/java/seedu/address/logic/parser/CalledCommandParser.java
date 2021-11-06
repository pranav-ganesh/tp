package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.EMPTY_PREFIX;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.CalledCommand;
import seedu.address.logic.commands.DisplayCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.List;

/**
 * Parses the input argument and creates a new CalledCommand object
 */
public class CalledCommandParser implements Parser<CalledCommand> {

    public static final String MESSAGE_INDEX_NOT_PARSED = "The index entered is not within the allowed range. "
            + "The index for display cannot be bigger than 2147483647 (i.e., MAX_VALUE).";

    /**
     * Parses the given {@code String} of argument and returns a CalledCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public CalledCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
        List<String> argList = argMultimap.getAllValues(EMPTY_PREFIX);

        Index index;
        try {
            ParserUtil.tryParseIndex(argList);
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CalledCommand.MESSAGE_USAGE), ive);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INDEX_NOT_PARSED), e);
        }
        return new CalledCommand(index);
    }
}
