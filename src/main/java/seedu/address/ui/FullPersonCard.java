package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

public class FullPersonCard extends UiPart<Region> {

    private static final String FXML = "FullPersonCard.fxml";

    private static final String PHONE_LABEL = "Phone: ";
    private static final String EMAIL_LABEL = "Email: ";
    private static final String DONE_LABEL = "Called: ";
    private static final String ADDRESS_LABEL = "Address: ";
    private static final String GENDER_LABEL = "Gender: ";
    private static final String AGE_LABEL = "Age: ";
    private static final String INTERESTS_LABEL = "Interests: ";
    private static final String DEFAULT_FIELD = "N.A";
    private static final String NO_PERSON_TO_DISPLAY = "No person to display";

    private final Logger logger = LogsCenter.getLogger(FullPersonCard.class);

    private Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label email;
    @FXML
    private Label isDone;
    @FXML
    private Label address;
    @FXML
    private Label gender;
    @FXML
    private Label age;
    @FXML
    private Label interests;

    /**
     * Constructor for the FullPersonCard
     * @param persons The current list displayed
     * @param displayedIndex The index of the person to display on the card
     * @param windowWidth The size of the card
     */
    public FullPersonCard(List<Person> persons, int displayedIndex, double windowWidth) {
        super(FXML);

        cardPane.setPrefWidth(windowWidth / 2);
        try {
            this.person = persons.get(displayedIndex - 1);
            id.setText(displayedIndex + ". ");
            name.setText(person.getName().fullName);
            phone.setText(PHONE_LABEL + person.getPhone().value);
            email.setText(EMAIL_LABEL + person.getEmail().value);

            if (person.getIsDone().value) {
                isDone.setText(DONE_LABEL + "True");
            } else {
                isDone.setText(DONE_LABEL + "False");
            }

            address.setText(ADDRESS_LABEL + DEFAULT_FIELD);
            gender.setText(GENDER_LABEL + DEFAULT_FIELD);
            age.setText(AGE_LABEL + DEFAULT_FIELD);
            interests.setText(INTERESTS_LABEL + DEFAULT_FIELD);
        } catch (IndexOutOfBoundsException e) {
            createEmptyCard();
        }
    }

    /**
     * Creates an empty card where all the fields are N.A.
     */
    private void createEmptyCard() {
        this.person = null;
        id.setText(NO_PERSON_TO_DISPLAY);
        name.setText("");
        phone.setText(PHONE_LABEL + DEFAULT_FIELD);
        email.setText(EMAIL_LABEL + DEFAULT_FIELD);
        isDone.setText(DONE_LABEL + DEFAULT_FIELD);
        address.setText(ADDRESS_LABEL + DEFAULT_FIELD);
        address.setText(ADDRESS_LABEL + DEFAULT_FIELD);
        gender.setText(GENDER_LABEL + DEFAULT_FIELD);
        age.setText(AGE_LABEL + DEFAULT_FIELD);
        interests.setText(INTERESTS_LABEL + DEFAULT_FIELD);
    }

}
