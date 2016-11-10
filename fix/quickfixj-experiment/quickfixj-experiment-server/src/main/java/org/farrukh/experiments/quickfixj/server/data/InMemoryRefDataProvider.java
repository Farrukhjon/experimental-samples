package org.farrukh.experiments.quickfixj.server.data;

import java.util.List;

import edu.emory.mathcs.backport.java.util.Arrays;
import quickfix.field.Password;
import quickfix.field.Username;
import quickfix.fixt11.Logon;

public class InMemoryRefDataProvider {
	
	private final List<Logon> logons;

	public InMemoryRefDataProvider() {
		Logon logon = new Logon();
		logon.set(new Username("suepr_user"));
		logon.set(new Password("suepr_password"));
		this.logons = Arrays.asList(new Logon[]{logon});
	}

	public List<Logon> getLogons() {
		return logons;
	}

}
