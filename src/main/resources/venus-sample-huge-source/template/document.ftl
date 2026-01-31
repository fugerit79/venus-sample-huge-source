<?xml version="1.0" encoding="utf-8"?>
<doc
        xmlns="http://javacoredoc.fugerit.org"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://javacoredoc.fugerit.org https://www.fugerit.org/data/java/doc/xsd/doc-2-1.xsd" >

    <#--
        This is a Venus Fugerit Doc (https://github.com/fugerit-org/fj-doc) FreeMarker Template XML (ftl[x]).
        For consideration of Venus Fugerit Doc and Apache FreeMarker integration see :
        https://venusdocs.fugerit.org/guide/#doc-freemarker-entry-point
        The result will be a :
    -->
    <!--
        This is a Venus Fugerit Doc (https://github.com/fugerit-org/fj-doc) XML Source Document.
        For documentation on how to write a valid Venus Doc XML Meta Model refer to :
        https://venusdocs.fugerit.org/guide/#doc-format-entry-point
    -->

    <#assign defaultTitle="Demo Huge List">

    <metadata>
        <!-- Margin for document : left;right;top;bottom -->
        <info name="default-font-name">TitilliumWeb</info>
        <info name="default-font-size">6</info>
        <!-- Margin for document : left;right;top;bottom -->
        <info name="margins">10;10;10;30</info>
        <!-- documenta meta information -->
        <info name="doc-title">${docTitle!defaultTitle}</info>
        <info name="doc-subject">fj doc venus sample source FreeMarker Template XML - ftlx</info>
        <info name="doc-author">fugerit79</info>
        <info name="doc-language">en</info>
        <!-- property specific for xls/xlsx -->
        <info name="excel-table-id">data-table=print</info>
        <!-- property specific for csv -->
        <info name="csv-table-id">data-table</info>
        <footer-ext>
            <para align="right">${r"${currentPage}"} / ${r"${pageCount}"}</para>
        </footer-ext>
    </metadata>
    <body>
    <para>Sample huge list</para>
    <table columns="6" colwidths="5;50;12;12;10;10"  width="100" id="data-table" padding="3">
        <row header="true">
            <cell align="center" rowspan="2"><para>NUMBER</para></cell>
            <cell align="center" rowspan="2"><para>NAME / SURNAME</para></cell>
            <cell align="center" rowspan="2"><para>DOCUMENT ID</para></cell>
            <cell align="center" rowspan="2"><para>SIGNATURE</para></cell>
            <cell align="center" colspan="2"><para>NOTES</para></cell>
        </row>
        <row header="true">
            <cell align="center"><para>From officer A</para></cell>
            <cell align="center"><para>From officer B</para></cell>
        </row>
        <#list 1..rowNumber as i>
        <row>
            <cell><para>${i}</para></cell>
            <cell>
                <para>ALAN TURING</para>
                <para>LONDON 25/05/1997</para>
                <para>CAMDEN TOWN</para>
            </cell>
            <cell><para></para></cell>
            <cell><para></para></cell>
            <cell><para></para></cell>
            <cell><para></para></cell>
        </row>
        </#list>
    </table>

    </body>

</doc>