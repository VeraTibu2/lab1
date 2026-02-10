import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;



public class TestTrucks {
    Scania S = new Scania();

    @Test
    void TestMoveWhenRaised(){
        double[] startPos = {S.x, S.y};
        S.raiseBed(100);
        assertEquals(S.getBedAngle(), 70);
        S.move();
        double[] newPos = {S.x, S.y};
        assertEquals(startPos, newPos);

    }
}
