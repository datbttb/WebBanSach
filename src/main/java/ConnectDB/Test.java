package ConnectDB;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Sockaddr;

import Dao.AccountDao;
import Dao.SachDao;
import Model.Account;
import Model.Sach;

public class Test {
	public static void main(String[] args) {
		Account ac=new AccountDao().login("datbttb", "123456");
		if(ac==null) {
			System.out.println("That bai");
		}
		else {
			System.out.println(ac.getName());
		}
	}
}
