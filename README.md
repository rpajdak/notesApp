#Simple  Notes App written in JavaSpring, React. It uses PostgreSQL database.

#To start this application it is required to have installed React and Java and PostgreSQL database with created table named "notesapp".;

##Start FrontEnd part

In the project directory, you can run:
### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.


##Start BackEnd part

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
 