#Simple  Notes App written in JavaSpring, React. It uses PostgreSQL database. All notes are stored in database including deleted ones and old version od edited notes.

##
Backend repository 
https://github.com/rpajdak/notesApp
##
Frontend repository
https://github.com/rpajdak/notesApp-client

#To start this application it is required to have installed React and Java and PostgreSQL database with created table named "notesapp".;


##Start Frontend part

In the project directory, you can run:
### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.


##Start Backend part

It is recommended to use IntelliJ IDEA to start backend side.


#Database

Tables in database are created automatically by Hibernate framework.

#Curl usage

To add note with method "POST"
"http://localhost:3000/notes" 

To get note by id with method "GET"
"http://localhost:3000/notes/id"

To get all note with method "GET"
"http://localhost:3000/notes" 

To delete note with method "DELETE"
"http://localhost:3000/notes/id"

To update note with method "PUT"
"http://localhost:3000/notes/id"

To get all deleted notes with method "GET"
"http://localhost:3000/notes/deleted"

To history of modified note with method "GET"
"http://localhost:3000/notes/updated/{id}"

View of section to add new note.
![New note](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/addnote.png)

View of section of all notes.
![All notes](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/allNotes.png)

View of section of all deleted notes.
![All notes](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/allDeleted.png)

When "Delete this note" button is clicked-pop-up shows up.
![All notes](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/deletedNote.png)

View of section to edit note.
![All notes](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/editNote.png)

View of history of edited note.
![All notes](https://github.com/rpajdak/notesApp/blob/dev/src/main/assets/historyOfUpdated.png)


 
