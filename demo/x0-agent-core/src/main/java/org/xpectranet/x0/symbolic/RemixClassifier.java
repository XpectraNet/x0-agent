package org.xpectranet.x0.symbolic;

import java.util.List;

public class RemixClassifier {
    public static boolean validateRemixLineage(List<String> ancestry) {
        return ancestry != null && ancestry.size() >= 1;
    }

    public static boolean withinRemixLimits(List<String> forks, int maxAllowed) {
        return forks.size() <= maxAllowed;
    }
}