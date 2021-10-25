package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_AGE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GENDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INTEREST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.Arrays;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Person;
import seedu.address.model.person.predicates.AddressContainsKeywordsPredicate;
import seedu.address.model.person.predicates.AgeContainsValuePredicate;
import seedu.address.model.person.predicates.DonePredicate;
import seedu.address.model.person.predicates.EmailContainsKeywordsPredicate;
import seedu.address.model.person.predicates.GenderContainsKeywordPredicate;
import seedu.address.model.person.predicates.InterestContainsKeywordsPredicate;
import seedu.address.model.person.predicates.NameContainsKeywordsPredicate;
import seedu.address.model.person.predicates.PhoneContainsNumberPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DONE,
                        PREFIX_ADDRESS, PREFIX_GENDER, PREFIX_AGE, PREFIX_INTEREST);

        if (!arePrefixesPresent(argMultimap) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        String nameKeywords = argMultimap.getValue(PREFIX_NAME).orElse(null);
        String phoneNumbers = argMultimap.getValue(PREFIX_PHONE).orElse(null);
        String emailKeywords = argMultimap.getValue(PREFIX_EMAIL).orElse(null);
        String doneKeywords = argMultimap.getValue(PREFIX_DONE).orElse(null);
        String addressKeywords = argMultimap.getValue(PREFIX_ADDRESS).orElse(null);
        String genderKeywords = argMultimap.getValue(PREFIX_GENDER).orElse(null);
        String ageValues = argMultimap.getValue(PREFIX_AGE).orElse(null);
        String interestKeywords = argMultimap.getValue(PREFIX_INTEREST).orElse(null);

        Predicate<Person> predicate;


        if (nameKeywords != null) {
            predicate = getNamePredicate(nameKeywords.toLowerCase(Locale.ROOT));
        } else if (phoneNumbers != null) {
            predicate = getPhonePredicate(phoneNumbers.toLowerCase(Locale.ROOT));
        } else if (emailKeywords != null) {
            predicate = getEmailPredicate(emailKeywords.toLowerCase(Locale.ROOT));
        } else if (doneKeywords != null) {
            predicate = getDonePredicate(doneKeywords.toLowerCase(Locale.ROOT));
        } else if (addressKeywords != null) {
            predicate = getAddressPredicate(addressKeywords.toLowerCase(Locale.ROOT));
        } else if (genderKeywords != null) {
            predicate = getGenderPredicate(genderKeywords.toLowerCase(Locale.ROOT));
        } else if (ageValues != null) {
            predicate = getAgePredicate(ageValues.toLowerCase(Locale.ROOT));
        } else if (interestKeywords != null) {
            predicate = getInterestPredicate(interestKeywords.toLowerCase(Locale.ROOT));
        } else {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        return new FindCommand(predicate);
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

    private NameContainsKeywordsPredicate getNamePredicate(String nameKeywords) {
        String[] nameKeywordsArr = nameKeywords.split("\\s+");
        return new NameContainsKeywordsPredicate(Arrays.asList(nameKeywordsArr));
    }

    private PhoneContainsNumberPredicate getPhonePredicate(String numbers) {
        String[] numbersArr = numbers.split("\\s+");
        return new PhoneContainsNumberPredicate(Arrays.asList(numbersArr));
    }

    private EmailContainsKeywordsPredicate getEmailPredicate(String emailKeywords) {
        String[] emailKeywordsArr = emailKeywords.split("\\s+");
        System.out.println("hello");
        return new EmailContainsKeywordsPredicate(Arrays.asList(emailKeywordsArr));
    }

    private DonePredicate getDonePredicate(String doneKeywords) {
        String[] doneKeywordsArr = doneKeywords.split("\\s+");
        return new DonePredicate(Arrays.asList(doneKeywordsArr));
    }

    private AddressContainsKeywordsPredicate getAddressPredicate(String addressKeywords) {
        String[] addressKeywordsArr = addressKeywords.split("\\s+");
        return new AddressContainsKeywordsPredicate(Arrays.asList(addressKeywordsArr));
    }

    private GenderContainsKeywordPredicate getGenderPredicate(String genderKeywords) {
        String[] genderKeywordsArr = genderKeywords.split("\\s+");
        return new GenderContainsKeywordPredicate(Arrays.asList(genderKeywordsArr));
    }

    private AgeContainsValuePredicate getAgePredicate(String ageValues) {
        String[] ageValuesArr = ageValues.split("\\s+");
        return new AgeContainsValuePredicate(Arrays.asList(ageValuesArr));
    }

    private InterestContainsKeywordsPredicate getInterestPredicate(String interestKeywords) {
        String[] interestKeywordsArr = interestKeywords.split("\\s+");
        return new InterestContainsKeywordsPredicate(Arrays.asList(interestKeywordsArr));
    }

}
