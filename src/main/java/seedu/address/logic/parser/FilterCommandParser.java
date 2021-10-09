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
            category = extractCategoryForFilter(argList);
            count = extractCountForFilter(argList);
        } else {
            // only category argument specified
            category = extractCategoryForFilter(argList);
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
        return argList.size() == 1 || argList.size() == 2;
    }

    /**
     * Returns true if both arguments are present in the given
     * {@code List<String>}.
     */
    private static boolean areBothArgumentsPresent(List<String> argList) {
        if (argList == null) {
            return false;
        }
        return argList.size() == 2;
    }

    /**
     * Extracts {@code category} from {@code List<String> argList}.
     */
    private Category extractCategoryForFilter(List<String> argList) throws ParseException {
        String test = argList.get(0); // category is the first argument
        return ParserUtil.parseCategory(test);
    }

    /**
     * Extracts {@code count} from {@code List<String> argList}.
     */
    private Integer extractCountForFilter(List<String> argList) throws ParseException {
        String test = argList.get(1); // count is the second argument
        if (test == "") {
            // count is unspecified
            return Integer.MAX_VALUE;
        }
        return ParserUtil.parseInteger(test);
    }
}
