package seedu.address.model.person.predicates;

import seedu.address.model.person.Person;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

public class DonePredicate implements Predicate<Person> {
    private final List<String> keywords;

    public DonePredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {
        return keywords.stream()
                .anyMatch(keyword -> person.getIsDone().toString().toLowerCase(Locale.ROOT).equals(keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DonePredicate // instanceof handles nulls
                && keywords.equals(((DonePredicate) other).keywords)); // state check
    }
}
