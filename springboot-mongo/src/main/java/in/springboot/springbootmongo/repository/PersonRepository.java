package in.springboot.springbootmongo.repository;

import in.springboot.springbootmongo.collection.Person;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, Integer> {

//    @Override
    public Person findByFirstNameStartsWith(String firstName);

    public List<Person> findByAgeBetween(Integer minAge, Integer maxAge);

    @Query(value = "{age:{$gt: ?0,$lt: ?1}}", fields = "{age:0}")
    public List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);

}
