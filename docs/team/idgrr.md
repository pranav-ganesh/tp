---
layout: page
title: Irfan's Project Portfolio Page
---

### Project: CallMeMaybe

CallMeMaybe (CMM) is a **desktop app** centered for Telemarketers in aiding them in customer contact management.
The in-built tracking functionality serves as a reminder to reach back on previously unreachable customers.
Importing and exporting of existing customer database is also supported by CMM to facilitate team-based environments.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. This is written in Java, and has about
16 kLoC. The development of this software was used as a medium for students to apply Software Engineering principles
taught during the Software Engineering Module CS2103T.

Given below are my contributions to the project.

* **New Feature**: Added Importing functionality
  * What it does: Allows users to import contacts into CMM's database quickly. CMM currently imports from Excel Files only
  * Justification: Based on the user story, a telemarketer receives his/her daily call list in an Excel sheet. This
    function is an integral part in  ensuring a smooth transition between the manager and the telemarketer. This
    function allows user to import multiple people at once, as compared to adding in contacts individually
    (previously the two options were to either learn json or to manually input all the data using the add function)
  * Highlights: This enhancement affects existing commands to will be added in the future. The type of data
    imported will affect how the commands interact with the data found in CMM. This enhancement will also be
    relevant and often updated as long as CMM uses a local storage, and the company processes continues with using Excel
    sheets for storing customer data. The implementation was challenging as it required constant updating and tweaking
    as the team's definition of a valid person to be imported constantly changed throughout the project
  * Credits: The previous iteration CallMeMaybe (AddressBookLevel3) 's JSON storage architecture helped me structure
    my Import feature. This taught me how to follow an existing architectural style while implementing a new
    feature. It also helped me rethink the way I approach code abstractions.

* **New Feature**: Added Exporting functionality
  * What it does: Allows users to export contacts found in CMM's database quickly. CMM currently export to Excel Files only
  * Justification: Based on the user story, a telemarketer returns the daily call list in an Excel sheet to the manager.
    This function is an integral part in ensuring a smooth transition between telemarketers back to managers. This
    is achieved by the seamless data conversion between Excel and CMM. This is important as managers will accept Excel
    files. The Export function also acts as a safety net should telemarketers wish to start a new database with imported
    contacts. CMM will immediately export the current database in an Excel file before wiping and introducing new
    contacts into the database.
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth 
    analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: The previous iteration CallMeMaybe (AddressBookLevel3) 's JSON storage architecture  helped me structure
    my Export feature. This taught me how to follow an existing architectural style while implementing a new 
    feature. It also helped me rethink the way I approach code abstractions.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/#breakdown=true&search=idgrr)

* **Project management**:
  * Managed releases `v1.1` - `v1.4` (4 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI resizing functionality to ensure that features can always be displayed
  * Wrote additional tests for existing features such as CsvUtil, CsvAdaptedPerson, CsvAddressBook


* **Documentation**:
  * User Guide:
    * Added documentation for the features `import` and `export` and `findAny`
      PR for reference:<br>
      * [Documentation for findAny command](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/131/files) <br>
      * [Documentation for import function](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/109/files) <br>
      * [Documentation for export function](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/97/files) <br>
  * Developer Guide:
    * Added implementation details of the `import` and `export` feature.<br>
      [Implementation details for ImporExport component](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/96/files) <br>
      [Added product usecases](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/32/files) <br>


* **Community**:
  * Examples of PRs reviewed (with non-trivial review comments): <br>
    [Reviewing find command](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/175) <br>
    [Reviewing Add command](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/89) <br>
    [Reviewing DG](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/93) <br>
    [Reviewing Addition of new Attributes](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/67) <br>
    [Reviewing testcases](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/38) <br>
    [Reviewing Storage](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/34) <br>
    
