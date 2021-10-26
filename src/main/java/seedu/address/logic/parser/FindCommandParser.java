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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.FindCommand;
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

        ArrayList<Predicate<Person>> predicates = new ArrayList<>();

        if (nameKeywords != null) {
            NameContainsKeywordsPredicate namePredicate = getNamePredicate(nameKeywords.toLowerCase(Locale.ROOT));
            predicates.add(namePredicate);
        }
        if (phoneNumbers != null) {
            PhoneContainsNumberPredicate phonePredicate = getPhonePredicate(phoneNumbers.toLowerCase(Locale.ROOT));
            predicates.add(phonePredicate);
        }
        if (emailKeywords != null) {
            EmailContainsKeywordsPredicate emailPredicate = getEmailPredicate(emailKeywords.toLowerCase(Locale.ROOT));
            predicates.add(emailPredicate);
        }
        if (doneKeywords != null) {
            DonePredicate donePredicate = getDonePredicate(doneKeywords.toLowerCase(Locale.ROOT));
            predicates.add(donePredicate);
        }
        if (addressKeywords != null) {
            AddressContainsKeywordsPredicate addressPredicate = getAddressPredicate(
                    addressKeywords.toLowerCase(Locale.ROOT)
            );
            predicates.add(addressPredicate);
        }
        if (genderKeywords != null) {
            GenderContainsKeywordPredicate genderPredicate = getGenderPredicate(
                    genderKeywords.toLowerCase(Locale.ROOT)
            );
            predicates.add(genderPredicate);
        }
        if (ageValues != null) {
            AgeContainsValuePredicate agePredicate = getAgePredicate(ageValues.toLowerCase(Locale.ROOT));
            predicates.add(agePredicate);
        }
        if (interestKeywords != null) {
            InterestContainsKeywordsPredicate interestPredicate = getInterestPredicate(
                    interestKeywords.toLowerCase(Locale.ROOT)
            );
            predicates.add(interestPredicate);
        }

        // Checks if the user passed in any valid prefixes and arguments
        if (predicates.size() == 0) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }

        CombinedPredicate combinedPredicate = new CombinedPredicate(predicates);

        return new FindCommand(combinedPredicate);
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
