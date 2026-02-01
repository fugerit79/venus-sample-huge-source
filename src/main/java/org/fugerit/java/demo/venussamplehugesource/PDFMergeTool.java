package org.fugerit.java.demo.venussamplehugesource;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.io.IOUtils; // Change this import

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class PDFMergeTool {

    public static void mergeDirectory(String sourceDirectoryPath, String destinationPath) throws IOException {
        File folder = new File(sourceDirectoryPath);
        File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (files == null || files.length == 0) {
            throw new IOException("No PDF files found in: " + sourceDirectoryPath);
        }

        Arrays.sort(files);

        PDFMergerUtility merger = new PDFMergerUtility();
        merger.setDestinationFileName(destinationPath);

        for (File file : files) {
            merger.addSource(file);
            log.info("add source: {}", file.getName());
        }

        // In PDFBox 3.x, use IOUtils to create the required StreamCacheCreateFunction
        // This replaces MemoryUsageSetting
        merger.mergeDocuments(IOUtils.createMemoryOnlyStreamCache());

        log.info("Merge successful: {}", destinationPath);
    }

}