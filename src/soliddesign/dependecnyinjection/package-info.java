package soliddesign.dependecnyinjection;
/*
 * Hello and welcome to this session. In this session, we are going to learn about the 5th and final design principle.

This is the 'D' in SOLID. It stands for Dependency Inversion Principle, often abbreviated as DIP.

Lets look at what this principle says.

It goes like this: "High Level Modules should not depend on Low Level Modules. Both should depend on abstractions".

Hang on, there's another part to it.

"Abstractions should not depend on details. Details should depend on abstractions".

So there are 2 parts to this principle.

But the fundamental concept behind both parts is the same, one follows from the other,

as you will see shortly.

Before we understand the principle, its important that we understand the terms used in the definition.

Lets take the terms - high level modules and low level modules first.

Say you are running an eCommerce website.

The software for the eCommerce web application is sophisiticaed and contains tens of thousands of lines of code.

But if we were to come up with a very high level design model,

this is what it would look like

There are 3 major business functions -

ProductCatalog , PaymentProcessor and CustomerProfile.

These, in turn, depend on a number of other modules , shown below, for the implementation.

so the modules on top

are closer to the business functions

and are called high level modules. The modules towards the bottom

deal with the implementation details and are called low level modules.So the bottom modules are SQLProductRepository

GooglePayGateway, WireTransfer,

EmailSender and VoiceDialer.

These deal with the low-level implementation.

How about the Communication module? Is it a high level module or a low level module?

Trick question, huh?!

Well, the answer is : Its both!

If you consider the CustomerProfile and the Communication module alone,

CustomerProfile is the high level module and Communication is the low level module.

But if you consider the Communication and the EmailSender module alone, Communication is

the high level module here and EmailSender is the low level module.

The point here is that whether a module is a high level or low level module is relative and not absolute.

Lets see our definition again.

The first part alone for now.

So we have covered the terms high level module and low level module.

Back to the diagram, note the arrow from ProductCatalog to SQLProductRepository.

This arrow should be read as 'depends on'.

So ProductCatalog depends on SQLProductRepository.

ProductCatalog , a high level module, depends on, SQLProductRepository, a low level module.

So this directly conflicts the definition.

The definition says High Level Modules should NOT depend on Low Level Modules. Both of them should depend on abstractions instead.

Lets take this particular relationship alone and analyze it further.

Lets try to come up with some code snippets for this relation.

So we have a SQLProductRepository class

which contains a method called getAllProductNames().

Assume this method contains the code to run a SELECT statement

from a PRODUCT database table in the backend.

This method returns a list of product name strings.

Next, we have the ProductCatalog class.

Here we first instantiate a new SQLProductRepository object, and then we call

the getAllProductNames() function on the instantiated object.

So ProductCatalog directly depends on SQLProductRepository, so this is the violation of the principle as seen in code.

now let's see if we can fix this violation

Lets go back to our definition for guidance.

Both should depend on abstractions.

So the definition gives us some guidance on how to fix this violation as well.

So lets try it out.

We will create an interface ,

an interface is an abstraction, and we'll call it ProductRepository.

We will make the SQLProductRepository implement this interface.

OK

so now we will need to get the SQLProductRepository object to the ProductCatalog somehow.

how can we do that?

We should not directly instantiate the SQLProductRepository object, so we will use a Factory class for the same.

This is what the Factory class looks like.

It has a single method called create which instantiates and returns a new SQLProductRepository object.

pretty simple and straightforward

Now, from the ProductCatalog class, we will invoke this factory method which will instantiate

and return a SQLProductRepository object.

But note that our reference object is ProductRepository, so we don't have any tight coupling

with SQLProductRepository anywhere in the ProductCatalog class.

Lets go back to our definition now.

Both should depend on abstractions.

Lets see how the dependency looks like now in the code, after our restructuring.

So ProductCatalog, which is our high level module, depends on ProductRepository, which is an abstraction.

So lets draw an arrow here.

Next, SQLProductRepository , which is our low level module, depends on ProductRepository again, because it implements it.

So lets draw another arrow here.

Now lets modify the figure on the left accordingly.

We have the ProductRepository which sits in between.

This is what we call the abstraction.

As you can see now, we are no longer violating the principle.

The high level module does not depend on the low level module anymore.

We went as per the definition. So both our high level and low level modules depend on the abstraction now.

Lets bring up the second part of the definition now.

"Abstractions should not depend on details. Details should depend on abstractions".

Look at the diagram on the left again.

The dependency arrow, which was earlier pointing TOWARDS the SQLProductRepository is now pointing in the opposite direction,

i.e , it is pointing away from SQLProductRepository.

So now, the detail, which is the SQLProductRepository class,

is dependent on the abstraction, which is the ProductRepository class. THis is strictly as per the definition.

The arrow changing direction

is at the core of this principle.

This is called the 'inversion of dependency',

and this is the reason why this principle is called

'dependency inversion principle'.

So to sum up, we started with showing a violation of the dependency inversion principle. We understood what the violation is,

then we took steps to restructure the code, so as to strictly follow this principle.
 */
