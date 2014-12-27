package impl.miw.business;

import impl.miw.business.usermanager.UserManager;

import com.miw.business.ServicesFactory;
import com.miw.business.UserManagerService;

public class SimpleServicesFactory implements ServicesFactory {

	@Override
	public UserManagerService getUserManagerService() {
		return new UserManager();
	}



}
