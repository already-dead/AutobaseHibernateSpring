package dao;

import data.Users;
import exception.DaoException;


public interface IFlightsDao{

	public Users logUser(String email, String pas) throws DaoException;
}
