package seedu.address.commons.util;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.storage.CsvAdaptedPerson;

public class CsvUtil {

    private static final Logger logger = LogsCenter.getLogger(CsvUtil.class);

    static List<Person> deserializeObjectFromCsvFile(Path filePath)
            throws IOException, IllegalValueException {
        requireNonNull(filePath);
        return fromCsvString(FileUtil.readFromFile(filePath));
    }

    /**
     * Reads from CSV file and converts into an optional list of people
     *
     * @param filePath filepath of the csv
     * @return list optional, whether there is a list of people within the csv
     * @throws DataConversionException
     */
    public static Optional<List<Person>> readCsvFile(Path filePath) throws DataConversionException {
        requireNonNull(filePath);
        if (!Files.exists(filePath)) {
            logger.info("Json file " + filePath + " not found");
            return Optional.empty();
        }

        List<Person> persons;

        try {
            persons = deserializeObjectFromCsvFile(filePath);
        } catch (IOException | IllegalValueException e) {
            logger.warning("Error reading from jsonFile file " + filePath + ": " + e);
            throw new DataConversionException(e);
        }

        return Optional.of(persons);
    }



    static List<Person> fromCsvString(String csv) {
        List<Person> persons = new ArrayList<>();
        String[] personRows = csv.split("\n");
        for (int i = 1; i < personRows.length; i++) {
            Person temp = createPerson(personRows[i]);
            if (temp == null) {
                continue;
            }
            persons.add(temp);

        }
        return persons;
    }

    static Person createPerson(String rowStringPerson) {
        try {
            return new CsvAdaptedPerson(rowStringPerson).toModelType();
        } catch (IllegalValueException e) {
            return null;
        }
    }


}
