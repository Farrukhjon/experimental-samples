/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */
package org.farrukh.examples.spring.data.jpa;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

/**
 * A value object abstraction of an email address.
 * 
 * @author Oliver Gierke
 */
@Embeddable
public class EmailAddress {

	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

	@Column(name = "email")
	private String value;

	/**
	 * Creates a new {@link EmailAddress} from the given string source.
	 * 
	 * @param emailAddress must not be {@literal null} or empty.
	 */
	public EmailAddress(String emailAddress) {
		Assert.isTrue(isValid(emailAddress), "Invalid email address!");
		this.value = emailAddress;
	}

	protected EmailAddress() {

	}

	/**
	 * Returns whether the given {@link String} is a valid {@link EmailAddress} which means you can safely instantiate the
	 * class.
	 * 
	 * @param candidate
	 * @return
	 */
	public static boolean isValid(String candidate) {
		return candidate == null ? false : PATTERN.matcher(candidate).matches();
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value;
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmailAddress)) {
			return false;
		}

		EmailAddress that = (EmailAddress) obj;
		return this.value.equals(that.value);
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
