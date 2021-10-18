---
layout: page
title: User Guide
---

CallMeMaybe (CMM) is a **desktop app** centered for Telemarketers in aiding them in customer contact management.
CMM provides a solution to quickly catalog people based on who has/yet to be called.
The in-built tracking functionality serves as a reminder to reach back on previously unreachable customers
Importing of existing customer database is also supported by CMM to facilitate team-based environments.

CMM is optimized for use via a **Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).

If you can type fast, CMM can get your contact management tasks done faster than traditional GUI apps.


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start
1. Ensure you have Java 11 or above installed in your Computer.

2. Download the latest CallMeMaybe.jar from [here](https://github.com/AY2122S1-CS2103T-T13-4/tp/releases).

3. Copy the file to the folder you want to use as the home folder for your AddressBook.

4. Double-click the file to start the app. A GUI similar to the screenshot below should appear in a few seconds. Note how the app contains some sample data.
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
   Commands that CallMeMaybe supports:
    - `list` : Lists all contacts.
    - `add n/John Doe p/98765432 e/johnd@example.com`: Adds a contact named John Doe to the Address Book.
    - `delete 3`: Deletes the 3rd contact shown in the current list.
    - `done 2`: Marks the 2nd contact shown in the current list as completed
    - `clear` : Deletes all contacts.
    - `exit` : Exits the app.

6. Remember to clear the sample data using `clear` command before adding your own data.

7. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a person: `add`

Adds a person to the CMM database.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL`

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com `
* `add n/Betsy Crowe p/1234567 e/betsycrowe@example.com `

**Things to note:**
* Name, Phone_number and Email fields are mandatory

**Common issues:**
* _Invalid command format!_: </br>
  a. Omitted one or more of the mandatory fields. </br>
  b. Used the wrong prefix. (e.g., '/n' instead of 'n/') </br>

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Marking a person as called : `done`

Marks the specified person from the address book as done

Format: `done INDEX`

Example:
* `done 3` marks the 3rd person in the displayed list as Called.

**Things to note:**

* Marks the person at the specified `INDEX` as completed (i.e. person has already been called).
* `INDEX` refers to the index number shown in the displayed list.
* `INDEX` **must be a positive integer** 1, 2, 3, …​

**Common issues:**
* _The person index provided is invalid_: Displayed list does not contain person at `INDEX`.

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

Example:
* `delete 2` deletes the 2nd person in the displayed list.

**Things to note:**
* Deletes the person at the specified `INDEX`.
* `INDEX` refers to the index number shown in the displayed person list.
* `INDEX` **must be a positive integer** 1, 2, 3, …​

**Common issues:**
* _The person index provided is invalid_: Displayed list does not contain person at `INDEX`.


### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`


### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

CMM data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

## Importing the data

CMM is able to import csv files into the existing database. The files have to be semicolon delimited.

Steps to Import from CSV file
1. Ensure that the Excel file is a CSV file with semicolon delimited.
   Instructions on how to import to this file type can be found [here](https://ashwaniashwin.wordpress.com/2013/04/19/save-excel-file-as-a-csv-semicolon-delimited-file-along-with-unicode-encoding/)
2. Ensure that the import file is named `import.csv` under the "data" folder found in the same directory as the CMM jar file
3. Upon CMM application startup, a prompt will popup asking whether you want to import or not. If yes, the import will add on to the
existing CMM database. Else, nothing would be done
**Do note that**
1. Currently, import is **irreversible**. Please double check before importing
2. CMM will not import data rows with:
   1. Duplicates (Data with the exact name,phone and address already exist in database)
   2. Missing details (Compulsory for data to have name/phone/address filled)
3. CMM will abort import if :
   1. Files has missing headers
      * First row of Excel file is reserved for datatype headers.
      * Headers must include Name, Detail, Phone and isDone from the left to right, Starting from the cell 'A1'
      * Headers are not case-sensitive
4. Import is only allowed during application startup. To import after startup, simply reopen application to get the import prompt

**Common Issues**

1. `CSV file not found in data\import.csv` message was shown.
   * This could either mean that
   the file does not exist at the specified location, or the file was incorrectly named
2. Data not imported despite correct import file placement and naming
   * File may not be in the correct CSV type. Please refer to [Import Setup Procedures](#importing-the-data) step 1
   to correctly format your file.
3. Unable to understand why a specific row was not able to be imported
   * Detailed reasons for any import error can be found in the logs of the CMM

**Future implementations**
1. Exporting current state of the database into a CSV file
### Editing the data file

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder. Data found can be found at `[JAR file location]/data/addressbook.json`.
--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL` <br> e.g., `add n/Labuschagne Ho p/22224444 e/labuschagne@example.com`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Done** | `done INDEX` <br> e.g., `done 2`
**List** | `list`
**Clear** | `clear`
**Exit** | `exit`
**Help** | `help`

</br>
--------------------------------------------------------------------------------------------------------------------
Thank you for reading the User Guide. Hope you have a pleasant experience with CallMeMaybe.
