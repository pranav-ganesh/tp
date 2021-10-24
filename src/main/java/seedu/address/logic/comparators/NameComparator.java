package seedu.address.logic.comparators;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Comparator;

import seedu.address.model.person.Person;

/**
 * A comparator that compares Persons based on their names.
 */
public class NameComparator implements Comparator<Person> {
    // Used for sorting in ascending order of name
    @Override
    public int compare(Person a, Person b) {
        requireAllNonNull(a, b);
        return a.getName().fullName.compareTo(b.getName().fullName);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof NameComparator); // instanceof handles nulls
    }
}
