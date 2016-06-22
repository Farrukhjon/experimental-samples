package org.farrukh.examples.integration.core.xml.handler

import groovy.transform.CompileDynamic
import groovy.util.logging.Slf4j
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.messaging.MessagingException

/**
 * Created by Farrukhjon SATTOROV.
 */
@Slf4j
class GlobalErrorHandler {

    static int DEFAULT_ERROR_CODE = 0

    @ServiceActivator
    void handleErrorMessage(MessagingException exception) {
        def rootCause = extractRootCause(exception)
        log.info('The root cause is: {}', rootCause)
        log.info('The error code is: {}', extractErrorCode(exception))
        log.info('The error message is: {}', rootCause.message)
    }

    private static Throwable extractRootCause(Throwable throwable) {
        def current = throwable
        def root = current
        while (current) {
            root = current
            current = current.cause
        }
        root
    }

    @CompileDynamic
    private static int extractErrorCode( Throwable rootCause ) {
        rootCause.hasProperty( 'code' ) ? rootCause.code : DEFAULT_ERROR_CODE
    }
}
