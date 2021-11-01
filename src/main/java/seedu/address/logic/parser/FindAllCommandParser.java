package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTEREST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindAllCommand;
import seedu.address.logic.commands.FindAnyCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;
import seedu.address.model.person.predicates.AddressContainsKeywordsPredicate;
import seedu.address.model.person.predicates.AgeContainsValuePredicate;
import seedu.address.model.person.predicates.CombinedPredicate;
import seedu.address.model.person.predicates.DonePredicate;
import seedu.address.model.person.predicates.EmailContainsKeywordsPredicate;
import seedu.address.model.person.predicates.GenderContainsKeywordPredicate;
import seedu.address.model.person.predicates.InterestContainsKeywordsPredicate;
import seedu.address.model.person.predicates.NameContainsKeywordsPredicate;
import seedu.address.model.person.predicates.PhoneContainsNumberPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindAllCommandParser implements Parser<FindAllCommand> {

    public static final String EMPTY_FIELD_MESSAGE = "Fields provided can be anything but cannot be an empty string \n"
            + "Found one violation at: ";

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindAllCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DONE,
                        PREFIX_ADDRESS, PREFIX_GENDER, PREFIX_AGE, PREFIX_INTEREST);

        if (!arePrefixesPresent(argMultimap) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindAllCommand.MESSAGE_USAGE));
        }

        String nameKeywords = argMultimap.getValue(PREFIX_NAME).orElse(null);
        String phoneNumbers = argMultimap.getValue(PREFIX_PHONE).orElse(null);
        String emailKeywords = argMultimap.getValue(PREFIX_EMAIL).orElse(null);
        String doneKeywords = argMultimap.getValue(PREFIX_DONE).orElse(null);
        String addressKeywords = argMultimap.getValue(PREFIX_ADDRESS).orElse(null);
        String genderKeywords = argMultimap.getValue(PREFIX_GENDER).orElse(null);
        String ageValues = argMultimap.getValue(PREFIX_AGE).orElse(null);
        String interestKeywords = argMultimap.getValue(PREFIX_INTEREST).orElse(null);

        ArrayList<Predicate<Person>> predicates = new ArrayList<>();

        if (nameKeywords != null) {
            checkEmptyString(nameKeywords, PREFIX_NAME);
            NameContainsKeywordsPredicate namePredicate = getNamePredicate(nameKeywords);
            predicates.add(namePredicate);
        }
        if (phoneNumbers != null) {
            checkEmptyString(phoneNumbers, PREFIX_PHONE);
            PhoneContainsNumberPredicate phonePredicate = getPhonePredicate(phoneNumbers);
            predicates.add(phonePredicate);
        }
        if (emailKeywords != null) {
            checkEmptyString(emailKeywords, PREFIX_EMAIL);
            EmailContainsKeywordsPredicate emailPredicate = getEmailPredicate(emailKeywords);
            predicates.add(emailPredicate);
        }
        if (doneKeywords != null) {
            checkEmptyString(doneKeywords, PREFIX_DONE);
            DonePredicate donePredicate = getDonePredicate(doneKeywords);
            predicates.add(donePredicate);
        }
        if (addressKeywords != null) {
            checkEmptyString(addressKeywords, PREFIX_ADDRESS);
            AddressContainsKeywordsPredicate addressPredicate = getAddressPredicate(addressKeywords);
            predicates.add(addressPredicate);
        }
        if (genderKeywords != null) {
            checkEmptyString(genderKeywords, PREFIX_GENDER);
            GenderContainsKeywordPredicate genderPredicate = getGenderPredicate(genderKeywords);
            predicates.add(genderPredicate);
        }
        if (ageValues != null) {
            checkEmptyString(ageValues, PREFIX_AGE);
            AgeContainsValuePredicate agePredicate = getAgePredicate(ageValues);
            predicates.add(agePredicate);
        }
        if (interestKeywords != null) {
            checkEmptyString(interestKeywords, PREFIX_INTEREST);
            InterestContainsKeywordsPredicate interestPredicate = getInterestPredicate(interestKeywords);
            predicates.add(interestPredicate);
        }

        CombinedPredicate combinedPredicate = new CombinedPredicate(predicates, true);

        return new FindAllCommand(combinedPredicate);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap) {
        return Stream.of(PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DONE,
                        PREFIX_ADDRESS, PREFIX_GENDER, PREFIX_AGE, PREFIX_INTEREST)
                .anyMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    /**
     * Checks if the string provided at the respective prefix is empty
     * @param test The string to be checked
     * @param prefix The prefix the string has
     * @throws ParseException when the string is empty
     */
    private void checkEmptyString(String test, Prefix prefix) throws ParseException {
        requireNonNull(test);
        requireNonNull(prefix);
        if (test.length() == 0) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, EMPTY_FIELD_MESSAGE + prefix.getPrefix()
            ));
        }
    }

    private NameContainsKeywordsPredicate getNamePredicate(String nameKeywords) {
        String[] nameKeywordsArr = nameKeywords.split("\\s+");
        return new NameContainsKeywordsPredicate(Arrays.asList(nameKeywordsArr), true);
    }

    private PhoneContainsNumberPredicate getPhonePredicate(String numbers) {
        String[] numbersArr = numbers.split("\\s+");
        return new PhoneContainsNumberPredicate(Arrays.asList(numbersArr), true);
    }

    private EmailContainsKeywordsPredicate getEmailPredicate(String emailKeywords) {
        String[] emailKeywordsArr = emailKeywords.split("\\s+");
        System.out.println("hello");
        return new EmailContainsKeywordsPredicate(Arrays.asList(emailKeywordsArr), true);
    }

    private DonePredicate getDonePredicate(String doneKeywords) {
        String[] doneKeywordsArr = doneKeywords.split("\\s+");
        return new DonePredicate(Arrays.asList(doneKeywordsArr), true);
    }

    private AddressContainsKeywordsPredicate getAddressPredicate(String addressKeywords) {
        String[] addressKeywordsArr = addressKeywords.split("\\s+");
        return new AddressContainsKeywordsPredicate(Arrays.asList(addressKeywordsArr), true);
    }

    private GenderContainsKeywordPredicate getGenderPredicate(String genderKeywords) {
        String[] genderKeywordsArr = genderKeywords.split("\\s+");
        return new GenderContainsKeywordPredicate(Arrays.asList(genderKeywordsArr), true);
    }

    private AgeContainsValuePredicate getAgePredicate(String ageValues) {
        String[] ageValuesArr = ageValues.split("\\s+");
        return new AgeContainsValuePredicate(Arrays.asList(ageValuesArr), true);
    }

    private InterestContainsKeywordsPredicate getInterestPredicate(String interestKeywords) {
        String[] interestKeywordsArr = interestKeywords.split("\\s+");
        return new InterestContainsKeywordsPredicate(Arrays.asList(interestKeywordsArr), true);
    }

}
