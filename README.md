# Browser history kata

**Draft**

## Summary

Create a class named `BrowserHistory` which is limited in size and drops least frequent visited urls

## Rules

- A newly created browser history is empty
- A visited site can be added through the following function `add(String url)`
- The number of urls of recent visited websites can be retrieved through `size()`
- The recent visited sites can be retrieved through `findAll()` where the most recent one is the first entry and the least recent one the last entry *LiFo* 
- The maximum number of entries is fixed to a constant value (let's assume i.e. 5 urls)
- If more than 5 entries were added to the history the least recent visited will be dropped
- A revisit on a site (calling add function with same url again) will *refresh* the entry and move it to the most recent position
- The most recent sites can be retrieved through a function `getRecentVisited(int index)`
    - Passing an index that is bigger that is above the current size and within the limit (0..4) will throw an Exception
    - Passing an index that is negative or above 5 will throw an IllegalArgumentException
    - Passing an index between 0 and 4 will return the entry

## Bonusses

- A function named `numberVisits(String url)` returns the number of times a site has been visited 
  - if a url was dropped the counter will start from zero again
  - given an url which is not part of the history it will return zero 
- The number of entries can be specified during construction time
- The number of entries can be after the construction if the object: On shrinking present entries will be dropped.
