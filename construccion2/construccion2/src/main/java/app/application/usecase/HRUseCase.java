package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.entities.User;
import app.domain.services.CreateUser;
import app.domain.services.DeleteUser;
import app.domain.services.SearchUser;
import app.domain.services.UpdateUser;

/**
 * Caso de uso para el rol de Recursos Humanos (HR)
 * Funcionalidades: gestión completa de empleados
 */
@Component
public class HRUseCase {
	
	@Autowired
	private CreateUser createUser;
	@Autowired
	private UpdateUser updateUser;
	@Autowired
	private DeleteUser deleteUser;
	@Autowired
	private SearchUser searchUser;
	
	/**
	 * Crear un nuevo empleado en el sistema
	 * Solo usuarios con rol HR pueden ejecutar esta acción
	 * y toca poner el parametro hrUser para que funcione en el hrclient, ya que si solo lo dejamos 
	 * con un solo parametro  nos va dar error en el hrclient al momento de llamar este metodo
	 */
	public void createEmployee(User employee, User hrUser) throws Exception {
		createUser.create(employee);
	}
	
	/**
	 * Actualizar información de un empleado existente
	 * Solo usuarios con rol HR pueden ejecutar esta acción
	 */
	public void updateEmployee(User employee, User hrUser) throws Exception {
		updateUser.update(employee);
	}
	
	/**
	 * Eliminar un empleado del sistema
	 * Solo usuarios con rol HR pueden ejecutar esta acción
	 * No se puede eliminar a otros usuarios administrativos
	 */
	public void deleteEmployee(User employee, User hrUser) throws Exception {
		deleteUser.delete(employee);
	}
	
	/**
	 * Buscar empleado por ID
	 */
	public User searchEmployee(User employee) throws Exception {
		return searchUser.search(employee);
	}
	
	/**
	 * Buscar empleado por documento
	 */
	public User searchEmployeeByDocument(User employee) throws Exception {
		return searchUser.searchByDocument(employee);
	}
	
	/**
	 * Buscar empleado por nombre de usuario
	 */
	public User searchEmployeeByUsername(User employee) throws Exception {
		return searchUser.searchByUsername(employee);
	}

	
}
