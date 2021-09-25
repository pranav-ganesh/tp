package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for DoneCommand.
 */
public class DoneCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute() {
        /*
        DoneCommand doneCommand = new DoneCommand(INDEX_FIRST_PERSON);
        CommandResult commandResult = doneCommand.execute(model);

        String expectedMessage = String.format(DoneCommand.MESSAGE_DONE_CALL_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(model.getFilteredPersonList().get(0), editedPerson);

        assertCommandSuccess(doneCommand, model, expectedMessage, expectedModel);
        */
        
        CommandResult expectedCommandResult = new CommandResult("Hello from done");
        assertCommandSuccess(new DoneCommand(INDEX_FIRST_PERSON), model, expectedCommandResult, expectedModel);
    }
}
