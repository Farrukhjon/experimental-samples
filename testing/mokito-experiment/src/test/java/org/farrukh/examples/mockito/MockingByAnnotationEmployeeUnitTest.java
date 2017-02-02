/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MockingByAnnotationEmployeeUnitTest {

    EmployeeRepository mockEmployeeRepo = mock(EmployeeRepository.class); // mocking by interface

    @Test
    public void shouldTestStoringAnEmployeeToTheDataBase() {

        //given
        Employee ali = new Employee("Ali");

        when(mockEmployeeRepo.insert(ali)).thenReturn(ali); // stub method call

        //when
        EmployeeService service = new EmployeeServiceImpl(mockEmployeeRepo);
        Employee savedEmployee = service.save(ali);

        //then
        verify(mockEmployeeRepo, times(1)).insert(ali);
        assertNotNull(savedEmployee);
        assertEquals("Ali", savedEmployee.getFirstName());
    }

}
