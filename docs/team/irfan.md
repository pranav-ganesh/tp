---
layout: page
title: Irfan's Project Portfolio Page
---

### Project: CallMeMaybe

CallMeMaybe (CMM) is a **desktop app** centered for Telemarketers in aiding them in customer contact management.
The in-built tracking functionality serves as a reminder to reach back on previously unreachable customers.
Importing and exporting of existing customer database is also supported by CMM to facilitate team-based environments.
The user interacts with it using a CLI, and it has a GUI created with JavaFX. This It is written in Java, and has about
16 kLoC. The development of this software was used as a medium for students to apply Software Engineering principles
taught during the Software Engineering Modulde CS2103T.

Given below are my contributions to the project.

* **New Feature**: Added Importing functionality
  * What it does: Allows users to input contacts CMM's database quickly. CMM currently imports from Excel Files only
  * Justification: Based on the user story, a telemarketer receives daily call list in an Excel sheet. It required an 
    in-depth analysis of design alternatives. This function is an integral part in  ensuring a smooth transition
    between the manager to the telemarketer. This process reduces learning curve, as well as overall time of adding in
    contacts (previously the two options were to either learn json or to manually input  all the data) 
  * Highlights: This enhancement affects existing commands and commands to be added in the future. The type of data
    imported will affect what and how the commands interact with the data found in CMM. This enhancement will also be
    relevant and often updated as long as CallMeMaybe uses a local storage, and the company  processes  include  Excel
    sheets  in storing customer data. The implementation was challenging as it required constant updating and tweaking
    as the team's definition of a valid person  to be imported constantly changed throughout the project
  * Credits: *The previous iteration CallMeMaybe (AddressBookLevel3) 's JSONstorage helped me structure my ImportExport
    feature. This taught me how to follow an existing architectural style while implementing a new feature. It also
    helped me rethink the way I approach code abstractions way before the CS2103T's lecture of code architecture*

* **New Feature**: Added Exporting functionality
  * What it does: Allows users to export contacts CMM's database quickly. CMM currently export to Excel Files only
  * Justification: Based on the user story, a telemarketer returns to the manager the daily call list in an Excel sheet.
    This function is an integral part in  ensuring a smooth transition between telemarketers to the marketers. This
    function also allows working with other telemarketers that has yet to migrate over to CMM to be a seamless process
    and workflow will not be interrupted even if CMM was introduced  into the company processes overnight. The Export
    function also acts as a safety net should telemarketers wish to start a new database with imported contacts.
    CMM will immediately export the  current database in an excel file before wiping and introducing new contacts into
    the database 
  * Highlights: This enhancement affects existing commands and commands to be added in future. It required an in-depth 
    analysis of design alternatives. The implementation too was challenging as it required changes to existing commands.
  * Credits: *The previous iteration CallMeMaybe (AddressBookLevel3) 's JSONstorage helped me structure my ImportExport
    feature. This taught me how to follow an existing architectural style while implementing a new feature. It also
    helped me rethink the way I approach code abstractions way before the CS2103T's lecture of code architecture*
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/#breakdown=true&search=idgrr)

* **Project management**:
  * Managed releases `v1.3` - `v1.4` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Updated the GUI resizing functionality to ensure that features can always be displayed
  * Wrote additional tests for existing features such as CsvUtil, CsvAdaptedPerson, CsvAddressBook

* **Documentation**:
  * User Guide:
    * Added documentation for the features `import` and `export` and `findAny`
      PR for reference:
      [findAny](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/131/files)
      
    * Did cosmetic tweaks to existing documentation of features `clear`, `exit`: [\#74]()
  * Developer Guide:
    * Added implementation details of the `import` and `export` feature.

* **Community**:
  * PRs reviewed (with non-trivial review comments): [\#12](), [\#32](), [\#19](), [\#42]()
  * Reported bugs and suggestions for other teams in the class (examples: [1](), [2](), [3]())
  * Some parts of the history feature I added was adopted by several other class mates ([1](), [2]())

* **Tools**:
  * Integrated a third party library (Natty) to the project ([\#42]())
  * Integrated a new Github plugin (CircleCI) to the team repo
