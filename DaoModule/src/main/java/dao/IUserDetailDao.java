package dao;

import data.Users;
import exception.DaoException;


public interface IUserDetailDao{

	public Users logUser(String email, String pas) throws DaoException;
}
