package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_NAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_CATEGORY_PHONE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COUNT_3;
import static seedu.address.logic.commands.CommandTestUtil.VALID_COUNT_5;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.FilterCommand.MESSAGE_SUCCESS;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.category.Category;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */
public class FilterCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Category validCategoryName = new Category(VALID_CATEGORY_NAME);
    private Category validCategoryPhone = new Category(VALID_CATEGORY_PHONE);
    private Integer validCountThree = Integer.valueOf(VALID_COUNT_3);
    private Integer validCountFive = Integer.valueOf(VALID_COUNT_5);

    @Test
    public void execute() {
        assertCommandSuccess(new FilterCommand(validCategoryName, validCountThree),
                model, MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void equals() {
        final FilterCommand standardCommand = new FilterCommand(validCategoryName, validCountThree);

        // same values -> returns true
        FilterCommand commandWithSameValues = new FilterCommand(validCategoryName, validCountThree);
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different category -> returns false
        assertFalse(standardCommand.equals(new FilterCommand(validCategoryPhone, validCountThree)));

        // different count -> returns false
        assertFalse(standardCommand.equals(new FilterCommand(validCategoryName, validCountFive)));
    }
}
