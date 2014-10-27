This project contains 2 XML files :

entity-info.xml : This contains a list of entities with their names and surnames
entity-list.xml : This contains a list of references to entities 

It provides an XSD called schema.xsd that describes the elements used in the above XML files.

You are expected to modify the pom file of this project in such a way that JAXB bindings
will be generated for the schema during the generate-sources phase.

These bindings should be contained in the target folder, and in no way form part of the src tree.

You will need to modify the TestAssessment.java file to do the following :

Part 1 :

1. Unmarshall both XML files into the generated JAXB binding objects
2. Retrieve a list of all entities mentioned in entity-list.xml
3. Remove any duplicate entity numbers
4. Sort this list by entity number descending
5. Loop through this list and for each entity number, find the corresponding info
   object mentioned in entity-info.xml
6. If an entity info object exists print out the number, surname and name.
7. If an entity info object does not exist, nothing should be printed

Part 2 :

1. Sort all entity info objects mentioned in entity-info.xml by name and then by surname
2. Loop through them and print out each name and surname

To test if your application works, run the maven clean and test goals, the following output should be produced : 

108 : Bloggs, Bill
107 : Bloggs, Jack
105 : Doe, Bill
103 : Doe, Jill
101 : Doe, John
***
Bill Bloggs
Bill Doe
Jack Bloggs
Jane Deer
Jane Doe
Jean Doe
Jill Doe
John Bloggs
John Deer
John Doe

The steps mentioned are just given to describe the requirements, you do not have follow 
them in sequence, as long as the desired output is produced.

You are not allowed to add any dependencies to the pom file, you may only add plugins.

You do not have to consider performance in any way, preference is given to clean and understandable code.

Remember : Comments don't make code understandable, good code makes code understandable.