package com.agileengine;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.similarity.FuzzyScore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
public class XmlComparatorService {
    private static final Integer EXIT_OK = 0;
    private static final String CHARSET_NAME = "utf8";
    private static final FuzzyScore FUZZY_SCORE = new FuzzyScore(Locale.ENGLISH);

    private XmlComparatorService() {
    }

    public static Integer compare(String elementId, File originFile, File compareFile) {
        log.info("The element id is: " + elementId);

        log.info("The origin file is: " + originFile.getAbsolutePath());
        ElementAttributesPath targetElement = findTargetElementById(elementId, getDocumentByFile(originFile));
        log.info("The target element full XPath is: " + targetElement.getFullXPath());
        log.info("The target element attributes are: " + targetElement.getAttributes());

        log.info("The file to compare is: " + compareFile.getAbsolutePath());
        return findSimilarElements(getDocumentByFile(compareFile), targetElement.getAttributes()) // List<ElementAttributesPath>
                .stream() // Stream<ElementAttributesPath>
                .map(similarElement -> new WeightedElement(
                                similarElement,
                                calculateWeight(
                                        targetElement.getAttributes(),
                                        similarElement.getAttributes()
                                )
                        )
                ) // Stream<WeightedElement>
                .peek(weightedElement -> log.info("  Element found: " + weightedElement.getElementAttributesPath().getFullXPath() + ", weight: " + weightedElement.getWeight()))
                .max(Comparator.comparing(WeightedElement::getWeight)) // Optional<WeightedElement>
                .map(weightedElement -> {
                    log.info("The most accurate element full XPath is: " + weightedElement.getElementAttributesPath().getFullXPath());
                    log.info("The most accurate element attributes are: " + weightedElement.getElementAttributesPath().getAttributes());
                    return EXIT_OK;
                }) // Optional<Integer>
                .orElseGet(() -> {
                    log.info("Couldn't find any similar element");
                    return EXIT_OK;
                });
    }

    private static Document getDocumentByFile(File file) {
        try {
            return Jsoup.parse(file, CHARSET_NAME);
        } catch (IOException ioe) {
            log.error("Error reading the file {}", file.getAbsolutePath());
            throw new DocumentReadingException(file.getAbsolutePath());
        }
    }

    private static ElementAttributesPath findTargetElementById(String id, Document originDocument) {
        return Optional
                .ofNullable(
                        originDocument.getElementById(id) // Element
                ) // Optional<Element>
                .map(ElementAttributesPath::new) // ElementAttributesPath
                .orElseThrow(() -> new MissingOriginAttributeException(id));
    }

    private static List<ElementAttributesPath> findSimilarElements(Document compareDocument, Map<String, String> elementAttributes) {
        return elementAttributes
                .keySet() // Set<String>
                .stream() // Stream<String>
                .map(key -> new HashSet<>(
                                compareDocument.getElementsByAttributeValue(
                                        key,
                                        elementAttributes.get(key)
                                ) // Elements extends ArrayList<Element>
                        )
                ) // Stream<Set<Element>>
                .filter(Predicate.not(Collection::isEmpty))
                .flatMap(Set::stream) // Stream<Element>
                .map(ElementAttributesPath::new) // Stream<ElementAttributesPath>
                .distinct()
                .collect(Collectors.toList()); // List<ElementAttributesPath>
    }

    private static Double calculateWeight(Map<String, String> targetElement, Map<String, String> similarElement) {
        return targetElement
                .keySet() // Set<String>
                .stream() // Stream<String>
                .filter(similarElement::containsKey)
                .map(key -> FUZZY_SCORE
                        .fuzzyScore(similarElement.get(key), targetElement.get(key))
                        .doubleValue()
                        /
                        FUZZY_SCORE
                                .fuzzyScore(targetElement.get(key), targetElement.get(key))
                                .doubleValue()
                ) // Stream<Double>
                .reduce(Double::sum) // Optional<Double>
                .map(sum -> sum / targetElement.keySet().size()) // Double
                .orElse(0d); // Double
    }
}
