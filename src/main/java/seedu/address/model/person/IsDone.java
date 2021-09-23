package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents whether a Person is called in the address book.
 */
public class IsDone {
    public final String value;

    public IsDone(String called) {
        requireNonNull(called);
        value = called;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof IsDone // instanceof handles nulls
                && value.equals(((IsDone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}