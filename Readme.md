### DDD Spring Microservices with Orthogonal Architecture
This is a sample project that aims to demonstrate the benefits of 
using Orthogonal software architecture combined with Spring submodules
after designing using Domain Driven Design (DDD) approach.

After a lot of research I couldn't find code that uses this approach.
So I started combining what could be found on the Internet and my own ideas to 
complete this software.

If you're not familiar with some of the concepts described, please check out the following
section where I give a small explanation of each one and some links where more
information can be read.

#### Domain Driven Design (DDD)
Refers to the approach to software development that centers the development
on programming a domain model that has a rich understanding of the processes
and rules of a domain. The name comes from a 2003 book by Eric Evans that 
describes the approach through a catalog of patterns.

In this approach the main idea is to start designing by understanding the real word
process and actors and model them as Classes in our object oriented programming language.
These classes that represents the real world actors and processes should be framework
agnostic and only use what features object oriented paradigm provides.

_More Information:_

[Martin Fowler website](https://martinfowler.com/tags/domain%20driven%20design.html)

[DDD in practice](https://www.infoq.com/articles/ddd-in-practice/)

[Wikipedia :-)](https://en.wikipedia.org/wiki/Domain-driven_design#:~:text=Domain%2Ddriven%20design%20(DDD),should%20match%20the%20business%20domain.)

#### Orthogonal (Hexagonal) Architecture

One of the main problems with software code over the years is that the application logic,
user interface and infrastructure code is usually really coupled and dependent. This results
in a lot of refactoring when the developer needs to do a small change in the UI or change the
database manager to use. Or the inability to correctly unit test the important part of the software
(application logic) because the developer must implement or mock a lot of boilerplate code that is not needed.


This software architecture aims to solve these and other problems by correctly separating (decoupling) the different layers of code that
do different things and only communicate them by using "adapters". Its intended to be used internally in a software application.

The asymmetry to exploit is not that between "left" and "right" sides of the application but between "inside" and "outside" of the application.
The rule to obey is that code pertaining to the "inside" part should not leak into the "outside" part. The "outside" part refers to the way the 
application communicates with other components or is invoked by using what is called "ports" that follows a protocol to correctly perform
the communication (The protocol takes the form of an application program interface - API).

The hexagon is intended to visually highlight:

(a) the inside-outside asymmetry and the similar nature of ports, to get away from the one-dimensional layered picture and all that evokes.

(b) the presence of a defined number of different ports – two, three, or four.

_More Information:_

[DZone article](https://dzone.com/articles/hexagonal-architecture-what-is-it-and-how-does-it0)

#### Some considerations

- This is a sample project, although it works and can be deployed using any Java 8 JVM,
the idea is to propose a maven multi module that uses DDD.
- Some DTOs and mappings could be removed in a production environment. Again, this is a sample
code trying to demonstrate how to separate each layer with different DTOs and POJOs.


If you have any comments or questions or want to discuss improvements, please contact me in twitter @GuilleDevelops
or email gjhr1304@gmail.com



