# ConsoleTable
This little libary contains some classes to create and show a table inside the console,
as I sometimes need to view some of my results inside a table, but without taking this
as a feature for the later user. 
As this library is not intented to be used inside the released project or at least not
inside a loop, it's not optimized for this purpose. 

## How to use it?
If you intend to use it as a "one liner", you could write it like this:
```Java
System.out.println(
  new Table(
    new HeadLine("Here", "is", "some", "data"),
    new Content(
      new Row("first", "row", here", ":D),
      new Row("second", row", here", "...")
    );
  );
);
```
result:
