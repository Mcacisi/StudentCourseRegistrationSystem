
package mcacisi.Backend;

import java.util.ArrayList;
import mcacisi.CustomExceptions.DataStorageException;
import mcacisi.CustomExceptions.NotFoundException;

/**
 *
 * @author Mcacisi Sithole
 */
public class serviceLayer {
    
         //INVOKE ALL THE DA METHODS SINCE PD IS THE MIDDLEMAN
     public static void initializeConnection() throws DataStorageException {
        StudentDA.initializeConnection();
     }

       public static void createDatabaseTable() throws DataStorageException {
         StudentDA.createDatabaseTable();
       }

     public static void add(StudentPD stud) throws DataStorageException{
        StudentDA.add(stud);
     }

     public static ArrayList<StudentPD> getAll() throws DataStorageException{
         return StudentDA.getAll();
     }

     public static void update(StudentPD stud) throws DataStorageException, NotFoundException {
        StudentDA.update(stud);
     }

     public static void delete(int student_No) throws DataStorageException,NotFoundException{
        StudentDA.delete(student_No);
     }

    public static void search(int student_No) throws DataStorageException,NotFoundException {
        StudentDA.search(student_No);
    }
}
