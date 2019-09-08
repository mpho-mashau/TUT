package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EmployeeEntity;
import model.Employee;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB implements EmployeeEJBLocal {

	@PersistenceContext
	private EntityManager em;
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void addNew(EmployeeEntity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity);
    	System.out.println("============================");
    }
    
    public List<Employee> findEmployees(EmployeeEntity employeeEntity){
    	
		System.out.println("============findEmployees================");    	
    	List<Employee> data = em.createQuery("Select e from Employee e",Employee.class).getResultList();
    	System.out.println(data.get(0));
    	System.out.println(data.get(1));
    	System.out.println(data.get(2));
    	return data;
    }


}
