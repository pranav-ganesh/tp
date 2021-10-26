package seedu.address.model.person.predicates;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Age} matches the value given.
 */
public class AgeContainsValuePredicate implements Predicate<Person> {
    private final List<String> ages;

    public AgeContainsValuePredicate(List<String> ages) {
        this.ages = ages;
    }

    @Override
    public boolean test(Person person) {
        return ages.stream()
                .anyMatch(age -> person.getAge().value.equals(age));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AgeContainsValuePredicate // instanceof handles nulls
                && ages.equals(((AgeContainsValuePredicate) other).ages)); // state check
    }
}
