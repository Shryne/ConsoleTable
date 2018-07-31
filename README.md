# ConsoleTable
This little libary contains some classes to create and show a table inside the console,
as I sometimes need to view some of my results inside a table, but without taking this
as a feature for the later user. 
As this library is not intented to be used inside the released project or at least not
inside a loop, it's not optimized for this purpose. 

## Characteristics
<lo>
    <li>Everything is immutable</li>
    <li>Everything uses interfaces</li>
    <li>Nothing is static</li>
    <li>No implementation inheritance is used</li>
</lo>

## How to use it?
If you intend to use it as a "one liner", you could write it like this:
```Java
new Table(
        2,
        "Name", "Age",
        "Steve", "15"
).printTo(System.out::println);
```
result:
```
 Name  | Age
============= 
 Steve | 15  
```

More complex example:
```java
new Table(
        2,
        new Cell(
                new Text(
                        new Right(),
                        new 
                )
        )
)
```