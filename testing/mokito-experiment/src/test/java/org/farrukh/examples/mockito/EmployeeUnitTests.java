/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.mockito;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class EmployeeUnitTests {

    @Test
    public void shouldTestStoringAnEmployeeToTheDataBase() {
        //given
        EmployeeRepository mockEmployeeRepo = mock(EmployeeRepository.class);


        Employee ali = new Employee("Ali");
        when(mockEmployeeRepo.insert(ali)).thenReturn(ali);

        //when
        EmployeeService service = new EmployeeServiceImpl(mockEmployeeRepo);
        Employee savedEmployee = service.save(ali);



        //then
        verify(mockEmployeeRepo, times(1)).insert(ali);
    }

}
