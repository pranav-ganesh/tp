package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IsDoneTest {

    @Test
    public void equals() {
        IsDone isDone = new IsDone("Hello");

        // same object -> returns true
        assertTrue(isDone.equals(isDone));

        // same values -> returns true
        IsDone remarkCopy = new IsDone(isDone.value);
        assertTrue(isDone.equals(remarkCopy));

        // different types -> returns false
        assertFalse(isDone.equals(1));

        // null -> returns false
        assertFalse(isDone.equals(null));

        // different remark -> returns false
        IsDone differentIsDone = new IsDone("Bye");
        assertFalse(isDone.equals(differentIsDone));
    }
}