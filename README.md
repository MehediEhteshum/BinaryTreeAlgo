### My Assumption:
Binary tree algorithm.

## Problem Statement:
A framework is collection of abstract classes, interfaces and algorithm templates that is designed for expansion & flexibility.
### Example:
Imagine you have parts that have a description and a price, some parts display description then price, others price then description, others just description without price. You need to provide these parts to various Catalogs. Catalogs need the parts sorted in different ways, some by price, some by description, and for some catalogs the order does not matter.

Here is a framework that can be built upon to handle these criteria with only simple extensions.

public abstract class Part {
                private String price;
                private String description;

                public Part(String price, String description) {
                this.price = price;
                this.description = description;
}
                
                public abstract String makeStringForCatalog;
} 

interface Sorter {
                Collection sortParts(Collection parts);
}

public class Catalog {
                private Sorter sorter;

                public Catalog(Sorter sorter) {
                                this.sorter = sorter;
}              

                public String printCatalog(Collection parts) {
                                String result = “”;
                parts = sorter.sortParts(parts);
                for(Part part in parts)
                                result = result + part.makeStringForCatalog() + “\n”;
                return result;
}
}

Now, this framework does not do anything. However, if we have CarTires that display price then description, and need to make a Catalog where the order does not matter, we can build on the framework.

class CarTire extends Part {
                String makeStringForCatalog {
                                return price + “ “ + description;  
}
}

class DontSortSorter implements Sorter {
Collection sortArrayOfParts(Collection parts) { // should be sortParts
                return parts;
                }
}

// And here it is in action
                Catalog carTireCatalog = new Catalog(new DontSortSorter());
                Collection carTireParts = makeTheCarTires(); // a method that builds CarTires and puts them in a Collection
                String result = carTireCatalog.printCatalog(carTireParts);

### Assignment:
The object of this assignment is to assess your skills at OOD and your ability to make/use abstract frameworks.

You have a Tree which contains Objects with the following interface:
public interface Tree {
      // Will return empty list if node has no children
      public List getChildren(Object node) throws ObjectNotInTreeException;
      
      // Will return null if node is the root of the tree
      public Object getParent(Object node) throws ObjectNotInTreeException;

      public boolean isInTree(Object node);
      
      // ObjectNotInTreeException is a checked Exception
}
We want to be able to transverse the trees using different transversal algorithms, and when some condition holds for an Object visited perform some action on that Object.
Assignment
a.	Build a simple yet flexible framework for walking the tree in an arbitrary manner, and if an arbitrary condition holds on the Objects visited, performs an arbitrary action on that Object.
b.	Using your framework show how, given an Object startNode in a Tree, you can build a Collection of all descendents of startNode that are of Type String.
c.	Using your framework show how, given an Object startNode in a Tree, you can concatenate the toString() results of all ancestors of startNode.
