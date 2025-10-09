# StudentCourseRegistrationSystem
Basic Java Swing used to register students for a course at any Tertiary Institution and save them in a database


TO RUN PROGRAM OR INSTALL
-NetBeans 19, IntelliJ or any platform that has a JVM (Java virtual machine)
 But NetBeans is the best to run Program


FEATURES
-Object Oriented Programming
-Add, search, remove, and update features(CRUD METHODS)
-Uses ArrayList for fast performance and reload purposes
-Uses a binary file to store students for security reasons 
-Solves user error through Exception handling


THE PROBLEMS THAT THE PROGRAM SOLVES
-Faster performance when adding and reloading
-can handle most user errors
-Data integrity and data security



Prerequisites
- Java 11 or higher
- MySQL Server installed and running


  DATABASE SETUPT
1. Ensure MySQL is running on localhost:330
2. Default credentials: username = root, password = ""
3. The application will automatically create the database and tables


  RUNNING
1. Clone this repository
2. Open in IntelliJ IDEA or NetBeans
3. NB: Add `lib/mysql-connector-j-9.4.0.jar` to your project libraries
   - IntelliJ: File → Project Structure → Modules → Dependencies → + → JARs or directories
   - NetBeans: Right-click Libraries → Add JAR/Folder
4. Run the main class


  LIBRARY DEPENDENCY
- MySQL Connector/J 9.4.0 (included in `lib/` folder)


  DATABASE CONFIGURATION
- Database name: `registeredStudent`
- Table: `tblStudents`


  FEATURES
-JDBC API
-XAMP as a server (APACHE & SQL)
-PDDA Classes (3-Tier Architecture Program)


Author: mcacisisithole@gmail.com
