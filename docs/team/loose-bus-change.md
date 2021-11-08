---
layout: page
title: Saketh's Project Portfolio Page
---

### Project: CallMeMaybe(CMM)

CallMeMaybe is a desktop application developed for freelance telemarketers.
While it has a GUI, most of the user interactions happen using a CLI (Command Line Interface).
The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 15 kLoC.

Given below are my contributions to the project.

* **Features worked on:**
  * **display command**: Added the ability for users to display additional details about a chosen contact.
      * What it does: Allows the user to view additional information about a particular contact. The additional details include things like
        age, called status, gender, address, interests. The feature allows them to view details of one contact at a time chosen based on index. 
      * Justification: This feature improves the product significantly because often times as a telemarketer you are looking for more information 
        about a particular contact rather than just the name and phone number. The additional information such as age, gender etc. can play a role
        in the telemarketer deciding how to approach calling the particular contact and how to handle the call. 

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=&sort=totalCommits&sortWithin=totalCommits%20dsc&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2021-09-17&tabOpen=true&tabType=authorship&tabAuthor=loose-bus-change&tabRepo=AY2122S1-CS2103T-T13-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other&authorshipIsBinaryFileTypeChecked=false)

* **Team-based tasks**: Updating user/developer docs that are not specific to a feature
    * Modifying target user profile. (Pull requests [#129](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/129/files))
* **Enhancements to existing features**:
    * Modified the original `add` command for the v1.2 release. (Pull requests [#45](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/45))
    * Modified the implementation of the `clear` command to change the updated UI of `display`. (Pull requests [#182](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/182))

* **Documentation**:
    * User Guide:
        * Added documentation for the features `add`, `display`, `list`, `done`, `exit`
          [#13](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/13), [#45](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/45),
          [#107](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/107)
    * Developer Guide:
        * Added implementation details of the `display` feature. [#129](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/129)
        * Diagrams drawn:
          ![Interactions Inside the Logic Component for the `display' Command](images/DisplaySequenceDiagram.png)
          ![DisplayActivityDiagram](images/DisplayActivityDiagram.png)
