# venus-sample-huge-source

This is a demo project to test Fugerit Venus Doc generation with huge source document and different handles.

[![Keep a Changelog v1.1.0 badge](https://img.shields.io/badge/changelog-Keep%20a%20Changelog%20v1.1.0-%23E05735)](CHANGELOG.md)

This is a sample project configured using [fj-doc-maven-plugin init plugin](https://venusdocs.fugerit.org/guide/#maven-plugin-goal-init).

## Quickstart

To run the test with specific resources, run for instance

```shell
mvn test -DargLine="-Xms2g -Xmx4g"
```

For instance to create a document with a 100,000 rows table with Apache FOP, PDF/UA-1

```shell
mvn test -DargLine="-Xms2g -Xmx4g" -DrowNumber=50000 -DhandlerType=pdf -DhandlerId=pdf-fop-ua
```

Or the same document with OpenPDF

```shell
mvn test -DargLine="-Xms2g -Xmx4g" -DrowNumber=50000 -DhandlerType=pdf -DhandlerId=openpdf
```

It is possible to generate the source XML too 

```shell
mvn test -DargLine="-Xms2g -Xmx4g" -DrowNumber=50000 -DhandlerType=xml
```

Or the XLS-FO format for Apache FOP

```shell
mvn test -DargLine="-Xms2g -Xmx4g" -DrowNumber=50000 -DhandlerType=xml
```

## Additional parameters

| parameter   | default        | note                                               |
|-------------|----------------|----------------------------------------------------|
| rowNumber   | 1000           | Number of row in the source document               |
| handlerType | PDF            | Handler type (output document format)              |
| handlerId   | ${handlerType} | Handler id if multimple are available for a format |

## handlerType / handlerId combination

| handler type | handler id            | note                         |
|--------------|-----------------------|------------------------------|
| pdf          | 'pdf' or 'pdf-fop-ua' | Apache FOP PDF-UA            |
| pdf          | 'openpdf'             | OpenPDF (IText fork)         |
| xml          | 'xml'                 | Fugerit venus doc xml source |
| fo           | 'FO'                  | Apache FOP XSL:FO            | 