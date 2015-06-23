package dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import base.BaseDao;
import data.Cars;

@Repository("carsDao")
@Transactional(propagation = Propagation.MANDATORY)
public class DaoCars extends BaseDao<Cars>{	

	private static DaoCars thisDao; 
	
	public DaoCars() {
		super();
	}
	
	public static  DaoCars getDaoCars()
	{
		if(thisDao == null)
			thisDao = new DaoCars();
		return thisDao;
	}
	

}
