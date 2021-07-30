import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TwoSumTest {
    class Parameters {
        Integer[] src;
        Integer target;

        public Parameters(Integer[] src, Integer target) {
            this.src = src;
            this.target = target;
        }

        public Integer[] getSrc() {
            return src;
        }

        public Integer getTarget() {
            return target;
        }
    }

    private final class TestData {
        String name;
        Parameters parameters;
        Integer[] result;

        public TestData(String name, Parameters parameters, Integer[] result) {
            this.name = name;
            this.parameters = parameters;
            this.result = result;
        }

        public String getName() {
            return name;
        }

        public Parameters getParameters() {
            return parameters;
        }

        public Integer[] getResult() {
            return result;
        }
    }

    private final List<TestData> testDataList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        //init test data
        testDataList.add(
                new TestData("t1", new Parameters(new Integer[]{1, 2, 3, 4, 5, 6, 7}, 12), new Integer[]{4, 6})
        );

        testDataList.add(
                new TestData("t2", new Parameters(new Integer[]{7, 6, 5, 4, 3, 2, 1}, 12), new Integer[]{0, 2})
        );

        testDataList.add(
                new TestData("t3", new Parameters(new Integer[]{7, 6, 4, 5, 3, 2, 1}, 12), new Integer[]{0, 3})
        );


        Integer[] arg = new Integer[9999999];
        for (int i = 0; i < 9999999; i++) {
            arg[i] = i + 1;
        }
        testDataList.add(
                new TestData("t4", new Parameters(arg, 19999997), new Integer[]{9999997, 9999998})
        );




        Integer[] arg2 = new Integer[9999999];
        for (int i = 0; i < 9999999; i++) {
            arg2[i] = i + 1;
        }
        Integer temp;
        temp = arg2[4999997];
        arg2[4999997] = arg2[9999997];
        arg2[9999997] = arg2[9999998];
        arg2[9999998] = temp;

        testDataList.add(
                new TestData("t5", new Parameters(arg2, 19999997), new Integer[]{4999997, 9999997})
        );
    }

    @Test
    void twoSum() {
        for (TestData testData : testDataList) {
            long startTime = System.currentTimeMillis();
            Integer[] result = new TwoSum().twoSum(testData.getParameters().getSrc(), testData.getParameters().getTarget());
            long endTime = System.currentTimeMillis();
            if (Arrays.equals(result, testData.getResult())) {
                System.out.println("Test success. test name:" + testData.getName() + " ,spend time:" + (endTime - startTime) + "ms");
            } else {
                System.err.println("Test failed. test name:" + testData.getName() + " ,spend time:" + (endTime - startTime) + "ms");
            }

            Assertions.assertArrayEquals(result, testData.getResult());
        }
    }
}