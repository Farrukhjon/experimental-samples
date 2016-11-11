package org.farrukh.experiments.spring.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SomeInnerServiceComponentImpl implements SomeInnerServiceComponent {

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testRequired() {
        throw new RuntimeException("Rollback this transaction!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void testRequiresNew() {
        throw new RuntimeException("Rollback this transaction!");
    }

}
