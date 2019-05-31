# healthTracker-backend

## Description

REST controller that handles the backend of the health tracker application
  * `GET` route
    * can be tested in postman by calling `localhost:8080/exercise/all`
    * will return a list of all exercises in the db in JSON form
  * `POST` route
    * can be tested in postman by calling `localhost:8080/exercise/` and adding a JSON formatted exercise under:
      * POST -> body -> raw -> (dropdown) JSON
    
