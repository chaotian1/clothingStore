SUMMARY
For my application time was a big factor. I had a total of 4 hours to complete this project due to my other work commitments. To finish the minimum viable project I attempted to finish the 2 most important user stories. The API documentation provided stopped working for some reason and so i could not read the documentation provided. I was able to complete the first user story but the second story, adding items to the cart displays a 404 error. I was not sure how the request should be formatted so i had to keep making gueses as to what the rest api could be. 

IMPLEMENTATION
For the application i decided to go with a nested scrolling view. I had experimented using a recycleview adapter and then populating each set of products with their own onclickable event but in the end it produced lots of code and I figured there must be a more efficient way of implementing it. To this degree I went with the unintuitive way of adding things to a basket, by using a floating action button. This was mainly due to time constraints and also because my primary focus was learning how to implement retrofit and finding out what the post request body could be.

RETROSPECTIVE
1. I would have liked to implement the project in MVVM but setting up projects with architecture patterns is not something i have done before as the applications ive already worked on have already been structured for me. To that end i can now appreciate how good architecutre helps with maintability, my current soultion puts too much of the logic in the HomeActivity class. There should be a greater seperatation between the UI and buisness logic. 

2. Before yesturday i had never implemented retrofit in the vanilla way, so learning to implement it for the first time was alot of fun. The senior developers are often the ones that handle setting up the adapters for rxjava or coroutines when a project is underway so its not something I've had much experience in but ive had a great time this afternoon doing this task.

3.Similar to point 2 is the senior developers being responsible for writing unit tests for their portion of work and so to that end, again i dont usually write unit tests for api calls. I did experiment with roboelectric and mockito earlier to see if i could replicate it but Roboelectric is a new library to me and so It would have taking too much time. 



