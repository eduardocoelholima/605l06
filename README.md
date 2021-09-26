# inheritance and code reuse

inheritance and code reuse are close cousins

## code: bst: a storage class, a node class
-- show node snippets, method signatures for sortedstorage

visually, we would have an inheritance tree like this one:
-- show class hierarchy drawing of sorted storage

what kind of data can eventually be stored by the node?
- IntegerNode
- StringNode
- SomethingElseNode
- ... and so on

at the storage level a new class also eventually need to be defined 
- SortedSetStorage
- SortedNonSetStorage
- SortedSetStorageWithNulls
- SortedNonSetStorageWithNulls
with time, you will have a million classes with repeated code

- maintenance, new features and bug fixes gradually becomes a nightmare
  storage requirement variations trigger the need for different classes.
- what to do? use inheritance


# abstract classes

but it can happens that some classes share components that does not need a concrete class

## code e.g. SortedStorage might define commonly used components
-- revisit the same code, drawing for node, sortedstorage

- abstract classes (and interfaces) can be used to require subclasses to follow a
  wanted behaviour (or API), where your classes need to follow the expected behaviour
- sometimes you need to make sure a number of subclasses implement a behaviour, but it
  is not needed to have parent instances, e.g. a SortedStorage abstract class could set
  the stage for concrete subclasses to be defined 


# so what are abstract classes

## code simple abstract: toyota,camry

So what are abstract classes?
- a class that can not be instanciated
- a class that can define abstract methods
  - a concrete subclass MUST implement them
  - eg: an abstract Animal must sound(), but each subclass will sound() differently:
        Cat.sound() { return "miaw"; } Dog.sound { return "woof"; }
- abstract classes are part of an inheritance tree, which makes sense when you have
  closely related classes
- if you need to define and/or access non-static and non-final fields (interfaces can't)

# when to use abstract classes

## code another abstract example: car, toyota, camry

- you want to separate or hide some common functionality in one place (reuse code)
  that will be shared among related subclasses
- you want to define an API that our subclasses can extend and refine
- your subclasses need to inherit one or more common methods or fields with
  protected access modifiers

# when not to use abstract classes

## code: Honkable, Pilotable, plane, boeing, b737
(compare against car, toyota, camry)

- when the api will be shared among not-closely-related classes
- when you want to use multiple inheritance

# interfaces

## drawing: show whole tree with interfaces

What if you want to define behaviour (e.g. Comparable, HumanReadable) among classes that
are not that closely related, e.g. String, Integer, SortedStorage, Node? 
- interfaces also imposes contracts on classes that implement them, but with differences
  compared to abstract classes:
- interface fields are always static and final
- interfaces can have have default methods, static or abstract methods,
  while abstract classes can also have concrete methods
- default methods prime usage is provide backwards compatibility (e.g. an updated
  interface requires a new abstract method or instead it can provide as a default so
  classes that previously implemented the interface dont break)

  
# when to use interfaces

## code: plane, airbus, a321

- as in abstract classes, you want to specify a behaviour that MUST be followed by
  classes that implement the interface, e.g. Comparable, Clonable, Serializable
- you dont expect classes that implement them to be closely related
- you want to be able to or right away implement multiple inheritance


# when not to use interfaces

## code: car, honda, accord

- when you need non-public or non-static fields in the api
- when you need protected access on the methods of the api
- when you need your api to provide concrete methods



# additional recommended material

https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
https://www.cs.rit.edu/~hpb/Lectures/2211/605/605-137.html
https://en.wikipedia.org/wiki/Open–closed_principle






Cheers,
eduardo.lima at mail.rit.edu