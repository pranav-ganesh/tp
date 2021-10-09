package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCommand;
import seedu.address.model.category.Category;

public class FilterCommandParserTest {
    private static final String NON_EMPTY_CATEGORY = "phone";
    private static final String NON_ZERO_COUNT = "4";

    private final Category nonEmptyCategory = new Category("phone");
    private final Integer nonZeroCount = 4;
    private FilterCommandParser parser = new FilterCommandParser();

    @Test
    public void parse_categorySpecified_success() {
        // have count
        String userInput = NON_EMPTY_CATEGORY + " " + NON_ZERO_COUNT;
        FilterCommand expectedCommand = new FilterCommand(nonEmptyCategory, nonZeroCount);
        assertParseSuccess(parser, userInput, expectedCommand);

        // no count
        userInput = NON_EMPTY_CATEGORY + " " + "";
        expectedCommand = new FilterCommand(nonEmptyCategory, Integer.MAX_VALUE);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = Category.MESSAGE_CONSTRAINTS;

        // no parameters
        assertParseFailure(parser, "", expectedMessage);

        // no category
        assertParseFailure(parser, NON_ZERO_COUNT, expectedMessage);
    }
}
