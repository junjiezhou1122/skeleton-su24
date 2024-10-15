import org.junit.Rule;
import org.junit.Test;
import static com.google.common.truth.Truth.assertWithMessage;
public abstract class TriangleTest {

    /** For autograding purposes; do not change this line. */
    abstract Triangle getNewTriangle();

    /* ***** TESTS ***** */

    // FIXME: Add additional tests for Triangle.java here that pass on a
    //  correct Triangle implementation and fail on buggy Triangle implementations.

    @Test
    public void test1() {
        // TODO: stub for first test
        Triangle t = getNewTriangle();
        // remember that you'll have to call on Triangle methods like
        // t.functionName(arguments), where t is a Triangle object

    }

    @Test
    public void sidesFormTriangleEdgeCasesTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("sidesFormTriangle(-1, 4, 5) should return false").that(t.sidesFormTriangle(-1, 4, 5)).isFalse();
        assertWithMessage("sidesFormTriangle(0, 4, 5) should return false").that(t.sidesFormTriangle(0, 4, 5)).isFalse();
        assertWithMessage("sidesFormTriangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE) should return true").that(t.sidesFormTriangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void pointsFormTriangleEdgeCasesTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("pointsFormTriangle(0, 0, 1, 1, 2, 2) should return false (collinear points)").that(t.pointsFormTriangle(0, 0, 1, 1, 2, 2)).isFalse();
        assertWithMessage("pointsFormTriangle(0, 0, 0, 0, 1, 0) should return false (degenerate triangle)").that(t.pointsFormTriangle(0, 0, 0, 0, 1, 0)).isFalse();
    }

    @Test
    public void triangleTypeEdgeCasesTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("triangleType(-1, 4, 5) should return Invalid").that(t.triangleType(-1, 4, 5)).isEqualTo("Invalid");
        assertWithMessage("triangleType(0, 4, 5) should return Invalid").that(t.triangleType(0, 4, 5)).isEqualTo("Invalid");
        assertWithMessage("triangleType(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE) should return Equilateral").that(t.triangleType(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo("Equilateral");
    }

    @Test
    public void squaredHypotenuseEdgeCasesTest() {
        Triangle t = getNewTriangle();
        assertWithMessage("squaredHypotenuse(-3, 4) should return 25").that(t.squaredHypotenuse(-3, 4)).isEqualTo(25);
        assertWithMessage("squaredHypotenuse(0, 0) should return 0").that(t.squaredHypotenuse(0, 0)).isEqualTo(0);
        assertWithMessage("squaredHypotenuse(Integer.MAX_VALUE, Integer.MAX_VALUE) should return a large value").that(t.squaredHypotenuse(Integer.MAX_VALUE, Integer.MAX_VALUE)).isGreaterThan(0);
    }


}
