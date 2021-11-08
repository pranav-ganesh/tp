---
layout: page
title: Pranav's Project Portfolio Page
---

### Project: CallMeMaybe

CallMeMaybe (CMM) is a desktop application developed for freelance telemarketers that aims to enhance the contact tracking process.
While it has a GUI created with JavaFX, most of the user interactions happen via a CLI (Command Line Interface). 
It is written in Java, and has about 15 kLoC.

Given below are my contributions to the project.

* **New Feature**: Implementing the Called command
  * What it does: Allows users to mark the specified contact from the address book as called (i.e. person has already been called)
  * Justification: Telemarketers make numerous calls every single day and must  keep track of who all they called so that they don't
    call the same person more than once and know who they are yet to call. Currently, they make use of long Excel sheets that make the process of contact
    tracking difficult and inefficient. We crafted a user story that strives to make this process of tracking easier as follows,
    'As a telemarketer who has a large number of people to call, I can easily track who I have called so that I don't have to call that person again'.
    This feature enhances the product significantly as it allows telemarketers to keep track of their call history as they can
    mark a contact as 'called' when they are done calling that contact. Therefore, this functionality is an essential part in ensuring
    that telemarketers are easily able to keep track of their call progress during work every day.
  * Highlights: The enhancement did affect the filter command since the filter feature makes use of the 'Called' field to sort contacts.
    Although there were difficulties posed due to the fact that I was new to the codebase, the implementation of this feature was not overly 
   challenging since it didn't require many changes to existing commands and didn't involve many complications.
  

* **New Feature**: Implementing the edit feature for interests list
    * What it does: Allows telemarketers to edit an interests list for every contact in CMM
    * Justification: On an average, telemarketers make several hundreds of calls every single day and most of the customers don't show much 
      interest in the service or product, making the job of telemarketers unproductive and inefficient at times. In an attempt to increase their
      productivity, we decided to include an optional interests list that is associated with every contact in the contact list. The telemarketers 
      can specifically target contacts whose interests are aligned with such a service or product. This will accentuate the probability of successful
      calls. The edit feature significantly improves the product by allowing telemarketers to edit this interests list for every 
      contact by adding, deleting or editing a specific interest whenever they want to.
    * Highlights: This enhancement affects existing commands and commands to be added in the future. It required an in-depth analysis of design 
      alternatives. There were several complications caused by the inclusion of a separate interests list index on top of the contact index.
      Such an index allowed telemarketers to edit the interests list by adding, deleting and editing interest values. One such complication is caused
      when the user attempts to remove, add and edit an interest all in the same command. Particularly, removing an interest can change the size of the
      interests list which can affect further edits and additions. Another complication arises from the fact that a user could make so many kinds of
      errors when typing such a long and convoluted command. For example, they could enter duplicate indexes, duplicate interest arguments, edit a person
      to someone who already exists in the list and many more. All these errors need to be handled and in order to do so, the design of the feature
      implementation is crucial. Overall, the implementation of this feature was challenging due to the several intricacies it involved.
    

* **Code contributed:** [RepoSense link](https://nus-cs2103-ay2122s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&since=2021-09-17&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=false&tabOpen=true&tabType=authorship&tabAuthor=pranav-ganesh&tabRepo=AY2122S1-CS2103T-T13-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false)


* **Enhancements to existing features**:
    * Enhanced the original Edit Command to allow users to edit more fields (age, gender, isCalled, interests list)  (Pull requests [#108](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/108) [\#194](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/194))
    * Wrote additional tests for the Edit Command and Edit Command Parser classes to improve testing (Pull requests [#108](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/108/files) [#187](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/187) [#194](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/194))
    * Added display feature to the Edit Command so that users can view the updated contact details in the full person card [#132](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/132)


* **Documentation**:
    * User Guide:
        * Added documentation for the features `add`, `display`, `edit` `findAny`, `findAll`, `csv import/export`
          [\#95](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/95), [#110](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/110),
          [#111](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/111), [#114](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/114),
          [#115](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/115), [#116](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/116),
          [#117](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/117), [\#118](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/118),
          [#119](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/119/files)
    * Developer Guide:
        * Added implementation details of the `add` feature. [#89](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/89)
        * Updated the diagrams for the model and Ui portions. [#93](https://github.com/AY2122S1-CS2103T-T13-4/tp/pull/93)