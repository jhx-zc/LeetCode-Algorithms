import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @Description: in this class. we can not find another result, because of {@code needPairs}
 */
public class TwoSum {
    /**
     * @Description: need-pair -> index
     * <p>
     * .e.g: [1,2,3,4,5], target = 5.
     * index=0, data=1, need-pair=target-data=4.
     * index=1, data=2, need-pair=target-data=3.
     * ...
     */
    private final Map<Integer, Integer> needPairs = new HashMap<>();

    public Integer[] twoSum(@NotNull Integer[] src, Integer target) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int index = 0; index < src.length; index++) {
            Integer pairDataIndex = needPairs.get(src[index]);
            if (pairDataIndex != null) {
                resultList.add(index);
                resultList.add(pairDataIndex);
                break;
            }

            needPairs.put(target - src[index], index);
        }

        resultList.sort(Integer::compareTo);
        return resultList.toArray(new Integer[0]);
    }
}
