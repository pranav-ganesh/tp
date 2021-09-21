package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;

public class CsvAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field in Import file is missing!";
    private static Map<String, Integer> map = Stream.of(new Object[][] {
            { "Name", 0 }, { "Phone", 1 }, {"Email", 2}, {"Address", 3}, {"Tags", 4}
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    private String name;
    private String phone;
    private String email;
    private String address;
    private String[] tagged;



    public CsvAdaptedPerson(String personDetails) {
        setDetails(personDetails);
    }

    //https://ashwaniashwin.wordpress.com/2013/04/19/save-excel-file-as-a-csv-semicolon-delimited
    // -file-along-with-unicode-encoding/
    private void setDetails(String personDetails) {
        String[] details = personDetails.split(";", 5);
        this.name = details[map.get("Name")];
        this.phone = details[map.get("Phone")];
        this.email = details[map.get("Email")];
        this.address = details[map.get("Address")];
        this.tagged = setTags(details[map.get("Tags")]);
    }

    private String[] setTags(String tags) {
        return tags.replace("\"", ("")).replace("\r", "").split(",");
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        if (email == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
        }
        final Email modelEmail = new Email(email);

        if (address == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalValueException(Address.MESSAGE_CONSTRAINTS);
        }
        final Address modelAddress = new Address(address);

        final List<Tag> personTags = new ArrayList<>();
        for (String tag : tagged) {
            System.out.println(tag);
            personTags.add(new Tag(tag));
        }

        final Set<Tag> modelTags = new HashSet<>(personTags);
        return new Person(modelName, modelPhone, modelEmail, modelAddress, modelTags);
    }

}
