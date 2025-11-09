package app.adapter.out;

import app.domain.entities.User;
import app.domain.ports.UserPort;

public class UserAdapter implements UserPort {
	
	private final UserRepository userRepository;

	@Override
	public User findById(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByDocument(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}
	


}
