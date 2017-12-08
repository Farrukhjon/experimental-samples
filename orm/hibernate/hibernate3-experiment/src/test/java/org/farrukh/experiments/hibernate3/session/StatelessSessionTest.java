package org.farrukh.experiments.hibernate3.session;

import org.farrukh.experiments.hibernate3.AbstractBaseTest;

/**
 * Not cache anything operations.
 */
public class StatelessSessionTest extends AbstractBaseTest {
    @Override
    protected String getUnitTestProperties() {
        return null;
    }
}
