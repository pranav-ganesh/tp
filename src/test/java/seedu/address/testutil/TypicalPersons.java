package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_AGE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INTEREST_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withEmail("alice@example.com").withPhone("94351253").withCalled("false").withAddress("MY HOUSE")
            .withGender("F").withAge("22").withInterest("Running").build();
    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withEmail("johnd@example.com").withPhone("98765432").withCalled("false").withAddress("HIS HOUSE")
            .withCalled("false").withGender("M").withAge("18").withInterest("Eating", "Sleeping").build();
    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withCalled("false").build();
    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withCalled("false").build();
    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("94822248")
            .withEmail("werner@example.com").withCalled("false").build();
    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("94824278")
            .withEmail("lydia@example.com").withCalled("false").build();
    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("94824428")
            .withEmail("anna@example.com").withCalled("false").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("84824248")
            .withEmail("stefan@example.com").withCalled("false").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("84821318")
            .withEmail("hans@example.com").withCalled("false").build();
    public static final Person BRADY = new PersonBuilder().withName("Brady Harrison").withPhone("96664428")
            .withEmail("brady@example.com").withAddress("HOME").withGender("M").withAge("45")
            .withCalled("false").withInterest("Cooking", "Tutoring").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withCalled("false").build();
    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withCalled("false").withAddress(VALID_ADDRESS_BOB)
            .withGender(VALID_GENDER_BOB).withAge(VALID_AGE_BOB).withInterest(VALID_INTEREST_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
