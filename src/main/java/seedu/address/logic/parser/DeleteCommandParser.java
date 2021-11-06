package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.EMPTY_PREFIX;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DisplayCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.List;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    public static final String MESSAGE_INDEX_NOT_PARSED = "The index entered is not within the allowed range. "
            + "The index for deletion cannot be bigger than 2147483647 (i.e., MAX_VALUE).";

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);
        List<String> argList = argMultimap.getAllValues(EMPTY_PREFIX);
        try {
            ParserUtil.tryParseIndex(argList);
            Index index = ParserUtil.parseIndex(args);
            return new DeleteCommand(index);
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), ive);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(MESSAGE_INDEX_NOT_PARSED), e);
        }
    }

}
