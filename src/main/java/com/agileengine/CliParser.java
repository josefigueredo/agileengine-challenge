package com.agileengine;

import picocli.CommandLine;

import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "XmlComparator",
        mixinStandardHelpOptions = true,
        version = "1.3.2",
        description = "Finds the closest match to a given xml element from one file in another file.")
public class CliParser implements Callable<Integer> {

    @CommandLine.Parameters(index = "0",
            paramLabel = "origin-file",
            description = "The source file which must contain the required element.")
    private File originFile;

    @CommandLine.Parameters(index = "1",
            paramLabel = "compare-file",
            description = "The file to compare and find the required element.")
    private File compareFile;

    @CommandLine.Option(names = {"-i", "--id"},
            description = "Id of the element")
    private String elementId = "make-everything-ok-button";

    @Override
    public Integer call() throws Exception {
        return XmlComparatorService.compare(elementId, originFile, compareFile);
    }

}
