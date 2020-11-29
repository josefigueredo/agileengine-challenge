#!/usr/bin/env bash
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #1"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-1-evil-gemini.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #2"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-2-container-and-clone.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #3"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-3-the-escape.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #4"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-4-the-mash.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #5 No match"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-5-no-match.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #6 Non exiting file"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-non-existing-file.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #7 Origin"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-0-origin.html
echo ""
echo "--------------------------------------------------------------------------------"
echo "Sample #8 Missing attribute"
java -jar ./target/xml-pseudofuzzycomparator-1.0-SNAPSHOT.jar ./src/test/resources/sample-0-origin.html ./src/test/resources/sample-0-origin.html --id=non-existing-id
echo ""
