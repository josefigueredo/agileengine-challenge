package com.agileengine;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.*;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
public class ElementAttributesPath {
    private final Map<String, String> attributes;
    private final String fullXPath;

    public ElementAttributesPath(Element element) {
        this(
                ElementAttributesPath.buildAttributeMap(element),
                ElementAttributesPath.buildFullXpath(element)
        );
    }

    public static Map<String, String> buildAttributeMap(Element element) {
        return element
                .attributes() // Attributes
                .asList() // List<Attributes>
                .stream() // Stream<Attributes>
                .collect(
                        Collectors.toMap(
                                Attribute::getKey,
                                Attribute::getValue
                        )
                );
    }

    private static String buildFullXpath(Element element) {
        List<String> tags = element
                .parents() // Elements
                .stream() // Stream<Element>
                .map(ElementAttributesPath::getTagName) // Stream<String>
                .collect(Collectors
                        .toCollection(LinkedList::new)
                );
        Collections.reverse(tags);
        tags.add(getNormalizedCurrentNode(element));
        return "/" + String.join("/", tags);
    }

    private static String getNormalizedCurrentNode(Element element) {
        List<Node> childNodesClone = new ArrayList<>(element.parent().childNodes());
        childNodesClone.removeIf(node -> (node instanceof TextNode) && ((TextNode) node).isBlank());
        return element.tagName() + (childNodesClone.indexOf(element) > 0 ? "[" + (childNodesClone.indexOf(element) + 1) + "]" : "");
    }

    private static String getTagName(Element element) {
        String tagName = element.tagName();

        List<Element> siblings = element
                .parent() // Elements
                .children() // Elements
                .stream() // Stream<Element>
                .filter(filteredElements -> filteredElements
                        .tagName()
                        .equals(
                                element.tagName()
                        )
                )
                .collect(Collectors
                        .toCollection(LinkedList::new)
                );

        return (siblings.size() > 1 ? tagName + "[" + (siblings.indexOf(element) + 1) + "]" : tagName);
    }
}