在`Visitor`模式中，数据结构与处理被分离开来。我们需要写一个`Visitor`
类来访问数据结构中的元素，并且把对各个元素处理对逻辑交给访问这类，这样的话当需要增加新的数据处理逻辑时，只需要编写新的访问者类而不需要动原来的数据结构了。

| 类名                        | 解释                 |
|---------------------------|--------------------|
| `Visitor`                 | 访问者的抽象类，由它访问文件和文件夹 |
| `Element`                 |                    |
| `ListVisitor`             |                    |
| `Entry`                   |                    |
| `File`                    |                    |
| `Directory`               |                    |
| `FileTreatementException` |                    |
| `Main`                    |                    |
