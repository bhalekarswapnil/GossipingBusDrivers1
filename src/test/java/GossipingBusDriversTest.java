import org.example.GossipingBusDrivers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GossipingBusDriversTest {


    @Test
    public void testDriverNeverGossips() {
        int[][] driverRoutes = {
                {2, 1, 2},
                {5, 2, 8}
        };
        int expectedOutput = -1; // never gossips
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }

    @Test
    public void testTwoDriversSameRoute() {
        int[][] driverRoutes = {
                {1, 2, 3},
                {1, 2, 3}
        };
        int expectedOutput = 3; // Two drivers, all gossips in 3 stops (same route)
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }

    @Test
    public void testMultipleDriversDifferentRoutes() {


        int[][] driverRoutes = {
                {3,1,2,3},
                {3,2,3,1},
                {4, 2,3,4,5 },
        };
        int expectedOutput = 5; 
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }

    @Test
    void testDriversHaveAllGossipsAtStart() {
        int[][] driverRoutes = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
        assertEquals(1, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }
    @Test
    void testLargeNumberOfMinutes() {
        int[][] routes = { { 1, 2, 3, 4 }, { 4, 3, 2, 1 } };
        assertEquals(-1,GossipingBusDrivers.getNumberStopsForSharingAllGosips(routes));
    }
}
