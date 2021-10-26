package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommandAny;
import seedu.address.model.person.Person;
import seedu.address.model.person.predicates.CombinedPredicateAny;
import seedu.address.model.person.predicates.NameContainsKeywordsPredicate;

public class FindCommandAnyParserTest {

    private FindCommandAnyParser parser = new FindCommandAnyParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommandAny.MESSAGE_USAGE)
        );
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        ArrayList<Predicate<Person>> predicates = new ArrayList<>();
        predicates.add(new NameContainsKeywordsPredicate(Arrays.asList("alice", "bob")));
        CombinedPredicateAny predicate = new CombinedPredicateAny(predicates);

        FindCommandAny expectedFindCommandAny =
                new FindCommandAny(predicate);
        assertParseSuccess(parser, " n/Alice Bob", expectedFindCommandAny);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " n/\n Alice \n \t Bob  \t", expectedFindCommandAny);
    }
}
