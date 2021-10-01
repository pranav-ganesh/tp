---
layout: page
title: User Guide
---

CallMeMaybe (CMM) is a **desktop app centered for Telemarketers in aiding them in customer contact management. 
CMM provides a solution to quickly catalog people based on who has/yet to be called. 
The in-built tracking functionality serves as a reminder to reach back on previously unreachable customers
Importing of existing customer database is also supported by CMM to facilitate team-based environments.

CMM is optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). 

If you can type fast, CMM can get your contact management tasks done faster than traditional GUI apps.


* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start
1. Ensure you have Java 11 or above installed in your Computer.

1. Download the latest CallMeMaybe.jar from [here](https://github.com/AY2122S1-CS2103T-T13-4/tp/releases).

1. Copy the file to the folder you want to use as the home folder for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing help and pressing Enter will open the help window.
   Commands that CallMeMaybe supports:
    - `list` : Lists all contacts.
    - `add n/John Doe p/98765432 e/johnd@example.com`: Adds a contact named John Doe to the Address Book.
    - `delete 3`: Deletes the 3rd contact shown in the current list.
    - `done 2`: Marks the 2nd contact shown in the current list as completed
    - `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

### Adding a person: `add`

Adds a person to the CMM database.

Format: `add n/NAME p/PHONE_NUMBER e/EMAIL`

Examples:
* `add n/John Doe p/98765432 e/johnd@example.com `
* `add n/Betsy Crowe p/1234567 e/betsycrowe@example.com `

**Things to take note:**
* Do Note that Name, Phone_number and email fields are Mandatory

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Marking a person as called : `done`

Marks the specified person from the address book as done

Format: `done INDEX`

**Things to take note:**

* Marks the person at the specified INDEX as completed (AKA person has already been called).
* The index refers to the index number shown in the displayed person list.
* The index must be a positive integer 1, 2, 3, …​

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

Example:
* `delete 2` deletes the 2nd person in the address book.

**Things to take note:**
* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​


### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

CMM data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

## Importing the data

CMM is able to import csv files into the existing database. The files have to be semicolon delimited. 
Instructions on how to import to this file type can be found [here](https://ashwaniashwin.wordpress.com/2013/04/19/save-excel-file-as-a-csv-semicolon-delimited-file-along-with-unicode-encoding/)

### Editing the data file

AddressBook data are saved as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

No FAQ for now
--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME p/PHONE_NUMBER e/EMAIL` <br> e.g., `add n/Labuschagne Ho p/22224444 e/labuschagne@example.com`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Done** | `done INDEX` <br> e.g., `done 2`
**List** | `list`
**Exit** | `exit`
