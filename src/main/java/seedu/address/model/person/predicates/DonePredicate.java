package seedu.address.model.person.predicates;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Done} matches the value given.
 */
public class DonePredicate implements Predicate<Person> {
    private final List<String> keywords;

    public DonePredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getIsDone().toString().toLowerCase(Locale.ROOT).equals(
                        getDoneValueFromKeyword(keyword)
                ));
    }

    /**
     * Allows more flexibility for user inputs
     * @param keyword entered by user
     * @return True if input is t or true
     *          false if its f or false
     */
    private String getDoneValueFromKeyword(String keyword) {
        String test = keyword.toLowerCase(Locale.ROOT);
        if (test.equals("t") || test.equals("true")) {
            return "true";
        } else if (test.equals("f") || test.equals("false")) {
            return "false";
        } else {
            // Basically return anything that is not 'true' / 'false' / 'N.A'
            // so that the predicate will return false
            return "THIS IS NOT A DONE VALUE";
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DonePredicate // instanceof handles nulls
                && keywords.equals(((DonePredicate) other).keywords)); // state check
    }
}
