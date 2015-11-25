# PCCS-app_project_355
app_project_355 created for PCCS

The goal of this project, Gaming Forecast, is to create an android app that allows gamers to keep in touch while leading a busy,
on the go, care free sort of lifestyle. It allows the user to stay connected to all the games they possibly want, but without
all the hastle of constantly searching up information, release dates, etc.

Created by Pulkit, Chris, Curtis, and Sherdil (AKA PCCS). 
****Now only Pulkit and Sherdil.

***
For the first iteration we started pretty late due to the bike race and some unfortunate circumstances.
We barely had enough time, and not enough people contributed, but we did get the app to work.

The HARDEST part of this is easily the espresso test, just because it's code that most of us can't understand or 
where we should be calling what function.

Next iteration we'll start earlier. Like... right away. - Pulkit R

***
********
IMPORTANT: PLEASE RUN THE APP THROUGH THE Banner.class AND NOT THROUGH MAIN ACTIVITY!
YOU CAN SET YOUR APP TO RUN, BUT RUN THROUGH Banner AND NOT MAIN ACTIVITY IN ANDROID STUDIO OR IT WILL NOT DISPLAY!
********

For the second iteration two of our group members left... so that was pretty bad. We worked pretty hard over the last three days creating the banner,
most popular tab, and search function/filter tab. I talked to Professor Kostadin about some things which I'll now discuss.

He told me to mention that one of our group members left over the weekend, so we had some trouble creating the banner and some espresso tests for it.
We finished the banner, but could not do the espresso tests for the banner. 
Please take the time constraint into consideration, seeing as ANOTHER member left and we now have two!!! Everything else is completed!

Professor Kostadin also told me to mention that the banner CANNOT have a sad path, which I told him. It uses your computers date/time setting and
compares it to a string/array, and if the time/date matches the string it displays a banner. THERE CANNOT BE USER ERROR HERE besides the creators when
making the product list array. If I put 31/31/31, yes the banner will never show up. I however did not do that, so the user will always get a banner on 
the correct date UNLESS they change the time/date setting on there device/computer.
The requirement was 1 sad path per user story, BUT THAT WAS NOT POSSIBLE FOR THE BANNER.

There's two of us now, so I guess the hardest part was that. Hopefully we can finish the 3rd iteration on time, and we plan on starting a lot earlier.

***

WE DID NOT INCLUDE OUR TDD AS PART OF THE 9 ESPRESSO TESTS. WE HAVE 14 TESTS TOTAL. PLEASE READ THIS. 9 ESPRESSO TESTS, 5 TDD USING MOCK OBJECTS!
THESE 5 TDD ARE NOT ON GITHUB OR ANY OF THE ITERATIONS BECAUSE WE USED 9 ESPRESSO TESTS FOR THOSE.

For the third and final iteration we ran into a lot of trouble with the unit tests.. there aren't any resources online. Like none.
Why were these put in this iteration? Who knows? Why would we need to test things before we develop them.. who knows?

It was just me and Sherdil for this iteration so we had a huge workload for just 2 people. The coding was easy, but no help was given for the unit
tests like I mentioned. I'm not sure how to properly use mockito, and I'm not sure our app has any methods that you can actually test without the app being run
since it uses arraylists with created products... 
Other then that I cleaned up the app, moved the banner into the main activity, made the code cleaner, added fonts, backgrounds, and ofcourse our 3 scenarious.
Looks good, but I plan to keep on working on it just for future reference and technique improvement.

A note to the tester. When you do the tests please make sure you manually open up the app, go to the favorites tab, and make sure nothing is favorited.
Do this by long clicking each item in it until it says the tab is empty.
ALL OF THE TESTS PASS. DO NOT SAY THEY DO NOT PASS. It is your fault if they don't pass. Last iteration you guys said they didn't pass, but they did. 
I didn't bring it up because we still got a 100, but this time make sure nothing is in your favorites tab on the app.

We also couldn't have a sad path for one of the "No Upcoming Games" tab. It was coded too well and I didn't think I could find any user errors for the tab.
I asked Prof Damevski if it was ok, like it.2, and he said it was. Enjoy testing it - Pulkit Rustgi