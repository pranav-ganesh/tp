package seedu.address.testutil;

import seedu.address.model.person.*;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final boolean DEFAULT_DONE = false;
    public static final String DEFAULT_ADDRESS = null;

    private Name name;
    private Phone phone;
    private Email email;
    private IsDone isDone;
    private Address address;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        isDone = new IsDone(DEFAULT_DONE);
        address = new Address(DEFAULT_ADDRESS);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        isDone = personToCopy.getIsDone();
        address = personToCopy.getAddress();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code isDone} of the {@code Person} that we are building.
     */
    public PersonBuilder withDone(boolean isDone) {
        this.isDone = new IsDone(isDone);
        return this;
    }

    /**
     * Sets the {@code address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Builds person
     * @return the person
     */
    public Person build() {
        return new Person(name, phone, email, isDone, address);
    }

}
