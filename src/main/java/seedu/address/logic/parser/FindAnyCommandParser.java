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
import java.util.Locale;
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
public class FindAnyCommandParser implements Parser<FindAnyCommand> {

    public static final String EMPTY_FIELD_MESSAGE = "Fields provided can be anything but cannot be an empty string \n"
            + "Found one violation at: ";

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindAnyCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_DONE,
                        PREFIX_ADDRESS, PREFIX_GENDER, PREFIX_AGE, PREFIX_INTEREST);

        if (!ParserUtil.arePrefixesPresent(argMultimap) || !argMultimap.getPreamble().isEmpty()) {
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
            ParserUtil.checkEmptyString(nameKeywords, PREFIX_NAME);
            NameContainsKeywordsPredicate namePredicate = ParserUtil.getNamePredicate(nameKeywords, false);
            predicates.add(namePredicate);
        }
        if (phoneNumbers != null) {
            ParserUtil.checkEmptyString(phoneNumbers, PREFIX_PHONE);
            PhoneContainsNumberPredicate phonePredicate = ParserUtil.getPhonePredicate(phoneNumbers, false);
            predicates.add(phonePredicate);
        }
        if (emailKeywords != null) {
            ParserUtil.checkEmptyString(emailKeywords, PREFIX_EMAIL);
            EmailContainsKeywordsPredicate emailPredicate = ParserUtil.getEmailPredicate(emailKeywords, false);
            predicates.add(emailPredicate);
        }
        if (doneKeywords != null) {
            ParserUtil.checkEmptyString(doneKeywords, PREFIX_DONE);
            ParserUtil.checkTrueOrFalse(doneKeywords);
            DonePredicate donePredicate = ParserUtil.getDonePredicate(doneKeywords, false);
            predicates.add(donePredicate);
        }
        if (addressKeywords != null) {
            ParserUtil.checkEmptyString(addressKeywords, PREFIX_ADDRESS);
            AddressContainsKeywordsPredicate addressPredicate = ParserUtil.getAddressPredicate(addressKeywords, false);
            predicates.add(addressPredicate);
        }
        if (genderKeywords != null) {
            ParserUtil.checkEmptyString(genderKeywords, PREFIX_GENDER);
            ParserUtil.checkMaleOrFemale(genderKeywords);
            GenderContainsKeywordPredicate genderPredicate = ParserUtil.getGenderPredicate(genderKeywords, false);
            predicates.add(genderPredicate);
        }
        if (ageValues != null) {
            ParserUtil.checkEmptyString(ageValues, PREFIX_AGE);
            AgeContainsValuePredicate agePredicate = ParserUtil.getAgePredicate(ageValues, false);
            predicates.add(agePredicate);
        }
        if (interestKeywords != null) {
            ParserUtil.checkEmptyString(interestKeywords, PREFIX_INTEREST);
            InterestContainsKeywordsPredicate interestPredicate = ParserUtil.getInterestPredicate(interestKeywords, false);
            predicates.add(interestPredicate);
        }

        CombinedPredicate combinedPredicate = new CombinedPredicate(predicates, false);

        return new FindAnyCommand(combinedPredicate);
    }
}
