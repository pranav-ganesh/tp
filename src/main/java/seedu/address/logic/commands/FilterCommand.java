package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import seedu.address.model.Model;
import seedu.address.model.category.Category;

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

    private final Integer count;
    private final Category category;

    /**
     * @param category of the person to be updated to
     * @param count of the person in the filtered person list to edit the remark
     */
    public FilterCommand(Category category, Integer count) {
        requireAllNonNull(category, count);

        this.category = category;
        this.count = count;
    }

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterCommand)) {
            return false;
        }

        // state check
        FilterCommand e = (FilterCommand) other;
        return category.equals(e.category)
                && count.equals(e.count);
    }
}
