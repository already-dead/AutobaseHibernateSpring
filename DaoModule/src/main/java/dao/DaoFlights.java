package dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import base.BaseDao;
import data.Flights;

@Repository("flightsDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DaoFlights extends BaseDao<Flights>{	
	private static DaoFlights thisDao; 

	public DaoFlights() {
		super();
	}
	
	public static  DaoFlights getDaoFlights()
	{
		if(thisDao == null)
			thisDao = new DaoFlights();
		return thisDao;
	}
	

}

