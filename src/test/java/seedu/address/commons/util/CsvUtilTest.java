package seedu.address.commons.util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.storage.CsvAdaptedPerson;
import seedu.address.testutil.TestUtil;

class CsvUtilTest {

    private static final Path MISSING_FILE = TestUtil.getFilePathInSandboxFolder("serialize.csv");
    private static final Path WRONG_HEADER_FILE = TestUtil.getFilePathInSandboxFolder("wrongHeader.csv");
    private static final Path SERIALIZATION_FILE = TestUtil.getFilePathInSandboxFolder("serialize.csv");
    private static final Path NON_EXISTANT_FILE = TestUtil.getFilePathInSandboxFolder("doesNotExist.csv");

    @Test
    public void getUnsuccessfulRow_emptyDatabase_string() {
         assertEquals("[]", CsvUtil.getUnsuccessfulRow());
    }


    @Test
    public void createPerson_invalidCsvString_emptyOptional() {
        String invalidCsvString = "Name;;;";
        assertEquals(Optional.empty(), CsvUtil.createPerson(invalidCsvString, 0));
    }

    @Test
    public void createPerson_rowMissingDelimiter_dataConversionExceptionThrown() {
        String rowMissingDelimiter = "name1;123456789;email@email.comTrue";
        int rowNumber = 0;
        assertEquals(Optional.empty(), CsvUtil.createPerson(rowMissingDelimiter, rowNumber));
    }

    @Test
    public void fromCsvString_mixOfValidAndInvalidPeople_peopleList() throws DataConversionException {
        String header = "Name;Phone;Email;Done\n";
        String validPerson = "name 3;123456789;email@email.com;TRUE\n";
        String invalidPerson = ";123111222;;\n";
        String csvString = header + validPerson + invalidPerson;
        assertEquals(1, CsvUtil.fromCsvString(csvString).size());
    }

    @Test
    public void readCsvFile_invalidFilePath_emptyOptional() throws DataConversionException {
        assertEquals(Optional.empty(), CsvUtil.readCsvFile(NON_EXISTANT_FILE));
    }

    @Test
    public void readCsvFile_wrongHeader_DataConversionException() {
        assertThrows(DataConversionException.class, () -> CsvUtil.readCsvFile(WRONG_HEADER_FILE));
    }


    @Test
    public void deserializeObjectFromCsvFile_wrongFile_IOException() {
        assertThrows(IOException.class, () -> CsvUtil.deserializeObjectFromCsvFile(NON_EXISTANT_FILE));
    }

    @Test
    public void readCsvFile_validPerson_noExceptionThrown() throws DataConversionException, IllegalValueException {
        String validStringPerson = "Leanne Beasley;833842049;leannebeasley@lunchpod.com;False";
        Person valid = new CsvAdaptedPerson(validStringPerson).toModelType();
        List<Person> validPersonList = Arrays.asList(valid);
        assertEquals(validPersonList, CsvUtil.readCsvFile(SERIALIZATION_FILE).get());
    }


    @Test
    public void checkValidHeader_wrongDelimiter_dataConversionExceptionThrown() {
        String header = "Name,Phone,Email,Done";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }

    @Test
    public void checkValidHeader_missingHeader_dataConversionExceptionThrown() {
        String header = "Name;Phone;Email";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }

    @Test
    public void checkValidHeader_wrongHeader_dataConversionExceptionThrown() {
        String header = "Name;Phone;Email;Called";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }



}
