// generated from template 'DocHelperTest.ftl' on 2026-01-30T22:04:01.027+01:00
package test.org.fugerit.java.demo.venussamplehugesource;

import org.fugerit.java.core.io.FileIO;
import org.fugerit.java.core.util.checkpoint.CheckpointFormatHelper;
import org.fugerit.java.demo.venussamplehugesource.DocHelper;

import org.fugerit.java.doc.base.config.DocConfig;
import org.fugerit.java.doc.base.process.DocProcessContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import lombok.extern.slf4j.Slf4j;

/**
 * This is a basic example of Fugerit Venus Doc usage,
 * running this junit will :
 * - creates data to be used in document model
 * - renders the 'document.ftl' template
 * - print the result in markdown format
 *
 * For further documentation :
 * https://github.com/fugerit-org/fj-doc
 *
 * NOTE: This is a 'Hello World' style example, adapt it to your scenario, especially :
 * - change the doc handler and the output mode (here a ByteArrayOutputStream buffer is used)
 */
@Slf4j
class DocHelperTest {

    private static final String PARAM_ROW_NUMBER = "rowNumber";
    private static final String PARAM_HANDLER_TYPE = "handlerType";
    private static final String PARAM_HANDLER_ID = "handlerId";

    private String getMem() {
        return String.format( "max memory: %s, free memory : %s", Runtime.getRuntime().maxMemory(), Runtime.getRuntime().freeMemory() );
    }

    @Test
    void testDocProcess() throws Exception {
        long startTime = System.currentTimeMillis();
        StringBuilder report = new StringBuilder();
        CheckpointFormatHelper formatHelper = new CheckpointFormatHelper();
        report.append( "-------------------- Fugerit Venus Doc sample huge source report (begin) --------------------------" );
        String beginMemory = getMem();
        log.info( beginMemory );
        report.append( "\n memory status (begin) : " );
        report.append( beginMemory );
        // handler type / file
        String handlerType = System.getProperty( PARAM_HANDLER_TYPE, DocConfig.TYPE_PDF);
        String handlerId = System.getProperty( PARAM_HANDLER_ID, handlerType );
        report.append( "\n handler type : " );
        report.append( handlerType );
        report.append( "\n handler id : " );
        report.append( handlerId );
        String rowNumber = System.getProperty( PARAM_ROW_NUMBER, "1000");
        report.append( "\n row.number : " );
        report.append( rowNumber );
        log.info( "row number : {} ", rowNumber );
        String fileNameBase = String.format( "output-%s-%s", rowNumber, handlerId.replace("/", "-") );
        File outputFile = new File("target/", String.format( "%s.%s", fileNameBase, handlerType ) );
        File reportFile = new File("target/", String.format( "%s.%s", fileNameBase, "txt" ) );
        outputFile.delete();
        report.append( "\n output file : " );
        report.append( outputFile.getCanonicalPath() );
        report.append( "\n report file : " );
        report.append( reportFile.getCanonicalPath() );
        try (FileOutputStream baos = new FileOutputStream(outputFile)) {
            // creates the doc helper
            DocHelper docHelper = new DocHelper();
            // create custom data for the fremarker template 'document.ftl'
            String chainId = "document";
            // output generation
            docHelper.getDocProcessConfig().fullProcess(chainId,
                    DocProcessContext.newContext( PARAM_ROW_NUMBER, Long.valueOf(rowNumber)), handlerId, baos);
            // print the output
            Assertions.assertTrue( outputFile.exists() );
        } finally {
            String endMemory = getMem();
            log.info( endMemory );
            report.append( "\n memory status (end) : " );
            report.append( endMemory );
            report.append( "\n total time : " );
            report.append( formatHelper.formatDuration( System.currentTimeMillis() - startTime ) );
            report.append( "\n-------------------- Fugerit Venus Doc sample huge source report (end) --------------------------\n" );
            FileIO.writeString( report.toString(), reportFile );
            log.info( "output file : {}, report file : {} \n\n{}", outputFile.getName(), reportFile.getName(), report );
        }
    }

}
