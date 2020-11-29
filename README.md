# AgileEngine challenge

Time frame: 2 hours

### Frameworks & Libraries

- JSoup: Html/Xml parser
- PicoCLI: CLI argument parser
- ApacheText: For fuzzy text similarity
- Lombok: Annotation processor that eliminates boilerplate

### Help

```bash
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar --help
Usage: XmlComparator [-hV] [-i=<elementId>] origin-file compare-file
Finds the closest match to a given xml element from one file in another file.
      origin-file        The source file which must contain the required
                           element.
      compare-file       The file to compare and find the required element.
  -h, --help             Show this help message and exit.
  -i, --id=<elementId>   Id of the element
  -V, --version          Print version information and exit.
```

### Running the tests

```bash
./run-all.sh
```

### Test output

- sample-0-origin.html vs sample-1-evil-gemini.html

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-1-evil-gemini.html
9 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
9 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
80 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
80 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
80 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-1-evil-gemini.html
97 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/a[2], weight: 0.6857142857142856
97 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/a, weight: 0.4916074059837274
97 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/nav/ul/li[1]/ul/li[7]/a, weight: 0.19047619047619047
98 [main] INFO com.agileengine.XmlComparatorService - The most accurate element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a[2]
98 [main] INFO com.agileengine.XmlComparatorService - The most accurate element attributes are: {onclick=javascript:window.okDone(); return false;, rel=done, href=#check-and-ok, title=Make-Button, class=btn btn-success}
```

- sample-0-origin.html vs sample-2-container-and-clone.html

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-2-container-and-clone.html
9 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
9 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
77 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
78 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
78 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-2-container-and-clone.html
95 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/div/a, weight: 0.618649497085015
95 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[2]/div/div[2]/a[4], weight: 0.3963693107456321
96 [main] INFO com.agileengine.XmlComparatorService - The most accurate element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/div/a
96 [main] INFO com.agileengine.XmlComparatorService - The most accurate element attributes are: {onclick=javascript:window.okComplete(); return false;, rel=next, href=#ok, title=Make-Button, class=btn test-link-ok}
```

- sample-0-origin.html vs sample-3-the-escape.html

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-3-the-escape.html
11 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
11 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
88 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
89 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
89 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-3-the-escape.html
109 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[3]/a, weight: 0.6666666666666666
109 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/a, weight: 0.4916074059837274
109 [main] INFO com.agileengine.XmlComparatorService - The most accurate element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[3]/a
109 [main] INFO com.agileengine.XmlComparatorService - The most accurate element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, href=#ok, title=Do-Link, class=btn btn-success}
```

- sample-0-origin.html vs sample-4-the-mash.html

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-4-the-mash.html
9 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
9 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
75 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
76 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
76 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-4-the-mash.html
90 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[3]/a, weight: 0.7465564738292011
90 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/button, weight: 0.209366391184573
91 [main] INFO com.agileengine.XmlComparatorService - The most accurate element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[3]/a
91 [main] INFO com.agileengine.XmlComparatorService - The most accurate element attributes are: {onclick=javascript:window.okFinalize(); return false;, rel=next, href=#ok, title=Make-Button, class=btn btn-success}
```

- sample-0-origin.html vs sample-5-no-match.html

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-5-no-match.html
9 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
9 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
80 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
80 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
81 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-5-no-match.html
90 [main] INFO com.agileengine.XmlComparatorService - Couldn't find any similar element
```

- sample-0-origin.html vs non existing file

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-non-existing-file.html
10 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
10 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
85 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
85 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
86 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-non-existing-file.html
87 [main] ERROR com.agileengine.XmlComparatorService - Error reading the file /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-non-existing-file.html
com.agileengine.DocumentReadingException: Error reading the file /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-non-existing-file.html
        at com.agileengine.XmlComparatorService.getDocumentByFile(XmlComparatorService.java:60)
        at com.agileengine.XmlComparatorService.compare(XmlComparatorService.java:32)
        at com.agileengine.CliParser.call(CliParser.java:30)
        at com.agileengine.CliParser.call(CliParser.java:8)
        at picocli.CommandLine.executeUserObject(CommandLine.java:1933)
        at picocli.CommandLine.access$1200(CommandLine.java:145)
        at picocli.CommandLine$RunLast.executeUserObjectOfLastSubcommandWithSameParent(CommandLine.java:2332)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2326)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2291)
        at picocli.CommandLine$AbstractParseResultHandler.execute(CommandLine.java:2159)
        at picocli.CommandLine.execute(CommandLine.java:2058)
        at com.agileengine.CliRunner.main(CliRunner.java:10)
```

- sample-0-origin.html vs itself

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-0-origin.html
10 [main] INFO com.agileengine.XmlComparatorService - The element id is: make-everything-ok-button
11 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
82 [main] INFO com.agileengine.XmlComparatorService - The target element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
83 [main] INFO com.agileengine.XmlComparatorService - The target element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
83 [main] INFO com.agileengine.XmlComparatorService - The file to compare is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
99 [main] INFO com.agileengine.XmlComparatorService -   Element found: /html/body/div/div/div[3]/div[1]/div/div[2]/a, weight: 1.0
99 [main] INFO com.agileengine.XmlComparatorService - The most accurate element full XPath is: /html/body/div/div/div[3]/div[1]/div/div[2]/a
99 [main] INFO com.agileengine.XmlComparatorService - The most accurate element attributes are: {onclick=javascript:window.okDone(); return false;, rel=next, id=make-everything-ok-button, href=#ok, title=Make-Button, class=btn btn-success}
```

- sample-0-origin.html vs itself but with an non existing attribute

```bash
❯ java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-0-origin.html --id=non-existing-id
10 [main] INFO com.agileengine.XmlComparatorService - The element id is: non-existing-id
11 [main] INFO com.agileengine.XmlComparatorService - The origin file is: /home/jose/Workspaces/interviews/agileengine/xml-pseudofuzzycomparator/./src/test/resources/sample-0-origin.html
com.agileengine.MissingOriginAttributeException: Couldn't found an attribute with id non-existing-id
        at com.agileengine.XmlComparatorService.lambda$findTargetElementById$4(XmlComparatorService.java:70)
        at java.base/java.util.Optional.orElseThrow(Optional.java:408)
        at com.agileengine.XmlComparatorService.findTargetElementById(XmlComparatorService.java:70)
        at com.agileengine.XmlComparatorService.compare(XmlComparatorService.java:27)
        at com.agileengine.CliParser.call(CliParser.java:30)
        at com.agileengine.CliParser.call(CliParser.java:8)
        at picocli.CommandLine.executeUserObject(CommandLine.java:1933)
        at picocli.CommandLine.access$1200(CommandLine.java:145)
        at picocli.CommandLine$RunLast.executeUserObjectOfLastSubcommandWithSameParent(CommandLine.java:2332)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2326)
        at picocli.CommandLine$RunLast.handle(CommandLine.java:2291)
        at picocli.CommandLine$AbstractParseResultHandler.execute(CommandLine.java:2159)
        at picocli.CommandLine.execute(CommandLine.java:2058)
        at com.agileengine.CliRunner.main(CliRunner.java:10)
```
