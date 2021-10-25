package seedu.address.model.person.predicates;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import seedu.address.model.person.Person;

public class GenderContainsKeywordPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public GenderContainsKeywordPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getGender().value.toLowerCase(Locale.ROOT).contains(keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GenderContainsKeywordPredicate // instanceof handles nulls
                && keywords.equals(((GenderContainsKeywordPredicate) other).keywords)); // state check
    }
}
