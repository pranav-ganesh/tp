package seedu.address.model.person.predicates;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s fields matches any of the respective fields provided
 */
public class CombinedPredicate implements Predicate<Person> {
    private final List<Predicate<Person>> predicates;

    /**
     * Combines all the predicates requested by the user.
     * @param predicates All the predicates created by the user
     */
    public CombinedPredicate(ArrayList<Predicate<Person>> predicates) {
        requireNonNull(predicates);
        this.predicates = predicates;
    }

    @Override
    public boolean test(Person person) {
        return predicates.stream()
                .anyMatch(predicate -> predicate.test(person));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof CombinedPredicate // instanceof handles nulls
                && predicates.equals(((CombinedPredicate) other).predicates)); // state check
    }
}
