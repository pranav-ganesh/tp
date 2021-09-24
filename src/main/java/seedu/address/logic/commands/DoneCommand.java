package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import seedu.address.commons.core.index.Index;
import seedu.address.model.person.Person;

import java.util.List;

/**
 * Allows telemarketers to mark calls as done.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the 'Called' field of the address identified "
            + "by the index number of the address listing. "
            + "Existing 'Called' field will change to True.\n"
            + "Parameter: INDEX (must be a positive integer)";

    public static final String MESSAGE_DONE_CALL_SUCCESS = "Marked Call as Done: %1$s";
    public static final String MESSAGE_ALREADY_DONE_CALL = "The 'Called' field for the specified address listing is "
            + "already marked as true!";
    
    private final Index index;
    
    public DoneCommand(Index index) {
        requireAllNonNull(index);

        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person person = lastShownList.get(index.getZeroBased());
        if (person.getIsDone()) {
            return new CommandResult(MESSAGE_ALREADY_DONE_CALL);
        }
        
        model.markCallAsDone(person);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(String.format(MESSAGE_DONE_CALL_SUCCESS, person));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        
        if (!(other instanceof DoneCommand)) {
            return false;
        }
        
        DoneCommand e = (DoneCommand) other;
        return index.equals(e.index);
    }
}
