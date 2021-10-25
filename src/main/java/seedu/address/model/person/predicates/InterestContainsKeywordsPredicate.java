package seedu.address.model.person.predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import seedu.address.model.person.Person;
import seedu.address.model.person.interests.Interest;

public class InterestContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> interests;

    public InterestContainsKeywordsPredicate(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public boolean test(Person person) {
        ArrayList<Interest> personInterestsList = person.getInterests().getAllInterests();
        return interests.stream().anyMatch(interest -> personInterestsList
                        .stream().anyMatch(interest1 -> interest1.value.toLowerCase(Locale.ROOT).contains(interest)));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof InterestContainsKeywordsPredicate // instanceof handles nulls
                && interests.equals(((InterestContainsKeywordsPredicate) other).interests)); // state check
    }
}
