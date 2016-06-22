package org.farrukh.examples.java.functional.collection;

import org.farrukh.examples.java.functional.domain.Department;
import org.farrukh.examples.java.functional.domain.Employee;
import org.farrukh.examples.java.functional.domain.builder.DepartmentBuilder;
import org.farrukh.examples.java.functional.domain.builder.EmployeeBuilder;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Test class for illustrating catalog of collection pipelines (pipe-and-filter) using stream API.
 */
public class CollectionPipelineTests extends BaseUnitTest {

    List<Employee> employees;

    @Before
    public void setUp() {
        Department itDep = new DepartmentBuilder().setId(1).setName("IT").build();
        Department accountDep = new DepartmentBuilder().setId(2).setName("Accountant").build();
        Department managementDep = new DepartmentBuilder().setId(3).setName("Management").build();
        Employee employee1 = new EmployeeBuilder()
                .setId(1)
                .setFirstName("Aliev")
                .setName("Vali")
                .setLastName("Samievich")
                .setAge(25)
                .setDepartment(itDep)
                .build();
        Employee employee2 = new EmployeeBuilder()
                .setId(2)
                .setFirstName("Hojiev")
                .setName("Hodi")
                .setLastName("Teshevich")
                .setAge(35)
                .setDepartment(itDep)
                .build();
        Employee employee3 = new EmployeeBuilder()
                .setId(3)
                .setFirstName("Hojiev")
                .setName("Hodi")
                .setLastName("Teshevich")
                .setAge(35)
                .setDepartment(accountDep)
                .build();
        Employee employee4 = new EmployeeBuilder()
                .setId(3)
                .setFirstName("Solieva")
                .setName("Maryam")
                .setLastName("Boboevna")
                .setAge(25)
                .setDepartment(managementDep)
                .build();
        employees = Arrays.asList(employee1, employee2, employee3, employee4);
    }

    public void testCollectingDepartmentUsingMapMapFilterCollect() {
        List<String> departmentNamesIT = employees.stream()
                .map(Employee::getDepartment)
                .map(Department::getName)
                .filter(name -> name.equals("IT"))
                .collect(Collectors.toList());
        departmentNamesIT.forEach(name ->
                assertTrue(name.equals("IT")));
    }

    public void testCollectingNoDuplicatedElementsUsingDistinctCollect() {
        List<Integer> duplicatedNumbers = Arrays.asList(1, 2, 3, 7, 1, 3, 2, 6, 5, 4, 4, 8, 9);
        List<Integer> noDuplicates = duplicatedNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(noDuplicates, is(not(duplicatedNumbers)));
        assertEquals(9, noDuplicates.size());
    }

    public void testCollectingElementsUsingFilterMapSortedCollect() {
        List<String> stringList = Arrays.asList("a1", "b2", "c1", "c2", "a3", "b2", "d1", "d3", "c3");
        stringList.stream()
                .filter(s -> s.startsWith("c") || s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
    }

    public void testConcatenateTwoCollectionsUsingConcat() {
        List<Integer> naturalNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> oddNumbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        Stream<Integer> concatenated = Stream.concat(naturalNumbers.stream(), oddNumbers.stream());
        Integer[] expectedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90};
        assertArrayEquals(expectedNumbers, concatenated.toArray());
    }

    public void testAverageAgeOfEmployeesUsingMapReduce() {
        int count = employees.size();
        int averageAge = employees.stream()
                .map(Employee::getAge)
                .reduce(0, (sum, age) -> sum + age) / count;
        assertEquals(30, averageAge);
    }

    public void testTransformingListElementsToUpperCaseViaMap() {
        List<String> lowerCaseStrings = Arrays.asList("a1", "b2", "c1", "c2", "a3", "b2", "d1", "d3", "c3");
        Object[] transformedToArray = lowerCaseStrings.stream()
                .map(String::toUpperCase)
                .toArray();
        String[] expectedStrings = {"A1", "B2", "C1", "C2", "A3", "B2", "D1", "D3", "C3"};
        assertArrayEquals(expectedStrings, transformedToArray);
    }
}
