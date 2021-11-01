package seedu.address.model.person.predicates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class DonePredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        DonePredicate firstPredicate = new DonePredicate(
                firstPredicateKeywordList, false
        );
        DonePredicate secondPredicate = new DonePredicate(
                secondPredicateKeywordList, false
        );
        DonePredicate thirdPredicate = new DonePredicate(
                secondPredicateKeywordList, true
        );



        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        DonePredicate firstPredicateCopy = new DonePredicate(
                firstPredicateKeywordList, false
        );
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));

        // different isFindAll -> returns false
        assertFalse(secondPredicate.equals(thirdPredicate));
    }

    @Test
    public void test_addressContainsKeywords_returnsTrue() {
        // One keyword
        DonePredicate predicate = new DonePredicate(
                Collections.singletonList("false"), false
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("false").build()));

        predicate = new DonePredicate(
                Collections.singletonList("f"), false
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("false").build()));

        predicate = new DonePredicate(
                Collections.singletonList("true"), false
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("true").build()));

        predicate = new DonePredicate(
                Collections.singletonList("t"), false
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("true").build()));

        // Multiple keywords
        predicate = new DonePredicate(Arrays.asList("t", "f"), false);
        assertTrue(predicate.test(new PersonBuilder().withDone("false").build()));

        // Mixed-case keywords
        predicate = new DonePredicate(Arrays.asList("tRuE", "fAlSe"), false);
        assertTrue(predicate.test(new PersonBuilder().withDone("false").build()));
    }

    @Test
    public void test_addressDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        DonePredicate predicate = new DonePredicate(
                Collections.emptyList(), false
        );
        assertFalse(predicate.test(new PersonBuilder().withDone("true").build()));

        // Non-matching keyword
        predicate = new DonePredicate(Arrays.asList("Carol"), false);
        assertFalse(predicate.test(new PersonBuilder().withDone("false").build()));

        // Keywords match name, phone, email, but does not match isDone
        predicate = new DonePredicate(Arrays.asList(
                "Alice", "12345", "alice@email.com"
        ), false);
        assertFalse(predicate.test(new PersonBuilder().withName("ALice").withPhone("12345678")
                .withEmail("alice@email.com").withDone("true").build()));
    }

    @Test
    public void test_addressContainsKeywordsIsFindAll() {
        // One keyword match -> true
        DonePredicate predicate = new DonePredicate(
                Collections.singletonList("f"), true
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("false").build()));

        predicate = new DonePredicate(
                Collections.singletonList("t"), true
        );
        assertTrue(predicate.test(new PersonBuilder().withDone("true").build()));

        // One keyword no match -> false
        predicate = new DonePredicate(
                Collections.singletonList("haha"), true
        );
        assertFalse(predicate.test(new PersonBuilder().withDone("false").build()));

        // Only one matching keyword -> false
        predicate = new DonePredicate(Arrays.asList("t", "f"), true);
        assertFalse(predicate.test(new PersonBuilder().withDone("false").build()));

        // Keywords match name, phone, email, but does not match isDone -> false
        predicate = new DonePredicate(Arrays.asList(
                "Alice", "12345678", "alice@email.com"
        ), true);
        assertFalse(predicate.test(new PersonBuilder().withName("ALice").withPhone("12345678")
                .withEmail("alice@email.com").withDone("false").build()));
    }
}
