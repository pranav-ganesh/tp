package seedu.address.model.person.predicates;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.model.person.Person;

/**
 * Tests that a {@code Person}'s {@code Phone} contains a substring equivalent to the numbers given.
 */
public class PhoneContainsNumberPredicate implements Predicate<Person> {
    private final List<String> numbers;

    public PhoneContainsNumberPredicate(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean test(Person person) {
        return numbers.stream()
                .anyMatch(number -> person.getPhone().value.contains(number));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PhoneContainsNumberPredicate // instanceof handles nulls
                && numbers.equals(((PhoneContainsNumberPredicate) other).numbers)); // state check
    }
}
