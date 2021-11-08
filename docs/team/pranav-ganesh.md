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
    The implementation of this feature was tricky but not overly challenging since it didn't require many changes to existing commands.
  
* **New Feature**: Implementing the edit feature for interests list
    * What it does: Allows users to mark the specified contact from the address book as called (i.e. person has already been called)
    * Justification: Telemarketers make numerous calls every single day and must  keep track of who all they called so that they don't
      call the same person more than once and know who they are yet to call. Currently, they make use of long Excel sheets that make the process of contact
      tracking difficult and inefficient. We crafted a user story that strives to make this process of tracking easier as follows,
      'As a telemarketer who has a large number of people to call, I can easily track who I have called so that I don't have to call that person again'.
      This feature enhances the product significantly as it allows telemarketers to keep track of their call history as they can
      mark a contact as 'called' when they are done calling that contact. Therefore, this functionality is an essential part in ensuring
      that telemarketers are easily able to keep track of their call progress during work every day.
    * Highlights: The enhancement did affect the filter command since the filter feature makes use of the 'Called' field to sort contacts.
      The implementation of this feature was tricky but not overly challenging since it didn't require many changes to existing commands.
    