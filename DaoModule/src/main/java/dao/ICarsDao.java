package dao;

import data.Users;
import exception.DaoException;


public interface ICarsDao{

	public Users logUser(String email, String pas) throws DaoException;
}
