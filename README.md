Coverage: 34%

Inventory Management System (IMS)

Creating an Inventory Management System that a user can interact with provides the oppertunity to apply concepts from all of our core training modules. Using the information taught from QA,  it is possible to create, read, update and 
delete from our customers, items, orders and order items tables. While, also using a version control system (Git) to ensure the code is integrated, scrum board (Jira) to ensure efficient time management, and a source code managent (GitHub).


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

 

The most recent version of Git Bash; which can be downloaded here: 

[GIT Download] (https://git-scm.com/downloads) 

Java needs to be installed so the most recent version of JDK can be downloaded here: 

[JDK Download] (https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe) 

JRE is used to for developing, debugging, and monitoring Java applications and is already installed with the JDK link 

The most recent version of Maven; which can be downloaded here: 

[Maven Download] (https://maven.apache.org/download.cgi) 

A local instance of MySQL is needed so the most recent version of SQL can be downloaded here: 

[SQL Download] (https://dev.mysql.com/downloads/windows/installer/8.0.html) 

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

- Fork the repository from Jordan Benbelaid from the link here:  https://github.com/jordanbenbelaid/IMS-22EnableMay2 

- Cloned the folder from GitHub to your personal local machine  

- Open the folder on Eclipse 

- Click  src/main/resources 

- Click db.properties and change the password to the same as your MySQL password 

- Click com.qa.ims package 

- Click Runer.java 

- Run the java code 
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

JUnit testing is an automated test that will run tests on the system that will give a coverage percentage of the tested code. To run the JUnit test: 

- Right click the project folder, ims-starting-pont, in the project explorer. 

- Click on coverage, then Run As and then  JUnit test. 

```
example:
@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}
```
This tests whether the `create()` method work as expected on the Customers table in CustomerDAO.java to ensure the database is working correctly and the right values are entered into the correct tale. 


### Integration Tests

Mockito was used for the integration tests to check if the system works together as a whole and individually tests if units can work together. 
```
example:
	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```
This tests whether the `create()` method work as expected on the Customers table in CustomerController.java to ensure the database is working correctly and the right values are entered into the correct tale. 



## Deployment

In the eclipse terminal or git bash terminal type `mvn clean `  to clean any traces of the previous build. 

Then type `mvn package` to compile the code.
  

## Built With

We used Maven (https://maven.apache.org/) for Dependency Management.

## Versioning

We used Github (https://github.com/) for versioning.

## Authors

Hodan Barkhad - IMS-22EnableMay2 - [HodanB](https://github.com/HodanB)

## License

MIT License

Copyright (c) [2022] [Hodan Barkhad]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), 
to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR
IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Acknowledgments

Jordan Benbelaid, for providing the initial stating point - https://github.com/jordanbenbelaid
