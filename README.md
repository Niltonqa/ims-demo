Coverage: 34%
# Project Title

One Paragraph of project description goes here

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Eclipse(source code) 
Mysql(my query) 
Sonar cube
Jenkins ( automated build tool
Maven (repository) 
Nexus
Github

### Installing

A step by step series of examples that tell you how to get a development env running
You'll need to install Sonarcube to a  VM instance in the google cloud platform

As well as downloading Maven repositiories to ensure that you have access to the MySql server instance too this ensures
that you have an adequate backup server which runs on its own legs without having any issues which come from using a local server
as well as having a much more in depth control of the backend. 


We use Nexus for Artefact Repository Management as it allows us to store compilable versions of our source code as well as granting us a much more assured version control system

End with an example of getting some data out of the system or using it for a little demo

## Tests

In the next spring i hope to implement more testing however in this current spring most of the testing covered the CustomerDao, Customer.java, CustomerServices. the tests were ran to ensure that we get the correct outputs in the code which is whhy we use Mockito as it enables us to perform at a larger scale and also mock user input 



### Integration Tests 
Explain what these tests test, why and how to run them

### And coding style tests

Using SonarQube we were able to tests the viability of our source code as well as being able to establish where things were going wrong and establish where most of the codde smells were to help extinguish them and also add a more refined approach to the way we operate making the code much more easier to digest and figure out when it come to the application of it as well as making sure it was packaged nicely
```
Give an example
```

## Deployment

We used Jenkins as our Continuous Development tool as once the commands are in and if they're correct, and the code is parseable then Jenkins will automatically build and deploy your application with the correct build steps.
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
 Thank you Chris
 Thanks to Tee
 Thanks to Matt D
 Thanks to Matt B
 Thanks to Nick J
