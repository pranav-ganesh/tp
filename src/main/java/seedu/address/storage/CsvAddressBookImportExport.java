package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.CsvUtil;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DoneCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Importing and exporting of csv files into the database
 */
public class CsvAddressBookImportExport implements ImportExport {

    public static final String MESSAGE_DUPLICATE_NOT_DONE_PERSON = "Import contains duplicate person(s) that has yet "
            + "to be called. " + "These person(s) with list index will not be added: \n";

    private static final Logger logger = LogsCenter.getLogger(CsvAddressBookImportExport.class);

    private boolean fileFound = true;
    private List<Integer> duplicateRowImport = new ArrayList<>();
    private List<Integer> updateRowImport = new ArrayList<>();
    private int successfulNewImportCount = 0;
    private int notCalledDuplicateImportCount = 0;
    private int unsuccessfulImportCount = 0;
    private int calledDuplicateImportCount = 0;


    private final Path filePath;

    /**
     * Constructor of the import export
     */
    public CsvAddressBookImportExport(Path filePath) {
        requireNonNull(filePath);
        this.filePath = filePath;
    }

    /**
     * The filepath the program expects the csv file to be
     * @return
     */
    public Path getImportExportPath() {
        return filePath;
    }

    /**
     * Imports the csv file into the model
     *
     * @param model Model of the addressbook
     * @return Optional list of person
     * @throws DataConversionException if there are any errors found in the data
     */
    @Override
    public Optional<List<Person>>importIntoAddressBook(Model model) throws DataConversionException {
        return importAddressBook(this.filePath, model);
    }

    /**
     * Returns a list of person optional that are to be imported
     *   Returns {@code Optional.empty()} if the csvfile is not found
     * @param filePath expected path of csv file
     * @param model model to me inserted into
     * @return optional list of person to be added
     * @throws DataConversionException when there are any errors in the person creation
     */
    private Optional<List<Person>> importAddressBook(Path filePath, Model model) throws DataConversionException {
        requireNonNull(filePath);
        fileFound = true;

        Optional<List<Person>> csvImportAddressBook = CsvUtil.readCsvFile(filePath);
        if (csvImportAddressBook.isEmpty()) {
            fileFound = false;
            return Optional.empty();
        }

        try {

            addImportIntoAddressBook(csvImportAddressBook.get(), model);

        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
        }
        List<Integer> unsuccessful = CsvUtil.getUnsuccessfulRow();
        unsuccessfulImportCount = unsuccessful.size();
        return csvImportAddressBook;
    }


    @Override
    public void exportCurrentAddressBook(Model model) {
        exportAddressBook(model);
    }

    private void exportAddressBook(Model model) {
        CsvUtil.writeCsvFile(model.getFilteredPersonList());
    }

    public String getImportStatus() {
        if (fileFound) {
            return String.format("New Imports : " + String.format("%-19.30s" , successfulNewImportCount)
                    + "          Unsuccessful imports : " + unsuccessfulImportCount
                    + "\nTotal Duplicates : "
                    + String.format("%-10.30s" , (calledDuplicateImportCount + notCalledDuplicateImportCount))
                    + "          Called Duplicate(s): " + calledDuplicateImportCount
                    + "          Not Called Duplicate(s) : " + notCalledDuplicateImportCount)
                    + "\nCheck logs for detailed explanation.";
        }
        return String.format("CSV file not found in " + filePath);
    }


    /**
     * Imports the list of valid people found in the CSV file
     *   Will not include duplicate people
     * @param people list of valid people
     * @param model model to import into
     * @throws IllegalValueException
     */
    public void addImportIntoAddressBook(List<Person> people, Model model) throws IllegalValueException {
        duplicateRowImport = new ArrayList<>(); // reset
        updateRowImport = new ArrayList<>(); // reset
        successfulNewImportCount = 0; // reset
        calledDuplicateImportCount = 0; //reset
        for (int pos = 0; pos < people.size(); pos++) {
            Person importPeople = people.get(pos);
            int listPos = model.duplicateIndex(importPeople);

            if (listPos != -1) {
                if (importPeople.getIsDone().value) {
                    Index listIndex = Index.fromZeroBased(listPos);
                    Command doneCommand = new DoneCommand(listIndex);
                    try {
                        doneCommand.execute(model);
                    } catch (CommandException e) { // throws exception if person not found
                        e.printStackTrace(); // should never reach here as listIndex and person exists
                    }
                    updateRowImport.add(listPos + 1);
                    calledDuplicateImportCount++;
                    continue;
                }
                duplicateRowImport.add(listPos + 1);
                notCalledDuplicateImportCount++;
                continue;
            }
            model.addPerson(importPeople);
            successfulNewImportCount++;
        }
        logger.info(successfulNewImportCount + " new person(s) successfully imported");
        logger.info("Person with list index : " + updateRowImport + " has been updated");
        if (successfulNewImportCount != people.size()) {
            throw new IllegalValueException(MESSAGE_DUPLICATE_NOT_DONE_PERSON + duplicateRowImport);
        }
    }

}
