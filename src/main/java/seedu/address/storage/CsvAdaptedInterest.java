package seedu.address.storage;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.interests.Interest;

public class CsvAdaptedInterest {

    private final String interest;

    public CsvAdaptedInterest(String interest) {
        this.interest = interest;
    }

    public CsvAdaptedInterest(Interest source) {
        interest = source.value;
    }

    public String getInterest() {
        return interest;
    }

    public Interest toModelType() throws IllegalValueException {
        if (!Interest.isValidInterest(interest)) {
            throw new IllegalValueException(Interest.MESSAGE_CONSTRAINTS);
        }
        return new Interest(interest);
    }


}
