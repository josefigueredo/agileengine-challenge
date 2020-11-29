package com.agileengine;

import picocli.CommandLine;

/**
 *
 */
class CliRunner {
    public static void main(String... args) {
        System.exit(new CommandLine(new CliParser()).execute(args));
    }
}
