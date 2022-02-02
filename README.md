# SE2811031_DefectedCodeTheVisiting
Riley Jensen and Andrew Crisler Eli Hamp implementing the visiter pattern.

Classes to be implemented by Andrew Crisler:
Classes related to Domain displaying classes and solution level classes. This includes: Client, Main, ProductList, ShoppingCart, Amazon2Controller

Classes to be implemented by Riley Jensen:
Classes related to the elements. This includes: Product, GPU, Potatoes, Rent-a-car


Classes to be implemented by Eli Hamp:
Classes related to the shoppers. This includes: BasicShopper, VIPShopper, PremiumShopper, ShopperType


Riley Jensen and Andrew Crisler implementing the visiter pattern.

Presentation Outline

What is the Visitor Pattern: -Behavioral Pattern -Implement new behavior =Makes it Open Closed -Defining New Behaviors

Explanation of our project: -New virtual dist platform -Products are the elemets -Different users are the "visitor"

Demo Code:

UML Diagram Explanation: -Domain UML elements -Tiers of subs. are visitors -Products are the elements -implents vists different by behavior needed

Deep Dive into the Visitor Pattern Structure: -when visists element, calls accept and all elements must implement -accept method will call visited method from the vistor class -vistor implements new behavior -visitor has a visit method for elements

Why the Visitor Pattern is Great: -implement different behaviors =no new behavoir in the element class =open/close =just implement the visit pattern

Visitor Pattern is not Great: -all must be updated when new element class -Code is not as legible, element objects spread about

Key Takeaway: -Change parts of elements, but not in the element -Open/Closed
