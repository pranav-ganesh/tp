package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

import java.util.List;
import java.util.logging.Logger;

public class FullPersonCard extends UiPart<Region> {

    private static final String FXML = "FullPersonCard.fxml";
    private final Logger logger = LogsCenter.getLogger(FullPersonCard.class);

    public final Person person;

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

    private final String PHONE_LABEL = "Phone: ";
    private final String EMAIL_LABEL = "Email: ";
    private final String DONE_LABEL = "Called: ";
    private final String ADDRESS_LABEL = "Address: ";
    private final String GENDER_LABEL = "Gender: ";
    private final String AGE_LABEL = "Age: ";
    private final String INTERESTS_LABEL = "Interests: ";
    private final String DEFAULT_FIELD = "N.A";


    public FullPersonCard(List<Person> persons, int displayedIndex, double windowWidth) {
        super(FXML);

        cardPane.setPrefWidth(windowWidth / 2);

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

    }

}
