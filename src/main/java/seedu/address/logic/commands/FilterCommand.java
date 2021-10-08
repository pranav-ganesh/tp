package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Filters the displayed list in the GUI of CallMeMaybe
 */
public class FilterCommand extends Command {

    public static final String COMMAND_WORD = "filter";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Filters the displayed list of people "
            + "by the category given by the user. "
            + "List will be shown in ascending alphabetical order.\n"
            + "Parameters: CATEGORY "
            + "INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " Called 5";

    public static final String MESSAGE_SUCCESS = "Filter success";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
