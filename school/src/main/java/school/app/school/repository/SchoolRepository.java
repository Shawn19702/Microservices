package school.app.school.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import school.app.school.model.School;
@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    School findSchoolByschoolCode(String schoolCode);
}
