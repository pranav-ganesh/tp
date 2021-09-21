package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.CsvUtil;

import seedu.address.model.Model;
import seedu.address.model.person.Person;

public class CsvAddressBookImportExport implements ImportExport {

    private static final Logger logger = LogsCenter.getLogger(CsvAddressBookImportExport.class);

    public static final String MESSAGE_DUPLICATE_PERSON = "Import list contains duplicate person(s). These person(s) " +
            "will not be added: \n";

    private final Path filePath;

    public CsvAddressBookImportExport() {
        this.filePath = new File("./data/importAddressBook.csv").toPath();
    }

    public Path getCsvImportExportFilePath() {
        return filePath;
    }

    @Override
    public Optional<List<Person>>importIntoAddressBook(Model model) throws DataConversionException {
        return importAddressBook(this.filePath, model);
    }

    private Optional<List<Person>> importAddressBook(Path filePath, Model model) throws DataConversionException {
        requireNonNull(filePath);

        Optional<List<Person>> csvImportAddressBook = CsvUtil.readCsvFile(filePath);
        if (csvImportAddressBook.isEmpty()) {
            return Optional.empty();
        }

        try {
            addImportIntoAddressBook(csvImportAddressBook.get(), model);
            return csvImportAddressBook;
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }


    private void addImportIntoAddressBook(List<Person> people, Model model) throws IllegalValueException {
        List<String> duplicatePeople = new ArrayList<>();
        for (Person importPeople : people) {
            if (model.hasPerson(importPeople)) {
                duplicatePeople.add(importPeople.getName().fullName);
            } else {
                model.addPerson(importPeople);
            }
        }
        logger.info(people.size()-duplicatePeople.size() + " person(s) successfully added");
        if (duplicatePeople.size()>0) {
            throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON + duplicatePeople.toString());
        }


    }
}
