SUMMARY
For my application, time was a big factor. I had a total of 4 hours to complete this project due to my other work commitments (Tight deadlines at work and 3 other technical assessments due by the end of this week). To finish the minimum viable project I attempted to finish the 2 most important user stories. The API documentation provided stopped displaying correctly about 2 hours in for some reason and so i could not read the documentation provided. I was able to complete the first user story but the second story, adding items to the cart displays a 404 error. I was not sure how the request should be formatted so i had to keep making gueses as to what the rest api could be. 

IMPLEMENTATION
For the application i decided to go with a nested scrolling view. I had experimented using a recycleview adapter and then populating each set of products with their own onclickable event but in the end it produced lots of code and I figured there must be a more efficient way of implementing it. To this degree I went with the unintuitive way of adding things to the shopping cart, by using a floating action button. This was mainly due to time constraints and also because my primary focus was learning how to implement retrofit and finding out what the post request body could be.

RETROSPECTIVE
1. I would have liked to implement the project in MVVM but setting up projects with architecture patterns is not something I have done before as the applications ive worked on in the past have already been structured for me. To that end I can now appreciate how good architecutre helps with maintability, my current soultion puts too much of the logic in the HomeActivity class. There should be a greater seperatation between the UI and buisness logic. 

2. Until today I had never implemented retrofit in the vanilla way, so learning to implement it for the first time was alot of fun. The senior developers are often the ones that handle setting up the adapters for rxjava or coroutines when a project is underway so its not something I've had much experience in but ive had a great time this afternoon doing this task.

3.Similar to point 2, the senior developers are responsible for writing unit tests for their portion of work and so to that end,i dont have many opportunities to write unit tests for api calls. I did experiment with roboelectric and mockito earlier to see if I could mock the api calls but Roboelectric is a new library to me and so It would have taking too much time. 

Thank you for reading! :)



