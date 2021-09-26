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


    public FullPersonCard(List<Person> persons, int displayedIndex) {
        super(FXML);

        this.person = persons.get(displayedIndex - 1);
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        email.setText(person.getEmail().value);

        if (person.getIsDone().value) {
            isDone.setText("Called: True");
        } else {
            isDone.setText("Called: False");
        }

        address.setText("N.A");
        gender.setText("N.A");
        age.setText("N.A");
        interests.setText("N.A");

    }

}
