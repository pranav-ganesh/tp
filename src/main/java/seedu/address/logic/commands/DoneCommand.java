package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Changes the done field of an existing person in the address book.
 */
public class DoneCommand extends Command {

    public static final String COMMAND_WORD = "done";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Hello from done");
    }
}
