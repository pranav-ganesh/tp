---
layout: page
title: User Guide
---

CallMeMaybe (CMM) is a **desktop app** centered for Telemarketers in aiding them in customer contact management.
CMM provides a solution to quickly catalog people based on who has/yet to be called.
The in-built tracking functionality serves as a reminder to reach back on previously unreachable customers
Importing and exporting of existing customer database is also supported by CMM to facilitate team-based environments.

CMM is optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).

If you can type fast, CMM can get your contact management tasks done faster than traditional GUI apps.


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start
1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest CallMeMaybe.jar from [here](https://github.com/AY2122S1-CS2103T-T13-4/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your AddressBook.

4. Double-click the file to start the app. Initially, a popup asking to import CSV data would appear. To learn more about
   importing CSV data, click [here](#importing-the-data-into-database). Otherwise, to quickly get started, simply click any button on the popup and a GUI similar to the screenshot below should appear in a few seconds. Note how the app contains some sample data.
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
   Commands that CallMeMaybe supports:
   - `add n/John Doe p/98765432 e/johnd@example.com` : Adds a contact named John Doe to the CMM database.
   - `list` : Lists all contacts.
   - `done 2` : Marks the 2nd contact shown in the current list as completed.
   - `edit 1 n/Bob p/62353535` : Edits the name and phone number of the first person in the displayed list.
   - `delete 3` : Deletes the 3rd contact shown in the current list.
   - `display 4` : Displays the full contact details of the fourth contact in the displayed list.
   - `clear` : Deletes all contacts.
   - `exit` : Exits the app.

7. Remember to clear the sample data using `clear` command before adding your own data.

8. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [g/GENDER]` can be used as `n/John Doe g/M` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[i/INTEREST]…​` can be used as ` ` (i.e. 0 times), `i/running`, `i/running i/watching tv` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command is specified multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help`

Shows a message explaining how to access the User Guide.

![help message](images/helpMessage.png)

Format: `help`

### Adding a contact: `add`

Adds a contact to the CMM database.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL [a/ADDRESS] [g/GENDER] [age/AGE] [i/INTEREST]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A contact can have multiple interests (including 0)
</div>

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com `
* `add n/Betsy Crowe p/1234567 e/betsycrowe@example.com a/her house i/running i/swimming i/eating`

**Things to note:**
* `Name`, `Phone_number` and `Email` fields are mandatory
* `Address`, `Gender`, `Age`, `Interest` fields are optional

**Common issues:**
* _Invalid command format!_: <br />
  a. Omitted one or more of the mandatory fields <br />
  b. Used the wrong prefix. (e.g., '/n' instead of 'n/') <br />

### Listing all contacts : `list`

Shows a list of all contacts in the CMM database.

Format: `list`

**Things to note:**
* `list` shows all contacts in ascending order by name.

### Marking a person as called : `done`

Marks the specified contact from the address book as done (i.e. person has already been called).

Format: `done INDEX`

Example:
* `done 3` marks the 3rd contact in the displayed list as Called.

**Things to note:**

* `INDEX` refers to the index number shown in the displayed list.
* `INDEX` **must be a positive integer** 1, 2, 3, …​

**Common issues:**
* _The index provided is invalid_: <br />
  a. Displayed list does not contain person at `INDEX`.

### Editing a contact : `edit`

Edits an existing contact in the CMM database.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [g/GENDER] [age/AGE] [d/DONE] [i/[INTERESTSLIST INDEX] INTEREST]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Specifying [INTERESTLIST INDEX] is optional as well. <br/>
If [INTERESTLIST INDEX] is specified, the interest at that index would be updated. <br/>
If it is not, then an interest would be added instead. <br/>
You can refer to the examples below for a better understanding.
</div>

Examples:
* `edit 1 n/Malan i/[2] Swimming` edits the name of person and the second interest of the first contact in the displayed list
* `edit 1 i/Painting i/[1] Running` adds 'painting' as an interest and edits the first interest of the first contact in the displayed list
* `edit 2 g/M e/myEmail@email.com age/55` edits the gender, email and age of the second contact in the displayed list

**Things to note:**

* `INDEX` refers to the index number shown in the displayed list.
* `INDEX` **must be a positive integer** 1, 2, 3, …​
* `INTERESTSLIST INDEX` refers to the index number shown in the displayed interests list of the contact.
* `INTERESTSLIST INDEX` **must be a positive integer** 1, 2, 3, …​
*  The Interests list of a contact can be found here (refer to the screenshot below) and can be displayed by using the [display command](#displaying-full-contact-details--display)
   ![interestsList](images/interestsList.png)


**Common issues:**
* _The index provided is invalid_: <br />
  a. Displayed list does not contain person at `INDEX`.
* _The interests list index provided is invalid_: <br />
  a. Displayed interests list does not contain an interest at `INTERESTSLIST INDEX`.
* _Invalid command format!_: <br />
  a. No fields provided <br />
  b. Used the wrong prefix. (e.g., 'i/(1)' instead of 'i/[1]') <br />
* _Invalid command arguments_: <br />
    a. Duplicate of the edited person already exists on the address book. <br />

### Finding a contact: `find`

Format: `find [n/NAME...] [p/PHONE...] [e/EMAIL...] [a/ADDRESS...] [g/GENDER…​] [age/AGE…​] [d/DONE…​] [i/INTEREST…​]`

### Deleting a contact : `delete`

Deletes the specified contact from the CMM database.

Format: `delete INDEX`

Example:
* `delete 2` deletes the 2nd contact in the displayed list.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:** Deleting is irreversible,
please use with caution.
</div>

**Things to note:**
* `INDEX` refers to the index number shown in the displayed person list.
* `INDEX` **must be a positive integer** 1, 2, 3, …​

**Common issues:**
* _The index provided is invalid_: <br />
  a. Displayed list does not contain person at `INDEX`.
  
### Finding contacts that matches **ANY** of the keywords specified: `findAny`

Finds persons whose details match any of the fields listed

Format: `findAny [n/NAME…​] [p/PHONE…​] [e/EMAIL…​] [a/ADDRESS…​] [g/GENDER…​] [age/AGE…​] 
[d/DONE…​] [i/INTEREST…​]`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
FndAny requires at least one field. It is optional to include all the fields.
However, to ensure consistency, each field should be written at most once. **If** there are duplicate fields, CMM will
only take the latest field (right-most in CLI)
</div>

* The search is case-insensitive. e.g `hans` will match `Hans`
* Any number of keywords can be specified within each field
* The order of the keywords within each field does not matter. e.g. `n/Hans Bo` will return the same result
as `n/Bo Hans`

Examples:
* `findAny n/John` returns `john` and `John Doe`
* `findAny n/alex david` returns `Alex Yeoh`, `David Li`<br>
* `findAny n/alex david a/woodlands returns `Alex Yeoh`, `David Li` even though Alex lives in Sengkang 
    * Alex Yeoh is returned as Alex satisfies the name field
* `findAny n/alex david e/@yahoo returns `Alex Yeoh`, `David Li` even though Alex lives only has a gmail account
    * Alex Yeoh is returned as Alex satisfies the name field

**Things to note:**
* findAll vs findAny
    * findAll searches for contacts that satisfy **all** the fields specified
    * findAny searches for contacts that satisfy **any** of the fields specified

**Common issues:**
* Wrong command given due to incorrect format. Only `findAny` is accepted.
* No fields provided will result in an error message

### Displaying full contact details : `display`

Displays additional information of a particular contact stored in the application. These include the
address, gender, age and their interests.

The full details of the contact are shown on the right side of the application (inside the white box).
![displayUi](images/displayUi.png)

Format: `display INDEX`

Example:
* `display 3` displays full contact details of the 3rd contact in the displayed list

**Common issues:**
* _The person index provided is invalid_: <br />
  a. Displayed list does not contain person at `INDEX`.

### Filtering contacts : `filter`

Filters the existing contacts in the CMM database. The displayed list will show contacts sorted by the chosen category.

Format: `filter CATEGORY [COUNT]`

Examples:
* `filter called` filters the displayed list to show uncalled contacts first
* `filter called 2` filters the displayed list to show uncalled contacts first and to only show the first two contacts
* `filter gender 3` filters the displayed list to show female contacts first and to only show the first three contacts

**Things to note:**
* `CATEGORY` field is mandatory
* `CATEGORY` refers to the category used to filter the contacts.
* `CATEGORY` **must be one of the following:** called, gender
* `COUNT` refers to the number of contacts to be shown in the displayed list.
* `COUNT` **must be a positive integer** 1, 2, 3, …​
* If more arguments are given than what is required, the last two arguments are taken into account.
  (e.g., `filter gender called 2` will be interpreted as `filter called 2`)
* If the last argument is not an integer, it will be interpreted as a `CATEGORY`.
  (e.g., `filter gender called` will be interpreted as `filter called`)
* If more than one category is entered, the last category will be interpreted as the `CATEGORY`.
  (e.g., `filter gender called 3` will be interpreted as `filter called 3`)


**Common issues:**
* _Category can only be either "called" or "gender"_: <br />
  a. The category specified is not `called` or `gender` <br />
  b. Category not specified
* _Count is not a non-zero unsigned integer_: <br />
  a. The last argument is not a positive integer

### Clearing all contacts : `clear`

Clears all contacts from the CMM database.

Format: `clear`

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:** Clearing is irreversible, please use with caution.
</div>

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

CMM data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Importing the data into database

CMM is able to import CSV files into CMM. The import files have to be in an Excel CSV format (semicolon delimited).

**Steps to Import from CSV file**
1. Ensure that the Excel file is a CSV file with **semicolon delimited**.
   Instructions on how to import to this file type can be found [here](SettingImportFileType.md)
2. Ensure that the import file is named import.csv under the "data" folder found in the same directory as the CMM jar file
3. Upon CMM application startup, a prompt will popup with 3 options : `Add On Imports`, `Start New Using Import`, `Don't Import`

![importPopUpUi](images/importPopUpMessage.png)

**Import options**

`Add On Imports`
- Adds on new imports into existing database

`Start New Using Import`
- Exports and reset the current database. CMM will then populate the reset database with new imports

`Don't Import`
- CMM will not import anything and application will startup normally
- Closing the prompt will also choose this option

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:** Currently, import is **irreversible**. Please double check before importing.
</div>

**Things to note**
* CMM will prompt user for imports upon **every** application startup.
* CMM will not import data rows with missing details (Compulsory for data to have `name`, `phone`, `email` filled)
* CMM will update duplicate imports **only when** import status has been called.
* CMM will abort import if : <br/>
a. Files has missing/invalid headers <br/>
b. First row of Excel file is reserved for datatype headers. <br/>
c. Headers must include `Name`, `Phone`, `Email`, `Address`, `Gender`, `Age`, `Interest` and `isDone` from the left to right, starting from the cell 'A1' <br/>
d. Headers are not case-sensitive<br/>
* Import is only allowed during application startup. To import after the startup, simply reopen application to get the import prompt

**Common Issues**

* `CSV file not found in data\import.csv` message was shown. <br/>
a. This could either mean that the file does not exist at the specified location or <br/>
b. The file was incorrectly named
* Data not imported despite correct import file placement and naming <br/>
a. File may not be in the correct CSV type. Please refer to this [guide](SettingImportFileType.md)
         to correctly format your file.

* Unable to understand why a specific row was not able to be imported <br/>
a. Detailed reasons for any import error can be found in the logs of the CMM


### Exporting state of database
CMM is able to export the current database as semicolon delimited CSV files. As such, there is no need for you to ensure that the formatting is right for furture use.

**Steps to Export data as CSV file**
1. Closing the application in any way would prompt user to export the current database <br/>
![exportPopup](images/exportPopup.png)
2. The CMM will export the database to the data file location
3. Export file will have the following file name : `export[Date HH:MM:SS].csv` where date and time will follow your system settings


### Editing the data file (JSON)

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>


--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder. Data found can be found at `[JAR file location]/data/addressbook.json`.
--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL [a/ADDRESS] [g/GENDER] [age/AGE] [i/INTEREST]…​` <br> e.g. `add n/Labuschagne Ho p/22224444 e/labuschagne@example.com a/my house g/F age/95 i/Sleeping`
**List** | `list`
**Done** | `done INDEX` <br> e.g. `done 2`
**edit** | `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [g/GENDER] [age/AGE] [d/DONE] [i/[INTERESTSLIST INDEX] INTEREST]` <br/> e.g. `edit 1 n/Bob p/68889444 e/email@email.com a/his house  g/M age/33 i/Eating i/[2] Swimming`
**Delete** | `delete INDEX`<br> e.g. `delete 3`
**Display** | `display INDEX` <br> e.g. `display 4`
**Filter** | `filter CATEGORY [COUNT]` <br> e.g. `filter gender 5`
**Clear** | `clear`
**Exit** | `exit`
**Help** | `help`


Thank you for reading the User Guide. Hope you have a pleasant experience with CallMeMaybe.


