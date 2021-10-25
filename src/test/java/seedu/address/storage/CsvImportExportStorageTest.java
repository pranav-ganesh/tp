package seedu.address.storage;


import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;


class CsvImportExportStorageTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "CsvImportExportStorage");
    private static final Path EMPTY_IMPORT = TEST_DATA_FOLDER.resolve("emptyAddressBook.csv");
    //    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    //    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");

    @Test
    public void readAddressBook_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CsvImportExportStorage(null));
    }



}
