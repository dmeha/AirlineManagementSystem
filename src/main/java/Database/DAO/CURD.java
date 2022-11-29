package Database.DAO;

import Database.Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CURD {
    //create
    Object createOne(Object singleObject);
    void createMany(List<Object> objects);
    //Read
    User getOneByUsername(String username);
    User getOneById(int id);

    List<Object> getAll();
    //Update
    void FindOneAndUpdate(Object singleObject);
    //Delete
    void findOneAndDelete(Object singleObject);

}
