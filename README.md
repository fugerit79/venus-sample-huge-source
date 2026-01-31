# venus-sample-huge-source

This is a sample project configured using [fj-doc-maven-plugin init plugin](https://venusdocs.fugerit.org/guide/#maven-plugin-goal-init).

## Quickstart

To run the test with specific resources, run for instance

```shell
mvn test -DargLine="-Xms2g -Xmx4g"
```

## Additional parameters

| parameter   | default        | note                                               |
|-------------|----------------|----------------------------------------------------|
| rowNumber   | 1000           | Number of row in the source document               |
| handlerType | PDF            | Handler type (output document format)              |
| handlerId   | ${handlerType} | Handler id if multimple are available for a format |

## handlerType / handlerId combination

| handler type | handler id | note                         |
|--------------|------------|------------------------------|
| pdf          | pdf-fop-ua | Apache FOP PDF-UA            |
| xml          | xml        | Fugerit venus doc xml source |
| fo           | FO         | Apache FOP xsl:fo            | 