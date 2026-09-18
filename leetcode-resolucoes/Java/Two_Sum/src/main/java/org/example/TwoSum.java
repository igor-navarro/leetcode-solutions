import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Para cada número, calcula o complemento (target - nums[i]) e verifica
     * se ele já apareceu antes. Se sim, achou o par. Isso resolve em uma
     * única passagem pelo array, em vez de comparar todo par (força bruta).
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // valor -> índice onde apareceu

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            seen.put(nums[i], i);
        }

        throw new IllegalArgumentException("Nenhuma solução encontrada");
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();

        System.out.println(Arrays.toString(solver.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(Arrays.toString(solver.twoSum(new int[]{3, 3}, 6)));          // [0, 1]
    }
}