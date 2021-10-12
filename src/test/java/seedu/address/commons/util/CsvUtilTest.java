package seedu.address.commons.util;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.testutil.TestUtil;

class CsvUtilTest {

    private static final Path MISSING_FILE = TestUtil.getFilePathInSandboxFolder("serialize.csv");
    private static final Path WRONG_HEADER_FILE = TestUtil.getFilePathInSandboxFolder("wrongHeader.csv");

    @Test
    public void invalidCsvString_createPerson_emptyOptional() {
        String invalidCsvString = "Name;;;";
        assertEquals(Optional.empty(), CsvUtil.createPerson(invalidCsvString, 0));
    }

    @Test
    public void rowMissingDelimiter_createPerson_dataConversionException() {
        String rowMissingDelimiter = "name1;123456789;email@email.comTrue";
        int rowNumber = 0;
        assertEquals(Optional.empty(), CsvUtil.createPerson(rowMissingDelimiter, rowNumber));
    }

    @Test
    public void mixOfValidAndInvalidPeople_fromCsvString_peopleList() throws DataConversionException {
        String header = "Name;Phone;Email;Done\n";
        String validPerson = "name 3;123456789;email@email.com;TRUE\n";
        String invalidPerson = ";123111222;;\n";
        String csvString = header + validPerson + invalidPerson;
        assertEquals(1, CsvUtil.fromCsvString(csvString).size());
    }

    @Test
    public void invalidFilePath_readCsvFile_emptyOptional() throws DataConversionException {
        assertEquals(Optional.empty(), CsvUtil.readCsvFile(MISSING_FILE));
    }

    @Test
    public void wrongHeader_readCsvFile_emptyOptional() {
        assertThrows(DataConversionException.class, () -> CsvUtil.readCsvFile(WRONG_HEADER_FILE));
    }

    @Test
    public void wrongDelimiter_checkValidHeader_dataConversionException() {
        String header = "Name,Phone,Email,Done";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }

    @Test
    public void missingHeader_checkValidHeader_dataConversionException() {
        String header = "Name;Phone;Email";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }

    @Test
    public void wrongHeader_checkValidHeader_dataConversionException() {
        String header = "Name;Phone;Email;Called";
        assertThrows(DataConversionException.class, () -> CsvUtil.checkValidHeader(header));
    }



}
