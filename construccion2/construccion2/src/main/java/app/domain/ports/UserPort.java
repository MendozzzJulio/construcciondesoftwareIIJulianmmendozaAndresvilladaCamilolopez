package app.domain.ports;


import app.domain.entities.User;


public interface UserPort {
	
	public User findById(User user) throws Exception;
	public User findByDocument(User user) throws Exception;
	public User findByUsername(User user) throws Exception;
	public void save(User user) throws Exception;


}
