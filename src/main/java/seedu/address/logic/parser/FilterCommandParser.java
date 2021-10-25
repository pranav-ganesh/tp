package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.EMPTY_PREFIX;

import java.util.List;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.category.Category;

/**
 * Parses input arguments and creates a new {@code FilterCommand} object
 */
public class FilterCommandParser implements Parser<FilterCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code FilterCommand}
     * and returns a {@code FilterCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FilterCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(trimmedArgs, EMPTY_PREFIX);

        Category category;
        Integer count;
        List<String> argList = argMultimap.getAllValues(EMPTY_PREFIX);

        if (!areArgumentsPresent(argList)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCommand.MESSAGE_USAGE));
        }

        if (areBothArgumentsPresent(argList)) {
            // category and count arguments are specified
            String lastArgument = extractLastArgument(argList);
            String secondLastArgument = extractSecondLastArgument(argList);
            try {
                count = ParserUtil.parseInteger(lastArgument);
                category = ParserUtil.parseCategory(secondLastArgument);
            } catch (ParseException e) {
                category = ParserUtil.parseCategory(lastArgument);
                count = Integer.MAX_VALUE;
            }
        } else {
            // only category argument specified
            String lastArgument = extractLastArgument(argList);
            category = ParserUtil.parseCategory(lastArgument);
            count = Integer.MAX_VALUE;
        }

        return new FilterCommand(category, count);
    }

    /**
     * Returns true if all the arguments are present in the given
     * {@code List<String>}.
     */
    private static boolean areArgumentsPresent(List<String> argList) {
        if (argList == null) {
            return false;
        }
        return argList.size() >= 1;
    }

    /**
     * Returns true if both arguments are present in the given
     * {@code List<String>}.
     */
    private static boolean areBothArgumentsPresent(List<String> argList) {
        if (argList == null) {
            return false;
        }
        return argList.size() >= 2;
    }

    /**
     * Extracts the last {@code argument} from {@code List<String> argList}.
     */
    private String extractLastArgument(List<String> argList) throws ParseException {
        String last = argList.get(argList.size() - 1); // category is the first argument
        return last;
    }

    /**
     * Extracts the second last {@code argument} from {@code List<String> argList}.
     */
    private String extractSecondLastArgument(List<String> argList) throws ParseException {
        String secondLast = argList.get(argList.size() - 2); // category is the first argument
        return secondLast;
    }
}
