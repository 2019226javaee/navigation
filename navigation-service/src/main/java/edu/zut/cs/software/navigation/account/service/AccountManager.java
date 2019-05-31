package edu.zut.cs.software.navigation.account.service;
import java.util.List;
import edu.zut.cs.software.navigation.admin.account.daomain.Account;
import edu.zut.cs.software.navigation.base.service.GenericManager;
public interface AccountManager extends GenericManager<Account,Long> {

	String sayHello(String name);

	List<Account> getAll();
}
