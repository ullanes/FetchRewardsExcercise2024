# Fetch Rewards Coding Exercise

An Android app that is made in kotlin that retrieves data from a url.

## Requirements
- [X] Display all items grouped by list
- [X] Sort the results by "listId" and then by "name"
- [X] Filter out any items where "name" is blank or null.

**Additional Features** 
- [X] Displayed on emulator
- [X] Used RecyclerView to  display the manipulated list

## Results


## Instructions
1) Clone Repository

   ![alt clone](resources/copy.png)

2) Open project in Android Studios

   ![alt open](resources/open.png)

3) Run app on a Pixel 3a API 30 device

   ![alt run](resources/run.png)

4) Wait for Emulator Run

5) Scroll up and down with mouse to view clean and sorted list

   ![alt running](resources/running.png)


6) To run all unit tests change configuration from app to MainActivityTest

   ![alt test](resources/test.png)


## Unit Test

- Remove All Null Name and  blank names

![alt RemoveTest](resources/removeData.png)


- Add all cleaned json objects into an ArrayList of fetchEx data class

![alt addTest](resources/addData.png)



- Sort the Arraylist by listId then by Name

![alt sortTest](resources/sortData.png)
