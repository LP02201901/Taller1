package taller1;



/**

 * A <a href="http://en.wikipedia.org/wiki/String_metric">string metric</a>.

 */

public interface StringMetric {



    /**

     * Returns the distance between the given strings.

     */

    int distance(CharSequence x, CharSequence y);

}