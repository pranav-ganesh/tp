package seedu.address.storage;

import java.util.List;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

public interface ImportExport {

    Optional<List<Person>> importIntoAddressBook(Model model) throws DataConversionException;


}
