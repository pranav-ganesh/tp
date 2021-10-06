package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Age;
import seedu.address.model.person.Email;
import seedu.address.model.person.Gender;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.testutil.PersonBuilder;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_ADDRESS = "";
    private static final String INVALID_GENDER = "APACHE HELICOPTER";
    private static final String INVALID_AGE = "Eighteen";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ISDONE = BENSON.getIsDone().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final String VALID_GENDER = BENSON.getGender().toString();
    private static final String VALID_AGE = BENSON.getAge().toString();

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                        VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                        VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_EMAIL, VALID_ISDONE,
                VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ISDONE,
                        VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, null, VALID_ISDONE,
                VALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                        INVALID_ADDRESS, VALID_GENDER, VALID_AGE);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_isValid() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                null, VALID_GENDER, VALID_AGE);
        Person personWithNullAddress = new PersonBuilder().withName(VALID_NAME).withPhone(VALID_PHONE)
                .withEmail(VALID_EMAIL).withDone(VALID_ISDONE).withAddress(null).withGender(VALID_GENDER)
                .withAge(VALID_AGE).build();
        assertEquals(person.toModelType(), personWithNullAddress);
    }

    @Test
    public void toModelType_invalidGender_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                        VALID_ADDRESS, INVALID_GENDER, VALID_AGE);
        String expectedMessage = Gender.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullGender_isValid() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                VALID_ADDRESS, null, VALID_AGE);
        Person personWithNullGender = new PersonBuilder().withName(VALID_NAME).withPhone(VALID_PHONE)
                .withEmail(VALID_EMAIL).withDone(VALID_ISDONE).withAddress(VALID_ADDRESS).withGender(null)
                .withAge(VALID_AGE).build();
        assertEquals(person.toModelType(), personWithNullGender);
    }

    @Test
    public void toModelType_invalidAge_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                        VALID_ADDRESS, VALID_GENDER, INVALID_AGE);
        String expectedMessage = Age.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAge_isValid() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ISDONE,
                VALID_ADDRESS, VALID_GENDER, null);
        Person personWithNullGender = new PersonBuilder().withName(VALID_NAME).withPhone(VALID_PHONE)
                .withEmail(VALID_EMAIL).withDone(VALID_ISDONE).withAddress(VALID_ADDRESS).withGender(VALID_GENDER)
                .withAge(null).build();
        assertEquals(person.toModelType(), personWithNullGender);
    }
}
