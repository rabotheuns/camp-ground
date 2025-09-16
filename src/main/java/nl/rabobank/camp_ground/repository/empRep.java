package nl.rabobank.camp_ground.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import nl.rabobank.camp_ground.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class empRep {

    @Autowired
    private EntityManager ENT;

    public List<Employee> find(String username) {
        String queryStr = "SELECT * FROM employee WHERE username = '" + username + "'";
        Query query = ENT.createNativeQuery(queryStr, Employee.class);
        return query.getResultList();
    }

    public List<Employee> findByUsernameAndPassword(String username, String password) {
        String queryStr = "SELECT * FROM employee WHERE username = '" + username + "' and password = '" + password + "'";
        Query query = ENT.createNativeQuery(queryStr, Employee.class);
        return query.getResultList();
    }
}
